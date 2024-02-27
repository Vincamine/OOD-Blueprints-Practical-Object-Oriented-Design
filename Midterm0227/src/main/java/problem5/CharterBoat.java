package problem5;

import java.util.Objects;

public class CharterBoat {
    Integer BASIC = 65;

    /**
     * Boat ID, a unique charter boat’s identifier, represented as a String.
     */
    protected String boatId;
    /**
     * Boat length, length of the boat, represented as Double.
     */
     protected Double boatLength;

    /**
     * Price per day, daily price of renting (chartering) this boat, represented as Double.
     */
    protected Double pricePerDay;

    /**
     * Manufacturing year, manufacturing year of the boat, represented as an Integer.
     */
    protected Integer manufacturingYear;

    /**
     * Number of cabins, number of cabins on the boat, represented as an Integer.
     */
    protected Integer numberOfCabins;

    /**
     * Skipper needed, a Boolean flag indicating if the boat needs to be chartered with a skipper.
     */
    protected Boolean skipperNeeded;

    public CharterBoat(String boatId, Double boatLength, Double pricePerDay,
        Integer manufacturingYear,
        Integer numberOfCabins, Boolean skipperNeeded) {
        this.boatId = boatId;
        this.boatLength = boatLength;
        this.pricePerDay = pricePerDay;
        this.manufacturingYear = manufacturingYear;
        this.numberOfCabins = numberOfCabins;
        this.skipperNeeded = skipperNeeded;
    }

    public String getBoatId() {
        return boatId;
    }

    public Double getBoatLength() {
        return boatLength;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Integer getManufacturingYear() {
        return manufacturingYear;
    }

    public Integer getNumberOfCabins() {
        return numberOfCabins;
    }

    public Boolean getSkipperNeeded() {
        return skipperNeeded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharterBoat that)) {
            return false;
        }
        return Objects.equals(boatId, that.boatId) && Objects.equals(boatLength,
            that.boatLength) && Objects.equals(pricePerDay, that.pricePerDay)
            && Objects.equals(manufacturingYear, that.manufacturingYear)
            && Objects.equals(numberOfCabins, that.numberOfCabins)
            && Objects.equals(skipperNeeded, that.skipperNeeded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boatId, boatLength, pricePerDay, manufacturingYear, numberOfCabins,
            skipperNeeded);
    }

    @Override
    public String toString() {
        return "CharterBoat{" +
            "boatId='" + boatId + '\'' +
            ", boatLength=" + boatLength +
            ", pricePerDay=" + pricePerDay +
            ", manufacturingYear=" + manufacturingYear +
            ", numberOfCabins=" + numberOfCabins +
            ", skipperNeeded=" + skipperNeeded +
            '}';
    }

    /**
     * Basic annual estimation:
     * Basic estimate is that every charter boat will be rented (chartered)
     * for at least 65 days yearly, producing a basic annual estimate equal to 65*price per day.
     * */
    protected Double estimateAnnualBoatRevenue(){
        return BASIC * this.pricePerDay;
    }

}
