package problem5;

public class SailBoat extends CharterBoat{
    protected Double ADD_FOR_SAIL = 1.45;
    public SailBoat(String boatId, Double boatLength, Double pricePerDay, Integer manufacturingYear,
        Integer numberOfCabins, Boolean skipperNeeded) {
        super(boatId, boatLength, pricePerDay, manufacturingYear, numberOfCabins, skipperNeeded);
    }

    @Override
    public String toString() {
        return "SailBoat{" +
            "BASIC=" + BASIC +
            ", boatId='" + boatId + '\'' +
            ", boatLength=" + boatLength +
            ", pricePerDay=" + pricePerDay +
            ", manufacturingYear=" + manufacturingYear +
            ", numberOfCabins=" + numberOfCabins +
            ", skipperNeeded=" + skipperNeeded +
            '}';
    }

    /**
     * @return
     */
    @Override
    protected Double estimateAnnualBoatRevenue() {
        if(this.skipperNeeded){
            return super.estimateAnnualBoatRevenue() * ADD_FOR_SAIL;
        }
        return super.estimateAnnualBoatRevenue();
    }
}
