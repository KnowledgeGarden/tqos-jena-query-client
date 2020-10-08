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
 * @see https://www.wikidata.org/wiki/Wikidata:SPARQL_query_service/apache-jena
 */
public class FirstWikidataTest extends SearchRoot {
	private final String queryStr = "PREFIX schema: <http://schema.org/>\n" + 
			"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" + 
			"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" + 
			"PREFIX hist: <http://wikiba.se/history/ontology#>\n" + 
			"PREFIX wd: <http://www.wikidata.org/entity/>\n" + 
			"PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" + 
			"PREFIX wikibase: <http://wikiba.se/ontology#>\n" + 
			"PREFIX dct: <http://purl.org/dc/terms/>\n" + 
			"\n" + 
			"SELECT ?lexemeId ?lemma WHERE {\n" + 
			"    ?lexemeId dct:language wd:Q1860;\n" + 
			"            wikibase:lemma ?lemma.\n" + 
			"  # only those lemmas that begin with \"pota\", i.e. \"potato\"\n" + 
			"  FILTER (regex(?lemma, '^pota.*'))\n" + 
			"}";

	/**
	 * 
	 */
	public FirstWikidataTest() {
		super();
		
		IResult r = engine.runQuery(queryStr, IConstants.WIKIDATA_SERVICE);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}

/*
------------------------------
| lexemeId  | lemma          |
==============================
| wd:L18187 | "potassium"@en |
| wd:L41230 | "potash"@en    |
| wd:L41229 | "potable"@en   |
| wd:L3784  | "potato"@en    |
------------------------------
A 

AFTER adding toJSON
A 
B { "head": {
    "vars": [ "lexemeId" , "lemma" ]
  } ,
  "results": {
    "bindings": [
      { 
        "lexemeId": { "type": "uri" , "value": "http://www.wikidata.org/entity/L18187" } ,
        "lemma": { "type": "literal" , "xml:lang": "en" , "value": "potassium" }
      } ,
      { 
        "lexemeId": { "type": "uri" , "value": "http://www.wikidata.org/entity/L41230" } ,
        "lemma": { "type": "literal" , "xml:lang": "en" , "value": "potash" }
      } ,
      { 
        "lexemeId": { "type": "uri" , "value": "http://www.wikidata.org/entity/L41229" } ,
        "lemma": { "type": "literal" , "xml:lang": "en" , "value": "potable" }
      } ,
      { 
        "lexemeId": { "type": "uri" , "value": "http://www.wikidata.org/entity/L3784" } ,
        "lemma": { "type": "literal" , "xml:lang": "en" , "value": "potato" }
      }
    ]
  }
}

 */
