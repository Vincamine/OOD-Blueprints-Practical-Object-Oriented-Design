package option1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RideTest {
    final int AVERAGE_SPEED_MPH = 60;
    final int HOURS_TO_MILLISECONDS = 3600000;
    RideRequest rideRequest;
    Timestamp testStartTime;
    Driver testDriver;
    Ride testRide;
    @BeforeEach
    void setUp() {
        rideRequest = new RideRequest("Customer1", "locA", "locAA",100.00, new Timestamp(System.currentTimeMillis()),RideType.Express_pickup);
        testStartTime = new Timestamp(System.currentTimeMillis());
        testDriver = new Driver("testDriver");
        testRide = new Ride(rideRequest, new Timestamp(System.currentTimeMillis()), new Driver("testDriver"));

    }

    @Test
    void getRideRequest() {
        assertEquals(rideRequest,testRide.getRideRequest());
    }

    @Test
    void getStartTime() {
        assertEquals(testStartTime, testRide.getStartTime());
    }

    @Test
    void getExpectedEndTime() {
        double durationInHours = rideRequest.getAnticipatedDistance() / AVERAGE_SPEED_MPH;
        Timestamp testExpectedEndTime = new Timestamp(testRide.getStartTime().getTime() + ((long) durationInHours * HOURS_TO_MILLISECONDS));
        assertEquals(testExpectedEndTime, testRide.getExpectedEndTime());
    }

    @Test
    void getRideDriver() {
        assertEquals(testDriver.getId(),testRide.getRideDriver().getId());
    }
}