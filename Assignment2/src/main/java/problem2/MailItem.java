package problem2;

/**
 * Class MailItem stores information about mail item - width, height, depth and recipient
 */
public class MailItem {
    private final Integer width;
    private final Integer height;
    private final Integer depth;
    private final Recipient recipient;

    /**
     * Constructor for the class MailItem
     *
     * @param width     - width in inches, an integer greater than or equal to 1.5
     * @param height    - height in inches, an integer greater than or equal to 2
     * @param depth     - depth in inches, an integer greater than or equal to 1
     * @param recipient - recipient, encoded as data type Recipient
     * @throws DimensionNumericException On non-positive number of dimension
     */
    public MailItem(Integer width, Integer height, Integer depth, Recipient recipient) throws DimensionNumericException{
        if (width < 1.5){
            throw new DimensionNumericException("The width should be greater than or equal to 1.5");
        } else {
            this.width = width;
        }

        if (height < 2.0){
            throw new DimensionNumericException("The height should be greater than or equal to 2");
        } else {
            this.height = height;
        }

        if (depth < 1.0){
            throw new DimensionNumericException("The depth should be greater than or equal to 1");
        } else {
            this.depth = depth;
        }

        this.recipient = recipient;
    }

    /**
     * Getter for width
     *
     * @return - width in inches, an integer greater than or equal to 1.5
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Getter for height
     *
     * @return - height in inches, an integer greater than or equal to 2
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Getter for depth
     *
     * @return - depth in inches, an integer greater than or equal to 1
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     * Getter for recipient
     *
     * @return - recipient, encoded as data type Recipient
     */
    public Recipient getRecipient() {
        return recipient;
    }
}
