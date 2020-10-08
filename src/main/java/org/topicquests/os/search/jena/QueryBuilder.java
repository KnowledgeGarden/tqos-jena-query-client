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

/**
 * @author jackpark
 * Fundamentally used for Wikidata queries
 */
public class QueryBuilder {
	private SearchEnvironment environment;

	/**
	 * 
	 */
	public QueryBuilder(SearchEnvironment env) {
		environment = env;
	}
	
	
	/**
	 * Perform a label search on Wikidata find concepts answering to
	 * {@code conceptLabel}
	 * @param conceptLabel
	 * @return
	 */
	public String generalLabelQuery(String conceptLabel) {
		String result = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"+
		"select ?s where {?s rdfs:label \""+conceptLabel+"\"@en}";
		return result;
	}

	
	/**
	 * Fetch all triples against a given {@code uri}
	 * @param uri
	 * @return
	 */
	public String finalQuery(String uri) {
		String result = "select ?p ?o where {<"+uri+"> ?p ?o}";
		return result;
	}
}
