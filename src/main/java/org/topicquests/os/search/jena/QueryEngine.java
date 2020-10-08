/**
 * 
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
 * @see https://jena.apache.org/documentation/query/manipulating_sparql_using_arq.html
 * @see https://github.com/apache/jena/blob/master/jena-arq/src-examples/arq/examples/ExampleDBpedia1.java
 * @see https://github.com/apache/jena/blob/67ce9537413c2aaa78f76ffe4810eb749a83c3da/jena-arq/src/test/java/org/apache/jena/sparql/resultset/TestResultSet.java
 * 
 */
public class QueryEngine {
	private SearchEnvironment environment;
	private QueryBuilder qb;

	/**
	 * @parm env
	 */
	public QueryEngine(SearchEnvironment env) {
		environment = env;
		qb = environment.getDSL();
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
				JSONObject x = (JSONObject)q.get("results");
				if (x != null) {
					List<JSONObject> l = (List<JSONObject>)x.get("bindings");
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
			}
		} catch (Exception e) {
			e.printStackTrace();
            environment.logError(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Core DBpedia query by {@code label}
	 * Note: assumes English label
	 * @param label
	 * @return
	 */
	public IResult searchDBpediaByLabel(String label) {
		IResult result = new ResultPojo();
		
		return result;
	}

	
	/**
	 * Run a given {@code sparql} query against the given {@code serviceURL}
	 * @param sparql
	 * @param serviceURL
	 * @return
	 */
	public IResult runQuery(String sparql, String serviceURL) {
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
            result.setResultObject(json);
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
        //ByteArrayInputStream ins = new ByteArrayInputStream(arr.toByteArray()) ;		
		result = new String(arr.toByteArray());
		return result;
	}

}
