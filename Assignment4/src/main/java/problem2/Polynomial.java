package problem2;

public interface Polynomial {

    /**
     * A method getDegree, that returns the degree of a polynomial.
     */
    Integer getDegree();

    /**
     * A method getCoefficient, that takes a power, and returns the coefficient for the term with that power.
     */
    Integer getCoefficient(Integer requestPower);

    /**
     * A method addTerm, that takes a coefficient and a power (both integer numbers), and adds the given term to an existing polynomial.
     */
    Polynomial addTerm(Integer requestPower, Integer requestCoef) throws InvalidPolynomialPowerException;

    /**
     * A method removeTerm, that takes a power, and removes a term in the polynomial with that power.
     */
    Polynomial removeTerm(Integer requestPower);

    /**
     * A method isSame, that takes another Polynomial object and returns True if they are the same,
     * False otherwise.
     */
    Boolean isSame(LinkedListOfPolynomial anotherPolynomial);

    /**
     * A method add, that takes another Polynomial object, and returns the resulting polynomial, obtained by adding the two polynomials.
     */
    Polynomial add(LinkedListOfPolynomial anotherPolynomial) throws InvalidPolynomialPowerException;

    Polynomial setDegree(Integer requestDegree);










}
