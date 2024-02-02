package problem2;
/**
 *  Using an array-based list
 * */
public class StrListWithoutLinkedList implements ListOfStrings{
    private Integer listSize;
    private String[] container;
    private static final Integer INITIAL_CAPACITY = 10;

    public StrListWithoutLinkedList(Integer listSize, String[] container) {
        this.listSize = listSize;
        this.container = container;
    }
    public StrListWithoutLinkedList(){
        this.listSize = 0;
        this.container = new String[INITIAL_CAPACITY];
    }

    @Override
    public Boolean isEmpty() {
        return this.listSize == 0;
    }

    @Override
    public Integer size() {
        return this.listSize;
    }

    @Override
    public Boolean contains(String element) {
        for(int i = 0; i < this.listSize; i++){
            if(this.container[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean containsAll(String[] allElements) {
        int count = 0;
        for(int )
        return null;
    }

    @Override
    public ListOfStrings filterLargerThan(Integer largerThanBound) {
        return null;
    }

    @Override
    public Boolean hasDuplicates() {
        return null;
    }

    @Override
    public ListOfStrings removedDuplicates() {
        return null;
    }
}
