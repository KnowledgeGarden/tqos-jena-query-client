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
package searchdevtests;

import org.topicquests.os.search.jena.HttpClient;
import org.topicquests.os.search.jena.QueryBuilder;
import org.topicquests.os.search.jena.QueryEngine;
import org.topicquests.os.search.jena.SearchEnvironment;

/**
 * @author jackpark
 *
 */
public class SearchRoot {
	protected SearchEnvironment environment;
	protected QueryEngine engine;
	protected QueryBuilder	dsl;
	protected HttpClient http;

	/**
	 * 
	 */
	public SearchRoot() {
		environment = new SearchEnvironment();
		engine = environment.getEngine();
		dsl  = environment.getDSL();
		http = engine.getClient();
	}

}
