package conformancetests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import testbase.TestBase;

@SuppressWarnings("javadoc")
public class StrangeTestCase extends TestBase {

    @Test
    public void shouldFindThreeSubclasses() throws OWLOntologyCreationException {
        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
        OWLOntology o = m.createOntology();
        OWLDataFactory d = m.getOWLDataFactory();
        o.add(d.getOWLSubClassOfAxiom(d.getOWLClass(IRI.create("urn:b")), d.getOWLClass(IRI.create("urn:c"))));
        o.add(d.getOWLSubClassOfAxiom(d.getOWLClass(IRI.create("urn:a")), d.getOWLClass(IRI.create("urn:b"))));
        OWLReasoner r = factory().createReasoner(o);
        r.precomputeInferences(InferenceType.CLASS_HIERARCHY);
        NodeSet<OWLClass> subClasses = r.getSubClasses(d.getOWLClass(IRI.create("urn:c")), false);
        assertEquals(3, subClasses.entities().count());
    }
}
