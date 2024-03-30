package problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] argus){
        List<Swimmer> swimmers = new ArrayList<>();
        Swimmer a = new Swimmer("Jane Smith", Arrays.asList(28.5,27.4,28.7),
            Arrays.asList(27.6,28.3,28.5), Arrays.asList(28.5,29.7,30.1,30.2,28.5),
            Arrays.asList(27.6,28.5,29.1, 28.5));
        Swimmer b = new Swimmer("Ann Doe", Arrays.asList(27.6,27.7,27.5,26.5,27.5),
            Arrays.asList(28.6,27.5,29.6,27.2), Arrays.asList(28.7,27.8,28.6,27.6,27.6),
            Arrays.asList(26.1,26.1,26.1));
        swimmers.add(a);
        swimmers.add(b);
        SwimmerIterator myIterator = new SwimmerIterator(swimmers);
        //System.out.println("swimmers.size() is " + swimmers.size());
        if(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}
