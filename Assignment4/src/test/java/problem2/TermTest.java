package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermTest {
    private Integer termPower1, termPower2, termCoefficient1, termCoefficient2;
    private Term term1;

    @BeforeEach
    void setUp() {
        termPower1 = 1;
        termPower2 = 2;
        termCoefficient1 = 10;
        termCoefficient2 = -9;
        term1 = new Term(termPower1, termCoefficient1);
    }

    @Test
    void getTermPower() {
        assertEquals(term1.getTermPower(),termPower1);
    }

    @Test
    void getTermCoefficient() {
        assertEquals(term1.getTermCoefficient(),termCoefficient1);
    }

    @Test
    void setTermPower() {
        term1.setTermPower(termPower2);
        assertEquals(term1.getTermPower(),termPower2);
    }

    @Test
    void setTermCoefficient() {
        term1.setTermCoefficient(termCoefficient2);
        assertEquals(term1.getTermCoefficient(),termCoefficient2);
    }
}