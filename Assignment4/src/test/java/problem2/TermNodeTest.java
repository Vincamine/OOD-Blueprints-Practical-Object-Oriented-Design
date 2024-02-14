package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TermNodeTest {
    private static Integer termPower1, termPower2,termPower3, termCoefficient1, termCoefficient2, termCoefficient3;
    private static TermNode node1, node2, node3;
    private static Term term1, term2, term3;


    @BeforeAll
    static void setUp() {
        termPower1 = 1;
        termPower2 = 2;
        termPower3 = 3;
        termCoefficient1 = 10;
        termCoefficient2 = -9;
        termCoefficient3 = 11;
        term1 = new Term(termPower1, termCoefficient1);
        term2 = new Term(termPower2, termCoefficient2);
        term3 = new Term(termPower3, termCoefficient3);
        node2 = new TermNode(term2, null);
        node1 = new TermNode(term1, node2);
    }


    @Test
    void testGetTerm() {
        assertTrue(term1.equals(node1.getTerm()));
    }

    @Test
    void testSetTerm() {
        node2.setTerm(term2);
        assertEquals(node2.getTerm(), term2);
    }

    @Test
    void testGetNextNode() {
        assertEquals(node2, node1.getNextNode());
    }

    @Test
    void testSetNextNode() {
        node3 = new TermNode(term2, null);
        node2.setNextNode(node3);
        assertEquals(node3, node2.getNextNode());
    }
}