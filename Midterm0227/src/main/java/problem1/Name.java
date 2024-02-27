package problem1;

import java.util.Objects;

/**
 * Class Name represents information about a person's name - their first, middle and last name.
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructor for class Name
   * @param firstName first name, represented as a String
   * @param middleName middle name, represented as a String
   * @param lastName last name, represented as a String
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * Getter for field first name.
   * @return first name, represented as a String.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for field middle name.
   * @return middle name, represented as a String.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Getter for field last name.
   * @return last name, represented as a String.
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(middleName,
        name.middleName) && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleName, lastName);
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
