/**
 * 
 */
package org.topicquests.os.search.jena;



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
	
	public IResult runQuery(String sparql, String serviceURL) {
		IResult result = new ResultPojo();
		Query query = QueryFactory.create(sparql);
	       // Remote execution.
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService(serviceURL, query) ) {
            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;

            // Execute.
            ResultSet rs = qexec.execSelect();
            ResultSetFormatter.out(System.out, rs, query);
        } catch (Exception e) {
            e.printStackTrace();
            environment.logError(e.getMessage(), e);
            result.addErrorString(e.getMessage());
        }	
		return result;
	}

}
