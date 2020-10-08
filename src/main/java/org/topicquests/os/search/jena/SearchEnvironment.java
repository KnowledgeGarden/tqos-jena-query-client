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
	private QueryBuilder	dsl;
	/**
	 */
	public SearchEnvironment() {
		super("jena-props.xml", "logger.properties");
		dsl = new QueryBuilder(this);
		engine = new QueryEngine(this);		
	}
	
	public QueryBuilder getDSL() {
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
