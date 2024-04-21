package problem2;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehicleFilter {

    private static final Integer CUTOFF_YEAR = 1999;
    private List<Vehicle> vehicles = new ArrayList<>();
    public OlderVehicleFilter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public OlderVehicleFilter(Vehicle vehicle1, Vehicle
        vehicle2, Vehicle vehicle3){
        this.vehicles.add(vehicle1);
        this.vehicles.add(vehicle2);
        this.vehicles.add(vehicle2);
    }
//    public List<String> filterVWvehilces(){
//    //YOUR CODE HERE
//        return null;
//    }
    public void filterOlderVehilces(){

        List<Vehicle> resultingVehicles = vehicles.stream().filter(x -> x.getYear() >= CUTOFF_YEAR).toList();
        resultingVehicles.stream().map(x->x.getMake() + " " + x.getModel() + " "+ x.getYear()).forEach(System.out::println);
    }

    private static String  makeToMakeModelYear(Vehicle vehicle){
        return new String(vehicle.getMake() + " " + vehicle.getModel() + " "+ vehicle.getYear());
    }

    private static void printVehicleInfo(Vehicle vehicle){
        System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " "+ vehicle.getYear());
    }
}
