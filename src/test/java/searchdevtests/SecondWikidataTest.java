/**
 * 
 */
package searchdevtests;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SecondWikidataTest extends SearchRoot {
	private final String Q = "leukemia";
	
	/**
	 * 
	 */
	public SecondWikidataTest() {
		super();
		IResult r = engine.searchWikidataByLabel(Q);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
