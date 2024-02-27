package problem1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class PriorityQueueTest {

    private PriorityQueue pqEmpty;
    private PriorityQueue pqSingle;
    private PriorityQueue pqMultiple;


    @BeforeEach
    public void setUp() {
        pqEmpty = new PriorityQueue();
        pqSingle = new PriorityQueue(new PriorityQueueElement(10, "Single"), null);
        pqMultiple = pqSingle.add(5, "Lower").add(15, "Higher").add(15,"Higher again");
    }

    @Test
    public void testCreateEmpty() {
        PriorityQueue empty = pqEmpty.createEmpty();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(pqSingle.isEmpty(), "Non-empty priority queue should not be empty.");
    }

    @Test
    public void testAdd() {
        PriorityQueue pqAfterAdd = pqEmpty.add(1, "Test");
        assertNotNull(pqAfterAdd);
        assertEquals("Test", pqAfterAdd.peek());
    }

    @Test
    public void testPeek() {
        assertEquals( "Higher again", pqMultiple.peek());
    }

    @Test
    public void testPeekEmpty() {
        assertThrows(IllegalStateException.class, () -> {
            pqEmpty.peek();
        });
    }

    @Test
    public void testPop() {
        PriorityQueue afterPop = pqMultiple.pop();
        assertNotNull(afterPop);
        assertEquals("Higher", afterPop.peek());
        afterPop = afterPop.pop();
        assertEquals("Single", afterPop.peek());
    }

    @Test
    public void testPopToEmpty() {
        PriorityQueue afterPop = pqSingle.pop();
        assertNull(afterPop);
    }
}
