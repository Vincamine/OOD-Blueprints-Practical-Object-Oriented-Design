package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.OperationNotSupportedException;

public class SwimmerIterator implements Iterator {

    private static final int BUTTERFLY_SWIMMERS_CUTOFF = 5;
    private static final Double OLYMPIC_CUTOFF = 26.17;
    private List<Swimmer> swimmers;

    public SwimmerIterator(List<Swimmer> swimmers) {
        this.swimmers = this.filterOutSwimmer(swimmers);
    }
    private List<Swimmer> filterOutSwimmer(List<Swimmer> swimmers){
        List<Swimmer> filteredSwimmers = new ArrayList<>();
        for(Swimmer swimmer : swimmers){
            if(this.isSwimmersQualified(swimmer))
                filteredSwimmers.add(swimmer);
        }
        return filteredSwimmers;
    }

    private Boolean isSwimmersQualified(Swimmer swimmer){
        return (swimmer.getButterfly50mTimes().size() >= BUTTERFLY_SWIMMERS_CUTOFF)
                && this.isFreestyleQualifies(swimmer);

    }
    private Boolean isFreestyleQualifies(Swimmer swimmer){
        for(Double freestyleTime : swimmer.getFreestyle50mTimes()){
            if(freestyleTime <= OLYMPIC_CUTOFF)
                return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        //System.out.println("this.swimmers.size(): " + this.swimmers.size());
        return this.swimmers.size() > 0;
    }

    @Override
    public Object next() {

        return this.swimmers.remove(0);

    }

    @Override
    public void remove() {
        throw new RuntimeException("no");

    }
}
