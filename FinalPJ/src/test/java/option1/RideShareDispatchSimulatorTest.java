package option1;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RideShareDispatchSimulatorTest {
    private RideShareDispatchSimulator simulator;
    private List<Driver> driversList;
    public static Integer NUM_OF_DIVERS= 3;

    @BeforeEach
    void setUp() {
        simulator = new RideShareDispatchSimulator(NUM_OF_DIVERS);
        driversList = Arrays.asList(new Driver("Driver_1"), new Driver("Driver_2"), new Driver("Driver_3"));

    }

    @Test
    void testStartSimulation_AllDriversAreBusyInitially() {
        List<RideRequest> requests = Arrays.asList(
            new RideRequest("Customer1", "locA", "locAA",100.00, new Timestamp(System.currentTimeMillis()),RideType.Express_pickup),
            new RideRequest("Customer2", "locB", "locBB", 110.00, new Timestamp(System.currentTimeMillis()),RideType.Standard_pickup)
        );
        // Making all drivers unavailable
        driversList.forEach(d -> d.assignRide(new Ride(new RideRequest("test all drivers unavailable", "startLoc", "endLoc", 10.00, new Timestamp(System.currentTimeMillis()), RideType.Environmentally_conscious_pickup), new Timestamp(System.currentTimeMillis()), d)));

        simulator.startSimulation(requests);
        assertTrue(simulator.getActiveRidePQueue().isEmpty());
        assertTrue(simulator.getRideRequestPQueue().isEmpty());
    }

    @Test
    void testSimulationWithRideCompletion() {
        List<RideRequest> requests = Arrays.asList(
            new RideRequest("Customer1", "locA", "locAA",100.00, new Timestamp(System.currentTimeMillis()),RideType.Express_pickup),
            new RideRequest("Customer2", "locB", "locBB", 110.00, new Timestamp(System.currentTimeMillis()),RideType.Standard_pickup)
        );
        simulator.startSimulation(requests);
        assertFalse(simulator.getRideRequestedEventsList().isEmpty());
        assertFalse(simulator.getRideFinishedEventsList().isEmpty());
    }

    @Test
    void testNoRideRequests() {
        simulator.startSimulation(List.of());
        assertTrue(simulator.getRideRequestedEventsList().isEmpty());
        assertTrue(simulator.getRideFinishedEventsList().isEmpty());
    }

    @Test
    void testGetDriversList(){
        for(int i = 0; i < NUM_OF_DIVERS; i++){
            assertEquals(driversList.get(i).getId(), simulator.getDriversList().get(i).getId());
        }
    }
    @Test
    void testGetRideRequestedEventsList(){
        List<RideRequest> rideRequests = Arrays.asList(
            new RideRequest("Customer1", "locA", "locAA",100.00, new Timestamp(System.currentTimeMillis()),RideType.Express_pickup),
            new RideRequest("Customer2", "locB", "locBB", 110.00, new Timestamp(System.currentTimeMillis()),RideType.Standard_pickup)
        );
        simulator.startSimulation(rideRequests);
        assertFalse(simulator.getRideRequestedEventsList().isEmpty());
    }
    @Test
    void testGetRideFinishedEventsList(){
        assertTrue(simulator.getRideFinishedEventsList().isEmpty());
    }
}