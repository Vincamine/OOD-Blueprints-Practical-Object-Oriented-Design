package problem1;

import java.util.Objects;

public class NewCar extends Car{
    private Integer numVehiclesAvailable;
    // Constructor includes fields from superclass;

    //getter
    public Integer getNumVehiclesAvailable() {
        return numVehiclesAvailable;
    }

    //equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NewCar newCar)) {
            return false;
        }
        NewCar newCar = (NewCar) o;
        return Objects.equals(this.id, newCar.id) && Objects.equals(this.manufacturingYear, newCar.manufacturingYear)
            && Objects.equals(this.makeModel, newCar.makeModel) && Objects.equals(this.msrp, newCar.msrp)
            && Objects.equals(this.bodyType, newCar.bodyType) && Objects.equals(numVehiclesAvailable, newCar.numVehiclesAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.manufacturingYear,
            this.makeModel, this.msrp, this.bodyType, this.numVehiclesAvailable);
    }
}
