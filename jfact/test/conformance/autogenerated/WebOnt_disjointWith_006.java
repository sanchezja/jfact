package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_disjointWith_006 {
	@Test
	public void testWebOnt_disjointWith_006() {
		String premise = "<rdf:RDF\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/disjointWith/consistent006\" >\n"
				+ "    <owl:Ontology/>\n" + "    <owl:Class rdf:nodeID=\"A\">\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"A\"/>\n"
				+ "        <owl:Class rdf:ID=\"K\"/>\n" + "      </owl:intersectionOf>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"D\"/>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"E\"/>\n" + "    </owl:Class>\n"
				+ "    <owl:Class rdf:nodeID=\"B\">\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"K\"/>\n"
				+ "        <owl:Class rdf:ID=\"B\"/>\n" + "      </owl:intersectionOf>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"C\"/>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"A\"/>\n" + "    </owl:Class>\n"
				+ "    <owl:Class rdf:nodeID=\"C\">\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"K\"/>\n"
				+ "        <owl:Class rdf:ID=\"C\"/>\n" + "      </owl:intersectionOf>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"A\"/>\n" + "    </owl:Class>\n"
				+ "    <owl:Class rdf:nodeID=\"D\">\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"K\"/>\n"
				+ "        <owl:Class rdf:ID=\"D\"/>\n" + "      </owl:intersectionOf>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"E\"/>\n" + "    </owl:Class>\n"
				+ "    <owl:Class rdf:nodeID=\"E\">\n"
				+ "      <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "        <owl:Class rdf:ID=\"K\"/>\n"
				+ "        <owl:Class rdf:ID=\"E\"/>\n" + "      </owl:intersectionOf>\n"
				+ "      <owl:disjointWith rdf:nodeID=\"D\"/>\n" + "    </owl:Class>\n"
				+ "\n" + "</rdf:RDF>";
		String conclusion = "";
		String id = "WebOnt_disjointWith_006";
		TestClasses tc = TestClasses.valueOf("CONSISTENCY");
		String d = "If the owl:disjointWith edges in the graph form\n"
				+ "undirected complete subgraphs which share blank nodes\n"
				+ "then this was not within OWL DL, but is permissible in OWL 2 DL.";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
