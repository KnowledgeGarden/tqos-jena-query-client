/*
 * Copyright 2020 TopicQuests
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
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
