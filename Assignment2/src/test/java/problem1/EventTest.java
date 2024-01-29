package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventTest {
    private String clientName;
    private int numberOfPeople;
    private Event event;

    @BeforeEach
    void setUp() throws Exception {
        this.clientName = "Wyllie";
        this.numberOfPeople = 30;
        this.event = new Event(clientName, numberOfPeople);
    }

    @Test
    public void getClientName() throws Exception {
        assertEquals(this.clientName, this.event.getClientName());
    }

    @Test
    public void getNumberOfPeople() throws Exception {
        assertEquals(this.numberOfPeople, this.event.getNumberOfPeople());
    }


}