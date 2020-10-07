/**
 * 
 */
package searchdevtests;

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 * @see https://github.com/apache/jena/blob/master/jena-arq/src-examples/arq/examples/ExampleDBpedia1.java
 */
public class FirstDBpediaTest extends SearchRoot {
	private final String queryStr = "select distinct ?Concept where {[] a ?Concept} LIMIT 10";
	/**
	 * 
	 */
	public FirstDBpediaTest() {
		super();
		
		IResult r = engine.runQuery(queryStr, IConstants.DBPEDIA_SERVICE);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
/*
----------------------------------------------------------------------
| Concept                                                            |
======================================================================
| <http://www.openlinksw.com/schemas/virtrdf#QuadMapFormat>          |
| <http://www.openlinksw.com/schemas/virtrdf#QuadStorage>            |
| <http://www.openlinksw.com/schemas/virtrdf#array-of-QuadMapFormat> |
| <http://www.openlinksw.com/schemas/virtrdf#QuadMap>                |
| <http://www.openlinksw.com/schemas/virtrdf#QuadMapValue>           |
| <http://www.openlinksw.com/schemas/virtrdf#array-of-QuadMapColumn> |
| <http://www.openlinksw.com/schemas/virtrdf#QuadMapColumn>          |
| <http://www.openlinksw.com/schemas/virtrdf#array-of-QuadMapATable> |
| <http://www.openlinksw.com/schemas/virtrdf#QuadMapATable>          |
| <http://www.openlinksw.com/schemas/virtrdf#QuadMapFText>           |
----------------------------------------------------------------------
A 
 */
