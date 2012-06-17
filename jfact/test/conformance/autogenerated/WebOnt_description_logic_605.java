package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_description_logic_605 {
	@Test
	public void testWebOnt_description_logic_605() {
		String premise = "<rdf:RDF\n"
				+ "    xmlns:oiled=\"http://oiled.man.example.net/test#\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ " xml:base=\"http://www.w3.org/2002/03owlt/description-logic/consistent605\">\n"
				+ " <owl:Ontology rdf:about=\"\"/>\n"
				+ " <owl:Class rdf:about=\"http://oiled.man.example.net/test#c2\"/>\n"
				+ " <owl:Class rdf:about=\"http://oiled.man.example.net/test#Satisfiable\">\n"
				+ "  <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "   <owl:Class rdf:about=\"#C.1\"/>\n"
				+ "   <owl:Restriction>\n"
				+ "    <owl:onProperty>\n"
				+ "     <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx3a\"/>\n"
				+ "    </owl:onProperty>\n"
				+ "    <owl:someValuesFrom>\n"
				+ "     <owl:Class rdf:about=\"http://oiled.man.example.net/test#c1\"/>\n"
				+ "    </owl:someValuesFrom>\n"
				+ "   </owl:Restriction>\n"
				+ "   <owl:Restriction>\n"
				+ "    <owl:onProperty>\n"
				+ "     <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx4a\"/>\n"
				+ "    </owl:onProperty>\n"
				+ "    <owl:someValuesFrom rdf:resource=\"http://oiled.man.example.net/test#c2\"/>\n"
				+ "   </owl:Restriction>\n"
				+ "  </owl:intersectionOf>\n"
				+ " </owl:Class>\n"
				+ " <owl:Class rdf:ID=\"C.1\">\n"
				+ "  <owl:equivalentClass>\n"
				+ "   <owl:Restriction>\n"
				+ "    <owl:onProperty>\n"
				+ "     <owl:DatatypeProperty rdf:ID=\"P.1\"/>\n"
				+ "    </owl:onProperty>\n"
				+ "    <owl:minCardinality rdf:datatype=\"/2001/XMLSchema#int\"\n"
				+ "    >1</owl:minCardinality>\n"
				+ "   </owl:Restriction>\n"
				+ "  </owl:equivalentClass>\n"
				+ " </owl:Class>\n"
				+ " <owl:Class rdf:ID=\"A.2\">\n"
				+ "  <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "   <owl:Class rdf:about=\"http://oiled.man.example.net/test#c1\"/>\n"
				+ "   <owl:Class rdf:about=\"http://oiled.man.example.net/test#c2\"/>\n"
				+ "  </owl:intersectionOf>\n"
				+ " </owl:Class>\n"
				+ " <owl:Class rdf:ID=\"C.1.comp\">\n"
				+ "  <owl:equivalentClass>\n"
				+ "   <owl:Restriction>\n"
				+ "    <owl:onProperty rdf:resource=\"#P.1\"/>\n"
				+ "    <owl:maxCardinality rdf:datatype=\"/2001/XMLSchema#int\"\n"
				+ "    >0</owl:maxCardinality>\n"
				+ "   </owl:Restriction>\n"
				+ "  </owl:equivalentClass>\n"
				+ "  <owl:equivalentClass>\n"
				+ "   <owl:Restriction>\n"
				+ "    <owl:onProperty>\n"
				+ "     <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx3a\"/>\n"
				+ "    </owl:onProperty>\n"
				+ "    <owl:someValuesFrom rdf:resource=\"#A.2\"/>\n"
				+ "   </owl:Restriction>\n"
				+ "  </owl:equivalentClass>\n"
				+ " </owl:Class>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx4\">\n"
				+ "  <rdfs:subPropertyOf>\n"
				+ "   <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx2\"/>\n"
				+ "  </rdfs:subPropertyOf>\n"
				+ "  <rdfs:subPropertyOf>\n"
				+ "   <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx\"/>\n"
				+ "  </rdfs:subPropertyOf>\n"
				+ "  <rdf:type rdf:resource=\"/2002/07/owl#FunctionalProperty\"/>\n"
				+ " </owl:ObjectProperty>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx3\">\n"
				+ "  <rdfs:subPropertyOf>\n"
				+ "   <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx1\"/>\n"
				+ "  </rdfs:subPropertyOf>\n"
				+ "  <rdfs:subPropertyOf>\n"
				+ "   <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx\"/>\n"
				+ "  </rdfs:subPropertyOf>\n"
				+ "  <rdf:type rdf:resource=\"/2002/07/owl#FunctionalProperty\"/>\n"
				+ " </owl:ObjectProperty>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rxa\"/>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx\">\n"
				+ "  <rdf:type rdf:resource=\"/2002/07/owl#FunctionalProperty\"/>\n"
				+ " </owl:ObjectProperty>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx1a\"/>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx2a\"/>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx3a\">\n"
				+ "  <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#rx1a\"/>\n"
				+ "  <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#rxa\"/>\n"
				+ "  <rdf:type rdf:resource=\"/2002/07/owl#FunctionalProperty\"/>\n"
				+ " </owl:ObjectProperty>\n"
				+ " <owl:ObjectProperty rdf:about=\"http://oiled.man.example.net/test#rx4a\">\n"
				+ "  <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#rx2a\"/>\n"
				+ "  <rdfs:subPropertyOf rdf:resource=\"http://oiled.man.example.net/test#rxa\"/>\n"
				+ "  <rdf:type rdf:resource=\"/2002/07/owl#FunctionalProperty\"/>\n"
				+ " </owl:ObjectProperty>\n" + " <oiled:Satisfiable/>\n" + "</rdf:RDF>";
		String conclusion = "";
		String id = "WebOnt_description_logic_605";
		TestClasses tc = TestClasses.valueOf("CONSISTENCY");
		String d = "DL Test: fact4.2";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
