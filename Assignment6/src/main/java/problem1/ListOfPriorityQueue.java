package problem1;

public interface ListOfPriorityQueue {
    PriorityQueue createEmpty();

    Boolean isEmpty();

    PriorityQueue add(Integer priority, String value);

    String peek();

    PriorityQueue pop();

}
