package bugs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.io.SystemOutDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.OWLFacet;

import uk.ac.manchester.cs.jfact.JFactFactory;
import uk.ac.manchester.cs.jfact.kernel.options.JFactReasonerConfiguration;

@SuppressWarnings("javadoc")
public class AddIndividualsAfterLoadingTestCase {

    @Test
    public void shouldLoadAndNotFailQuery() throws Exception {
        // given
        OWLOntology o = OWLManager.createOWLOntologyManager().createOntology();
        OWLOntologyManager m = o.getOWLOntologyManager();
        OWLDataFactory f = m.getOWLDataFactory();
        OWLClass c1 = f.getOWLClass(IRI.create("urn:test#c1"));
        OWLClass c2 = f.getOWLClass(IRI.create("urn:test#c2"));
        OWLObjectProperty p = f.getOWLObjectProperty(IRI.create("urn:test#p"));
        m.addAxiom(o, f.getOWLDisjointClassesAxiom(c1, c2));
        m.addAxiom(o, f.getOWLObjectPropertyDomainAxiom(p, c1));
        m.addAxiom(o, f.getOWLObjectPropertyRangeAxiom(p, c2));
        // OWLReasoner r = new JFactFactory().createReasoner(o);
        // r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        OWLIndividual i = f.getOWLNamedIndividual(IRI.create("urn:test#i"));
        OWLIndividual j = f.getOWLNamedIndividual(IRI.create("urn:test#j"));
        m.addAxiom(o, f.getOWLObjectPropertyAssertionAxiom(p, i, j));
        // r.flush();
        // r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        OWLReasoner r = new JFactFactory().createReasoner(o);
        r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        OWLIndividual k = f.getOWLNamedIndividual(IRI.create("urn:test#k"));
        OWLIndividual l = f.getOWLNamedIndividual(IRI.create("urn:test#l"));
        m.addAxiom(o, f.getOWLObjectPropertyAssertionAxiom(p, k, l));
        OWLDataProperty dt = f.getOWLDataProperty(IRI.create("urn:test#dt"));
        m.addAxiom(o, f.getOWLDeclarationAxiom(dt));
        m.addAxiom(
                o,
                f.getOWLDataPropertyRangeAxiom(dt,
                        f.getOWLDatatype(OWL2Datatype.XSD_STRING.getIRI())));
        m.addAxiom(
                o,
                f.getOWLDataPropertyAssertionAxiom(dt, l,
                        f.getOWLLiteral("test")));
        r.flush();
        r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        assertTrue(r.isConsistent());
    }

    @Test
    public void shouldLoadAndNotFailQueryDataHasValue() throws Exception {
        OWLOntology o = OWLManager.createOWLOntologyManager().createOntology();
        OWLOntologyManager m = o.getOWLOntologyManager();
        OWLDataFactory f = m.getOWLDataFactory();
        OWLDataProperty p = f.getOWLDataProperty(IRI.create("urn:test#p"));
        m.addAxiom(o,
                f.getOWLDataPropertyRangeAxiom(p, f.getFloatOWLDatatype()));
        OWLNamedIndividual i = f
                .getOWLNamedIndividual(IRI.create("urn:test#i"));
        m.addAxiom(o, f.getOWLDataPropertyAssertionAxiom(p, i, 19.0F));
        m.saveOntology(o, new SystemOutDocumentTarget());
        OWLReasoner r = new JFactFactory().createReasoner(o);
        r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        assertTrue(r.getInstances(
                f.getOWLDataAllValuesFrom(p,
                        f.getOWLDatatypeMaxInclusiveRestriction(20.0F)), false)
                .containsEntity(i));
    }

