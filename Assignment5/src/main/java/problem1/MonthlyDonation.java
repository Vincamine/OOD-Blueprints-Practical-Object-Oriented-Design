package problem1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents a monthly donation to a non-profit organization, extending the Donation class.
 * This class includes functionalities specific to monthly donations, such as managing cancellation times.
 */
public class MonthlyDonation extends Donation{
    private final int monthsOfYear = 12;
    private final int oneToCount = 1;

    /**
     * The time at which the monthly donation is canceled. If null, the donation is considered ongoing.
     */
    private LocalDateTime cancelTime;

    /**
     * Constructs a new MonthlyDonation instance with specified creation time and donation amount.
     * The cancel time is initially set to null, indicating an ongoing donation.
     *
     * @param createdTime the time at which the donation was created.
     * @param amountOfMoney the amount of money donated monthly.
     */
    public MonthlyDonation(LocalDateTime createdTime, float amountOfMoney) {
        super(createdTime, amountOfMoney);
        this.cancelTime = null;
    }

    /**
     * Sets the cancellation time of the monthly donation.
     * Throws IllegalArgumentException if the cancellation time is before the creation time of the donation.
     *
     * @param cancelTime the time at which the donation is canceled.
     * @throws IllegalArgumentException if cancelTime is before the donation's createdTime.
     */
    public void setCancelTime(LocalDateTime cancelTime) throws IllegalArgumentException{
        if(cancelTime.isBefore(createdTime)){
            throw new IllegalArgumentException("The cancel time shouldn't before created time!");
        }
        this.cancelTime = cancelTime;
    }

    /**Way1: naive
     * Calculates the total donation amount for a specified year, taking into account the creation and cancellation times.
     *
     * @param year the year for which the total donation amount is to be calculated.
     * @return the total donation amount for the specified year.
     */
    @Override
    public float getYearlyDonation(int year) {
        if(cancelTime != null){
            int createdDay = this.createdTime.getDayOfMonth();
            int cancelDay = this.cancelTime.getDayOfMonth();
            LocalTime createdTimeToMinute = this.createdTime.toLocalTime();
            LocalTime cancelTimeToMinute = this.cancelTime.toLocalTime();
            if((this.cancelTime.getYear() - this.createdTime.getYear()) == 0){
                if(year == this.cancelTime.getYear()){
                    if(createdDay == cancelDay){
                        // compare the minute
                        if(!createdTimeToMinute.isBefore(cancelTimeToMinute)){
                            return amountOfMoney * (this.cancelTime.getMonthValue()
                                - this.createdTime.getMonthValue() - oneToCount);
                        }
                        return amountOfMoney * (this.cancelTime.getMonthValue()
                            - this.createdTime.getMonthValue());
                    } else if (createdDay < cancelDay) {
                        return amountOfMoney * (this.cancelTime.getMonthValue()
                            - this.createdTime.getMonthValue());
                    } else{
                        return amountOfMoney * (this.cancelTime.getMonthValue()
                            - this.createdTime.getMonthValue() - oneToCount);
                    }
                }
                //not the year I want
                return 0;
            //cancel year and create year are not the same.
            } else if ((this.cancelTime.getYear() - this.createdTime.getYear()) >= oneToCount) {
                if(year == this.createdTime.getYear()){
                    return amountOfMoney * (monthsOfYear + oneToCount - this.createdTime.getMonthValue());
                } else if (year == this.cancelTime.getYear()) {
                    if(createdDay == cancelDay){
                        // compare the minute
                        if(!createdTimeToMinute.isBefore(cancelTimeToMinute)){
                            return amountOfMoney * (this.cancelTime.getMonthValue() - oneToCount);
                        }
                        return amountOfMoney * (this.cancelTime.getMonthValue());
                    } else if (createdDay < cancelDay) {
                        return amountOfMoney * (this.cancelTime.getMonthValue());
                    } else{
                        return amountOfMoney * (this.cancelTime.getMonthValue() - oneToCount);
                    }

                } else {
                    return amountOfMoney * monthsOfYear;
                    //return amountOfMoney * 12 * (this.cancelTime.getYear() - this.createdTime.getYear() - 1);
                }
            }
        }
        // not cancel
        else {
            if(year == this.createdTime.getYear()){
                return amountOfMoney * (monthsOfYear + oneToCount - this.createdTime.getMonthValue());
            } else if (year > this.createdTime.getYear()) {
                return amountOfMoney * monthsOfYear;
            }
        }
        return 0;
    }

    /*
     * Way2: minus and get bigger or smaller

    public float getYearlyDonationWay2(int year){
        LocalDate dateLeftBound = LocalDate.of(year, 1, 1);
        LocalTime timeLeftBound = LocalTime.of(0, 0, 0);
        LocalDate dateRightBound = LocalDate.of(year, 12, 30);
        LocalTime timeRightBound = LocalTime.of(23, 59, 59);
        LocalDateTime dateTimeLeftBound = LocalDateTime.of(dateLeftBound, timeLeftBound);
        LocalDateTime dateTimeRightBound = LocalDateTime.of(dateRightBound,timeRightBound);

        if(this.createdTime.isAfter(dateTimeLeftBound) && this.cancelTime.isBefore(dateTimeRightBound)){
        }
        if(this.cancelTime.getYear() < rightYearBound){

        }
    }
     */

    /**
     * Indicates whether some other object is "equal to" this one.
     * Compares this MonthlyDonation to the specified object. The result is true if and only if the argument
     * is not null and is a MonthlyDonation object that has the same cancelTime value as this object.
     *
     * @param o the object to compare this MonthlyDonation against.
     * @return true if the given object represents a MonthlyDonation equivalent to this donation, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonthlyDonation that)) {
            return false;
        }
        return Objects.equals(cancelTime, that.cancelTime);
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(cancelTime);
    }

    /**
     * Returns a string representation of the MonthlyDonation object.
     * The string includes the cancel time, creation time, and the amount of money donated.
     *
     * @return a string representation of the MonthlyDonation object.
     */
    @Override
    public String toString() {
        return "MonthlyDonation{" +
            "cancelTime=" + cancelTime +
            ", createdTime=" + createdTime +
            ", amountOfMoney=" + amountOfMoney +
            '}';
    }
}
