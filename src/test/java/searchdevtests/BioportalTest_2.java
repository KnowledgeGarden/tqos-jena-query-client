/**
 * 
 */
package searchdevtests;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class BioportalTest_2 extends SearchRoot {

	/**
	 * 
	 */
	public BioportalTest_2() {
		super();
		IResult r = bioPortal.ontologyQuery();
		System.out.println("A "+r.getErrorString());
		environment.logDebug("B\n"+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
