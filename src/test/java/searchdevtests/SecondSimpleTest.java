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

import org.topicquests.os.search.jena.api.IConstants;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class SecondSimpleTest extends SearchRoot {
	private final String URL = "http://dbpedia.org/resource/leukemia";
	//"http://dbpedia.org/resource/Chronic_myelogenous_leukemia";

	/**
	 * 
	 */
	public SecondSimpleTest() {
		super();
		String queryStr = dsl.finalQuery(URL);
		IResult r = engine.runQuery(queryStr, IConstants.DBPEDIA_SERVICE);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		environment.shutDown();
		System.exit(0);
		
	}

}
/*

A 
B { "head": {
    "vars": [ "p" , "o" ]
  } ,
  "results": {
    "bindings": [
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#Thing" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://www.wikidata.org/entity/Q12136" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/ontology/Disease" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://umbel.org/umbel/rc/AilmentCondition" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/WikicatHematologicNeoplasms" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Abstraction100002137" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Attribute100024264" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/BloodDisease114189204" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/BloodDyscrasia114053850" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Condition113920835" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Disease114070360" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Dyscrasia114053717" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Growth114234074" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/IllHealth114052046" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Illness114061805" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/PathologicalState114051917" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/PhysicalCondition114034177" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/State100024720" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/Tumor114235200" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/class/yago/WikicatBloodDisorders" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "ar" , "value": "ابيضاض الدم النقوي المزمن" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "en" , "value": "Chronic myelogenous leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "de" , "value": "Chronische myeloische Leukämie" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "es" , "value": "Leucemia mieloide crónica" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "fr" , "value": "Leucémie myéloïde chronique" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "it" , "value": "Leucemia mieloide cronica" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "ja" , "value": "慢性骨髄性白血病" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "nl" , "value": "Chronische myeloïde leukemie" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "pl" , "value": "Przewlekła białaczka szpikowa" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "pt" , "value": "Leucemia mieloide crônica" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "ru" , "value": "Хронический миелоидный лейкоз" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#label" } ,
        "o": { "type": "literal" , "xml:lang": "zh" , "value": "慢性粒细胞性白血病" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "es" , "value": "La leucemia mieloide crónica (LMC) es una enfermedad clasificada dentro del síndrome mieloproliferativo crónico (conjunto de enfermedades que afectan a la sangre) caracterizado por una proliferación de los glóbulos blancos de la serie granulocítica hasta las últimas fases madurativas de su diferenciación. Circula con los granulocitosis a nivel de la sangre periférica. Algunos reportes indican que la LMC representa por lo menos el 9% del total de casos de leucemia." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "fr" , "value": "La leucémie myéloïde chronique (LMC) est une prolifération myéloïde monoclonale sans blocage de maturation prédominant sur la lignée granuleuse au niveau médullaire et splénique. Dans l'espèce humaine, elle fait partie des 4 grands syndromes myéloprolifératifs (avec la maladie de Vaquez, la thrombocytémie essentielle et la splénomégalie myéloïde). Elle touche surtout l'adulte entre 30 et 50 ans et est favorisée par l'exposition au benzène et aux rayons ionisants." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "ja" , "value": "慢性骨髄性白血病（まんせいこつずいせいはっけつびょう　Chronic myelogenous leukemia ,CML）とは、造血幹細胞の遺伝子が後天的に変異して、造血細胞が分化・成熟能を保ったまま自律的な増殖をし、血液において白血球や時に血小板が増加する血液腫瘍である。" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "pl" , "value": "Przewlekła białaczka szpikowa (łac. myelosis leukaemica chronica, używany jest skrótowiec CML od ang. chronic myeloid leukemia) \u2013 zespół mieloproliferacyjny polegający na rozroście klonalnym przekształconej nowotworowo komórki macierzystej szpiku kostnego." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "pt" , "value": "Leucemia mieloide crônica (português brasileiro) ou leucemia mieloide crónica (português europeu) (LMC) é uma forma de leucemia crônica caracterizada pela proliferação de células da linhagem granulocítica sem a perda de capacidade de diferenciação. É um tipo de doença mieloproliferativa característica por uma aberração citogenética ocasionada por uma translocação entre o cromossomo 9 e 22; t(9;22). Essa translocação resulta em um cromossomo 22 mais encurtado, chamado de cromossomo Filadélfia (cromossomo Ph1). Ocorre a fusão de dois genes nos cromossomos 9 e 22, chamados respectivamente de abl e bcr. É uma doença mais comum em adultos entre 40-50. Quando acomete jovens, a doença é mais agressiva que o normal." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "zh" , "value": "慢性粒细胞性白血病（英语：Chronic Granulocytic Leukemia, CGL），或称慢性髓细胞性白血病（英语：Chronic Myelogenous Leukemia, CML），是一类白血病。这种白血病表现为人体骨髓中的主要粒细胞不受管制地增长，并在血液中积累而形成。这种获得性骨髓造血干细胞，即成熟的粒细胞（中性粒细胞、嗜酸性粒细胞和嗜碱性粒细胞）进行恶性克隆衍生，通常并伴生一种骨髓增生性疾病。这种疾病源自一种称为费城染色体（英语：Philadelphia chromosome）的染色体易位现象（9号染色体长臂移至22号染色体短臂上）。对于慢性粒细胞性白血病的一类靶向治疗包括有伊马替尼（英语：imatinib）、达沙替尼（英语：dasatinib）和尼罗替尼（英语：nilotinib），这类靶向治疗方式对缓解治疗慢性粒细胞性白血病有非常良好的效果，患者可以獲得接近一般人的生活品質及預期壽命。" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "ru" , "value": "Хронический миелоидный лейкоз (ХМЛ, хронический миелолейкоз) \u2014 форма лейкоза, которая характеризуется ускоренной и нерегулируемой пролиферацией преимущественно миелоидных клеток в костном мозге с их накоплением в крови.ХМЛ \u2014 гемопоэтическое клональное заболевание, основным проявлением которого является пролиферация зрелых гранулоцитов (нейтрофилов, эозинофилов и базофилов) и их предшественников. Это миелопролиферативное заболевание ассоциировано с характерной хромосомной транслокацией (филадельфийской хромосомой). В настоящее время основным способом лечения хронического миелолейкоза является таргетная (целевая) терапия ингибиторами тирозинкиназ, такими как иматиниб, нилотиниб, дазатиниб и другие, значительно улучшившая показатели выживаемости." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "en" , "value": "Chronic myelogenous (or myeloid or myelocytic) leukemia (CML), also known as chronic granulocytic leukemia (CGL), is a cancer of the white blood cells. It is a form of leukemia characterized by the increased and unregulated growth of predominantly myeloid cells in the bone marrow and the accumulation of these cells in the blood. CML is a clonal bone marrow stem cell disorder in which a proliferation of mature granulocytes (neutrophils, eosinophils and basophils) and their precursors is found. It is a type of myeloproliferative disease associated with a characteristic chromosomal translocation called the Philadelphia chromosome. CML is now largely treated with targeted drugs called tyrosine kinase inhibitors (TKIs) which have led to dramatically improved long-term survival rates since the i" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "ar" , "value": "25بك المحتوى هنا ينقصه الاستشهاد بمصادر. يرجى إيراد مصادر موثوق بها. أي معلومات غير موثقة يمكن التشكيك بها وإزالتها. (فبراير 2016) أبيضاض الدم النقوي المزمن (بالإنجليزية: Chronic Myeloid Leukemia) هو مرض سرطاني يصيب الخلايا الجذعية متعددة القدرات المسؤولة عن تصنيع خلايا الدم (Pluripotent Hematopoietic Stem Cells). ويتميز عن أبيضاض الدم النقوي الحاد ببطء سير المرض في جسم المريض. ومن أهم العلامات الفارقة في هذا المرض وجود اضطراب وراثي خلوي يسمى وبصبغي فيلادلفيا. يتم استخدام عدة أساليب للعلاج ومن أهمها دواء إماتينيب (Imatinib) وزراعة نخاع العظم الخيفي (Allogenic HSC transplant)." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "de" , "value": "Die chronische myeloische Leukämie (CML), auch chronische Myelose genannt, ist eine chronische Leukämie, die mit einer starken Vermehrung von Leukozyten (weißen Blutkörperchen), speziell von Granulozyten und ihren Vorstufen, im Blut und im blutbildenden Knochenmark einhergeht. Die Erkrankung ist in der Anfangsphase häufig symptomlos." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "it" , "value": "La leucemia mieloide cronica (LMC) è una condizione clinica patologica determinata dalla proliferazione monoclonale incontrollata di una sola cellula multipotente colpita dall'evento leucemogeno. La malattia può coinvolgere le linee mieloide, monocitica, eritroide, megacariocitica e talora anche il compartimento linfoide." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2000/01/rdf-schema#comment" } ,
        "o": { "type": "literal" , "xml:lang": "nl" , "value": "Chronische myeloïde leukemie, ook wel CML, is een vorm van leukemie waarbij er een overmatige productie is van witte bloedcellen. Bij 95% van CML-patiënten wordt ook het Philadelphia chromosoom gevonden, een genetische abnormaliteit die kan ontstaan door straling (onder andere als gevolg van bestraling van andere kankervormen). CML is een zeldzame ziekte. Per jaar komen er in Nederland zo\u2019n 200-250 patiënten bij. De meeste patiënten zijn te vinden in de leeftijdsgroep van 50 tot 60 jaar. CML komt vaker voor bij mannen dan bij vrouwen." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://www.wikidata.org/entity/Q729735" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://de.dbpedia.org/resource/Chronische_myeloische_Leukämie" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://es.dbpedia.org/resource/Leucemia_mieloide_crónica" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://fr.dbpedia.org/resource/Leucémie_myéloïde_chronique" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://it.dbpedia.org/resource/Leucemia_mieloide_cronica" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://ja.dbpedia.org/resource/慢性骨髄性白血病" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://ko.dbpedia.org/resource/만성_골수성_백혈병" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://nl.dbpedia.org/resource/Chronische_myeloïde_leukemie" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://pl.dbpedia.org/resource/Przewlekła_białaczka_szpikowa" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://pt.dbpedia.org/resource/Leucemia_mieloide_crônica" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://wikidata.dbpedia.org/resource/Q729735" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://www4.wiwiss.fu-berlin.de/sider/resource/side_effects/C0023473" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://rdf.freebase.com/ns/m.02q0yh" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://yago-knowledge.org/resource/Chronic_myelogenous_leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/2002/07/owl#sameAs" } ,
        "o": { "type": "uri" , "value": "http://yago-knowledge.org/resource/Chronic_myeloid_leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://purl.org/dc/terms/subject" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Category:Chronic_myeloid_leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageID" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/2001/XMLSchema#integer" , "value": "559874" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageRevisionID" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/2001/XMLSchema#integer" , "value": "741178451" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Tyrosine_kinase" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Vaccination" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Oncology" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Chloroma" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Dasatinib" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Platelet" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Leukocytosis" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Ecchymosis" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Interferon-alpha" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/File:LMC4.jpg" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Isoleucine" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Threonine" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Cytarabine" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Cephalon" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/M.D._Anderson_Cancer_Center" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Cell_cycle" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Food_and_Drug_Administration" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Interferon" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Phosphate" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Polymerase_chain_reaction" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Stem_cell" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Philadelphia_chromosome" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Category:Chronic_myeloid_leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Granulocyte" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Imatinib" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Acute_leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Radotinib" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/University_of_Pennsylvania" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/American_Cancer_Society" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Bone_marrow" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Hematology" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Cytogenetics" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Basophil" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/DNA_repair" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Nilotinib" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Targeted_therapy" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Complete_blood_count" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/World_Health_Organization" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Steroid" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Eosinophil" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Neutrophil" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Myelocyte" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Interleukin-3_receptor" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/GM-CSF" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/KDa" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Petechiae" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Chromosomal_translocation" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Fox_Chase_Cancer_Center" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Splenomegaly" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Myeloid" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Alkylating_antineoplastic_agent" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Philadelphia,_Pennsylvania" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Leukemoid_reaction" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Myeloblast" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Interferon_alfa-2b" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Imatinib_mesylate" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Bosutinib" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/White_blood_cell" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Chromosome_abnormality" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Blood_film" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Splenectomy" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Lymphoblast" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Ponatinib" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/RT-PCR" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Myelodysplastic/myeloproliferative_disorder" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Bcr-Abl_tyrosine-kinase_inhibitor" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Bone_marrow_biopsy" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Abl_gene" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Myeloproliferative_disease" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Fluorescent_in_situ_hybridization" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Tyrosine_kinase_inhibitor" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Hydroxyurea" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Omacetaxine" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/BCR_gene" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/File:Chronic_Myeloid_Leukemia_smear_2009-04-09.JPG" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/File:Diagram_showing_which_cells_CML_can_start_in_CRUK_388.svg" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/File:Hypolobated_small_megakaryocyte.jpg" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/File:Philadelphia_chromosome.jpg" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageWikiLink" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Leukopheresis" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageExternalLink" } ,
        "o": { "type": "uri" , "value": "http://www.cancer.org/docroot/CRI/CRI_2_3x.asp?dt=83" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageExternalLink" } ,
        "o": { "type": "uri" , "value": "http://pubweb.fccc.edu/philadelphiachromosome/" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageExternalLink" } ,
        "o": { "type": "uri" , "value": "http://www.cmleukemia.com/" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageExternalLink" } ,
        "o": { "type": "uri" , "value": "http://www.leukemia-lymphoma.org/all_page?item_id=8501" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageExternalLink" } ,
        "o": { "type": "uri" , "value": "http://www.spirit-cml.org/spirit-2-home.aspx" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/wikiPageExternalLink" } ,
        "o": { "type": "uri" , "value": "http://www.nationalcmlsociety.org" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://xmlns.com/foaf/0.1/name" } ,
        "o": { "type": "literal" , "xml:lang": "en" , "value": "Chronic myelogenous leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://xmlns.com/foaf/0.1/depiction" } ,
        "o": { "type": "uri" , "value": "http://commons.wikimedia.org/wiki/Special:FilePath/Bcrablmet.jpg" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://xmlns.com/foaf/0.1/isPrimaryTopicOf" } ,
        "o": { "type": "uri" , "value": "http://en.wikipedia.org/wiki/Chronic_myelogenous_leukemia" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/thumbnail" } ,
        "o": { "type": "uri" , "value": "http://commons.wikimedia.org/wiki/Special:FilePath/Bcrablmet.jpg?width=300" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://www.w3.org/ns/prov#wasDerivedFrom" } ,
        "o": { "type": "uri" , "value": "http://en.wikipedia.org/wiki/Chronic_myelogenous_leukemia?oldid=741178451" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "ar" , "value": "25بك المحتوى هنا ينقصه الاستشهاد بمصادر. يرجى إيراد مصادر موثوق بها. أي معلومات غير موثقة يمكن التشكيك بها وإزالتها. (فبراير 2016) أبيضاض الدم النقوي المزمن (بالإنجليزية: Chronic Myeloid Leukemia) هو مرض سرطاني يصيب الخلايا الجذعية متعددة القدرات المسؤولة عن تصنيع خلايا الدم (Pluripotent Hematopoietic Stem Cells). ويتميز عن أبيضاض الدم النقوي الحاد ببطء سير المرض في جسم المريض. ومن أهم العلامات الفارقة في هذا المرض وجود اضطراب وراثي خلوي يسمى وبصبغي فيلادلفيا. يتم استخدام عدة أساليب للعلاج ومن أهمها دواء إماتينيب (Imatinib) وزراعة نخاع العظم الخيفي (Allogenic HSC transplant). يشكل ما نسبته 15% من حالات الإصابة بأبيضاض الدم بمختلف الفئات العمرية، ويتم تشخيص 1-1.5 حالة لكل 100000 شخص سنويا. متوسط عمر الإصابة للمريض ما بيين 50-60 عاما، ومثله كمثل أبيضاض الدم النقوي الحاد لا يوجد أي سبب معين لحدوث المرض مثل أسباب وراثية أو عوامل معدية. وجد أن الإشعاعات الناتجة من القنبلة الذرية في هيروشيما ونكازاكي لها دور في حدوث المرض وتعتبر كعوامل مخطرة." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "en" , "value": "Chronic myelogenous (or myeloid or myelocytic) leukemia (CML), also known as chronic granulocytic leukemia (CGL), is a cancer of the white blood cells. It is a form of leukemia characterized by the increased and unregulated growth of predominantly myeloid cells in the bone marrow and the accumulation of these cells in the blood. CML is a clonal bone marrow stem cell disorder in which a proliferation of mature granulocytes (neutrophils, eosinophils and basophils) and their precursors is found. It is a type of myeloproliferative disease associated with a characteristic chromosomal translocation called the Philadelphia chromosome. CML is now largely treated with targeted drugs called tyrosine kinase inhibitors (TKIs) which have led to dramatically improved long-term survival rates since the introduction of the first such agent in 2001. These drugs have revolutionized treatment of this disease and allow most patients to have a good quality of life when compared to the former chemotherapy drugs. In Western countries, CML accounts for 15-20% of all adult leukemias and 14% of leukemias overall (including the pediatric population)." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "de" , "value": "Die chronische myeloische Leukämie (CML), auch chronische Myelose genannt, ist eine chronische Leukämie, die mit einer starken Vermehrung von Leukozyten (weißen Blutkörperchen), speziell von Granulozyten und ihren Vorstufen, im Blut und im blutbildenden Knochenmark einhergeht. Die Erkrankung ist in der Anfangsphase häufig symptomlos. Die CML gehört zur Gruppe der myeloproliferativen Neoplasien (MPN), also Krankheiten, die aus einer (genetischen) Störung der im Knochenmark vorzufindenden hämatopoetischen Stammzellen resultieren. Bei der von Rudolf Virchow im Jahr 1845 beschriebenen und erstmals mit dem Namen Leukämie belegten Erkrankung handelte es sich mit hoher Wahrscheinlichkeit um eine CML. Durch den Einsatz neuerer tumorspezifischer Medikamente, den sogenannten Tyrosinkinase-Inhibitoren, seit etwa der Jahrtausendwende haben sich die Prognose und die Behandlungsformen der CML deutlich gewandelt und die Erkrankung ist in vielen Fällen gut und verhältnismäßig nebenwirkungsarm behandelbar geworden. Die CML ist durch diesen Einsatz sogenannter zielgerichteter Therapien (engl. targeted therapies) geradezu zu einer Modellerkrankung für die ganze Hämatologie oder Tumortherapie im Allgemeinen geworden." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "es" , "value": "La leucemia mieloide crónica (LMC) es una enfermedad clasificada dentro del síndrome mieloproliferativo crónico (conjunto de enfermedades que afectan a la sangre) caracterizado por una proliferación de los glóbulos blancos de la serie granulocítica hasta las últimas fases madurativas de su diferenciación. Circula con los granulocitosis a nivel de la sangre periférica. Algunos reportes indican que la LMC representa por lo menos el 9% del total de casos de leucemia." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "fr" , "value": "La leucémie myéloïde chronique (LMC) est une prolifération myéloïde monoclonale sans blocage de maturation prédominant sur la lignée granuleuse au niveau médullaire et splénique. Dans l'espèce humaine, elle fait partie des 4 grands syndromes myéloprolifératifs (avec la maladie de Vaquez, la thrombocytémie essentielle et la splénomégalie myéloïde). Elle touche surtout l'adulte entre 30 et 50 ans et est favorisée par l'exposition au benzène et aux rayons ionisants." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "it" , "value": "La leucemia mieloide cronica (LMC) è una condizione clinica patologica determinata dalla proliferazione monoclonale incontrollata di una sola cellula multipotente colpita dall'evento leucemogeno. La malattia può coinvolgere le linee mieloide, monocitica, eritroide, megacariocitica e talora anche il compartimento linfoide. Gli anni 2005-2010 hanno visto un cambiamento radicale nella terapia e nella prognosi della leucemia mieloide cronica, ottenuto grazie all'utilizzo delle conoscenze sulla patogenesi molecolare della malattia; il miglioramento è stato paragonato alla scoperta degli antibiotici per il trattamento delle malattie causate da batteri." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "ja" , "value": "慢性骨髄性白血病（まんせいこつずいせいはっけつびょう　Chronic myelogenous leukemia ,CML）とは、造血幹細胞の遺伝子が後天的に変異して、造血細胞が分化・成熟能を保ったまま自律的な増殖をし、血液において白血球や時に血小板が増加する血液腫瘍である。" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "pl" , "value": "Przewlekła białaczka szpikowa (łac. myelosis leukaemica chronica, używany jest skrótowiec CML od ang. chronic myeloid leukemia) \u2013 zespół mieloproliferacyjny polegający na rozroście klonalnym przekształconej nowotworowo komórki macierzystej szpiku kostnego." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "nl" , "value": "Chronische myeloïde leukemie, ook wel CML, is een vorm van leukemie waarbij er een overmatige productie is van witte bloedcellen. Bij 95% van CML-patiënten wordt ook het Philadelphia chromosoom gevonden, een genetische abnormaliteit die kan ontstaan door straling (onder andere als gevolg van bestraling van andere kankervormen). CML is een zeldzame ziekte. Per jaar komen er in Nederland zo\u2019n 200-250 patiënten bij. De meeste patiënten zijn te vinden in de leeftijdsgroep van 50 tot 60 jaar. CML komt vaker voor bij mannen dan bij vrouwen. Als medicijn kan imatinib worden toegediend waarvoor een studie in het New England Journal of Medicine een vijfjaarsoverleving van 89% laat zien. Ook de weesgeneesmiddelen Dasatinib (Sprycel) en Nilotinib (tasigna) kunnen gebruikt worden als remmende medicatie van deze afwijking." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "pt" , "value": "Leucemia mieloide crônica (português brasileiro) ou leucemia mieloide crónica (português europeu) (LMC) é uma forma de leucemia crônica caracterizada pela proliferação de células da linhagem granulocítica sem a perda de capacidade de diferenciação. É um tipo de doença mieloproliferativa característica por uma aberração citogenética ocasionada por uma translocação entre o cromossomo 9 e 22; t(9;22). Essa translocação resulta em um cromossomo 22 mais encurtado, chamado de cromossomo Filadélfia (cromossomo Ph1). Ocorre a fusão de dois genes nos cromossomos 9 e 22, chamados respectivamente de abl e bcr. É uma doença mais comum em adultos entre 40-50. Quando acomete jovens, a doença é mais agressiva que o normal." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "zh" , "value": "慢性粒细胞性白血病（英语：Chronic Granulocytic Leukemia, CGL），或称慢性髓细胞性白血病（英语：Chronic Myelogenous Leukemia, CML），是一类白血病。这种白血病表现为人体骨髓中的主要粒细胞不受管制地增长，并在血液中积累而形成。这种获得性骨髓造血干细胞，即成熟的粒细胞（中性粒细胞、嗜酸性粒细胞和嗜碱性粒细胞）进行恶性克隆衍生，通常并伴生一种骨髓增生性疾病。这种疾病源自一种称为费城染色体（英语：Philadelphia chromosome）的染色体易位现象（9号染色体长臂移至22号染色体短臂上）。对于慢性粒细胞性白血病的一类靶向治疗包括有伊马替尼（英语：imatinib）、达沙替尼（英语：dasatinib）和尼罗替尼（英语：nilotinib），这类靶向治疗方式对缓解治疗慢性粒细胞性白血病有非常良好的效果，患者可以獲得接近一般人的生活品質及預期壽命。" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/abstract" } ,
        "o": { "type": "literal" , "xml:lang": "ru" , "value": "Хронический миелоидный лейкоз (ХМЛ, хронический миелолейкоз) \u2014 форма лейкоза, которая характеризуется ускоренной и нерегулируемой пролиферацией преимущественно миелоидных клеток в костном мозге с их накоплением в крови.ХМЛ \u2014 гемопоэтическое клональное заболевание, основным проявлением которого является пролиферация зрелых гранулоцитов (нейтрофилов, эозинофилов и базофилов) и их предшественников. Это миелопролиферативное заболевание ассоциировано с характерной хромосомной транслокацией (филадельфийской хромосомой). В настоящее время основным способом лечения хронического миелолейкоза является таргетная (целевая) терапия ингибиторами тирозинкиназ, такими как иматиниб, нилотиниб, дазатиниб и другие, значительно улучшившая показатели выживаемости." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/icd10" } ,
        "o": { "type": "literal" , "value": "C92.1" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/icd9" } ,
        "o": { "type": "literal" , "value": "205.1" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/ontology/meshId" } ,
        "o": { "type": "literal" , "value": "D015464" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/caption" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/1999/02/22-rdf-syntax-ns#langString" , "value": "The Philadelphia chromosome as seen by metaphase FISH." }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/diseasesdb" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/2001/XMLSchema#integer" , "value": "2659" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/emedicinesubj" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/1999/02/22-rdf-syntax-ns#langString" , "value": "med" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/emedicinetopic" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/2001/XMLSchema#integer" , "value": "371" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/field" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/1999/02/22-rdf-syntax-ns#langString" , "value": "Hematology and oncology" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/medlineplus" } ,
        "o": { "type": "literal" , "datatype": "http://www.w3.org/2001/XMLSchema#integer" , "value": "570" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://dbpedia.org/property/wordnet_type" } ,
        "o": { "type": "uri" , "value": "http://www.w3.org/2006/03/wn/wn20/instances/synset-disease-noun-1" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://purl.org/voc/vrank#hasRank" } ,
        "o": { "type": "bnode" , "value": "b0" }
      } ,
      { 
        "p": { "type": "uri" , "value": "http://purl.org/linguistics/gold/hypernym" } ,
        "o": { "type": "uri" , "value": "http://dbpedia.org/resource/Cancer" }
      }
    ]
  }
}

*/