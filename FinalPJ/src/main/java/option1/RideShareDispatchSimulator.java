package option1;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Simulates a ride-sharing dispatch system. This class manages the dispatching of rides to drivers,
 * maintaining a queue of ride requests and active rides, and tracking events for requested and finished rides.
 */
public class RideShareDispatchSimulator {
    private PriorityQueue<RideRequest> rideRequestPQueue;
    private PriorityQueue<Ride> activeRidePQueue;
    private List<Driver> driversList;
    private List<RideRequestedEvent> rideRequestedEventsList;
    private List<RideFinishedEvent> rideFinishedEventsList;

    /**
     * Initializes a new RideShareDispatchSimulator instance with the specified number of drivers.
     * Each driver is added to the drivers list and is named in the format "Driver_{number}",
     * where {number} is the sequential number starting from 1 up to numOfDrivers.
     *
     * This constructor also initializes two priority queues:
     * 1. {@code rideRequestPQueue} that sorts {@link RideRequest} objects based on their ride type
     *    and anticipated distance. Ride type is the primary sort key, followed by the anticipated distance.
     * 2. {@code activeRidePQueue} that sorts {@link Ride} objects based on their expected end time.
     *
     * Additionally, two lists to keep track of ride requested and finished events are initialized:
     * {@code rideRequestedEventsList} and {@code rideFinishedEventsList}.
     *
     * @param numOfDrivers the number of drivers to be initialized in the simulator; must be non-negative.
     * @throws IllegalArgumentException if {@code numOfDrivers} is negative.
     */
    public RideShareDispatchSimulator(int numOfDrivers) {
        driversList = new ArrayList<>(numOfDrivers);
        for(int i = 0; i < numOfDrivers; i++){
            driversList.add(new Driver("Driver_" + (i+1)));
        }
        Comparator<RideRequest> rideRequestComparator = Comparator.comparing(RideRequest::getRideType).thenComparing(RideRequest::getAnticipatedDistance);
        rideRequestPQueue = new PriorityQueue<>(rideRequestComparator);
        Comparator<Ride> rideComparator = Comparator.comparing(Ride::getExpectedEndTime);
        activeRidePQueue = new PriorityQueue<>(rideComparator);
        rideRequestedEventsList = new ArrayList<>();
        rideFinishedEventsList = new ArrayList<>();
    }

    /**
     * Starts the simulation of ride requests processing. This method processes all incoming ride requests by assigning available drivers to them until all requests are handled. It continues to manage ride state transitions from requested to active and then to completed, as time progresses.
     *
     * The method operates in two main loops: The first loop assigns drivers to incoming ride requests and generates ride requested events, as long as there are unassigned ride requests and available drivers. The second loop transitions active rides to completed status based on the expected end time of each ride.
     *
     * @param rideRequests A list of {@link RideRequest} objects representing all the ride requests that need to be processed.
     * @throws NullPointerException if any ride in the active ride queue is null when trying to complete it.
     */
    public void startSimulation(List<RideRequest> rideRequests) {
        rideRequestPQueue.addAll(rideRequests);
        while(!rideRequestPQueue.isEmpty() || !activeRidePQueue.isEmpty()){
            while (!rideRequestPQueue.isEmpty() && isDriverAvailable()) {
                RideRequest nextRequest = rideRequestPQueue.poll();
                Driver availableDriver = getAvailableDriver();
                assignRideToDriver(nextRequest, availableDriver);
                RideRequestedEvent rideRequestedEvent = new RideRequestedEvent(nextRequest,
                    nextRequest != null ? nextRequest.requestedTime : null);
                rideRequestedEventsList.add(rideRequestedEvent);

            }
            Timestamp now = getCurrentTime();
            while (!activeRidePQueue.isEmpty() && activeRidePQueue.peek().getExpectedEndTime().before(now)){
                Ride rideComplete = activeRidePQueue.poll();
                completedRide(Objects.requireNonNull(rideComplete));
                rideFinishedEventsList.add(new RideFinishedEvent(rideComplete,getCurrentTime()));
            }
        }
    }

    /**
     * Retrieves the current system time as a {@link Timestamp}.
     *
     * This method generates a new Timestamp based on the current system time in milliseconds, providing the precise moment the method is called.
     *
     * @return A {@link Timestamp} representing the current system time.
     */
    private Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Completes the given ride and marks the associated driver as available for new assignments.
     *
     * This method updates the state of the driver involved in the completed ride to reflect that they are no longer engaged in an active ride, allowing them to be assigned to new ride requests.
     *
     * @param ride The {@link Ride} object representing the ride that has just been completed.
     * @throws NullPointerException if the ride or the driver associated with the ride is null.
     */
    private void completedRide(Ride ride) {
        // Mark the driver as available again
        Driver driver = ride.getRideDriver();
        driver.completeRide();
    }
    /**
     * Checks if there is any available driver in the drivers list.
     *
     * This method assesses the availability of drivers by iterating through the list of drivers and checking if any are currently available to take new ride requests.
     *
     * @return true if at least one driver is available, false otherwise.
     */
    private boolean isDriverAvailable() {
        return driversList.stream().anyMatch(Driver::isAvailable);
    }

