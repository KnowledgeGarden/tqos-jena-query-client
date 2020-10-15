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

import java.util.*;
import java.net.URLEncoder;

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.os.util.JSONUtil;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class BioportalClient {
	private SearchEnvironment environment;
	private HttpClient http;
	private final String
		BASE_URL,
		API_KEY;

	/**
	 * 
	 */
	public BioportalClient(SearchEnvironment env) {
		environment = env;
		http = environment.getHttpClient();
		BASE_URL = environment.getStringProperty("BioportalURL");
		API_KEY = environment.getStringProperty("BioportalAPI_KEY");
	}
	
	/**
	 * Fetch pages of hits on a biomedical concept identified by {@code label}
	 * <p>{@code pageCount}<br/>
	 * 		0 means just take the first page<br/>
	 * 		-1 means take all available pages<br/>
	 * 		N - an integer > 0 means take N-max pages</p>
	 * @param label
	 * @param pageCount
	 * @return
	 */
	public IResult labelQuery(String label, int pageCount) {
		IResult result = new ResultPojo();
		///////////////////////////////
		// federatedResult is going to be a collection of classes,
		// with the key being a canonical label, lower case
		// which means that "myocardial infarction" and "MYOCARDIAL INFARCTION" would be
		// included in the same object, as would "myocardial infarction acute" and "acute myocardial infarction"
		//
		JSONObject federatedResult = new JSONObject();
		////////////////////////////////
		result.setResultObject(federatedResult);
		String qx = label;
		try {
			qx = URLEncoder.encode(qx, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			environment.logError(e.getMessage(), e);
			result.addErrorString(e.getMessage());
		}
		String query = BASE_URL+"search?q="+qx;
		IResult r = http.bioportalGet(query, API_KEY);
		String json = (String)r.getResultObject();
		if (json != null) {
			JSONObject jo = null;
			try {
				jo = JSONUtil.toJSON(json);
			} catch (Exception e) {
				e.printStackTrace();
				environment.logError(e.getMessage(), e);
				result.addErrorString(e.getMessage());
			}
			if (jo != null) {
				federateTwo(federatedResult, jo);
				int avail = jo.getAsNumber("pageCount").intValue();
				if (pageCount != 0 && avail > 1)
					jo = morePages(avail, pageCount, federatedResult, query, result);
			}
		}
		
		
		System.out.println("Size: "+federatedResult.size());
		return result;
	}
	
	
	
	
	JSONObject morePages(int available, int max, JSONObject master, String query, IResult result) {
		JSONObject federatedResult = master;
		IResult r;
		int howMany = available;
		JSONObject jo=null;
		String json;
		String oQuery = query;
		if (max > -1 && max < available)
			howMany = max;
		for (int i=2; i< howMany; i++) {
			oQuery  = query+"&page="+i;
			System.out.println(query);
			r = http.bioportalGet(oQuery, API_KEY);
			json = (String)r.getResultObject();
			if (json != null) {
				try {
					jo = JSONUtil.toJSON(json);
				} catch (Exception e) {
					e.printStackTrace();
					environment.logError(e.getMessage(), e);
					result.addErrorString(e.getMessage());
				}
				federateTwo(federatedResult, jo);
			}
		}
		
		return federatedResult;
	}

	/**
	 * Return an {@code JSONObject} which is either empty, or populated.
	 * @param fed
	 * @param label
	 * @return
	 */
	JSONObject findOrCreate(JSONObject fed, String label) {
		String lbl = label.toLowerCase();
		JSONObject result = (JSONObject)fed.get(lbl);
		if (result == null) {
			//This can be quite complex:
			// we cannot just make an empty result until we prove
			// that some permutation of lbl is not already in fed
			Set<String> keys = fed.keySet();
			String key = checkPermutation(lbl, keys);
			System.out.println("KEY "+key);
			if (key != null) {
				result = (JSONObject)fed.get(lbl);
				// can return null if bad key
				// checkPermutation can get false positives
			}
		}
		if (result == null) {
			result =  new JSONObject();
			fed.put(lbl, result);
		}
		System.out.println("FOC "+lbl+" "+result);
		return result;
	}
	
	/**
	 * Find permutated key
	 * @param lcLabel
	 * @param keys
	 * @return can return {@code null}
	 */
	String checkPermutation(String lcLabel, Set<String>keys) {
		String [] words = lcLabel.split(" ");
		int len = words.length;
		if (len == 1)
			return null; // single word was never found
		String result = null;
		Iterator<String>itr = keys.iterator();
		String key;
		boolean found = true;
		while (itr.hasNext()) {
			found = true;
			key = itr.next();
			for (int i=0; i<len; i++) {
				//FAILURE MODE:
				// key: inferior myocardial infarction
				// returned posteroinferior myocardial infarction
				// must check for that
				if (!key.contains(words[i]))
					found = false;
			}
			if (found)
				return key;
		}
		return result;
	}
	/**
	 * 
	 * @param fed is the final federated object
	 * @param hit
	 */
	void federateTwo(JSONObject fed, JSONObject hit) {
		
		List<JSONObject> hitCollection = (List<JSONObject>)hit.get("collection");
		JSONObject  hCollection;
		String  hPrefLabel;
		List<String>  hCUI;
		List<String>  hSemType;
		String  hID;
		String hDefinition;
		List<String>  hSynonyms;
		JSONObject links;
		JSONObject master;
		int len = hitCollection.size();
		for (int i=0; i<len; i++) {
			hCollection = (JSONObject)hitCollection.get(i);
			hID = hCollection.getAsString("@id");
			hPrefLabel = hCollection.getAsString("prefLabel");
			if (hPrefLabel != null) {
				master = this.findOrCreate(fed, hPrefLabel);
				hCUI = (List<String>)hCollection.get("cui");
				hSynonyms = (List<String>)hCollection.get("synonym");
				hSemType = (List<String>)hCollection.get("semanticType");
				links = (JSONObject)hCollection.get("links");
	
				hDefinition = hCollection.getAsString("definition");
				federateID(master, hID);
				federateCUI(master, hCUI);
				federatePrefLabel(master, hPrefLabel);
				federateSynonyms(master, hSynonyms);
				federateDefinition(master, hDefinition);
				federateSemanticType(master, hSemType);
				if (links != null)
					federateParents(master, links.getAsString("parents"));
			} else
				environment.logError("MISSING LABEL "+i+"\n"+hCollection, null);
		}
	}
	
	void federateID(JSONObject master, String hID) {
		if (hID == null)
			return;
		List<String> psis = (List<String>)master.get(IConstants.PSI_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		if (!psis.contains(hID))
			psis.add(hID);
		master.put(IConstants.PSI_FIELD, psis);
	}
	void federateParents(JSONObject master, String parent) {
		if (parent == null)
			return;
		List<String> psis = (List<String>)master.get(IConstants.PARENT_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		if (!psis.contains(parent))
			psis.add(parent);
		master.put(IConstants.PARENT_FIELD, psis);
	}
	
	void federatePrefLabel(JSONObject master, String lbl) {
		if (lbl == null)
			return;
		List<String> psis = (List<String>)master.get(IConstants.PREF_LABEL_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		if (!psis.contains(lbl))
			psis.add(lbl);
		master.put(IConstants.PREF_LABEL_FIELD, psis);
	}
	
	void federateDefinition(JSONObject master, String defn) {
		if (defn == null)
			return;
		List<String> psis = (List<String>)master.get(IConstants.DEFINITION_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		if (!psis.contains(defn))
			psis.add(defn);
		master.put(IConstants.DEFINITION_FIELD, psis);
	}
	
	void federateCUI(JSONObject master, List<String> cui) {
		if (cui == null || cui.isEmpty())
			return;
		List<String> psis = (List<String>)master.get(IConstants.CUI_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		Iterator<String> itr = cui.iterator();
		String x;
		while (itr.hasNext()) {
			x = itr.next();
			if (!psis.contains(x))
				psis.add(x);
		}
		master.put(IConstants.CUI_FIELD, psis);
	}
	
	void federateSemanticType(JSONObject master, List<String> st) {
		if (st == null || st.isEmpty())
			return;
		List<String> psis = (List<String>)master.get(IConstants.SEMANTIC_TYPE_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		Iterator<String> itr = st.iterator();
		String x;
		while (itr.hasNext()) {
			x = itr.next();
			if (!psis.contains(x))
				psis.add(x);
		}
		master.put(IConstants.SEMANTIC_TYPE_FIELD, psis);
	}
	
	void federateSynonyms(JSONObject master, List<String> syns) {
		if (syns == null || syns.isEmpty())
			return;
		List<String> psis = (List<String>)master.get(IConstants.SYNONYM_FIELD);
		if (psis == null) psis = new ArrayList<String>();
		Iterator<String> itr = syns.iterator();
		String x;
		while (itr.hasNext()) {
			x = itr.next();
			if (!psis.contains(x))
				psis.add(x);
		}
		master.put(IConstants.SYNONYM_FIELD, psis);
	}
	
	/**
	 * Lists all the ontologies returned as a 3mb {@code JSONArray}
	 * <p>For hints on how to walk through those ontologies:
	 * @see https://github.com/ncbo/ncbo_rest_sample_code/blob/master/java/src/GetLabels.java
	 * </p>
	 * @return
	 */
	public IResult ontologyQuery() {
		IResult result = new ResultPojo();
		String qx = "ontologies";
		String query = BASE_URL+qx;
		IResult r = http.bioportalGet(query, API_KEY);
		String json = (String)r.getResultObject();
		if (json != null) {
			JSONArray jo = null;
			try {
				jo = JSONUtil.toJSONArray(json);
			} catch (Exception e) {
				e.printStackTrace();
				environment.logError(e.getMessage(), e);
				result.addErrorString(e.getMessage());
			}
			result.setResultObject(jo);	
		}		
		return result;
	}

}
