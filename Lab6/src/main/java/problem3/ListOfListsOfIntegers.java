package problem3;

import problem1.ListOfIntegers;

public interface ListOfListsOfIntegers {

    /**
     * Returns the number of list of integers inside the outer list
     * @return
     */
    Integer size();

    /**
     * Returns the number of total integers inside this list/
     */
    Integer length();

    /**
     * Returns the sum of all integers inside this list
     * @return
     */
    Integer sum();

    Boolean isEmpty();


    ListOfListsOfIntegers add(ListOfIntegers list);

    /**
     * Takes an integer and removes the first occurrence of this integer in the list
     * @return
     */
    ListOfListsOfIntegers removeInteger(Integer element);

    /**
     * Takes an integer and removes the all occurrence of this integer in the list.
     * @param element
     * @return
     */
    ListOfListsOfIntegers removeAllIntegers(Integer element);

}