package problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a non-profit organization with the capability to track and manage donations.
 * This class allows for the storage of an organization's name and a collection of donations made to it.
 */
public class NonProfit {
    /**
     * The name of the non-profit organization.
     */
    protected String organizationName;
    /**
     * Collection of donations made to the non-profit organization.
     */
    protected ArrayList<Donation> donationsCollection;

    /**
     * Constructs a new NonProfit instance with the specified organization name.
     * Initializes the donations collection as an empty ArrayList of Donation objects.
     *
     * @param organizationName the name of the non-profit organization.
     */
    public NonProfit(String organizationName) {
        this.organizationName = organizationName;
        this.donationsCollection = new ArrayList<Donation>();
    }

    /**
     * Calculates the total amount of donations received for a specified year.
     *
     * @param year the year for which the total donation amount is calculated.
     * @return the total donation amount received in the specified year.
     */
    public float getTotalDonationForYear(int year) {
        float totalDonationForYear = 0;
        for (Donation item : donationsCollection) {
            totalDonationForYear += item.getYearlyDonation(year);
        }
        return totalDonationForYear;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * The equals method implements an equivalence relation on non-null object references.
     *
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NonProfit nonProfit)) {
            return false;
        }
        return Objects.equals(organizationName, nonProfit.organizationName)
            && Objects.equals(donationsCollection, nonProfit.donationsCollection);
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(organizationName, donationsCollection);
    }

    /**
     * Returns a string representation of the object.
     * In general, the toString method returns a string that "textually represents" this object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "NonProfit{" +
            "organizationName='" + organizationName + '\'' +
            ", donationsCollection=" + donationsCollection +
            '}';
    }
}
