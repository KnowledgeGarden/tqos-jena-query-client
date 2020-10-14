/**
 * 
 */
package org.topicquests.os.search.jena;

import java.net.URLEncoder;

import org.topicquests.os.util.JSONUtil;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

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
	
	public IResult labelQuery(String label) {
		IResult result = new ResultPojo();
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
			result.setResultObject(jo);	
		}

		return result;
	}
	
	
	public IResult ontologyQuery() {
		IResult result = new ResultPojo();

		return result;
	}

}
