package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {

    private Recipient testRecipient;


    @BeforeEach
    void setUp() {
        testRecipient = new Recipient("Wyllie", "Fang", "fang.wenxu@northeastern.edu");
    }

    @Test
    void getFirstName() {
        assertEquals("Wyllie", testRecipient.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Fang", testRecipient.getLastName());
    }

    @Test
    void getEmailAddress() {
        assertEquals("fang.wenxu@northeastern.edu", testRecipient.getEmailAddress());
    }

    @Test
    void testEquals_SameObjects() {
        assertTrue(testRecipient.equals(testRecipient));
    }

    /*
    @Test
    void testEquals_NullObject() {
        assertNotEquals(null, testRecipient);
    }
     */
    @Test
    void testEquals_NullComparison() {
        assertFalse(testRecipient.equals(null));
    }

    @Test
    void testEquals_DifferentDataTypes() {
        assertFalse(testRecipient.equals("String"));
        //String newRecipient = "Wyllie Fang";
        //assertNotEquals(testRecipient, newRecipient);
    }

    /*
    @Test
    void testEquals_SameFieldsOverall() {
        Recipient newRecipient = new Recipient("Wyllie", "Fang", "fang.wenxu@northeastern.edu");
        assertEquals(testRecipient, newRecipient);
    }
    */

    @Test
    void testEquals_DifferentFirstName() {
        Recipient newRecipient = new Recipient("Snow", "Fang", "fang.wenxu@northeastern.edu");
        assertFalse(testRecipient.equals(newRecipient));
    }

    @Test
    void testEquals_DifferentLastName() {
        Recipient newRecipient = new Recipient("Wyllie", "F", "fang.wenxu@northeastern.edu");
        assertFalse(testRecipient.equals(newRecipient));
    }

    @Test
    void testEquals_DifferentEmailAddress() {
        Recipient newRecipient = new Recipient("Wyllie", "Fang", "12345@outlook.com");
        assertFalse(testRecipient.equals(newRecipient));
    }

    @Test
    void testHashCode() {
        Recipient newRecipient = new Recipient("Wyllie", "Fang", "fang.wenxu@northeastern.edu");
        assertEquals(newRecipient.hashCode(), testRecipient.hashCode());
    }
}