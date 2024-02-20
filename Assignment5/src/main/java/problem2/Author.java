package problem2;

public class Author extends Creator {
    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * @return
     */
    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    /**
     * @return
     */
    @Override
    public String getLastName() {
        return super.getLastName();
    }
}
