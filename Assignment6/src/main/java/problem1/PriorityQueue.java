package problem1;

import java.util.Objects;

public class PriorityQueue implements ListOfPriorityQueue {
    /* change protected to private
    protected PriorityQueueElement firstElementOfPriorityQueue;
    protected PriorityQueue restElementsOfPriorityQueue;
    */
    private PriorityQueueElement firstElementOfPriorityQueue;
    private PriorityQueue restElementsOfPriorityQueue;


    public PriorityQueue(PriorityQueueElement firstElementOfPriorityQueue,
        PriorityQueue restElementsOfPriorityQueue) {
        this.firstElementOfPriorityQueue = firstElementOfPriorityQueue;
        this.restElementsOfPriorityQueue = restElementsOfPriorityQueue;
    }


    public PriorityQueue() {
        this.firstElementOfPriorityQueue = null;
        this.restElementsOfPriorityQueue = null;
    }


    /**
     * @return
     */
    @Override
    public PriorityQueue createEmpty() {
        return new PriorityQueue(null ,null);
    }

    /**
     * @return
     */
    @Override
    public Boolean isEmpty() {
        if(this.firstElementOfPriorityQueue == null){return Boolean.TRUE;}
        else {
            return Boolean.FALSE;
        }
    }

    /**
     * @param priority
     * @param value
     * @return
     */
    @Override
    public PriorityQueue add(Integer priority, String value) {
        //write only object?
        PriorityQueueElement newElement = new PriorityQueueElement(priority,value);
        if(this.firstElementOfPriorityQueue == null){
            return new PriorityQueue(newElement, null);

        }
        //T create new object F this
        return new PriorityQueue(newElement, this);
    }

    /**x
     * @return
     */
    @Override
    public String peek() throws IllegalStateException{
        if(this.isEmpty()){
            throw new IllegalStateException("PQ is empty!");
        } else if(this.restElementsOfPriorityQueue == null){
            return this.firstElementOfPriorityQueue.value;
        } else{
            PriorityQueueElement compareElementHead = new PriorityQueueElement(this.firstElementOfPriorityQueue.priority,this.firstElementOfPriorityQueue.value);
            PriorityQueueElement compareElementNext = new PriorityQueueElement(this.restElementsOfPriorityQueue.firstElementOfPriorityQueue.priority, this.restElementsOfPriorityQueue.firstElementOfPriorityQueue.value);
            //
            if(compareElementHead.priority < compareElementNext.priority){
                return this.restElementsOfPriorityQueue.peek();
            } else {
                PriorityQueue newPQ = new PriorityQueue(compareElementHead, this.restElementsOfPriorityQueue.restElementsOfPriorityQueue);
                return newPQ.peek();
            }
            /*
            else {
                // 10 10 9 2 10
                //Cannot save to new PQ and peek all cause peek() only can give 1 value.
                //maxPriorityQueue.add(compareElementHead.priority, compareElementHead.value);
                //maxPriorityQueue.add(compareElementNext.priority, compareElementNext.value);
                if(compareElementHead.value.compareTo(compareElementNext.value) >= 0){
                    PriorityQueue newPQ = new PriorityQueue(compareElementHead, this.restElementsOfPriorityQueue.restElementsOfPriorityQueue);
                    return newPQ.peek();
                }
                else {
                    PriorityQueue newPQ = new PriorityQueue(compareElementNext, this.restElementsOfPriorityQueue.restElementsOfPriorityQueue);
                    return newPQ.peek();
                }
            }*/
        }
    }


    /** pop() bounds with peek().
     * Consider multiple priorities:
     * If peek() give 1 element that was already chose from multiple priorities elements, pop() should pop the rest elements.
     */
    @Override
    public PriorityQueue pop() {
        // Need to write new recursion

        // basic condition
        if (this.restElementsOfPriorityQueue == null) {
            return null;
        }

        //repeat
//        if (this.restElementsOfPriorityQueue.restElementsOfPriorityQueue == null) {
//            // >= matches with peek()
//            if (this.firstElementOfPriorityQueue.priority >= this.restElementsOfPriorityQueue.firstElementOfPriorityQueue.priority) {
//                return new PriorityQueue(this.restElementsOfPriorityQueue.firstElementOfPriorityQueue);
//            }else {
//                return new PriorityQueue(this.firstElementOfPriorityQueue);
//            }
//        }

        if (this.firstElementOfPriorityQueue.priority >= this.restElementsOfPriorityQueue.firstElementOfPriorityQueue.priority) {
            return new PriorityQueue(
                this.restElementsOfPriorityQueue.firstElementOfPriorityQueue,
                (new PriorityQueue(this.firstElementOfPriorityQueue, this.restElementsOfPriorityQueue.restElementsOfPriorityQueue)).pop()
            );
        } else {
            return new PriorityQueue(
                this.firstElementOfPriorityQueue,
                this.restElementsOfPriorityQueue.pop()
            );
        }


//        while(checkElement != null) {
//            if (assumedMaxPriority. equals(checkElement.priority)){
//                return this.restElementsOfPriorityQueue;
//            } else {
//                newPriorityQueueForPop.add(checkElement.priority, checkElement.value);
//            }
//            checkElement = this.restElementsOfPriorityQueue.firstElementOfPriorityQueue;
//        }
//        return newPriorityQueueForPop;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PriorityQueue that)) {
            return false;
        }
        return Objects.equals(firstElementOfPriorityQueue, that.firstElementOfPriorityQueue)
            && Objects.equals(restElementsOfPriorityQueue, that.restElementsOfPriorityQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElementOfPriorityQueue, restElementsOfPriorityQueue);
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
            "firstElementOfPriorityQueue=" + firstElementOfPriorityQueue +
            ", restElementsOfPriorityQueue=" + restElementsOfPriorityQueue +
            '}';
    }
}
