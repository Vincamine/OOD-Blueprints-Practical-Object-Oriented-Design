package problem2;

import java.util.HashSet;
import java.util.Set;
public class LinkedListStrList implements ListOfStrings{
    private static class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
        private Node head;
        private int size;
        public LinkedListStrList(){
            head = null;
            size = 0;
        }

    @Override
    public Boolean isEmpty() {
        return null;
    }

    @Override
    public Integer size() {
        return null;
    }

    @Override
    public Boolean contains(String element) {
        return null;
    }

    @Override
    public Boolean containsAll(String[] allElements) {
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
