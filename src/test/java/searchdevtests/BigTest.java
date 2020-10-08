package searchdevtests;

import java.util.List;

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.os.util.JSONUtil;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

public class BigTest extends SearchRoot {
	private final String
		L1 = "leukemia",
		QUERY;
	
	public BigTest() {
		super();
		QUERY = dsl.generalLabelQuery(L1);
		System.out.println("Q "+QUERY);
		IResult r = engine.runQuery(QUERY, IConstants.DBPEDIA_SERVICE);
		String json = (String)r.getResultObject();
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+json);
		if (json != null) {
			JSONObject q = null;
			try {
				q  = JSONUtil.toJSON(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONObject x = (JSONObject)q.get("results");
			if (x != null) {
				List<JSONObject> l = (List<JSONObject>)x.get("bindings");
				if (l != null && !l.isEmpty()) {
					JSONObject u = l.get(0);
					JSONObject s = (JSONObject)u.get("s");
					String uri = s.getAsString("value");
					String q2 = dsl.finalQuery(uri);
					r = engine.runQuery(q2, IConstants.DBPEDIA_SERVICE);
					System.out.println("A1 "+r.getErrorString());
					System.out.println("B1 "+r.getResultObject());
					System.out.println("Q1 "+q2);
				}
				
			}
		}
		r = engine.runQuery(QUERY, IConstants.WIKIDATA_SERVICE);
		System.out.println("C "+r.getErrorString());
		System.out.println("D "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}

/*
A 
B { "head": {
    "vars": [ "s" ]
  } ,
  "results": {
    "bindings": [
      { 
        "s": { "type": "uri" , "value": "http://www.wikidata.org/entity/Q29496" }
      } ,
      { 
        "s": { "type": "uri" , "value": "#WN30Word-leukemia" }
      }
    ]
  }
}

C 
D { "head": {
    "vars": [ "s" ]
  } ,
  "results": {
    "bindings": [
      { 
        "s": { "type": "uri" , "value": "http://www.wikidata.org/entity/Q29496" }
      }
    ]
  }
}
*/