public class Author {
    private Name name;
    private Email email;
    private String address;

    public Author(Name name, Email email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name=" + name +
                ", email=" + email +
                ", address='" + address + '\'' +
                '}';
    }
}


