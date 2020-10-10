/**
 * 
 */
package org.topicquests.os.search.jena;

import java.util.*;
import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.os.util.JSONUtil;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class DBP_WD_Util {
	private SearchEnvironment environment;
	private QueryEngine qe;
	private final String Q =
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
			"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
			"select distinct ?s ?o where  {?s a rdf:Property; owl:equivalentProperty ?o}";

	/**
	 * 
	 */
	public DBP_WD_Util(SearchEnvironment env) {
		environment = env;
		qe = environment.getEngine();
	}
	
	public JSONObject getMapping() {
		JSONObject result = new JSONObject();
		IResult r = qe.runQuery(Q, IConstants.DBPEDIA_SERVICE);
		String json = (String)r.getResultObject();
		//environment.logDebug("Hits\n"+json);
		if (json != null) {
			try {
				JSONObject jo = JSONUtil.toJSON(json);
				List<JSONObject> bindings = qe.getBindings(jo);
				Iterator<JSONObject>itr = bindings.iterator();
				JSONObject subj, obj;
				String sV, oV;
				Object rx;
				List<String>lx;
				while (itr.hasNext()) {
					jo = itr.next();
					subj = (JSONObject)jo.get("s");
					sV = subj.getAsString("value");
					obj  = (JSONObject)jo.get("o");
					oV = obj.getAsString("value");
					if (oV.contains("wikidata")) {
						rx = result.get(oV);
						if (rx == null)
							result.put(oV, sV);
						else 
							environment.logDebug("MergeDup "+oV+" "+sV+" "+rx);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				environment.logError(e.getLocalizedMessage(), e);
			}
		}
		environment.logDebug("Hits\n"+result);

		
		return result;
	}

}
