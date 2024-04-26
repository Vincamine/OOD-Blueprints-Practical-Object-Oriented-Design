package option1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RideRequestTest {
    String id = "ride123";
    String startLoc = "Location A";
    String endLoc = "Location B";
    Double anticipatedDistance = 15.0;
    Timestamp requestedTime = new Timestamp(System.currentTimeMillis());
    RideType rideType = RideType.Express_pickup;
    RideRequest rideRequest = new RideRequest(id, startLoc, endLoc, anticipatedDistance, requestedTime, rideType);

    @Test
    void getId() {
        assertEquals( id, rideRequest.getId());
    }

    @Test
    void getStartLoc() {
        assertEquals(startLoc, rideRequest.getStartLoc());
    }

    @Test
    void getEndLoc() {
        assertEquals(endLoc, rideRequest.getEndLoc());
    }

    @Test
    void getAnticipatedDistance() {
        assertEquals(anticipatedDistance, rideRequest.getAnticipatedDistance());

    }

    @Test
    void getRequestedTime() {
        assertEquals(requestedTime, rideRequest.getRequestedTime());
    }

    @Test
    void getRideType() {
        assertEquals(rideType, rideRequest.getRideType());
    }
}