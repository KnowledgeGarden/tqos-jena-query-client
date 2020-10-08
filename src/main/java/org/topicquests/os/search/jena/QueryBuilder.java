/**
 * 
 */
package org.topicquests.os.search.jena;

/**
 * @author jackpark
 *
 */
public class QueryBuilder {
	private SearchEnvironment environment;

	/**
	 * 
	 */
	public QueryBuilder(SearchEnvironment env) {
		environment = env;
	}
	
	
	/**
	 * Perform a label search on Wikidata or DBpedia to find concepts answering to
	 * {@code conceptLabel}
	 * @param conceptLabel
	 * @return
	 */
	public String generalLabelQuery(String conceptLabel) {
		String result = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"+
		"select ?s where {?s rdfs:label \""+conceptLabel+"\"@en}";
		return result;
	}

}
