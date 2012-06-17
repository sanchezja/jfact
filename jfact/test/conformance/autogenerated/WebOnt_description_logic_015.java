package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_description_logic_015 {
	@Test
	public void testWebOnt_description_logic_015() {
		String premise = "<rdf:RDF\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/description-logic/inconsistent015\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\">\n"
				+ "    <owl:Ontology rdf:about=\"\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#Unsatisfiable\">\n"
				+ "        <owl:equivalentClass>\n"
				+ "            <owl:Class>\n"
				+ "                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#s\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Class>\n"
				+ "                                    <owl:complementOf>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "                                    </owl:complementOf>\n"
				+ "                                    </owl:Class>\n"
				+ "                                    <owl:Class>\n"
				+ "                                    <owl:complementOf>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#q\"/>\n"
				+ "                                    </owl:complementOf>\n"
				+ "                                    </owl:Class>\n"
				+ "                                </owl:intersectionOf>\n"
				+ "                            </owl:Class>\n"
				+ "                        </owl:someValuesFrom>\n"
				+ "                    </owl:Restriction>\n"
				+ "                    <owl:Restriction>\n"
				+ "                        <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "                        <owl:someValuesFrom>\n"
				+ "                            <owl:Class>\n"
				+ "                                <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#invR\"/>\n"
				+ "                                    <owl:maxCardinality rdf:datatype=\"http://www.w3.org/2001/XMLSchema#nonNegativeInteger\">1</owl:maxCardinality>\n"
				+ "                                    </owl:Restriction>\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#invR\"/>\n"
				+ "                                    <owl:someValuesFrom>\n"
				+ "                                    <owl:Restriction>\n"
				+ "                                    <owl:onProperty rdf:resource=\"http://oiled.man.example.net/test#s\"/>\n"
				+ "                                    <owl:allValuesFrom>\n"
				+ "                                    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "                                    </owl:allValuesFrom>\n"
				+ "                                    </owl:Restriction>\n"
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
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#p\"/>\n"
				+ "    <owl:Class rdf:about=\"http://oiled.man.example.net/test#q\"/>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#invR\">\n"
				+ "        <owl:inverseOf rdf:resource=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    </owl:ObjectProperty>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#r\"/>\n"
				+ "    <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#s\"/>\n"
				+ "    <rdf:Description>\n"
				+ "        <rdf:type rdf:resource=\"http://oiled.man.example.net/test#Unsatisfiable\"/>\n"
				+ "    </rdf:Description>\n" + "</rdf:RDF>";
		String conclusion = "";
		String id = "WebOnt_description_logic_015";
		TestClasses tc = TestClasses.valueOf("INCONSISTENCY");
		String d = "DL Test: t12.1";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
