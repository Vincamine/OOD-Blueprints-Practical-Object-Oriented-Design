public class Email {
    private  String user;
    private  String domain;

    public Email(String user, String domain) {
        this.user = user;
        this.domain = domain;
    }

    public String getUser() {
        return user;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return "Email{" +
                "user='" + user + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
