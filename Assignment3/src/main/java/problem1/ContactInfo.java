package problem1;

public class ContactInfo {
    protected Name name;
    protected String address;
    protected String phoneNumber;
    protected String emailAddress;
    protected Name emergencyContact;

    public ContactInfo(Name name, String address, String phoneNumber, String emailAddress,
        Name emergencyContact) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.emergencyContact = emergencyContact;
    }
}
