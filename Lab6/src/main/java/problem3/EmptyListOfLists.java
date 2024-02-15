package problem3;

import problem1.ListOfIntegers;

public class EmptyListOfLists implements ListOfListsOfIntegers{

    @Override
    public Integer size() {
        return 0;
    }

    @Override
    public Integer length() {
        return 0;
    }

    @Override
    public Integer sum() {
        return 0;
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.TRUE;
    }

    @Override
    public ListOfListsOfIntegers add(ListOfIntegers list) {
        return new NonEmptyListOfLists(list, this);
    }

    @Override
    public ListOfListsOfIntegers removeInteger(Integer element) {
        return this;
    }

    @Override
    public ListOfListsOfIntegers removeAllIntegers(Integer element) {
        return this;
    }
}