    @Test
    public void debug() throws OWLOntologyCreationException,
            OWLOntologyStorageException {
        String input = "Prefix(owl:=<http://www.w3.org/2002/07/owl#>)\n"
                + "Prefix(rdf:=<http://www.w3.org/1999/02/22-rdf-syntax-ns#>)\n"
                + "Prefix(xml:=<http://www.w3.org/XML/1998/namespace>)\n"
                + "Prefix(xsd:=<http://www.w3.org/2001/XMLSchema#>)\n"
                + "Prefix(rdfs:=<http://www.w3.org/2000/01/rdf-schema#>)\n"
                + "\n"
                + "\n"
                + "Ontology(<urn:test>\n"
                + "\n"
                + "Declaration(Class(<urn:test#Producto>))\n"
                + "Declaration(Class(<urn:test#lessThan20>))\n"
                + "Declaration(DataProperty(<urn:test#hasEnergia>))\n"
                + "Declaration(NamedIndividual(<urn:test#prod1>))\n"
                + "Declaration(NamedIndividual(<urn:test#prod2>))\n"
                + "Declaration(NamedIndividual(<urn:test#prod3>))\n"
                + "Declaration(NamedIndividual(<urn:test#prod4>))\n"
                + "Declaration(NamedIndividual(<urn:test#prod5>))\n"
                + "EquivalentClasses(<urn:test#lessThan20> ObjectIntersectionOf(DataSomeValuesFrom(<urn:test#hasEnergia> DatatypeRestriction(xsd:float xsd:maxExclusive \"20.0\"^^xsd:float)) <urn:test#Producto>))\n"
                + "SubClassOf(<urn:test#lessThan20> <urn:test#Producto>)\n"
                + "FunctionalDataProperty(<urn:test#hasEnergia>)\n"
                + "DataPropertyDomain(<urn:test#hasEnergia> <urn:test#Producto>)\n"
                + "DataPropertyRange(<urn:test#hasEnergia> xsd:float)\n"
                + "DataPropertyAssertion(<urn:test#hasEnergia> <urn:test#prod1> \"30.0\"^^xsd:float)\n"
                + "DataPropertyAssertion(<urn:test#hasEnergia> <urn:test#prod2> \"35.0\"^^xsd:float)\n"
                + "DataPropertyAssertion(<urn:test#hasEnergia> <urn:test#prod3> \"58.0\"^^xsd:float)\n"
                + "DataPropertyAssertion(<urn:test#hasEnergia> <urn:test#prod4> \"14.0\"^^xsd:float)\n"
                + "DataPropertyAssertion(<urn:test#hasEnergia> <urn:test#prod5> \"5.0\"^^xsd:float))";
        OWLOntology o = OWLManager.createOWLOntologyManager()
                .loadOntologyFromOntologyDocument(
                        new StringDocumentSource(input));
        OWLOntologyManager m = o.getOWLOntologyManager();
        OWLDataFactory f = m.getOWLDataFactory();
        JFactReasonerConfiguration config = new JFactReasonerConfiguration();
        config.setLoggingActive(true);
        OWLReasoner r = new JFactFactory().createReasoner(o, config);
        // m.saveOntology(o, new OWLFunctionalSyntaxOntologyFormat(),
        // new SystemOutDocumentTarget());
        r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        OWLClass c = f.getOWLClass(IRI.create("urn:test#Producto"));
        OWLDataProperty p = f.getOWLDataProperty(IRI
                .create("urn:test#hasEnergia"));
        OWLNamedIndividual i = f.getOWLNamedIndividual(IRI
                .create("urn:test#prod4"));
        OWLClass test = f.getOWLClass(IRI.create("urn:test#lessThan20"));
        System.out.println("AddIndividualsAfterLoadingTestCase.debug() "
                + r.getInstances(test, false));
        // assertTrue(r.getInstances(c, false).containsEntity(i));
        assertTrue(r
                .getInstances(
                        f.getOWLDataSomeValuesFrom(p, f
                                .getOWLDatatypeRestriction(f
                                        .getFloatOWLDatatype(), f
                                        .getOWLFacetRestriction(
                                                OWLFacet.MAX_INCLUSIVE, 20f))),
                        false).containsEntity(i));
        assertTrue(r
                .getInstances(
                        f.getOWLObjectIntersectionOf(
                                c,
                                f.getOWLDataSomeValuesFrom(
                                        p,
                                        f.getOWLDatatypeMaxInclusiveRestriction(20.0F))),
                        false).containsEntity(i));
    }
}
