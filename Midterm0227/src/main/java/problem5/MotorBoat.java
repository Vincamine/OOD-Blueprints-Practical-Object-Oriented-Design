package problem5;

import java.util.Objects;

public class MotorBoat extends CharterBoat{
    /**
     * Engine power, boat’s engine power, represented as a Double.
     * */
    protected Double enginePower;
    protected Double LIMIT_LENGTH = 45.0;
    private Double ADD_FOR_MOTOR = 1.35;

    public MotorBoat(String boatId, Double boatLength, Double pricePerDay,
        Integer manufacturingYear,
        Integer numberOfCabins, Boolean skipperNeeded) {
        super(boatId, boatLength, pricePerDay, manufacturingYear, numberOfCabins, skipperNeeded);
    }

    public Double getEnginePower() {
        return enginePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MotorBoat motorBoat)) {
            return false;
        }
        return Objects.equals(enginePower, motorBoat.enginePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enginePower);
    }

    @Override
    public String toString() {
        return "MotorBoat{" +
            "enginePower=" + enginePower +
            ", boatId='" + boatId + '\'' +
            ", boatLength=" + boatLength +
            ", pricePerDay=" + pricePerDay +
            ", manufacturingYear=" + manufacturingYear +
            ", numberOfCabins=" + numberOfCabins +
            ", skipperNeeded=" + skipperNeeded +
            '}';
    }

    /**
     * @return Double
     */
    @Override
    protected Double estimateAnnualBoatRevenue() {
        if(this.boatLength > LIMIT_LENGTH) {return (super.estimateAnnualBoatRevenue() * ADD_FOR_MOTOR);}
        return super.estimateAnnualBoatRevenue();
    }
}
