/**
 * 
 */
package searchdevtests;

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class ThirdDBpedia extends SearchRoot {

	/**
	 * 
	 */
	public ThirdDBpedia() {
		super();
		String queryStr = dsl.generalLabelQuery("climate change");
		
		IResult r = engine.runQuery(queryStr, IConstants.DBPEDIA_SERVICE);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
/*
Still picking up wikidata hits, not dbpedia hits
A 
B { "head": {
    "vars": [ "s" ]
  } ,
  "results": {
    "bindings": [
      { 
        "s": { "type": "uri" , "value": "http://www.wikidata.org/entity/Q125928" }
      }
    ]
  }
}

*/