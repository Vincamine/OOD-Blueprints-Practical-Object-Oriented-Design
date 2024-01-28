package problem2;

import java.util.Objects;
public class Recipient {
    /**
     * Class Recipient stores information about recipient - first name, last name and email address
     */
    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    /**
     * Constructor for the class Recipient
     *
     * @param firstName    - first name, encoded as String
     * @param lastName     - last name, encoded as String
     * @param emailAddress - email address, encoded as String
     */
    public Recipient(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    /**
     * Getter for first name
     *
     * @return - first name, encoded as String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for last name
     *
     * @return - last name, encoded as String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for email address
     *
     * @return - email address, encoded as String
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipient recipient = (Recipient) o;
        return Objects.equals(firstName, recipient.firstName) && Objects.equals(
            lastName, recipient.lastName) && Objects.equals(emailAddress,
            recipient.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, emailAddress);
    }
}
