package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduleTest {
    private Schedule schedule;
    private int numberOfPeople;
    private String clientName;
    private String eventType;
    private static final String LUNCH_TYPE = "LunchEvent";
    private static final String DINNER_TYPE = "DinnerEvent";

    @BeforeEach
    void setUp() throws Exception{
        this.numberOfPeople = 20;
        this.clientName = "Alex";
        this.eventType = LUNCH_TYPE;
        this.schedule = new Schedule();
    }

    @Test
    void createEvent() {
    }
}