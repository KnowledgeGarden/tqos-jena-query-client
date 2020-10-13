/**
 * 
 */
package searchdevtests;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 * Testing a URL returned by DBPedia to see what it returns.
 * it returns an HTML document.
 */
public class SimpleTest extends SearchRoot {
	private final String URL = 
		"http://linkedlifedata.com/sparql.json?query=SELECT+*%0D%0AWHERE+%7B%0D%0A++++%3Fs+%3Fp+%3Fo+.%0D%0A++%09%3Fs+rdfs%3Alabel+%27leukemia%27+.%0D%0A%7D+LIMIT+1000&_implicit=false&implicit=true&_form=%2Fsparql";	
			//"http://dbpedia.org/resource/Chronic_myelogenous_leukemia";
	
	/**
	 * 
	 */
	public SimpleTest() {
		super();
		IResult r = http.simpleGet(URL);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
	}

}
/*

A 
B <?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML+RDFa 1.0//EN" "http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:dbpprop="http://dbpedia.org/property/"
    xmlns:foaf="http://xmlns.com/foaf/0.1/"
    version="XHTML+RDFa 1.0"
    xml:lang="en"
>


<!-- header -->
<head profile="http://www.w3.org/1999/xhtml/vocab">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>About: Chronic myelogenous leukemia</title>
    <link rel="alternate" type="application/rdf+xml" 		href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.rdf" title="Structured Descriptor Document (RDF/XML format)" />
    <link rel="alternate" type="text/n3" 			href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.n3" title="Structured Descriptor Document (N3 format)" />
    <link rel="alternate" type="text/turtle" 			href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.ttl" title="Structured Descriptor Document (Turtle format)" />
    <link rel="alternate" type="application/json+rdf" 		href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.jrdf" title="Structured Descriptor Document (RDF/JSON format)" />
    <link rel="alternate" type="application/json" 		href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.json" title="Structured Descriptor Document (RDF/JSON format)" />
    <link rel="alternate" type="application/atom+xml" 		href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.atom" title="OData (Atom+Feed format)" />
    <link rel="alternate" type="text/plain" 			href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.ntriples" title="Structured Descriptor Document (N-Triples format)" />
    <link rel="alternate" type="text/csv"   			href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fcsv" title="Structured Descriptor Document (CSV format)" />
    
    <link rel="alternate" type="text/cxml"  			href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fcxml" title="Structured Descriptor Document (CXML format)" />
    
    <link rel="alternate" type="application/microdata+json"	href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=application%2Fmicrodata%2Bjson" title="Structured Descriptor Document (Microdata/JSON format)" />
    <link rel="alternate" type="text/html" 			href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fhtml" title="Structured Descriptor Document (Microdata/HTML format)" />
    <link rel="alternate" type="application/ld+json" 		href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=application%2Fjson-ld" title="Structured Descriptor Document (JSON-LD format)" />
    <link rel="alternate" type="text/x-html-script-ld+json"	href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fx-html-script-ld%2Bjson" title="Structured Descriptor Document (HTML with embedded JSON-LD)" />
    <link rel="alternate" type="text/x-html-script-turtle"	href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fx-html-script-turtle" title="Structured Descriptor Document (HTML with embedded Turtle)" />
    <link rel="timegate" type="text/html" 			href="http://dbpedia.mementodepot.org/timegate/http://dbpedia.org/page/Chronic_myelogenous_leukemia" title="Time Machine" />
    <link rel="foaf:primarytopic" 				href="http://dbpedia.org/resource/Chronic_myelogenous_leukemia"/>
    <link rev="describedby" 					href="http://dbpedia.org/resource/Chronic_myelogenous_leukemia"/>
    <link rel="stylesheet" type="text/css"			href="/statics/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" 			href="/statics/css/dbpedia.css" />
</head>
<body about="http://dbpedia.org/resource/Chronic_myelogenous_leukemia">
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
	<div class="navbar-header">
	    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#dbp-navbar" aria-expanded="false">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="http://wiki.dbpedia.org/about" title="About DBpedia" style="color: #2c5078">
	    <img class="img-responsive" src="/statics/images/dbpedia_logo_land_120.png" alt="About DBpedia" style="display: inline-block;  margin-top: -12px"/>
	    </a>
	</div>

	<div class="collapse navbar-collapse" id="dbp-navbar">
	    <ul class="nav navbar-nav navbar-right">
		<li><a class="active" href="/fct/" title="Switch to /fct endpoint"><span class="glyphicon glyphicon-new-window" aria-hidden="true"></span> Faceted Browser </a></li>
		<li><a class="active" href="/sparql/" title="Switch to /sparql endpoint"><span class="glyphicon glyphicon-new-window" aria-hidden="true"></span> Sparql Endpoint </a></li>
	    </ul>
	    <ul class="nav navbar-nav">
	    <li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Browse using <span class="caret"></span></a>
		<ul class="dropdown-menu">
		<li><a href="/describe/?uri=http%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia">OpenLink Faceted Browser</a></li>
		<li><a href="http://linkeddata.uriburner.com/rdf-editor/#/editor?uri=http%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia&amp;view=statements">OpenLink Structured Data Editor</a></li>
		<li><a href="http://en.lodlive.it/?http%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia">LodLive Browser</a></li>
		<li><a href="http://lodmilla.sztaki.hu/lodmilla/?url=http%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia">LODmilla Browser</a></li>
		</ul>
	    </li>
	    <li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-file" aria-hidden="true"></span> Formats <span class="caret"></span></a>
		<ul class="dropdown-menu">
		<li>&nbsp;RDF:</li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.ntriples">N-Triples</a></li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.n3">N3</a></li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.ttl">Turtle</a></li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.json">JSON</a></li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.rdf">XML</a></li>
		<li class="divider"></li>
		<li>&nbsp;OData:</li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.atom">Atom</a></li>
		    <li><a href="http://dbpedia.org/data/Chronic_myelogenous_leukemia.jsod">JSON</a></li>
		<li class="divider"></li>
		<li>&nbsp;Microdata:</li>
		    <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=application%2Fmicrodata%2Bjson">JSON</a></li>
		    <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fhtml">HTML</a></li>
		<li class="divider"></li>
		<li>&nbsp;Embedded:</li>
		    <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fx-html-script-ld%2Bjson">JSON</a></li>
		    <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fx-html-script-turtle">Turtle</a></li>
		<li class="divider"></li>
		    
		        <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fcxml">CXML</a></li>
		    
		    <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=text%2Fcsv">CSV</a></li>
		    <li><a href="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&amp;query=DESCRIBE%20%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FChronic_myelogenous_leukemia%3E&amp;format=application%2Fjson-ld">JSON-LD</a></li>
		</ul>
	    </li>
	    </ul>
	</div>
    </div>
</div>

<div class="container">
<!-- page-header -->
    <div class="page-header">
	<!-- div class="pull-right">
	    <a href="http://wiki.dbpedia.org/about" title="About DBpedia">
	    <img class="img-responsive" src="/statics/images/dbpedia_logo_land_120.png" alt="About DBpedia"/>
	    </a>
	</div -->
	<h1 id="title">About:
	    <a href="http://dbpedia.org/resource/Chronic_myelogenous_leukemia">Chronic myelogenous leukemia</a>
	</h1>
	<div class="page-resource-uri">
	    An Entity of Type : <a href="http://dbpedia.org/ontology/Disease">disease</a>,
	    from Named Graph : <a href="http://dbpedia.org">http://dbpedia.org</a>,
	    within Data Space : <a href="http://dbpedia.org">dbpedia.org</a>
	</div>
    </div>
<!-- page-header -->
<!-- row -->
    <div class="row">
	<div class="col-xs-12">
	    <p class="lead">Chronic myelogenous (or myeloid or myelocytic) leukemia (CML), also known as chronic granulocytic leukemia (CGL), is a cancer of the white blood cells. It is a form of leukemia characterized by the increased and unregulated growth of predominantly myeloid cells in the bone marrow and the accumulation of these cells in the blood. CML is a clonal bone marrow stem cell disorder in which a proliferation of mature granulocytes (neutrophils, eosinophils and basophils) and their precursors is found. It is a type of myeloproliferative disease associated with a characteristic chromosomal translocation called the Philadelphia chromosome. CML is now largely treated with targeted drugs called tyrosine kinase inhibitors (TKIs) which have led to dramatically improved long-term survival rates since the i</p>
	</div>
	<div class="col-xs-12">
	    <!-- proptable -->
	    <table class="description table table-striped">
	    <tr>
		<th class="col-xs-3">Property</th>
		<th class="col-xs-9">Value</th>
	    </tr>
<tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/abstract"><small>dbo:</small>abstract</a>
</td><td><ul>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="ar">25بك المحتوى هنا ينقصه الاستشهاد بمصادر. يرجى إيراد مصادر موثوق بها. أي معلومات غير موثقة يمكن التشكيك بها وإزالتها. (فبراير 2016) أبيضاض الدم النقوي المزمن (بالإنجليزية: Chronic Myeloid Leukemia) هو مرض سرطاني يصيب الخلايا الجذعية متعددة القدرات المسؤولة عن تصنيع خلايا الدم (Pluripotent Hematopoietic Stem Cells). ويتميز عن أبيضاض الدم النقوي الحاد ببطء سير المرض في جسم المريض. ومن أهم العلامات الفارقة في هذا المرض وجود اضطراب وراثي خلوي يسمى وبصبغي فيلادلفيا. يتم استخدام عدة أساليب للعلاج ومن أهمها دواء إماتينيب (Imatinib) وزراعة نخاع العظم الخيفي (Allogenic HSC transplant). يشكل ما نسبته 15% من حالات الإصابة بأبيضاض الدم بمختلف الفئات العمرية، ويتم تشخيص 1-1.5 حالة لكل 100000 شخص سنويا. متوسط عمر الإصابة للمريض ما بيين 50-60 عاما، ومثله كمثل أبيضاض الدم النقوي الحاد لا يوجد أي سبب معين لحدوث المرض مثل أسباب وراثية أو عوامل معدية. وجد أن الإشعاعات الناتجة من القنبلة الذرية في هيروشيما ونكازاكي لها دور في حدوث المرض وتعتبر كعوامل مخطرة.</span><small> (ar)</small></span></li>
	<li><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="en">Chronic myelogenous (or myeloid or myelocytic) leukemia (CML), also known as chronic granulocytic leukemia (CGL), is a cancer of the white blood cells. It is a form of leukemia characterized by the increased and unregulated growth of predominantly myeloid cells in the bone marrow and the accumulation of these cells in the blood. CML is a clonal bone marrow stem cell disorder in which a proliferation of mature granulocytes (neutrophils, eosinophils and basophils) and their precursors is found. It is a type of myeloproliferative disease associated with a characteristic chromosomal translocation called the Philadelphia chromosome. CML is now largely treated with targeted drugs called tyrosine kinase inhibitors (TKIs) which have led to dramatically improved long-term survival rates since the introduction of the first such agent in 2001. These drugs have revolutionized treatment of this disease and allow most patients to have a good quality of life when compared to the former chemotherapy drugs. In Western countries, CML accounts for 15-20% of all adult leukemias and 14% of leukemias overall (including the pediatric population).</span><small> (en)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="de">Die chronische myeloische Leukämie (CML), auch chronische Myelose genannt, ist eine chronische Leukämie, die mit einer starken Vermehrung von Leukozyten (weißen Blutkörperchen), speziell von Granulozyten und ihren Vorstufen, im Blut und im blutbildenden Knochenmark einhergeht. Die Erkrankung ist in der Anfangsphase häufig symptomlos. Die CML gehört zur Gruppe der myeloproliferativen Neoplasien (MPN), also Krankheiten, die aus einer (genetischen) Störung der im Knochenmark vorzufindenden hämatopoetischen Stammzellen resultieren. Bei der von Rudolf Virchow im Jahr 1845 beschriebenen und erstmals mit dem Namen Leukämie belegten Erkrankung handelte es sich mit hoher Wahrscheinlichkeit um eine CML. Durch den Einsatz neuerer tumorspezifischer Medikamente, den sogenannten Tyrosinkinase-Inhibitoren, seit etwa der Jahrtausendwende haben sich die Prognose und die Behandlungsformen der CML deutlich gewandelt und die Erkrankung ist in vielen Fällen gut und verhältnismäßig nebenwirkungsarm behandelbar geworden. Die CML ist durch diesen Einsatz sogenannter zielgerichteter Therapien (engl. targeted therapies) geradezu zu einer Modellerkrankung für die ganze Hämatologie oder Tumortherapie im Allgemeinen geworden.</span><small> (de)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="es">La leucemia mieloide crónica (LMC) es una enfermedad clasificada dentro del síndrome mieloproliferativo crónico (conjunto de enfermedades que afectan a la sangre) caracterizado por una proliferación de los glóbulos blancos de la serie granulocítica hasta las últimas fases madurativas de su diferenciación. Circula con los granulocitosis a nivel de la sangre periférica. Algunos reportes indican que la LMC representa por lo menos el 9% del total de casos de leucemia.</span><small> (es)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="fr">La leucémie myéloïde chronique (LMC) est une prolifération myéloïde monoclonale sans blocage de maturation prédominant sur la lignée granuleuse au niveau médullaire et splénique. Dans l&#39;espèce humaine, elle fait partie des 4 grands syndromes myéloprolifératifs (avec la maladie de Vaquez, la thrombocytémie essentielle et la splénomégalie myéloïde). Elle touche surtout l&#39;adulte entre 30 et 50 ans et est favorisée par l&#39;exposition au benzène et aux rayons ionisants.</span><small> (fr)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="it">La leucemia mieloide cronica (LMC) è una condizione clinica patologica determinata dalla proliferazione monoclonale incontrollata di una sola cellula multipotente colpita dall&#39;evento leucemogeno. La malattia può coinvolgere le linee mieloide, monocitica, eritroide, megacariocitica e talora anche il compartimento linfoide. Gli anni 2005-2010 hanno visto un cambiamento radicale nella terapia e nella prognosi della leucemia mieloide cronica, ottenuto grazie all&#39;utilizzo delle conoscenze sulla patogenesi molecolare della malattia; il miglioramento è stato paragonato alla scoperta degli antibiotici per il trattamento delle malattie causate da batteri.</span><small> (it)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="ja">慢性骨髄性白血病（まんせいこつずいせいはっけつびょう　Chronic myelogenous leukemia ,CML）とは、造血幹細胞の遺伝子が後天的に変異して、造血細胞が分化・成熟能を保ったまま自律的な増殖をし、血液において白血球や時に血小板が増加する血液腫瘍である。</span><small> (ja)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="pl">Przewlekła białaczka szpikowa (łac. myelosis leukaemica chronica, używany jest skrótowiec CML od ang. chronic myeloid leukemia) – zespół mieloproliferacyjny polegający na rozroście klonalnym przekształconej nowotworowo komórki macierzystej szpiku kostnego.</span><small> (pl)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="nl">Chronische myeloïde leukemie, ook wel CML, is een vorm van leukemie waarbij er een overmatige productie is van witte bloedcellen. Bij 95% van CML-patiënten wordt ook het Philadelphia chromosoom gevonden, een genetische abnormaliteit die kan ontstaan door straling (onder andere als gevolg van bestraling van andere kankervormen). CML is een zeldzame ziekte. Per jaar komen er in Nederland zo’n 200-250 patiënten bij. De meeste patiënten zijn te vinden in de leeftijdsgroep van 50 tot 60 jaar. CML komt vaker voor bij mannen dan bij vrouwen. Als medicijn kan imatinib worden toegediend waarvoor een studie in het New England Journal of Medicine een vijfjaarsoverleving van 89% laat zien. Ook de weesgeneesmiddelen Dasatinib (Sprycel) en Nilotinib (tasigna) kunnen gebruikt worden als remmende medicatie van deze afwijking.</span><small> (nl)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="pt">Leucemia mieloide crônica (português brasileiro) ou leucemia mieloide crónica (português europeu) (LMC) é uma forma de leucemia crônica caracterizada pela proliferação de células da linhagem granulocítica sem a perda de capacidade de diferenciação. É um tipo de doença mieloproliferativa característica por uma aberração citogenética ocasionada por uma translocação entre o cromossomo 9 e 22; t(9;22). Essa translocação resulta em um cromossomo 22 mais encurtado, chamado de cromossomo Filadélfia (cromossomo Ph1). Ocorre a fusão de dois genes nos cromossomos 9 e 22, chamados respectivamente de abl e bcr. É uma doença mais comum em adultos entre 40-50. Quando acomete jovens, a doença é mais agressiva que o normal.</span><small> (pt)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="zh">慢性粒细胞性白血病（英语：Chronic Granulocytic Leukemia, CGL），或称慢性髓细胞性白血病（英语：Chronic Myelogenous Leukemia, CML），是一类白血病。这种白血病表现为人体骨髓中的主要粒细胞不受管制地增长，并在血液中积累而形成。这种获得性骨髓造血干细胞，即成熟的粒细胞（中性粒细胞、嗜酸性粒细胞和嗜碱性粒细胞）进行恶性克隆衍生，通常并伴生一种骨髓增生性疾病。这种疾病源自一种称为费城染色体（英语：Philadelphia chromosome）的染色体易位现象（9号染色体长臂移至22号染色体短臂上）。对于慢性粒细胞性白血病的一类靶向治疗包括有伊马替尼（英语：imatinib）、达沙替尼（英语：dasatinib）和尼罗替尼（英语：nilotinib），这类靶向治疗方式对缓解治疗慢性粒细胞性白血病有非常良好的效果，患者可以獲得接近一般人的生活品質及預期壽命。</span><small> (zh)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="dbo:abstract" xmlns:dbo="http://dbpedia.org/ontology/" xml:lang="ru">Хронический миелоидный лейкоз (ХМЛ, хронический миелолейкоз) — форма лейкоза, которая характеризуется ускоренной и нерегулируемой пролиферацией преимущественно миелоидных клеток в костном мозге с их накоплением в крови.ХМЛ — гемопоэтическое клональное заболевание, основным проявлением которого является пролиферация зрелых гранулоцитов (нейтрофилов, эозинофилов и базофилов) и их предшественников. Это миелопролиферативное заболевание ассоциировано с характерной хромосомной транслокацией (филадельфийской хромосомой). В настоящее время основным способом лечения хронического миелолейкоза является таргетная (целевая) терапия ингибиторами тирозинкиназ, такими как иматиниб, нилотиниб, дазатиниб и другие, значительно улучшившая показатели выживаемости.</span><small> (ru)</small></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/icd10"><small>dbo:</small>icd10</a>
</td><td><ul>
	<li><span class="literal"><span property="dbo:icd10" xmlns:dbo="http://dbpedia.org/ontology/">C92.1</span></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/icd9"><small>dbo:</small>icd9</a>
</td><td><ul>
	<li><span class="literal"><span property="dbo:icd9" xmlns:dbo="http://dbpedia.org/ontology/">205.1</span></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/meshId"><small>dbo:</small>meshId</a>
</td><td><ul>
	<li><span class="literal"><span property="dbo:meshId" xmlns:dbo="http://dbpedia.org/ontology/">D015464</span></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/thumbnail"><small>dbo:</small>thumbnail</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="dbo:thumbnail" xmlns:dbo="http://dbpedia.org/ontology/" href="http://commons.wikimedia.org/wiki/Special:FilePath/Bcrablmet.jpg?width=300"><small>wiki-commons</small>:Special:FilePath/Bcrablmet.jpg?width=300</a></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/wikiPageExternalLink"><small>dbo:</small>wikiPageExternalLink</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="dbo:wikiPageExternalLink nofollow" xmlns:dbo="http://dbpedia.org/ontology/" href="http://www.cancer.org/docroot/CRI/CRI_2_3x.asp?dt=83">http://www.cancer.org/docroot/CRI/CRI_2_3x.asp?dt=83</a></span></li>
	<li><span class="literal"><a class="uri" rel="dbo:wikiPageExternalLink nofollow" xmlns:dbo="http://dbpedia.org/ontology/" href="http://pubweb.fccc.edu/philadelphiachromosome/">http://pubweb.fccc.edu/philadelphiachromosome/</a></span></li>
	<li><span class="literal"><a class="uri" rel="dbo:wikiPageExternalLink nofollow" xmlns:dbo="http://dbpedia.org/ontology/" href="http://www.cmleukemia.com/">http://www.cmleukemia.com/</a></span></li>
	<li><span class="literal"><a class="uri" rel="dbo:wikiPageExternalLink nofollow" xmlns:dbo="http://dbpedia.org/ontology/" href="http://www.leukemia-lymphoma.org/all_page?item_id=8501">http://www.leukemia-lymphoma.org/all_page?item_id=8501</a></span></li>
	<li><span class="literal"><a class="uri" rel="dbo:wikiPageExternalLink nofollow" xmlns:dbo="http://dbpedia.org/ontology/" href="http://www.spirit-cml.org/spirit-2-home.aspx">http://www.spirit-cml.org/spirit-2-home.aspx</a></span></li>
	<li><span class="literal"><a class="uri" rel="dbo:wikiPageExternalLink nofollow" xmlns:dbo="http://dbpedia.org/ontology/" href="http://www.nationalcmlsociety.org">http://www.nationalcmlsociety.org</a></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/wikiPageID"><small>dbo:</small>wikiPageID</a>
</td><td><ul>
	<li><span class="literal"><span property="dbo:wikiPageID" xmlns:dbo="http://dbpedia.org/ontology/">559874</span><small> (xsd:integer)</small></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/ontology/wikiPageRevisionID"><small>dbo:</small>wikiPageRevisionID</a>
</td><td><ul>
	<li><span class="literal"><span property="dbo:wikiPageRevisionID" xmlns:dbo="http://dbpedia.org/ontology/">741178451</span><small> (xsd:integer)</small></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/property/caption"><small>dbp:</small>caption</a>
</td><td><ul>
	<li><span class="literal"><span property="dbp:caption">The Philadelphia chromosome as seen by metaphase FISH.</span></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/property/diseasesdb"><small>dbp:</small>diseasesdb</a>
</td><td><ul>
	<li><span class="literal"><span property="dbp:diseasesdb">2659</span><small> (xsd:integer)</small></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/property/emedicinesubj"><small>dbp:</small>emedicinesubj</a>
</td><td><ul>
	<li><span class="literal"><span property="dbp:emedicinesubj">med</span></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/property/emedicinetopic"><small>dbp:</small>emedicinetopic</a>
</td><td><ul>
	<li><span class="literal"><span property="dbp:emedicinetopic">371</span><small> (xsd:integer)</small></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/property/field"><small>dbp:</small>field</a>
</td><td><ul>
	<li><span class="literal"><span property="dbp:field">Hematology and oncology</span></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://dbpedia.org/property/medlineplus"><small>dbp:</small>medlineplus</a>
</td><td><ul>
	<li><span class="literal"><span property="dbp:medlineplus">570</span><small> (xsd:integer)</small></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://dbpedia.org/property/wordnet_type"><small>dbp:</small>wordnet_type</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="dbp:wordnet_type nofollow" href="http://www.w3.org/2006/03/wn/wn20/instances/synset-disease-noun-1">http://www.w3.org/2006/03/wn/wn20/instances/synset-disease-noun-1</a></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://purl.org/dc/terms/subject"><small>dct:</small>subject</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="dct:subject" xmlns:dct="http://purl.org/dc/terms/" href="http://dbpedia.org/resource/Category:Chronic_myeloid_leukemia"><small>dbc</small>:Chronic_myeloid_leukemia</a></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://purl.org/linguistics/gold/hypernym">http://purl.org/linguistics/gold/hypernym</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="ns1:hypernym" xmlns:ns1="http://purl.org/linguistics/gold/" href="http://dbpedia.org/resource/Cancer"><small>dbr</small>:Cancer</a></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://www.w3.org/1999/02/22-rdf-syntax-ns#type"><small>rdf:</small>type</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://www.w3.org/2002/07/owl#Thing"><small>owl</small>:Thing</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://www.wikidata.org/entity/Q12136"><small>wikidata</small>:Q12136</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/ontology/Disease"><small>dbo</small>:Disease</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://umbel.org/umbel/rc/AilmentCondition"><small>umbel-rc</small>:AilmentCondition</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/WikicatHematologicNeoplasms"><small>yago</small>:WikicatHematologicNeoplasms</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Abstraction100002137"><small>yago</small>:Abstraction100002137</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Attribute100024264"><small>yago</small>:Attribute100024264</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/BloodDisease114189204"><small>yago</small>:BloodDisease114189204</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/BloodDyscrasia114053850"><small>yago</small>:BloodDyscrasia114053850</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Condition113920835"><small>yago</small>:Condition113920835</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Disease114070360"><small>yago</small>:Disease114070360</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Dyscrasia114053717"><small>yago</small>:Dyscrasia114053717</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Growth114234074"><small>yago</small>:Growth114234074</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/IllHealth114052046"><small>yago</small>:IllHealth114052046</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Illness114061805"><small>yago</small>:Illness114061805</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/PathologicalState114051917"><small>yago</small>:PathologicalState114051917</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/PhysicalCondition114034177"><small>yago</small>:PhysicalCondition114034177</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/State100024720"><small>yago</small>:State100024720</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/Tumor114235200"><small>yago</small>:Tumor114235200</a></span></li>
	<li><span class="literal"><a class="uri" rel="rdf:type" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" href="http://dbpedia.org/class/yago/WikicatBloodDisorders"><small>yago</small>:WikicatBloodDisorders</a></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://www.w3.org/2000/01/rdf-schema#comment"><small>rdfs:</small>comment</a>
</td><td><ul>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="es">La leucemia mieloide crónica (LMC) es una enfermedad clasificada dentro del síndrome mieloproliferativo crónico (conjunto de enfermedades que afectan a la sangre) caracterizado por una proliferación de los glóbulos blancos de la serie granulocítica hasta las últimas fases madurativas de su diferenciación. Circula con los granulocitosis a nivel de la sangre periférica. Algunos reportes indican que la LMC representa por lo menos el 9% del total de casos de leucemia.</span><small> (es)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="fr">La leucémie myéloïde chronique (LMC) est une prolifération myéloïde monoclonale sans blocage de maturation prédominant sur la lignée granuleuse au niveau médullaire et splénique. Dans l&#39;espèce humaine, elle fait partie des 4 grands syndromes myéloprolifératifs (avec la maladie de Vaquez, la thrombocytémie essentielle et la splénomégalie myéloïde). Elle touche surtout l&#39;adulte entre 30 et 50 ans et est favorisée par l&#39;exposition au benzène et aux rayons ionisants.</span><small> (fr)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="ja">慢性骨髄性白血病（まんせいこつずいせいはっけつびょう　Chronic myelogenous leukemia ,CML）とは、造血幹細胞の遺伝子が後天的に変異して、造血細胞が分化・成熟能を保ったまま自律的な増殖をし、血液において白血球や時に血小板が増加する血液腫瘍である。</span><small> (ja)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="pl">Przewlekła białaczka szpikowa (łac. myelosis leukaemica chronica, używany jest skrótowiec CML od ang. chronic myeloid leukemia) – zespół mieloproliferacyjny polegający na rozroście klonalnym przekształconej nowotworowo komórki macierzystej szpiku kostnego.</span><small> (pl)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="pt">Leucemia mieloide crônica (português brasileiro) ou leucemia mieloide crónica (português europeu) (LMC) é uma forma de leucemia crônica caracterizada pela proliferação de células da linhagem granulocítica sem a perda de capacidade de diferenciação. É um tipo de doença mieloproliferativa característica por uma aberração citogenética ocasionada por uma translocação entre o cromossomo 9 e 22; t(9;22). Essa translocação resulta em um cromossomo 22 mais encurtado, chamado de cromossomo Filadélfia (cromossomo Ph1). Ocorre a fusão de dois genes nos cromossomos 9 e 22, chamados respectivamente de abl e bcr. É uma doença mais comum em adultos entre 40-50. Quando acomete jovens, a doença é mais agressiva que o normal.</span><small> (pt)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="zh">慢性粒细胞性白血病（英语：Chronic Granulocytic Leukemia, CGL），或称慢性髓细胞性白血病（英语：Chronic Myelogenous Leukemia, CML），是一类白血病。这种白血病表现为人体骨髓中的主要粒细胞不受管制地增长，并在血液中积累而形成。这种获得性骨髓造血干细胞，即成熟的粒细胞（中性粒细胞、嗜酸性粒细胞和嗜碱性粒细胞）进行恶性克隆衍生，通常并伴生一种骨髓增生性疾病。这种疾病源自一种称为费城染色体（英语：Philadelphia chromosome）的染色体易位现象（9号染色体长臂移至22号染色体短臂上）。对于慢性粒细胞性白血病的一类靶向治疗包括有伊马替尼（英语：imatinib）、达沙替尼（英语：dasatinib）和尼罗替尼（英语：nilotinib），这类靶向治疗方式对缓解治疗慢性粒细胞性白血病有非常良好的效果，患者可以獲得接近一般人的生活品質及預期壽命。</span><small> (zh)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="ru">Хронический миелоидный лейкоз (ХМЛ, хронический миелолейкоз) — форма лейкоза, которая характеризуется ускоренной и нерегулируемой пролиферацией преимущественно миелоидных клеток в костном мозге с их накоплением в крови.ХМЛ — гемопоэтическое клональное заболевание, основным проявлением которого является пролиферация зрелых гранулоцитов (нейтрофилов, эозинофилов и базофилов) и их предшественников. Это миелопролиферативное заболевание ассоциировано с характерной хромосомной транслокацией (филадельфийской хромосомой). В настоящее время основным способом лечения хронического миелолейкоза является таргетная (целевая) терапия ингибиторами тирозинкиназ, такими как иматиниб, нилотиниб, дазатиниб и другие, значительно улучшившая показатели выживаемости.</span><small> (ru)</small></span></li>
	<li><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="en">Chronic myelogenous (or myeloid or myelocytic) leukemia (CML), also known as chronic granulocytic leukemia (CGL), is a cancer of the white blood cells. It is a form of leukemia characterized by the increased and unregulated growth of predominantly myeloid cells in the bone marrow and the accumulation of these cells in the blood. CML is a clonal bone marrow stem cell disorder in which a proliferation of mature granulocytes (neutrophils, eosinophils and basophils) and their precursors is found. It is a type of myeloproliferative disease associated with a characteristic chromosomal translocation called the Philadelphia chromosome. CML is now largely treated with targeted drugs called tyrosine kinase inhibitors (TKIs) which have led to dramatically improved long-term survival rates since the i</span><small> (en)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="ar">25بك المحتوى هنا ينقصه الاستشهاد بمصادر. يرجى إيراد مصادر موثوق بها. أي معلومات غير موثقة يمكن التشكيك بها وإزالتها. (فبراير 2016) أبيضاض الدم النقوي المزمن (بالإنجليزية: Chronic Myeloid Leukemia) هو مرض سرطاني يصيب الخلايا الجذعية متعددة القدرات المسؤولة عن تصنيع خلايا الدم (Pluripotent Hematopoietic Stem Cells). ويتميز عن أبيضاض الدم النقوي الحاد ببطء سير المرض في جسم المريض. ومن أهم العلامات الفارقة في هذا المرض وجود اضطراب وراثي خلوي يسمى وبصبغي فيلادلفيا. يتم استخدام عدة أساليب للعلاج ومن أهمها دواء إماتينيب (Imatinib) وزراعة نخاع العظم الخيفي (Allogenic HSC transplant).</span><small> (ar)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="de">Die chronische myeloische Leukämie (CML), auch chronische Myelose genannt, ist eine chronische Leukämie, die mit einer starken Vermehrung von Leukozyten (weißen Blutkörperchen), speziell von Granulozyten und ihren Vorstufen, im Blut und im blutbildenden Knochenmark einhergeht. Die Erkrankung ist in der Anfangsphase häufig symptomlos.</span><small> (de)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="it">La leucemia mieloide cronica (LMC) è una condizione clinica patologica determinata dalla proliferazione monoclonale incontrollata di una sola cellula multipotente colpita dall&#39;evento leucemogeno. La malattia può coinvolgere le linee mieloide, monocitica, eritroide, megacariocitica e talora anche il compartimento linfoide.</span><small> (it)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:comment" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="nl">Chronische myeloïde leukemie, ook wel CML, is een vorm van leukemie waarbij er een overmatige productie is van witte bloedcellen. Bij 95% van CML-patiënten wordt ook het Philadelphia chromosoom gevonden, een genetische abnormaliteit die kan ontstaan door straling (onder andere als gevolg van bestraling van andere kankervormen). CML is een zeldzame ziekte. Per jaar komen er in Nederland zo’n 200-250 patiënten bij. De meeste patiënten zijn te vinden in de leeftijdsgroep van 50 tot 60 jaar. CML komt vaker voor bij mannen dan bij vrouwen.</span><small> (nl)</small></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://www.w3.org/2000/01/rdf-schema#label"><small>rdfs:</small>label</a>
</td><td><ul>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="ar">ابيضاض الدم النقوي المزمن</span><small> (ar)</small></span></li>
	<li><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="en">Chronic myelogenous leukemia</span><small> (en)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="de">Chronische myeloische Leukämie</span><small> (de)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="es">Leucemia mieloide crónica</span><small> (es)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="fr">Leucémie myéloïde chronique</span><small> (fr)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="it">Leucemia mieloide cronica</span><small> (it)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="ja">慢性骨髄性白血病</span><small> (ja)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="nl">Chronische myeloïde leukemie</span><small> (nl)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="pl">Przewlekła białaczka szpikowa</span><small> (pl)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="pt">Leucemia mieloide crônica</span><small> (pt)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="ru">Хронический миелоидный лейкоз</span><small> (ru)</small></span></li>
	<li style="display:none;"><span class="literal"><span property="rdfs:label" xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xml:lang="zh">慢性粒细胞性白血病</span><small> (zh)</small></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://www.w3.org/2002/07/owl#sameAs"><small>owl:</small>sameAs</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://www.wikidata.org/entity/Q729735"><small>wikidata</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://de.dbpedia.org/resource/Chronische_myeloische_Leukämie"><small>dbpedia-de</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://es.dbpedia.org/resource/Leucemia_mieloide_crónica"><small>dbpedia-es</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://fr.dbpedia.org/resource/Leucémie_myéloïde_chronique"><small>dbpedia-fr</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://it.dbpedia.org/resource/Leucemia_mieloide_cronica"><small>dbpedia-it</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://ja.dbpedia.org/resource/慢性骨髄性白血病"><small>dbpedia-ja</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://ko.dbpedia.org/resource/만성_골수성_백혈병"><small>dbpedia-ko</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://nl.dbpedia.org/resource/Chronische_myeloïde_leukemie"><small>dbpedia-nl</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://pl.dbpedia.org/resource/Przewlekła_białaczka_szpikowa"><small>dbpedia-pl</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://pt.dbpedia.org/resource/Leucemia_mieloide_crônica"><small>dbpedia-pt</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://wikidata.dbpedia.org/resource/Q729735"><small>dbpedia-wikidata</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://www4.wiwiss.fu-berlin.de/sider/resource/side_effects/C0023473">http://www4.wiwiss.fu-berlin.de/sider/resource/side_effects/C0023473</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://rdf.freebase.com/ns/m.02q0yh"><small>freebase</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://yago-knowledge.org/resource/Chronic_myelogenous_leukemia"><small>yago-res</small>:Chronic myelogenous leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rel="owl:sameAs" href="http://yago-knowledge.org/resource/Chronic_myeloid_leukemia"><small>yago-res</small>:Chronic myelogenous leukemia</a></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://www.w3.org/ns/prov#wasDerivedFrom"><small>prov:</small>wasDerivedFrom</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="prov:wasDerivedFrom" xmlns:prov="http://www.w3.org/ns/prov#" href="http://en.wikipedia.org/wiki/Chronic_myelogenous_leukemia?oldid=741178451"><small>wikipedia-en</small>:Chronic_myelogenous_leukemia?oldid=741178451</a></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://xmlns.com/foaf/0.1/depiction"><small>foaf:</small>depiction</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="foaf:depiction" xmlns:foaf="http://xmlns.com/foaf/0.1/" href="http://commons.wikimedia.org/wiki/Special:FilePath/Bcrablmet.jpg"><small>wiki-commons</small>:Special:FilePath/Bcrablmet.jpg</a></span></li>
</ul></td></tr><tr class="even"><td class="property"><a class="uri" href="http://xmlns.com/foaf/0.1/isPrimaryTopicOf"><small>foaf:</small>isPrimaryTopicOf</a>
</td><td><ul>
	<li><span class="literal"><a class="uri" rel="foaf:isPrimaryTopicOf" xmlns:foaf="http://xmlns.com/foaf/0.1/" href="http://en.wikipedia.org/wiki/Chronic_myelogenous_leukemia"><small>wikipedia-en</small>:Chronic_myelogenous_leukemia</a></span></li>
</ul></td></tr><tr class="odd"><td class="property"><a class="uri" href="http://xmlns.com/foaf/0.1/name"><small>foaf:</small>name</a>
</td><td><ul>
	<li><span class="literal"><span property="foaf:name" xmlns:foaf="http://xmlns.com/foaf/0.1/" xml:lang="en">Chronic myelogenous leukemia</span><small> (en)</small></span></li>
</ul></td></tr><tr class="even"><td class="property">is <a class="uri" href="http://dbpedia.org/ontology/wikiPageDisambiguates"><small>dbo:</small>wikiPageDisambiguates</a>
 of</td><td><ul>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageDisambiguates" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/CML"><small>dbr</small>:CML</a></span></li>
</ul></td></tr><tr class="odd"><td class="property">is <a class="uri" href="http://dbpedia.org/ontology/wikiPageRedirects"><small>dbo:</small>wikiPageRedirects</a>
 of</td><td><ul>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_granulocytic_leukaemia"><small>dbr</small>:Chronic_granulocytic_leukaemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Leukemia,_myeloid,_chronic"><small>dbr</small>:Leukemia,_myeloid,_chronic</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Blast_crisis"><small>dbr</small>:Blast_crisis</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_granulocytic_leukemia"><small>dbr</small>:Chronic_granulocytic_leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Adult_Chronic_Leukemia"><small>dbr</small>:Adult_Chronic_Leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_Myeloid_Leukemia"><small>dbr</small>:Chronic_Myeloid_Leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_myelogenous_leukaemia"><small>dbr</small>:Chronic_myelogenous_leukaemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_myeloid_leukaemia"><small>dbr</small>:Chronic_myeloid_leukaemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_monocytic_leukemia"><small>dbr</small>:Chronic_monocytic_leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Accelerated_phase"><small>dbr</small>:Accelerated_phase</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_myeloid_leukemia"><small>dbr</small>:Chronic_myeloid_leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_Myelogenous_Leukemia"><small>dbr</small>:Chronic_Myelogenous_Leukemia</a></span></li>
	<li><span class="literal"><a class="uri" rev="dbo:wikiPageRedirects" xmlns:dbo="http://dbpedia.org/ontology/" href="http://dbpedia.org/resource/Chronic_myelogeneous_leukemia"><small>dbr</small>:Chronic_myelogeneous_leukemia</a></span></li>
</ul></td></tr><tr class="even"><td class="property">is <a class="uri" href="http://dbpedia.org/property/use"><small>dbp:</small>use</a>
 of</td><td><ul>
	<li><span class="literal"><a class="uri" rev="dbp:use" href="http://dbpedia.org/resource/Imatinib"><small>dbr</small>:Imatinib</a></span></li>
</ul></td></tr><tr class="odd"><td class="property">is <a class="uri" href="http://xmlns.com/foaf/0.1/primaryTopic"><small>foaf:</small>primaryTopic</a>
 of</td><td><ul>
	<li><span class="literal"><a class="uri" rev="foaf:primaryTopic" xmlns:foaf="http://xmlns.com/foaf/0.1/" href="http://en.wikipedia.org/wiki/Chronic_myelogenous_leukemia"><small>wikipedia-en</small>:Chronic_myelogenous_leukemia</a></span></li>
</ul></td></tr>
      </table>
    </div>
<!-- row  -->
</div>
</div>
<!-- footer -->
<div class="footer">
    <div class="container">
	<a href="http://virtuoso.openlinksw.com" title="OpenLink Virtuoso"><img class="powered_by" src="/statics/images/virt_power_no_border.png" alt="Powered by OpenLink Virtuoso"/></a>&nbsp; &nbsp;
	<a href="http://linkeddata.org/"><img alt="This material is Open Knowledge" src="/statics/images/LoDLogo.gif"/></a> &nbsp; &nbsp;
	<a href="http://dbpedia.org/sparql"><img alt="W3C Semantic Web Technology" src="/statics/images/sw-sparql-blue.png"/></a> &nbsp;  &nbsp;
	<a href="http://www.opendefinition.org/"><img alt="This material is Open Knowledge" src="/statics/images/od_80x15_red_green.png"/></a>&nbsp; &nbsp;
	<span style="display:none;" about=""
	    resource="http://www.w3.org/TR/rdfa-syntax"
	    rel="dc:conformsTo" xmlns:dc="http://purl.org/dc/terms/">
	    <a href="http://validator.w3.org/check?uri=referer">
		<img src="http://www.w3.org/Icons/valid-xhtml-rdfa" alt="Valid XHTML + RDFa" height="27px" />
	    </a>
	</span>
	<br />
	<div class="text-muted">
	    This content was extracted from <a href="http://en.wikipedia.org/wiki/Chronic_myelogenous_leukemia">Wikipedia</a> and is licensed under the <a href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>

	</div>
    </div>
</div>
<!-- #footer -->
<!--#content-->
    <!--script type="text/javascript">
     Place any Javascript code e.g. Google Analytics scripts
    </script-->
    
    <script type="text/javascript" src="/statics/js/jquery.min.js"></script>
    <script type="text/javascript" src="/statics/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/statics/js/dbpedia.js"></script>
</body>
</html>

*/