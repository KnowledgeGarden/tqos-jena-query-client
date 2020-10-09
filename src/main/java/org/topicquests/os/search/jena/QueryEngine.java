/*
 * Copyright 2020 TopicQuests
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.topicquests.os.search.jena;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.os.util.JSONUtil;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 * 
 */
public class QueryEngine {
	private SearchEnvironment environment;
	private QueryBuilder qb;
	private HttpClient http;
	private MergeEngine merger;

	/**
	 * @parm env
	 */
	public QueryEngine(SearchEnvironment env) {
		environment = env;
		qb = environment.getDSL();
		http = environment.getHttpClient();
	}
	
	public void setMerger(MergeEngine m) {
		merger = m;
	}
	public HttpClient getClient() {
		return http;
	}
	
	/**
	 * <p>A <em>federated query</em> is one which queries both Wikidata
	 * and DBpedia. Wikidata returns a List of triples in JSON, whereas
	 * DBpedia returns an array of XML results. We must normalize both of those
	 * results into a single JSON result which federates both.</p>
	 * @param label
	 * @return
	 */
	public IResult federatedQueryBylabel(String label) {
		IResult result = new ResultPojo();
		IResult wikidata = this.searchWikidataByLabel(label);
		IResult dbpedia = this.searchDBpediaByLabel(label);
		//temporary
		result.setResultObject(wikidata.getResultObject());
		result.setResultObjectA(dbpedia.getResultObject());
		result.addErrorString(wikidata.getErrorString()); 
		result.addErrorString(dbpedia.getErrorString()); 
		// TODO
		return result;
	}
	
	/**
	 * Core Wikidata query by {@code label} 
	 * Note: assumes English label
	 * @param label
	 * @return
	 */
	public IResult searchWikidataByLabel(String label) {
		System.out.println("SW "+label+" "+qb);
		IResult result = new ResultPojo();
		String q1 = qb.generalLabelQuery(label);
		IResult r = runQuery(q1, IConstants.WIKIDATA_SERVICE);
		String json = (String)r.getResultObject();
		JSONObject q = null;
		try {
			if (json != null) {
				q  = JSONUtil.toJSON(json);
				List<JSONObject> l = getBindings(q);
				if (l != null && !l.isEmpty()) {
					JSONObject u = l.get(0);
					JSONObject s = (JSONObject)u.get("s");
					String uri = s.getAsString("value");
					String q2 = qb.finalQuery(uri);
					r = runQuery(q2, IConstants.WIKIDATA_SERVICE);
					json = (String)r.getResultObject();
					if (json!= null) {
						q = JSONUtil.toJSON(json);
						q = (JSONObject)q.get("results");
						l = (List<JSONObject>)q.get("bindings");
						result.setResultObject(l);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
            environment.logError(e.getMessage(), e);
		}
		return result;
	}
	
	public List<JSONObject> getBindings(JSONObject q) {
		List<JSONObject>result = null;
		JSONObject x = (JSONObject)q.get("results");
		if (x != null)
			result = (List<JSONObject>)x.get("bindings");
		return result;
	}

	/**
	 * Core DBpedia query by {@code label}
	 * Note: assumes English label
	 * @param label First letter in label must be upper-case
	 * @return can return {@code null} data
	 */
	public IResult searchDBpediaByLabel(String label) {
		IResult result = http.doGet(label);
		String urx = IConstants.DBPEDIA_RESOURCE+label;
		urx = urx.replaceAll(" ", "_");
		environment.logDebug("QueryEngine.searchDBpediaBylabel-4 "+label+" "+urx);
		String q = qb.finalQuery(repairURI(urx, label));
		IResult r = this.runQuery(q, IConstants.DBPEDIA_SERVICE);
		result.addErrorString(r.getErrorString());
		String json = (String)r.getResultObject();
		try {
			if (json!= null) {
				JSONObject jx = JSONUtil.toJSON(json);
				jx = (JSONObject)jx.get("results");
				result.setResultObject(jx.get("bindings"));
			}
		} catch (Exception e) {
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
		}
		return result;
	}

	String repairURI(String uri, String properLabel) {
		String result = uri;
		String lcl = properLabel.toLowerCase();
		lcl = lcl.replaceAll(" ","_");
		String flbl = properLabel.replaceAll(" ", "_");
		int where = result.indexOf(lcl);
		if (where > -1) {
			result = result.substring(0, where)+flbl;
		}
		
		return result;
	}
	
	/**
	 * Run a given {@code sparql} query against the given {@code serviceURL}
	 * @param sparql
	 * @param serviceURL
	 * @return
	 */
	public IResult runQuery(String sparql, String serviceURL) {
		environment.logDebug("QueryEngine.runQuery- "+serviceURL+"\n"+sparql);
		IResult result = new ResultPojo();
		Query query = QueryFactory.create(sparql);
	       // Remote execution.
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService(serviceURL, query) ) {
            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;

            // Execute.
            ResultSet rs = qexec.execSelect();
            //ResultSetFormatter.out(System.out, rs, query);
            String json = resultSetToJSON(rs);
            //environment.logDebug("QueryEngine.runQuery "+sparql+"\n"+json);;
            result.setResultObject(json);
            //String xml = resultSetToXML(rs);
            //result.setResultObject(xml);
        } catch (Exception e) {
            e.printStackTrace();
            environment.logError(e.getMessage(), e);
            result.addErrorString(e.getMessage());
        }	
		return result;
	}
	
	String resultSetToJSON(ResultSet rs) {
		String result = null;
        ByteArrayOutputStream arr = new ByteArrayOutputStream() ;
        ResultSetFormatter.outputAsJSON(arr, rs) ;
		result = new String(arr.toByteArray());
		return result;
	}
	
	String resultSetToXML(ResultSet rs) {
		String result = null;
        ByteArrayOutputStream arr = new ByteArrayOutputStream() ;
        ResultSetFormatter.outputAsXML(arr, rs) ;
		result = new String(arr.toByteArray());
		return result;
		
	}

}
