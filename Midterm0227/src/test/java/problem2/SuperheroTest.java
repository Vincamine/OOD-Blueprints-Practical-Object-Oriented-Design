package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SuperheroTest {

    private Superhero superhero;



    @BeforeEach
    public void setUp() throws Exception {
        Name testName = new Name("Wyllie", "A","Wayne");
        superhero = new Superhero(testName, 30, 50.0, 70.0);


    }

    @Test
    public void testDecreaseHealthLevelValid() throws HealthLevelException {
        superhero.decreaseHealthLevel(10.0);
        assertEquals(90.0, superhero.getHealthLevel(), 0.0);
    }

    @Test
    public void testDecreaseHealthLevelNegative() throws HealthLevelException {
        assertThrows(HealthLevelException.class, () ->{
            superhero.decreaseHealthLevel(-5.0);
            }, "Expected decreaseHealthLevel to throw, but it didn't");

//        try {
//            superhero.decreaseHealthLevel(-5.0);
//        } catch (HealthLevelException e){
//            fail(e.getMessage());}
    }

    @Test
    public void testDecreaseHealthLevelTooMuch() throws HealthLevelException {
        assertThrows(HealthLevelException.class, () -> {
            superhero.decreaseHealthLevel(200.0);
            }, "Expected decreaseHealthLevel to throw, but it didn't");

    }
}
