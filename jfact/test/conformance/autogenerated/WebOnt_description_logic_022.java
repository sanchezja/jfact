package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_description_logic_022 {
	@Test
	public void testWebOnt_description_logic_022() {
		String premise = "<rdf:RDF\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/description-logic/inconsistent022\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\">\n"
				+ "    <owl:Ontology rdf:about=\"\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#Unsatisfiable\">\n"
				+ "        <owl:equivalentClass>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p1\"/>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p2\"/>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p3\"/>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p4\"/>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p1\"/>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p2\"/>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p3\"/>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p4\"/>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:maxCardinality rdf:datatype=\"http://www.w3.org/2001/XMLSchema#nonNegativeInteger\">4</owl:maxCardinality>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p5\"/>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                </owl:intersectionOf>\n"
				+ "            </owl:Class>\n"
				+ "        </owl:equivalentClass>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p1\">\n"
				+ "        <rdfs:subClassOf>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:complementOf>\n"
				+ "                    <owl:Class>\n"
				+ "                        <owl:unionOf rdf:parseType=\"Collection\">\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p2\"/>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p3\"/>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p4\"/>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p5\"/>\n"
				+ "                        </owl:unionOf>\n"
				+ "                    </owl:Class>\n"
				+ "                </owl:complementOf>\n"
				+ "            </owl:Class>\n"
				+ "        </rdfs:subClassOf>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p2\">\n"
				+ "        <rdfs:subClassOf>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:complementOf>\n"
				+ "                    <owl:Class>\n"
				+ "                        <owl:unionOf rdf:parseType=\"Collection\">\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p3\"/>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p4\"/>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p5\"/>\n"
				+ "                        </owl:unionOf>\n"
				+ "                    </owl:Class>\n"
				+ "                </owl:complementOf>\n"
				+ "            </owl:Class>\n"
				+ "        </rdfs:subClassOf>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p3\">\n"
				+ "        <rdfs:subClassOf>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:complementOf>\n"
				+ "                    <owl:Class>\n"
				+ "                        <owl:unionOf rdf:parseType=\"Collection\">\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p4\"/>\n"
				+ "                            <owl:Class rdf:about=\"http://oiled.man.example.net/test#p5\"/>\n"
				+ "                        </owl:unionOf>\n"
				+ "                    </owl:Class>\n"
				+ "                </owl:complementOf>\n"
				+ "            </owl:Class>\n"
				+ "        </rdfs:subClassOf>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p4\">\n"
				+ "        <rdfs:subClassOf>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:complementOf>\n"
				+ "                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p5\"/>\n"
				+ "                </owl:complementOf>\n"
				+ "            </owl:Class>\n"
				+ "        </rdfs:subClassOf>\n"
				+ "    </owl:Class>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p5\"/>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    <rdf:Description>\n"
				+ "        <rdf:type rdf:resource=\"http://oiled.man.example.net/test#Unsatisfiable\"/>\n"
				+ "    </rdf:Description>\n" + "</rdf:RDF>";
		String conclusion = "";
		String id = "WebOnt_description_logic_022";
		TestClasses tc = TestClasses.valueOf("INCONSISTENCY");
		String d = "DL Test: t3a.3\n"
				+ "There are 42,525 possible partitions in the satisfiable case";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
