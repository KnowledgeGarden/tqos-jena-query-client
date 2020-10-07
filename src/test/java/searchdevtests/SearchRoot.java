/**
 * 
 */
package searchdevtests;

import org.topicquests.os.search.jena.QueryEngine;
import org.topicquests.os.search.jena.SearchEnvironment;

/**
 * @author jackpark
 *
 */
public class SearchRoot {
	protected SearchEnvironment environment;
	protected QueryEngine engine;

	/**
	 * 
	 */
	public SearchRoot() {
		environment = new SearchEnvironment();
		engine = environment.getEngine();
	}

}
