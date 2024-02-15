package problem1;

public class EmptyNode implements ListOfIntegers {


    @Override
    public Boolean contains(Integer element) {
        return Boolean.FALSE;
    }

    @Override
    public Integer elementAt(Integer index) throws IllegalArgumentException{
        //return null;
        //throw new IndexOutOfBoundsException("An element with this index does not exist in the list!");
        throw new IllegalArgumentException("An element with this index does not exist in the list!");
    }

    @Override
    public Integer count() {
        return 0;
    }

    @Override
    public Integer sumElements() {
        return 0;
    }

    @Override
    public ListOfIntegers remove(Integer element) {
        return this;
    }


}