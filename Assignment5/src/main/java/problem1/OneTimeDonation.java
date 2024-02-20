package problem1;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Represents a one-time donation to a non-profit organization, extending the Donation class.
 * This class encapsulates the functionality specific to a single, non-recurring donation.
 */
public class OneTimeDonation extends Donation{
    /**
     * Constructs a new OneTimeDonation instance with a specified creation time and donation amount.
     *
     * @param createdTime the time at which the donation was made.
     * @param amountOfMoney the amount of money donated.
     */
    public OneTimeDonation(LocalDateTime createdTime, float amountOfMoney) {
        super(createdTime, amountOfMoney);
    }

    /**
     * Calculates the total donation amount for a specified year.
     * This method returns the donation amount if the donation was made within the specified year;
     * otherwise, it returns zero.
     *
     * @param year the year for which the total donation amount is to be calculated.
     * @return the total donation amount for the specified year, or zero if the donation was not made in the specified year.
     */
    @Override
    public float getYearlyDonation(int year) {
        if(this.createdTime.getYear() == year){
            return this.amountOfMoney;
        }
        return 0;
    }

    /**
     * Returns a string representation of the OneTimeDonation object.
     * In this implementation, the method returns a basic representation indicating that it's an instance of OneTimeDonation.
     *
     * @return a string representation of the OneTimeDonation object.
     */

    @Override
    public String toString() {
        return "OneTimeDonation{}";
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of hash
     * tables such as those provided by {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     *     an execution of a Java application, the {@code hashCode} method
     *     must consistently return the same integer, provided no information
     *     used in {@code equals} comparisons on the object is modified.
     *     This integer need not remain consistent from one execution of an
     *     application to another execution of the same application.
     * <li>If two objects are equal according to the {@link
     *     #equals(Object) equals} method, then calling the {@code
     *     hashCode} method on each of the two objects must produce the
     *     same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     *     according to the {@link #equals(Object) equals} method, then
     *     calling the {@code hashCode} method on each of the two objects
     *     must produce distinct integer results.  However, the programmer
     *     should be aware that producing distinct integer results for
     *     unequal objects may improve the performance of hash tables.
     * </ul>
     *
     * @return a hash code value for this object.
     * @implSpec As far as is reasonably practical, the {@code hashCode} method defined by class
     * {@code Object} returns distinct integers for distinct objects.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     *
     * <p>
     * An equivalence relation partitions the elements it operates on
     * into <i>equivalence classes</i>; all the members of an
     * equivalence class are equal to each other. Members of an
     * equivalence class are substitutable for each other, at least
     * for some purposes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     * @implSpec The {@code equals} method for class {@code Object} implements the most
     * discriminating possible equivalence relation on objects; that is, for any non-null reference
     * values {@code x} and {@code y}, this method returns {@code true} if and only if {@code x} and
     * {@code y} refer to the same object ({@code x == y} has the value {@code true}).
     * <p>
     * In other words, under the reference equality equivalence relation, each equivalence class
     * only has a single element.
     * @apiNote It is generally necessary to override the {@link #hashCode() hashCode} method
     * whenever this method is overridden, so as to maintain the general contract for the
     * {@code hashCode} method, which states that equal objects must have equal hash codes.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

