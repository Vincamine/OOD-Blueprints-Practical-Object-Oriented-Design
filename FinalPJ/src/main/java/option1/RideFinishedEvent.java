package option1;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Represents an event signaling the completion of a ride in a transportation system.
 * This class holds information about the ride that has finished and the timestamp when it concluded.
 */
public class RideFinishedEvent implements Event{
    private Ride ride;
    private Timestamp timeStamp;
    /**
     * Constructs a RideFinishedEvent with the specified ride and timestamp.
     *
     * @param ride The ride that has finished.
     * @param timeStamp The timestamp when the ride finished.
     */
    public RideFinishedEvent(Ride ride, Timestamp timeStamp) {
        this.ride = ride;
        this.timeStamp = timeStamp;
    }

    /**
     * Returns the ride associated with this event.
     *
     * @return The finished ride.
     */
    public Ride getRide() {
        return ride;
    }
    /**
     * Returns the timestamp when the ride finished.
     *
     * @return The timestamp of this event.
     */
    @Override
    public Timestamp getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String toString() {
        return "RideFinishedEvent{" +
            "ride=" + ride +
            ", timeStamp=" + timeStamp +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RideFinishedEvent that)) {
            return false;
        }
        return Objects.equals(ride, that.ride) && Objects.equals(timeStamp,
            that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ride, timeStamp);
    }
}
