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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class HttpClient {
	private SearchEnvironment environment;

	/**
	 * 
	 */
	public HttpClient(SearchEnvironment env) {
		environment = env;
	}
	
	public IResult doGet(String query) {
		IResult result = new ResultPojo();
		BufferedReader rd = null;
		HttpURLConnection con = null;

		try {
			String x =  URLEncoder.encode(query, "UTF-8");
			String q = IConstants.DBPEDIA_LOOKUP+x;
			
			URL urx = new URL(q);
			con = (HttpURLConnection) urx.openConnection();
			con.setReadTimeout(500000);
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder buf = new StringBuilder();

			String line;
			while ((line = rd.readLine()) != null) {
				buf.append(line + '\n');
			}

			result.setResultObject(buf.toString());
		} catch (Exception var18) {
			var18.printStackTrace();
			result.addErrorString(var18.getMessage());
		} finally {
			try {
				if (rd != null) {
					rd.close();
				}

				if (con != null) {
					con.disconnect();
				}
			} catch (Exception var17) {
				var17.printStackTrace();
				result.addErrorString(var17.getMessage());
			}

		}		
		return result;
	}

}
