/**
 * 
 */
package org.topicquests.os.search.jena;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 * <p>A typical {@code JSONObject} is a predicate-object pair, where
 * the subject is the URI in play.<br/>
 * <code>
 * {
 *	"p": {
 *		"type": "uri",
 *		"value": "http:\/\/schema.org\/version"
 *	},
 *	"o": {
 *		"datatype": "http:\/\/www.w3.org\/2001\/XMLSchema#integer",
 *		"type": "literal",
 *		"value": "1208653206"
 *	}
 * }
 * </code>
 */
public class MergeEngine {
	private SearchEnvironment environment;
	private final JSONObject propertyMappings;

	/**
	 * @param env
	 */
	public MergeEngine(SearchEnvironment env) {
		environment = env;
		propertyMappings = bootMappings();
	}
	
	JSONObject bootMappings() {
		DBP_WD_Util utx = new DBP_WD_Util(environment);
		return utx.getMapping();
	}


	public JSONObject considerMerge(List<JSONObject> dbp, List<JSONObject> wd) {
		JSONObject result = null;
		if (dbp != null && wd != null)
			result = mergeBoth(dbp, wd);
		
		return result;
	}
	
	JSONObject mergeBoth(List<JSONObject> dbp, List<JSONObject> wd) {
		JSONObject result = null;
		JSONObject dbpDict = this.toDictionary(dbp);
		JSONObject wdDict = this.toDictionary(wd);
		
		
		JSONObject longest = dbpDict;
		JSONObject other = wdDict;
		if (wdDict.size() > dbpDict.size()) {
			longest = wdDict;
			other = dbpDict;
		}
		
		
		return result;
	}
	
	/**
	 * Create a {@link JSONObject} where:<br/>
	 * key = predicate {@code String}<br/>
	 * value = object {@code JSONObject}
	 * @param l
	 * @return
	 */
	JSONObject toDictionary(List<JSONObject> l) {
		JSONObject result = new JSONObject();
		Iterator<JSONObject> itr = l.iterator();
		JSONObject jo;
		JSONObject obj;
		String key;
		List<JSONObject> lx;
		while (itr.hasNext()) {
			jo = itr.next();
			key = ((JSONObject)jo.get("p")).getAsString("value");
			obj = (JSONObject)jo.get("o");
			if (!result.containsKey(key))
				result.put(key, obj);
			else {
				environment.logDebug("MergeEngine.foundCollection "+key+" "+obj);
				//forced to make a collection
				Object ox = result.get(key);
				if (ox instanceof JSONObject) {
					lx = new ArrayList<JSONObject>();
					lx.add((JSONObject)ox);
					lx.add(obj);
				} else {
					lx = (List<JSONObject>)ox;
					lx.add(obj);
				}
				result.put(key, lx);
			}
		}
		return result;
	}
}
