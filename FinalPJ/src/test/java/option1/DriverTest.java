package option1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriverTest {
    Ride testRide;
    RideRequest rideRequest;
    String driverId;
    Ride currentRide, currentRide2;
    Driver driver001, driver002;

    @BeforeEach
    void setUp() {
        driverId = "testDriver";
        rideRequest = new RideRequest("Customer1", "locA", "locB",100.00, new Timestamp(System.currentTimeMillis()),RideType.Express_pickup);
        rideRequest = new RideRequest("Customer2", "locC", "locD",50.00, new Timestamp(System.currentTimeMillis()),RideType.Wait_and_save_pickup);
        currentRide = new Ride(rideRequest, new Timestamp(System.currentTimeMillis()), new Driver("testDriver"));
        currentRide2 = new Ride(rideRequest, new Timestamp(System.currentTimeMillis()), new Driver("testDriver"));
        driver001 = new Driver("testDriver");
        driver002 = new Driver("testDriver2",currentRide2);
    }

    @Test
    void testGetId() {
        assertEquals("testDriver", driver001.getId());
    }

    @Test
    void testGetCurrentRide() {
        assertNull(driver001.getCurrentRide());
        assertEquals(currentRide2, driver002.getCurrentRide());
    }

    @Test
    void testAssignRide() {
        driver001.assignRide(testRide);
        assertEquals(testRide, driver001.getCurrentRide());
    }

    @Test
    void testIsAvailable() {
        assertTrue(driver001.isAvailable());
    }

    @Test
    void testCompleteRide() {
        driver001.completeRide();
        assertNull(driver001.getCurrentRide());
    }
}