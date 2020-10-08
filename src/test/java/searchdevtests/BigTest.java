package searchdevtests;

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.support.api.IResult;

public class BigTest extends SearchRoot {
	private final String
		L1 = "leukemia",
		QUERY;
	
	public BigTest() {
		super();
		QUERY = dsl.generalLabelQuery(L1);
		System.out.println("Q "+QUERY);
		IResult r = engine.runQuery(QUERY, IConstants.DBPEDIA_SERVICE);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
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