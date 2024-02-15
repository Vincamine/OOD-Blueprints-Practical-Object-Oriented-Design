package problem1;

public interface ListOfIntegers {

    Boolean contains(Integer element);
    Integer elementAt(Integer index);
    Integer count();

    //Included for the sake of Problem 3
    Integer sumElements();
    ListOfIntegers remove(Integer element);

}