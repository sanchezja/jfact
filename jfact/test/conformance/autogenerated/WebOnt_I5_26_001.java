package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_I5_26_001 {
	@Test
	public void testWebOnt_I5_26_001() {
		String premise = "<rdf:RDF\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/I5.26/consistent001\" >\n"
				+ "    <owl:Ontology/>\n" + "    <owl:Class rdf:nodeID=\"B\">\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"A\"/>\n"
				+ "        <owl:Class rdf:ID=\"B\"/>\n" + "      </owl:intersectionOf>\n"
				+ "    </owl:Class>\n" + "    <rdf:Description>\n"
				+ "      <rdf:type rdf:nodeID=\"B\"/>\n" + "    </rdf:Description>\n"
				+ "    <owl:Class>\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"C\"/>\n"
				+ "        <rdf:Description rdf:nodeID=\"B\"/>\n"
				+ "      </owl:intersectionOf>\n" + "    </owl:Class>\n" + "\n"
				+ "</rdf:RDF>";
		String conclusion = "";
		String id = "WebOnt_I5_26_001";
		TestClasses tc = TestClasses.valueOf("CONSISTENCY");
		String d = "Structure sharing was not permitted in OWL DL, between a class description\n"
				+ "and a type triple, but is permitted in OWL 2 DL.";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
