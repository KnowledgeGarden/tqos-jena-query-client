/**
 * 
 */
package searchdevtests;

/**
 * @author jackpark
 *
 */
public class BootTest extends SearchRoot {

	/**
	 * 
	 */
	public BootTest() {
		super();
		System.out.println("Booted!");
		environment.shutDown();
		System.exit(0);
	}

}
