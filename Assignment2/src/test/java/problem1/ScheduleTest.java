package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScheduleTest {
    private Schedule dailyEvents;
    private int numberOfPeople;
    private String clientName;
    private String eventType;
    private static final String LUNCH_TYPE = "LunchEvent";
    private static final String DINNER_TYPE = "DinnerEvent";

    @BeforeEach
    public void setUp() throws Exception {
        this.numberOfPeople = 20;
        this.clientName = "Alexa";
        this.eventType = LUNCH_TYPE;
        this.dailyEvents = new Schedule();
    }

    @Test
    public void createEventEventTypeIllegal() throws Exception {
        this.eventType = "ChristmasEvent";
        this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

    @Test
    public void createEventLunchEventExists() throws Exception {
        this.eventType = LUNCH_TYPE;
        this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
        this.eventType = LUNCH_TYPE;
        this.numberOfPeople = 30;
        this.clientName = "Wyllie";
        this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

    @Test
    public void createEventDinnerEventExists() throws Exception {
        this.eventType = DINNER_TYPE;
        this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
        this.eventType = DINNER_TYPE;
        this.numberOfPeople = 30;
        this.clientName = "Wyllie";
        this.dailyEvents = this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

    @Test
    public void createLunchEventPeopleNotEnough() throws Exception {
        this.eventType = LUNCH_TYPE;
        this.numberOfPeople = 14;
        this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

    @Test
    public void createLunchEventPeopleTooMany() throws Exception {
        this.eventType = LUNCH_TYPE;
        this.numberOfPeople = 91;
        this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

    @Test
    public void createDinnerEventPeopleNotEnough() throws Exception {
        this.numberOfPeople = 9;
        this.eventType = DINNER_TYPE;
        this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

    @Test
    public void createDinnerEventPeopleTooMany() throws Exception {
        this.numberOfPeople = 51;
        this.eventType = DINNER_TYPE;
        this.dailyEvents.createEvent(eventType, numberOfPeople, clientName);
    }

}