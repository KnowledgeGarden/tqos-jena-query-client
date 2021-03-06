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
package org.topicquests.os.search.jena.api;

/**
 * @author jackpark
 *
 */
public interface IConstants {
	/** URLs */
	public static final String
		DBPEDIA_SERVICE		= "http://live.dbpedia.org/sparql",
		DBPEDIA_RESOURCE	= "http://dbpedia.org/resource/",
		WIKIDATA_SERVICE	= "https://query.wikidata.org/sparql",
		DBPEDIA_LOOKUP		= "https://lookup.dbpedia.org/api/search.asmx/KeywordSearch?QueryString=";
	/** Federated Class Fields */
	public static final String
		PSI_FIELD			= "psi",
		CUI_FIELD			= "cui",
		DEFINITION_FIELD	= "defn",
		PARENT_FIELD		= "parent",
		PREF_LABEL_FIELD	= "prefLbl",
		SEMANTIC_TYPE_FIELD	= "semType",
		SYNONYM_FIELD		= "syns";

}
