package problem2;

import java.util.Objects;

public abstract class Creator {

    protected String firstName;
    protected String lastName;

    public Creator(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Creator creator)) {
            return false;
        }
        return Objects.equals(firstName, creator.firstName) && Objects.equals(
            lastName, creator.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Creator{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}