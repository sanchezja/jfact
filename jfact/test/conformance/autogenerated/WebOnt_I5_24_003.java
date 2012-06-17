package conformance.autogenerated;

import org.junit.Test;

import conformance.Factory;
import conformance.JUnitRunner;
import conformance.TestClasses;

public class WebOnt_I5_24_003 {
	@Test
	public void testWebOnt_I5_24_003() {
		String premise = "<rdf:RDF\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/I5.24/premises003\" >\n"
				+ "  <owl:Ontology/>\n" + "  <owl:ObjectProperty rdf:ID=\"prop\">\n"
				+ "     <rdfs:range>\n" + "        <owl:Class rdf:about=\"#A\"/>\n"
				+ "     </rdfs:range>\n" + "  </owl:ObjectProperty>\n" + "</rdf:RDF>";
		String conclusion = "<rdf:RDF\n"
				+ "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n"
				+ "    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n"
				+ "    xmlns:owl=\"http://www.w3.org/2002/07/owl#\"\n"
				+ "    xml:base=\"http://www.w3.org/2002/03owlt/I5.24/conclusions003\" >\n"
				+ "  \n" + "   <owl:Ontology/>\n"
				+ "   <owl:Class rdf:about=\"http://www.w3.org/2002/07/owl#Thing\">\n"
				+ "      <rdfs:subClassOf>\n" + "          <owl:Restriction>\n"
				+ "             <owl:onProperty>\n"
				+ "               <owl:ObjectProperty rdf:about=\"premises003#prop\"/>\n"
				+ "             </owl:onProperty>\n"
				+ "             <owl:allValuesFrom>\n"
				+ "               <owl:Class rdf:about=\"premises003#A\"/>\n"
				+ "              </owl:allValuesFrom>\n"
				+ "          </owl:Restriction>\n" + "       </rdfs:subClassOf>\n"
				+ "   </owl:Class>\n" + "\n" + "</rdf:RDF>";
		String id = "WebOnt_I5_24_003";
		TestClasses tc = TestClasses.valueOf("POSITIVE_IMPL");
		String d = "This is a typical definition of range from description logic.";
		JUnitRunner r = new JUnitRunner(premise, conclusion, id, tc, d);
		r.setReasonerFactory(Factory.factory());
		r.run();
	}
}
