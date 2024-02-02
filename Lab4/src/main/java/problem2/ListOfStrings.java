package problem2;

public interface ListOfStrings {
    Boolean isEmpty();
    Integer size();
    Boolean contains(String element);
    Boolean containsAll(String[] allElements);
    ListOfStrings filterLargerThan(Integer largerThanBound);
    Boolean hasDuplicates();
    ListOfStrings removedDuplicates();
}
