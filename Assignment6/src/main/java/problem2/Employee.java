package problem2;

import java.util.Objects;

public class Employee {
    String firstName;
    String lastName;
    Float annualEarning;
    String currentRole;
    Integer yearOfJoin;
    public Employee(String firstName, String lastName, Float annualEarning, String currentRole,
        Integer yearOfJoin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualEarning = annualEarning;
        this.currentRole = currentRole;
        this.yearOfJoin = yearOfJoin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Float getAnnualEarning() {
        return annualEarning;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public Integer getYearOfJoin() {
        return yearOfJoin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee employee)) {
            return false;
        }
        return Objects.equals(firstName, employee.firstName) && Objects.equals(
            lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", annualEarning=" + annualEarning +
            ", currentRole='" + currentRole + '\'' +
            ", yearOfJoin=" + yearOfJoin +
            '}';
    }
}
