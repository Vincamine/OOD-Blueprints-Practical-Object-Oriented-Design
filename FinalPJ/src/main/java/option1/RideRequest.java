package option1;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Represents a request for a ride within a transportation system, detailing the starting location,
 * ending location, distance expected to be traveled, time requested, and the type of ride.
 */
public class RideRequest {
    public String id;
    public String StartLoc;
    public String EndLoc;
    public Double anticipatedDistance;
    public Timestamp requestedTime;
    public RideType rideType;

    /**
     * Constructs a new RideRequest with specified details about the ride.
     *
     * @param id The unique identifier for this request.
     * @param startLoc The starting location of the ride.
     * @param endLoc The ending location of the ride.
     * @param anticipatedDistance The anticipated distance of the ride in miles.
     * @param requestedTime The time at which the ride is requested.
     * @param rideType The type of ride requested.
     */
    public RideRequest(String id, String startLoc, String endLoc, double anticipatedDistance,
        Timestamp requestedTime, RideType rideType) {
        this.id = id;
        StartLoc = startLoc;
        EndLoc = endLoc;
        this.anticipatedDistance = anticipatedDistance;
        this.requestedTime = requestedTime;
        this.rideType = rideType;
    }

    /**
     * Returns the unique identifier for this ride request.
     *
     * @return the ride request ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the starting location of the ride.
     *
     * @return the start location.
     */
    public String getStartLoc() {
        return StartLoc;
    }

    /**
     * Returns the ending location of the ride.
     *
     * @return the end location.
     */
    public String getEndLoc() {
        return EndLoc;
    }

    public Double getAnticipatedDistance() {
        return anticipatedDistance;
    }

    public Timestamp getRequestedTime() {
        return requestedTime;
    }

    public RideType getRideType() {
        return rideType;
    }

    @Override
    public String toString() {
        return "RideRequest{" +
            "id='" + id + '\'' +
            ", StartLoc='" + StartLoc + '\'' +
            ", EndLoc='" + EndLoc + '\'' +
            ", anticipatedDistance=" + anticipatedDistance +
            ", requestedTime=" + requestedTime +
            ", rideType=" + rideType +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RideRequest that)) {
            return false;
        }
        return Objects.equals(id, that.id) && Objects.equals(StartLoc,
            that.StartLoc) && Objects.equals(EndLoc, that.EndLoc) && Objects.equals(
            anticipatedDistance, that.anticipatedDistance) && Objects.equals(requestedTime,
            that.requestedTime) && rideType == that.rideType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, StartLoc, EndLoc, anticipatedDistance, requestedTime, rideType);
    }
}
