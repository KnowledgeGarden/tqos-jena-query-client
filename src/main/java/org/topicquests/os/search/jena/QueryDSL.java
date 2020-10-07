/**
 * 
 */
package org.topicquests.os.search.jena;

/**
 * @author jackpark
 *
 */
public class QueryDSL {
	private SearchEnvironment environment;

	/**
	 * 
	 */
	public QueryDSL(SearchEnvironment env) {
		environment = env;
	}
	
	
	/**
	 * Perform a label search on Wikidata to find concepts answering to
	 * {@code conceptLabel}
	 * @param conceptLabel
	 * @return
	 */
	public String wikidataLabelQuery(String conceptLabel) {
		String result = null;
		//TODO
		return result;
	}

	/**
	 * Perform a label search on Dbpedia to find concepts answering to
	 * {@code conceptLabel}
	 * @param conceptLabel
	 * @return
	 */
	public String dbPediaLabelQuery(String conceptLabel) {
		String result = null;
		//TODO
		return result;
	}

}
