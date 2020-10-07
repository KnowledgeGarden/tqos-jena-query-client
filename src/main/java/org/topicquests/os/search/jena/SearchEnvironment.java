/**
 * 
 */
package org.topicquests.os.search.jena;

import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class SearchEnvironment extends RootEnvironment {
	private QueryEngine engine;
	/**
	 */
	public SearchEnvironment() {
		super("jena-props.xml", "logger.properties");
		engine = new QueryEngine(this);
		
	}
	
	public QueryEngine getEngine() {
		return engine;
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}

}
