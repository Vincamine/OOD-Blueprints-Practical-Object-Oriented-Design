package option1;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Represents a ride in a transportation system, associating a ride request with a driver and managing time calculations.
 * This class encapsulates the details of a ride including the request, start time, expected end time, and the driver.
 */
public class Ride {

    private static final int AVERAGE_SPEED_MPH = 60;
    private static final int HOURS_TO_MILLISECONDS = 3600000;
    private RideRequest rideRequest;
    private Timestamp startTime;
    private Timestamp expectedEndTime;
    private Driver rideDriver;

    /**
     * Constructs a Ride object with specified ride request, start time, and driver.
     * The expected end time is calculated based on the anticipated distance from the ride request.
     *
     * @param rideRequest the ride request detailing the anticipated distance and other parameters.
     * @param startTime   the start time of the ride.
     * @param rideDriver  the driver assigned to this ride.
     */
    public Ride(RideRequest rideRequest, Timestamp startTime,
        Driver rideDriver) {
        this.rideRequest = rideRequest;
        this.startTime = startTime;
        this.rideDriver = rideDriver;
        this.expectedEndTime = calculateExpectedEndTime();
    }
    /**
     * Calculates the expected end time of the ride based on the average speed and anticipated distance.
     *
     * @return the expected end time as a Timestamp.
     */
    private Timestamp calculateExpectedEndTime(){
        double durationInHours = rideRequest.getAnticipatedDistance() / AVERAGE_SPEED_MPH;
//        Timestamp durationInMillis =  new Timestamp();
        return new Timestamp(startTime.getTime() + ((long) durationInHours * HOURS_TO_MILLISECONDS));

    }
    /**
     * Returns the ride request associated with this ride.
     *
     * @return the ride request.
     */
    public RideRequest getRideRequest() {
        return rideRequest;
    }
    /**
     * Returns the start time of the ride.
     *
     * @return the start time as a Timestamp.
     */
    public Timestamp getStartTime() {
        return startTime;
    }
    /**
     * Returns the expected end time of the ride.
     *
     * @return the expected end time as a Timestamp.
     */
    public Timestamp getExpectedEndTime() {
        return expectedEndTime;
    }

    public Driver getRideDriver() {
        return rideDriver;
    }

    @Override
    public String toString() {
        return "Ride{" +
            "rideRequest=" + rideRequest +
            ", startTime=" + startTime +
            ", expectedEndTime=" + expectedEndTime +
            ", rideDriver=" + rideDriver +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ride ride)) {
            return false;
        }
        return Objects.equals(rideRequest, ride.rideRequest) && Objects.equals(
            startTime, ride.startTime) && Objects.equals(expectedEndTime,
            ride.expectedEndTime) && Objects.equals(rideDriver, ride.rideDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideRequest, startTime, expectedEndTime, rideDriver);
    }
}
