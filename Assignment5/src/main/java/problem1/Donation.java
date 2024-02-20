/**
 * Represents an abstract concept of a donation. This class serves as a foundation for specific types of donations,
 * capturing common attributes such as the creation time of the donation and the amount of money donated. It provides
 * a constructor for initializing these common attributes and defines an abstract method for calculating the yearly
 * donation amount, which must be implemented by subclasses.
 */
package problem1;

import java.time.LocalDateTime;

public abstract class Donation {

    /**
     * The time when the donation was created.
     */
    protected LocalDateTime createdTime;

    /**
     * The amount of money donated.
     */
    protected float amountOfMoney;

    /**
     * Constructs a new Donation with the specified creation time and donation amount.
     *
     * @param createdTime The time when the donation was created.
     * @param amountOfMoney The amount of money that was donated.
     */
    public Donation(LocalDateTime createdTime, float amountOfMoney) {
        this.createdTime = createdTime;
        this.amountOfMoney = amountOfMoney;
    }

    /**
     * Calculates and returns the total donation amount for a specified year. This method is abstract and must be
     * implemented by subclasses to define the specific calculation logic for yearly donations.
     *
     * @param year The year for which the total donation amount is to be calculated.
     * @return The total donation amount for the specified year.
     */
    public abstract float getYearlyDonation(int year);

}
