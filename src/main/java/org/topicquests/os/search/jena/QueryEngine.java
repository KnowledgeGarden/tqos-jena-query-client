/**
 * 
 */
package org.topicquests.os.search.jena;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 * @see https://jena.apache.org/documentation/query/manipulating_sparql_using_arq.html
 * @see https://github.com/apache/jena/blob/master/jena-arq/src-examples/arq/examples/ExampleDBpedia1.java
 * @see https://github.com/apache/jena/blob/67ce9537413c2aaa78f76ffe4810eb749a83c3da/jena-arq/src/test/java/org/apache/jena/sparql/resultset/TestResultSet.java
 * 
 */
public class QueryEngine {
	private SearchEnvironment environment;

	/**
	 * 
	 */
	public QueryEngine(SearchEnvironment env) {
		environment = env;
	}
	
	/**
	 * Run a given {@code sparql} query against the given {@code serviceURL}
	 * @param sparql
	 * @param serviceURL
	 * @return
	 */
	public IResult runQuery(String sparql, String serviceURL) {
		IResult result = new ResultPojo();
		Query query = QueryFactory.create(sparql);
	       // Remote execution.
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService(serviceURL, query) ) {
            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;

            // Execute.
            ResultSet rs = qexec.execSelect();
            //ResultSetFormatter.out(System.out, rs, query);
            String json = resultSetToJSON(rs);
            result.setResultObject(json);
        } catch (Exception e) {
            e.printStackTrace();
            environment.logError(e.getMessage(), e);
            result.addErrorString(e.getMessage());
        }	
		return result;
	}
	
	String resultSetToJSON(ResultSet rs) {
		String result = null;
        ByteArrayOutputStream arr = new ByteArrayOutputStream() ;
        ResultSetFormatter.outputAsJSON(arr, rs) ;
        //ByteArrayInputStream ins = new ByteArrayInputStream(arr.toByteArray()) ;		
		result = new String(arr.toByteArray());
		return result;
	}

}
