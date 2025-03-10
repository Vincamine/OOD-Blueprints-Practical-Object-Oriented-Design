package problem1;

/**
 * Represents details of a lunch event, including the number of sandwiches to be served.
 *
 * @author Wyllie
 */
public class LunchEvent extends Event {
    private int numberOfSandwiches;
    private double numberOfTimesSandwichesToProvide = 1.05;

    /**
     * Creates a lunch event.
     *
     * @param clientName the name of the client.
     * @param numberOfPeople the number of attendees.
     */
    public LunchEvent(String clientName, int numberOfPeople){
        super(clientName, numberOfPeople);
        this.numberOfSandwiches = (int) Math.round(numberOfTimesSandwichesToProvide * super.getNumberOfPeople());
    }

    /**
     * @return the number of sandwiches to be served.
     */
    public int getNumberOfSandwiches() {
        return numberOfSandwiches;
    }
}