    /**
     * Retrieves the first available driver from the list of drivers.
     *
     * This method searches through the list of drivers, filtering for those who are currently available to take a ride, and returns the first available driver it finds. If no available drivers are found, the method returns null.
     *
     * @return An available {@link Driver} object if one is found, or null if no available drivers are present.
     */
    private Driver getAvailableDriver() {
        Optional<Driver> optionalDriver = driversList.stream().filter(Driver::isAvailable).findFirst();
        return optionalDriver.orElse(null);
    }

    private void assignRideToDriver(RideRequest request, Driver driver) {
        Ride ride = new Ride(request, getCurrentTime(), driver);
        driver.assignRide(ride);
        activeRidePQueue.add(ride);
    }

    public PriorityQueue<RideRequest> getRideRequestPQueue() {
        return rideRequestPQueue;
    }

    public PriorityQueue<Ride> getActiveRidePQueue() {
        return activeRidePQueue;
    }

    public List<Driver> getDriversList() {
        return driversList;
    }

    public List<RideRequestedEvent> getRideRequestedEventsList() {
        return rideRequestedEventsList;
    }

    public List<RideFinishedEvent> getRideFinishedEventsList() {
        return rideFinishedEventsList;
    }


    public double calculateAverageWaitTime() {
        if (rideFinishedEventsList.isEmpty()) return 0.0;

        double totalWaitTime = 0;
        for (RideFinishedEvent rideFinishedEvent : rideFinishedEventsList ) {
            Ride ride = rideFinishedEvent.getRide();
            Timestamp requestTime = ride.getRideRequest().getRequestedTime();
            Timestamp startTime = ride.getStartTime();
            long waitTime = startTime.getTime() - requestTime.getTime();
            totalWaitTime += waitTime;
//            System.out.println("startTime: " + startTime + "  requestTime: " + requestTime);
        }
        return totalWaitTime / rideRequestedEventsList.size();
    }

    public double calculateAverageRidesPerDriver() {
        if (driversList.isEmpty()) return 0.0;

        int totalRides = rideFinishedEventsList.size();
        return (double) totalRides / driversList.size();
    }

    private static List<RideRequest> generateRideRequests(int numRides) {
        List<RideRequest> requests = new ArrayList<>();
        Random rand = new Random();
        String[] startLocations = {"StartA", "StartB", "StartC"};
        String[] endLocations = {"EndA", "EndB", "EndC"};
        RideType[] rideTypes = RideType.values();

        for (int i = 0; i < numRides; i++) {
            // Generate random ride details
            String id = "Ride" + (i + 1);
            String startLoc = startLocations[rand.nextInt(startLocations.length)];
            String endLoc = endLocations[rand.nextInt(endLocations.length)];
            double distance = 5 + rand.nextInt(20);
            Timestamp requestedTime = new Timestamp(System.currentTimeMillis() - 2 * rand.nextInt(60000));
            RideType rideType = rideTypes[rand.nextInt(rideTypes.length)];

            // Create new RideRequest and add to list
            requests.add(new RideRequest(id, startLoc, endLoc, distance, requestedTime, rideType));
        }
        return requests;
    }

    public static void main(String[] args) {
        // Scenarios to run
        int[][] scenarios = {{50, 25}, {50, 100}, {50, 250}};

        for (int[] scenario : scenarios) {
            int numDrivers = scenario[0];
            int numRides = scenario[1];

            // Create the simulator
            RideShareDispatchSimulator simulator = new RideShareDispatchSimulator(numDrivers);

            // Generate random ride requests
            List<RideRequest> rideRequests = generateRideRequests(numRides);

            // Start simulation
            simulator.startSimulation(rideRequests);

            // Calculate statistics
            double averageWaitTime = simulator.calculateAverageWaitTime();
            double averageRidesPerDriver = simulator.calculateAverageRidesPerDriver();
            long minutes = (long) (averageWaitTime / 1000) / 60;
            long seconds = (long) (averageWaitTime / 1000) % 60;

            // Output the results

            System.out.println("Simulation with " + numDrivers + " drivers and " + numRides + " rides:");
            System.out.println("Average wait time for a ride: " + minutes + " minutes and " + seconds + " seconds");
            System.out.println("Average number of rides per driver: " + averageRidesPerDriver);
            System.out.println();
        }
    }


}
