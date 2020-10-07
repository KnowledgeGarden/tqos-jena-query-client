/**
 * 
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
		environment.shutDown();
		System.exit(0);
	}

}

/*
 SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
------------------------------
| lexemeId  | lemma          |
==============================
| wd:L18187 | "potassium"@en |
| wd:L41230 | "potash"@en    |
| wd:L41229 | "potable"@en   |
| wd:L3784  | "potato"@en    |
------------------------------
A 

 */
