package problem2;

public class InvalidPolynomialPowerException extends Exception {

    public InvalidPolynomialPowerException(){
        super("Polynomial Power should be positive!");
    }
}
