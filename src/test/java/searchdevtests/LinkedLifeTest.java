/**
 * 
 */
package searchdevtests;

import java.net.URLEncoder;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class LinkedLifeTest extends SearchRoot {
	private final String
		LABEL = "leukemia",
		URL,
		Q;
	/**
	 * <p>Returns JSON results inside "bindings"
	 * {
	 * "head": {
	 *	"vars": [ "s", "p", "o" ]
	 * }, 
	 * "results": {
	 *	"bindings": [
	 *		{ .....</p>
	 * <p>LinkedLifeData public us useful for development, but not production</p>
	 */
	public LinkedLifeTest() {
		super();
		URL = environment.getStringProperty("LinkedLifeURL");
		Q = dsl.tripleQuery(LABEL, 1000);
		try {
			String qq = URLEncoder.encode(Q, "UTF-8");
			String query = URL+".json?query="+qq+"&_implicit=false&implicit=true&_form=%2Fsparql";
			IResult r = http.simpleGet(query);
			System.out.println("A "+r.getErrorString());
			environment.logDebug("B\n"+r.getResultObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		environment.shutDown();
		System.exit(0);
		
	}

}

/*
fails
http://linkedlifedata.com/sparql.json%3Fquery%3DSELECT+*+WHERE+%7B%0A+%3Fs+%3Fp+%3Fo+.%0A+%3Fs+rdfs%3Alabel+%27leukemia%27%7D+LIMIT+1000%26_implicit%3Dfalse%26implicit%3Dtrue%26_form%3D%2Fsparql
works through simple get
http://linkedlifedata.com/sparql.json?query=SELECT+*%0D%0AWHERE+%7B%0D%0A++++%3Fs+%3Fp+%3Fo+.%0D%0A++%09%3Fs+rdfs%3Alabel+%27leukemia%27+.%0D%0A%7D+LIMIT+1000&_implicit=false&implicit=true&_form=%2Fsparql";	
works
http://linkedlifedata.com/sparql.json?query=SELECT+*+WHERE+%7B%0A+%3Fs+%3Fp+%3Fo+.%0A+%3Fs+rdfs%3Alabel+%27leukemia%27%7D+LIMIT+1000&_implicit=false&implicit=true&_form=%2Fsparql
[
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T038" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T046" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T047" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T051" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T067" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T070" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/semanticnetwork\/id\/T191" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#Concept" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#Resource" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/1999\/02\/22-rdf-syntax-ns#type" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKAEMIA" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIA" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia [Disease\/Finding]" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythaemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIAS" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia NOS" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukaemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIA NOS" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukaemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia of unspecified cell type" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Unspecified leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythaemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIA, MALIGNANT" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "all types of leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Blood (Leukemia)" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "BLOOD (LEUKEMIA)" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemias, General" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIAS, GENERAL" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia types" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia type" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemias types" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "type leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "types leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2000\/01\/rdf-schema#label" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/LIVB" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/ANAT" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/DISO" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/GENE" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/PHEN" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/PROC" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/DEVI" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/CONC" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/group\/CHEM" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/calbc\/hasCorrelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0027651" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#broaderTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#broaderTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0027671" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#broaderTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0178516" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#broaderTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0678128" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023443" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023493" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023488" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023434" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023440" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023448" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023449" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023465" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023467" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023470" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023473" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023484" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0026998" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0085669" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1279296" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1879321" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0598894" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0596978" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0597646" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1838670" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrowerTransitive" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#exactMatch" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/pubmed\/mesh\/Leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#exactMatch" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/www4.wiwiss.fu-berlin.de\/sider\/resource\/side_effects\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#exactMatch" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#closeMatch" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/pubmed\/mesh\/Leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#closeMatch" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/www4.wiwiss.fu-berlin.de\/sider\/resource\/side_effects\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#closeMatch" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "MSH: A progressive, malignant disease of the blood-forming organs, characterized by distorted proliferation and development of leukocytes and their precursors in the blood and bone marrow. Leukemias were originally termed acute or chronic based on life expectancy but now are classified according to cellular maturity. Acute leukemias consist of predominately immature cells; chronic leukemias are composed of more mature cells. (From The Merck Manual, 2006),CSP: progressive, malignant disease of the blood-forming organs, characterized by distorted proliferation and development of leukocytes and their precursors in the blood and bone marrow; classified according to degree of cell differentiation as acute or chronic, and according to predominant type of cell involved as myelogenous or lymphocytic.,NCI: Cancer that starts in blood-forming tissue such as the bone marrow and causes large numbers of blood cells to be produced and enter the bloodstream.,MEDLINEPLUS: <p>Leukemia is cancer of the white blood cells. White" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#definition" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#inScheme" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#prefLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKAEMIA" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIA" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia [Disease\/Finding]" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythaemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIAS" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia NOS" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukaemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIA NOS" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukaemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemia of unspecified cell type" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Unspecified leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leucocythaemias" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIA, MALIGNANT" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "all types of leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Blood (Leukemia)" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "BLOOD (LEUKEMIA)" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "Leukemias, General" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "LEUKEMIAS, GENERAL" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia types" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemia type" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "leukemias types" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "type leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "types leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "literal", "value": "MSH: A progressive, malignant disease of the blood-forming organs, characterized by distorted proliferation and development of leukocytes and their precursors in the blood and bone marrow. Leukemias were originally termed acute or chronic based on life expectancy but now are classified according to cellular maturity. Acute leukemias consist of predominately immature cells; chronic leukemias are composed of more mature cells. (From The Merck Manual, 2006),CSP: progressive, malignant disease of the blood-forming organs, characterized by distorted proliferation and development of leukocytes and their precursors in the blood and bone marrow; classified according to degree of cell differentiation as acute or chronic, and according to predominant type of cell involved as myelogenous or lymphocytic.,NCI: Cancer that starts in blood-forming tissue such as the bone marrow and causes large numbers of blood cells to be produced and enter the bloodstream.,MEDLINEPLUS: <p>Leukemia is cancer of the white blood cells. White" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#note" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0678128" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023443" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023493" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0027651" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023488" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023434" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023440" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023448" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023449" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023465" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023467" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023470" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023473" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023484" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0026998" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0085669" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1279296" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1879321" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0598894" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0027671" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0178516" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0596978" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0597646" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1838670" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/pubmed\/mesh\/Leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/www4.wiwiss.fu-berlin.de\/sider\/resource\/side_effects\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0001909" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0006726" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0005539" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0005517" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#semanticRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0027651" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#broader" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0178516" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#broader" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023443" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023488" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023440" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023448" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023465" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023470" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023484" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0085669" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C1279296" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0598894" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0596978" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0597646" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#narrower" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0001909" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#related" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0006726" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#related" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0005539" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#related" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/purl.org\/obo\/owlapi\/hpo-conversion#HP_0005517" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#related" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#mappingRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/pubmed\/mesh\/Leukemia" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#mappingRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/www4.wiwiss.fu-berlin.de\/sider\/resource\/side_effects\/C0023418" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2004\/02\/skos\/core#mappingRelation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A7750905" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#prefLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0482717" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0482718" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0482719" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A10764867" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18629580" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A4343717" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0079215" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0079217" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A11973790" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18018776" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18807266" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A7571704" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0079219" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0427744" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0427746" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0427749" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0427745" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0014768" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0014769" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0014771" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A7568400" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0427724" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A0427726" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20250543" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A8360293" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18610995" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18610996" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20244396" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18666809" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A8343681" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A8340873" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20018363" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A19589185" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20020529" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A19580733" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A19584912" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A19580732" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20247450" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18624414" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A7631629" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20235187" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A7603012" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A20247451" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18066993" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18568631" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18661615" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18698571" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18680128" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/label\/A18624415" }, 
				"p": { "type": "uri", "value": "http:\/\/www.w3.org\/2008\/05\/skos-xl#altLabel" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05300637" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R44102382" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R44102383" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05301925" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111921082" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874794" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874796" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874787" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874789" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874786" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874785" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874841" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874842" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874790" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874792" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874843" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874784" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874795" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874788" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874791" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874793" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874833" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874810" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874797" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874823" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874798" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157333" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157335" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157337" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157339" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157341" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157343" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157345" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157347" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157351" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157355" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157359" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157363" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157367" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157375" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129299" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129303" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129307" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129311" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129319" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129323" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129327" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874825" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129331" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129339" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129343" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129347" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129351" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874837" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129367" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874844" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874846" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874845" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874847" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874816" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874849" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129373" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874827" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129371" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129355" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129359" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129363" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129315" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129335" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157371" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111874835" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157349" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157353" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157357" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157361" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157365" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157369" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157373" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134157377" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129301" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129305" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129309" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129313" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129317" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129321" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129325" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129329" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129333" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129337" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129341" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129345" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129349" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129353" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129357" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129361" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129365" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134129369" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R111921574" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R28409264" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R06493953" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R06493954" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R28504290" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348571" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348572" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348573" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348574" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348576" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348578" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348579" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348580" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348581" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348582" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348592" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348583" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348584" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348585" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348586" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348588" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348589" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348590" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348591" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348595" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348596" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348598" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348599" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348600" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348601" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348602" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348603" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348604" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348605" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348606" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348607" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348594" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348575" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348587" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348597" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348577" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R120348593" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71410977" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71119261" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71300211" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71249683" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71003580" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71073551" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71076909" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71072031" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71113356" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71096526" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R128856118" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R28388481" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R28388482" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R28388483" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R123295744" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R123295742" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R123295743" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71106248" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71271604" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71216068" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R70996456" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71216069" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71106247" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71326465" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71216070" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71216079" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71381610" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71051302" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71271612" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R71381611" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00943703" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12426453" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12426451" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12426450" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12426449" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12426452" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12429884" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12429885" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04597915" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04597916" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04602550" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04602548" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04602547" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04602546" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R04602549" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951708" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951706" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951707" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951704" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951705" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546072" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546088" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546113" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546091" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546067" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546150" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546103" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546107" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546124" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546079" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546172" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546176" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546092" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546102" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546192" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546106" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546108" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546109" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546120" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546122" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546110" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546190" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546128" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546127" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546131" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546132" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546084" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546133" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546117" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546137" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546138" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546141" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546140" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546142" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546183" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546144" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546181" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546076" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546148" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546147" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546146" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546069" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546077" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546152" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546154" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546149" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546157" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546158" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546078" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546159" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546161" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546162" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546165" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546167" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546169" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546171" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546071" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546173" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546174" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546082" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546070" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546178" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546126" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546145" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546180" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546057" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546063" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546064" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546065" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546066" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546068" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546083" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546155" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546182" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546163" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546175" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546096" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546123" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546177" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546085" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546184" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546179" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546143" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546139" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546135" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546136" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546098" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546100" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546094" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546130" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546153" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546121" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546097" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546151" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546104" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546116" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546115" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546168" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546089" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546101" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546099" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546060" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546119" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546160" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546156" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546187" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546118" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546095" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546164" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546134" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546111" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546185" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546186" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546188" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546189" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546191" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546129" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546086" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546112" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546074" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546075" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546059" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546058" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546093" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546087" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546081" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546061" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546114" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546105" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546125" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546170" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546062" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546073" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546090" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546166" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546080" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R12546193" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05778092" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05778091" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951719" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00943711" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951718" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00943710" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951721" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951720" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00943712" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00951722" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05204567" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05204568" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05204569" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05218883" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00692231" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00692232" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05240829" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747020" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747023" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747018" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747019" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747024" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747021" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747025" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00747022" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662881" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662882" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662889" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662883" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662884" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662880" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662885" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662887" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662888" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05662886" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05673164" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00894143" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906255" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906256" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906263" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906257" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906258" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906254" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906259" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906261" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906262" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00906260" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00913710" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R00913709" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R43987469" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R43987468" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R43987470" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05722156" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05722157" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05722158" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05722159" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R05722155" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60734459" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60519398" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60664785" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60665997" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R108508425" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60578622" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R132871112" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494954" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567168" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494940" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567154" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198856" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198821" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198816" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494970" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567184" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198817" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494955" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567169" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494943" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567157" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494941" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567155" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198848" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198849" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494963" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567177" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494926" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567140" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198830" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198839" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198840" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198835" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494934" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567148" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198831" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198841" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494964" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567178" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494971" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567185" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198857" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198842" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198818" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198863" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494923" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567137" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494945" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567159" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494981" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567195" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198871" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494935" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567149" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494936" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567150" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494946" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567160" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494956" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567170" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198850" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494947" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567161" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494948" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567162" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494919" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567133" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494966" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567180" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198822" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198823" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198858" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198855" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198864" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198865" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494958" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567172" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494928" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567142" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494937" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567151" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494942" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567156" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494959" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567173" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494967" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567181" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198868" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198819" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198826" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198827" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198833" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198838" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198843" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198844" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198845" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198852" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198853" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198869" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494960" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567174" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198854" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494961" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567175" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198847" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198860" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198861" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198862" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494950" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567164" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494968" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567182" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494976" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567190" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494944" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567158" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494949" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567163" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494975" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567189" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494938" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567152" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494951" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567165" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494952" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567166" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494921" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567135" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494979" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567193" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494932" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567146" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494933" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567147" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494962" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567176" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494925" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567139" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494939" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567153" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494953" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567167" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494972" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567186" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494924" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567138" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494982" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567196" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494983" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567197" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494931" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567145" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494969" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567183" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494980" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567194" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198820" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198846" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198829" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494920" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567134" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494930" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567144" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494977" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567191" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494978" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567192" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494929" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567143" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494973" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567187" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198828" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198834" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198870" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494974" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567188" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494922" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567136" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198824" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198825" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198832" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198836" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198837" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R132455069" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R132455070" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198851" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198859" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R132455071" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R132455072" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198866" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R116198867" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494927" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567141" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494957" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567171" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134494965" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R134567179" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337027" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337028" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337029" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337030" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337031" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337032" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119337033" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R119380743" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R123295263" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R123296990" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130963964" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130963965" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130959720" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130959715" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130959718" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130959719" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130959716" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R130959717" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036238" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036240" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036296" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036241" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036242" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036320" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036325" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036324" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036247" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036312" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036336" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036328" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036224" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036348" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036252" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036331" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036269" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036262" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036236" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036297" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036310" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036289" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036298" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036249" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036318" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036263" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036274" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036260" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036230" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036307" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036338" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036305" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036258" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036266" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036259" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036300" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036267" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036268" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036234" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036282" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036288" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036229" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036351" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036244" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036341" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036342" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036314" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036227" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036275" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036278" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036295" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036251" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036322" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036281" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036329" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036271" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036232" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036231" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036332" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036294" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036319" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036344" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036349" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036339" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036304" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036306" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036326" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036335" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036333" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036243" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036246" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036287" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036254" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036280" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036316" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036311" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036308" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036257" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036276" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036239" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036283" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036237" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036301" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036334" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036286" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036343" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036279" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036255" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036293" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036225" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036272" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036291" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036317" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036256" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036226" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036315" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036321" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036285" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036261" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036350" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036273" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036302" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036340" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036347" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036345" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036270" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036330" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036323" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036264" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036233" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036292" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036284" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036327" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036313" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036245" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036250" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036290" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036228" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036277" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036248" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036253" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036346" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036265" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036352" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036299" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036235" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036309" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036303" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R131036337" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R129098305" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R129102470" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R129099293" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R129104639" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60463469" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60465947" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60465289" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60466340" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60464013" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60464214" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R60463875" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54263834" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54425021" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54326682" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R109434111" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291355" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291356" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291365" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291357" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291369" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291366" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54326683" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291359" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291362" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291363" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R99699181" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54413244" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291367" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291368" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54398979" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54355337" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54425022" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54405268" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R109434113" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54344664" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964658" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964663" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964659" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964651" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964652" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964649" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964656" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R99699182" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291342" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291350" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291344" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291353" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291352" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291346" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R99699184" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291349" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291340" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291341" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291343" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291354" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291338" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R54291339" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R114964646" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}, 
			{
				"s": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/id\/C0023418" }, 
				"o": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation\/R99699183" }, 
				"p": { "type": "uri", "value": "http:\/\/linkedlifedata.com\/resource\/umls\/relation" }
			}
		]
*/
