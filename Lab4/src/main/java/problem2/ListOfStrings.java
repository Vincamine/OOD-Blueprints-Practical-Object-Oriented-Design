package problem2;

public interface ListOfStrings {
    Boolean isEmpty();
    Integer size();
    Boolean contains(String element);
    Boolean containsAll(ListOfStrings sub);
    ListOfStrings filterLargerThan(Integer );
    Boolean hasDuplicates();
    ListOfStrings removedDuplicates();

}
