package M3L1;

public class Book {
    private String title;
    private Person author;
    private float price;
    private TypeOfBook bookType;

    /**
     * Construct a Book object that has the provided title, author and  price
     *
     * @param title  the title to be given to this book
     * @param author the author to be given to this book
     * @param bookType the type of this book
     * @param price  the price to be assigned to this book
     */
    public Book(String title, Person author, float price, TypeOfBook bookType) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.bookType = bookType;
    }

    public TypeOfBook getBookType() {
        return this.bookType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setBookType(TypeOfBook bookType) {
        this.bookType = bookType;
    }

    /**
     * Return a formatted string that contains the information
     * of this object. The string should be in the following format:
     * Title: [title of the book]
     * Author: [first-name last-name]
     * Price: [Price as a decimal number with two numbers after decimal]
     *
     * @return the formatted string as above
     */

    @Override
    public String toString() {
        String str;
        str = "Title: " + this.title + "\n" +
            "Author: " + this.author + "\n" +
            "Type: ";
        str = switch (bookType) {
            case PAPERBACK -> str + "Paperback";
            case HARDCOVER -> str + "Hardcover";
            case KINDLE -> str + "Kindle";
        };
        str = str + String.format("Price: %.2f", price);
        return str;
    }

    /**
     * Compute and return the price of this book with the given discount (as a
     * percentage)
     *
     * @param discount the percentage discount to be applied
     * @return the discounted price of this book
     * @throws IllegalArgumentException if a negative discount is passed as an
     *                                  argument
     */
    public float salePrice(float discount) throws IllegalArgumentException{
        if (discount < 0){
            throw new IllegalArgumentException("Discount cannot be negative.");
        }
        return this.price - (this.price * discount) / 100;
    }

    /**
     * check if this book has the same author as another and return true if so,
     * false otherwise
     *
     * @param other the other book
     * @return true if the two books have the same author, false otherwise
     */
    public boolean sameAuthor(Book other){
        return this.author.same(other.author);
    }

    public Book discountBook(float discount){
        float discountedPrice = this.salePrice(discount);
        return  new Book(this.title,this.author,discountedPrice,this.bookType);
    }
}
