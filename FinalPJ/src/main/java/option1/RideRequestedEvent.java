package option1;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Represents an event that a ride request has been made within a transportation system.
 * This class encapsulates details of the ride request along with the timestamp when the request was made.
 */
public class RideRequestedEvent implements Event {
    private RideRequest rideRequest;
    private Timestamp timeStamp;

    /**
     * Constructs a new RideRequestedEvent with the specified ride request and timestamp.
     *
     * @param rideRequest The ride request associated with this event.
     * @param timeStamp The timestamp when the ride request was made.
     */
    public RideRequestedEvent(RideRequest rideRequest, Timestamp timeStamp) {
        this.rideRequest = rideRequest;
        this.timeStamp = timeStamp;
    }

    /**
     * Returns the timestamp when the ride request was made.
     *
     * @return The timestamp of the event.
     */
    @Override
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    /**
     * Returns the ride request associated with this event.
     *
     * @return The ride request.
     */
    public RideRequest getRideRequest() {
        return rideRequest;
    }

    @Override
    public String toString() {
        return "RideRequestedEvent{" +
            "rideRequest=" + rideRequest +
            ", timeStamp=" + timeStamp +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RideRequestedEvent that)) {
            return false;
        }
        return Objects.equals(rideRequest, that.rideRequest) && Objects.equals(
            timeStamp, that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideRequest, timeStamp);
    }
}
