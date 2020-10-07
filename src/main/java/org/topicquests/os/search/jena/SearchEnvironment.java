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
	private QueryDSL	dsl;
	/**
	 */
	public SearchEnvironment() {
		super("jena-props.xml", "logger.properties");
		engine = new QueryEngine(this);
		dsl = new QueryDSL(this);
		
	}
	
	public QueryDSL getDSL() {
		return dsl;
	}
	public QueryEngine getEngine() {
		return engine;
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}

}
