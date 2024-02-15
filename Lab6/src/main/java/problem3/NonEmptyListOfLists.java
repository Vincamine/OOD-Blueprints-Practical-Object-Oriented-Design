package problem3;

import problem1.ListOfIntegers;

public class NonEmptyListOfLists implements ListOfListsOfIntegers {

    private ListOfIntegers headList;
    private ListOfListsOfIntegers restOfTheListOfLists;

    public NonEmptyListOfLists(ListOfIntegers headList, ListOfListsOfIntegers restOfTheListOfLists) {
        this.headList = headList;
        this.restOfTheListOfLists = restOfTheListOfLists;
    }

    public NonEmptyListOfLists(ListOfIntegers headList) {
        this.headList = headList;
        this.restOfTheListOfLists = new EmptyListOfLists();
    }

    public ListOfIntegers getHeadList() {
        return headList;
    }

    public ListOfListsOfIntegers getRestOfTheListOfLists() {
        return restOfTheListOfLists;
    }


    @Override
    public Integer size() {
        return 1 + this.restOfTheListOfLists.size();
    }

    @Override
    public Integer length() {
        return this.headList.count() + this.restOfTheListOfLists.length();
    }

    @Override
    public Integer sum() {
        return this.headList.sumElements() + this.restOfTheListOfLists.sum();
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.FALSE;
    }

    @Override
    public ListOfListsOfIntegers add(ListOfIntegers list) {
        return new NonEmptyListOfLists(list, this);
    }

    @Override
    public ListOfListsOfIntegers removeInteger(Integer element) {
        if(this.headList.contains(element))
            return new NonEmptyListOfLists(this.headList.remove(element), this.getRestOfTheListOfLists());
        else return new NonEmptyListOfLists(this.headList, this.getRestOfTheListOfLists().removeInteger(element));
    }

    @Override
    public ListOfListsOfIntegers removeAllIntegers(Integer element) {
        if(this.headList.contains(element))
            return new NonEmptyListOfLists(this.headList.remove(element), this.getRestOfTheListOfLists().removeAllIntegers(element));
        else return new NonEmptyListOfLists(this.headList, this.getRestOfTheListOfLists().removeInteger(element));
    }
}