package option1;

import java.util.Objects;

/**
 * Represents a driver in a ride-sharing system. The Driver class
 * manages information about the driver's identity and their current ride assignment.
 */
public class Driver {
    /**
     * Unique identifier for the driver.
     */
    private String id;
    /**
     * Current ride assigned to the driver. Null if no ride is currently assigned.
     */
    private Ride currentRide;

    /**
     * Constructs a new Driver with a specified ID and a current ride.
     *
     * @param id the unique identifier for the driver
     * @param currentRide the initial ride assigned to the driver; may be null if no ride is assigned
     */
    public Driver(String id, Ride currentRide) {
        this.id = id;
        this.currentRide = currentRide;
    }
    /**
     * Constructs a new Driver with a specified ID and no current ride.
     *
     * @param id the unique identifier for the driver
     */
    public Driver(String id) {
        this.id = id;
        this.currentRide = null;
    }

    public String getId() {
        return id;
    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    /**
     * Assigns a new ride to the driver if they are currently available.
     *
     * @param ride the ride to be assigned
     */
    public void assignRide(Ride ride) {
        if (isAvailable()) {
            this.currentRide = ride;
        }
    }

    /**
     * Checks if the driver is available to take a new ride.
     *
     * @return true if no current ride is assigned, otherwise false
     */
    public boolean isAvailable() {
        return currentRide == null;
    }
    /**
     * Marks the current ride as complete by setting it to null.
     */
    public void completeRide() {
        this.currentRide = null;
    }

    @Override
    public String toString() {
        return "Driver{" +
            "id='" + id + '\'' +
            ", currentRide=" + currentRide +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Driver driver)) {
            return false;
        }
        return Objects.equals(id, driver.id) && Objects.equals(currentRide,
            driver.currentRide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentRide);
    }
}
