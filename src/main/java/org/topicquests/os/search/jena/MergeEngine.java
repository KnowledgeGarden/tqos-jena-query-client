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
		// make dictionaries and clean them
		JSONObject dbpDict = this.toDictionary(dbp);
		dbpDict = cleanDBP(dbpDict);
		JSONObject wdDict = this.toDictionary(wd);
		wdDict = this.cleanWD(wdDict);
		// swap out wikidata predicates for dbpedia predicates
		wdDict = this.mapPreds(wdDict);
		environment.logDebug("MergeBoth-1\n"+wdDict);

		
		JSONObject longest = dbpDict;
		JSONObject other = wdDict;
		if (wdDict.size() > dbpDict.size()) {
			longest = wdDict;
			other = dbpDict;
		}
		
		
		return result;
	}
	
	/**
	 * Strip useless predicates
	 * @param dbpDict
	 * @return
	 */
	JSONObject cleanDBP(JSONObject dbpDict) {
		JSONObject result = dbpDict;
		environment.logDebug("CDBP-1\n"+result);
		String [] badPreds = UselessPreds.DBPUselessPreds;
		int len = badPreds.length;
		for (String bp: badPreds) {
			result.remove(bp);
		}
		environment.logDebug("CDBP-2\n"+result);	
		return result;
	}
	
	JSONObject cleanWD(JSONObject wdDict) {
		JSONObject result = wdDict;
		environment.logDebug("CWD-1\n"+result);
		String [] badPreds = UselessPreds.WDUselessPreds;
		int len = badPreds.length;
		for (String bp: badPreds) {
			result.remove(bp);
		}
		environment.logDebug("CWD-2\n"+result);	
		return result;
	}
	
	/**
	 * For each Wikidata predicate type, substitute its equivalent
	 * DBpedia predicate type
	 * @param wdDict
	 * @return
	 */
	JSONObject mapPreds(JSONObject wdDict) {
		JSONObject result = wdDict;
		Iterator<String>itr = this.propertyMappings.keySet().iterator();
		String wdKey, dbpKey;
		Object dbpObj;
		while (itr.hasNext()) {
			wdKey = itr.next();
			dbpKey = this.propertyMappings.getAsString(wdKey);
			dbpObj = wdDict.remove(wdKey);
			if (dbpObj != null) {
				environment.logDebug("MapPreds "+wdKey+" "+dbpKey);
				wdDict.put(dbpKey, dbpObj);
			}
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
				//environment.logDebug("MergeEngine.foundCollection "+key+" "+obj);
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
