package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class MailItemTest {
    private MailIterm testMailItem;
    private Recipient testRecipient;

    @BeforeEach
    void setUP() throws DimensionNumericException {
        testRecipient = new Recipient("Wyllie", "Fang", "fang.wenxu@northeastern.edu");
        testMailItem = new MailIterm(12,8,15,testRecipient);
    }

    @Test
    void testMailItemConstructor() {
        assertThrows(DimensionNumericException.class, ()-> {
            new MailIterm(0, 8, 15,testRecipient);
        });
        assertThrows(DimensionNumericException.class, ()-> {
            new MailIterm(12, -1, 15,testRecipient);
        });
        assertThrows(DimensionNumericException.class, ()-> {
            new MailIterm(12, 8, -2,testRecipient);
        });
    }

    @Test
    void getWidth() {
        assertEquals(12, testMailItem.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(8,testMailItem.getHeight());
    }

    @Test
    void getDepth() {
        assertEquals(15,testMailItem.getDepth());
    }

    @Test
    void getRecipient() {
        assertEquals(testRecipient, testMailItem.getRecipient());
    }
}
