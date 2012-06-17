package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_description_logic_108 {
	@Test
	public void testWebOnt_description_logic_108() {
		String premise = "<rdf:RDF\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/description-logic/inconsistent108\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\">\n"
				+ "    <owl:Ontology rdf:about=\"\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#Unsatisfiable\">\n"
				+ "        <owl:equivalentClass>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                    <owl:Class>\n"
				+ "                        <owl:complementOf>\n"
				+ "                            <owl:Restriction>\n"
				+ "                                <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                                <owl:minCardinality\n"
				+ " rdf:datatype=\"http://www.w3.org/2001/XMLSchema#nonNegativeInteger\"\n"
				+ "                                >2</owl:minCardinality>\n"
				+ "                            </owl:Restriction>\n"
				+ "                        </owl:complementOf>\n"
				+ "                    </owl:Class>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r1\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "                                    <owl:maxCardinality\n"
				+ " rdf:datatype=\"http://www.w3.org/2001/XMLSchema#nonNegativeInteger\"\n"
				+ "                                    >1</owl:maxCardinality>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#t1\"/>\n"
				+ "                                    <owl:someValuesFrom>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#c\"/>\n"
				+ "                                    </owl:someValuesFrom>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r2\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "                                    <owl:maxCardinality\n"
				+ " rdf:datatype=\"http://www.w3.org/2001/XMLSchema#nonNegativeInteger\"\n"
				+ "                                    >1</owl:maxCardinality>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#t2\"/>\n"
				+ "                                    <owl:someValuesFrom>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#d\"/>\n"
				+ "                                    </owl:someValuesFrom>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r3\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "                                    <owl:maxCardinality\n"
				+ " rdf:datatype=\"http://www.w3.org/2001/XMLSchema#nonNegativeInteger\"\n"
				+ "                                    >1</owl:maxCardinality>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#t3\"/>\n"
				+ "                                    <owl:someValuesFrom>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#e\"/>\n"
				+ "                                    </owl:someValuesFrom>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                </owl:intersectionOf>\n"
				+ "            </owl:Class>\n"
				+ "        </owl:equivalentClass>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#a\">\n"
				+ "        <owl:equivalentClass>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:unionOf rdf:parseType=\"Collection\">\n"
				+ "                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#c\"/>\n"
				+ "                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#d\"/>\n"
				+ "                </owl:unionOf>\n"
				+ "            </owl:Class>\n"
				+ "        </owl:equivalentClass>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#c\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#d\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#e\"/>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#r1\">\n"
				+ "        <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#r2\">\n"
				+ "        <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#r3\">\n"
				+ "        <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#t1\">\n"
				+ "        <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#t2\">\n"
				+ "        <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#t3\">\n"
				+ "        <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#tt\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#c\">\n"
				+ "        <owl:disjointWith>\n"
				+ "            <owl:Class rdf:about=\"http://oiled.man.example.net/test#d\"/>\n"
				+ "        </owl:disjointWith>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#c\">\n"
				+ "        <owl:disjointWith>\n"
				+ "            <owl:Class rdf:about=\"http://oiled.man.example.net/test#e\"/>\n"
				+ "        </owl:disjointWith>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#d\">\n"
				+ "        <owl:disjointWith>\n"
				+ "            <owl:Class rdf:about=\"http://oiled.man.example.net/test#e\"/>\n"
				+ "        </owl:disjointWith>\n"
				+ "    </owl:Class>\n"
				+ "    <rdf:Description>\n"
				+ "        <rdf:type rdf:resource=\"http://oiled.man.example.net/test#Unsatisfiable\"/>\n"
				+ "    </rdf:Description>\n" + "</rdf:RDF>";
		String conclusion = "";
		String id = "WebOnt_description_logic_108";
		TestClasses tc = TestClasses.valueOf("INCONSISTENCY");
		String d = "DL Test: heinsohn3.2\n" + "Tbox tests from Heinsohn et al.\n" + "\n"
				+ "Tests incoherency caused by number restrictions and role hierarchy";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
