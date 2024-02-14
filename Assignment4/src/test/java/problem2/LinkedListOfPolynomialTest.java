package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListOfPolynomialTest {
    private TermNode head;
    private LinkedListOfPolynomial polynomial;
    Integer power0, power1, power2, coeff0, coeff1, coeff2, degree;
    Integer power3, coeff3, power4, coeff4;

    @BeforeEach
    void setUp() throws InvalidPolynomialPowerException {
        power0 = 2;
        power1 = 1;
        power2 = 0;
        coeff0 = 4;
        coeff1 = 3;
        coeff2 = 2;
        degree = 2;
        power3 = 3;
        coeff3 = 6;
        power4 = 3;
        coeff4 = 1;

        head = new TermNode(new Term(power0, coeff0), null);
        polynomial = new LinkedListOfPolynomial(head);
    }

    @Test
    void getDegree() {
        assertEquals(degree,polynomial.getDegree());
    }

    @Test
    void getCoefficient() throws InvalidPolynomialPowerException {
        assertEquals(coeff0,polynomial.getCoefficient(power0));

        polynomial.addTerm(power1,coeff1);
        assertEquals(coeff1, polynomial.getCoefficient(power1));

        polynomial.addTerm(power2,coeff2);
        assertEquals(coeff2,polynomial.getCoefficient(power2));

        polynomial.addTerm(power3,coeff3);
        assertEquals(coeff3,polynomial.getCoefficient(power3));

    }

    @Test
    void setDegree() {
        polynomial.setDegree(1);
        assertNotEquals(1, polynomial.getDegree());
        polynomial.setDegree(9);
        assertEquals(9, polynomial.getDegree());

    }

    @Test
    void addTerm() throws InvalidPolynomialPowerException {
        polynomial.addTerm(power3,coeff3);
        assertEquals(coeff3,polynomial.getCoefficient(power3));

        polynomial.addTerm(power4,coeff4);
        assertEquals(coeff3+coeff4,polynomial.getCoefficient(power3));

        polynomial.addTerm(power1, coeff1);
        assertEquals(coeff1,polynomial.getCoefficient(power1));

        polynomial.addTerm(power2, coeff2);
        assertEquals(coeff2,polynomial.getCoefficient(power2));
    }

    @Test
    void removeTerm() throws InvalidPolynomialPowerException {
        polynomial.removeTerm(power0);
        assertEquals(0,polynomial.getCoefficient(coeff0));

        polynomial.addTerm(power3,coeff3);
        polynomial.addTerm(power4,coeff4);

        polynomial.addTerm(power2, coeff2);

        polynomial.removeTerm(power0);
        assertEquals(0,polynomial.getCoefficient(coeff0));

        polynomial.removeTerm(power3);
        assertEquals(0,polynomial.getCoefficient(coeff1));

    }

    @Test
    void testIsSame() throws InvalidPolynomialPowerException {
        polynomial.addTerm(power1,coeff1);
        polynomial.addTerm(power2,coeff2);

        TermNode anotherHead = new TermNode(new Term(2, 4), null);
        LinkedListOfPolynomial anotherPolynomial = new LinkedListOfPolynomial(anotherHead);
        anotherPolynomial.addTerm(1, 3);
        anotherPolynomial.addTerm(0, 2);
        assertTrue(polynomial.isSame(anotherPolynomial));

        TermNode thirdHead = new TermNode(new Term(11, 11), null);
        LinkedListOfPolynomial thirdPolynomial = new LinkedListOfPolynomial(thirdHead);
        thirdPolynomial.addTerm(0,2);
        assertFalse(polynomial.isSame(thirdPolynomial));
    }


    @Test
    void add() throws InvalidPolynomialPowerException {
        TermNode anotherHead = new TermNode(new Term(3, 1), null);
        LinkedListOfPolynomial anotherPolynomial = new LinkedListOfPolynomial(anotherHead);
        polynomial.add(anotherPolynomial);
        assertEquals(1, polynomial.getCoefficient(3));
    }
}