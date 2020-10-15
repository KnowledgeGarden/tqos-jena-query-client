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