package problem2;

import java.util.Objects;

public class Vehicle {

    private String make;
    private String model;
    private Integer year;
    private Color vehicleColor;

    public Vehicle(String make, String model, Integer year, Color
        vehicleColor) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vehicleColor = vehicleColor;
    }

    /*
     * Getter for the property ’make’
     * @returns value for property ’make’ (String)
     */
    public String getMake() {
        return make;
    }

    public Integer getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public Color getVehicleColor() {
        return vehicleColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vehicle))
            return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getMake(), vehicle.getMake());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            ", vehicleColor=" + vehicleColor +
            '}';
    }
}
