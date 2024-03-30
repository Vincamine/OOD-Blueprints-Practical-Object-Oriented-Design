package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
    public FrequencyCounter(){

    }
    public static Map<Integer, Double> countFrequencies(List<Integer> integerList){
        Map<Integer, Double> frequencyMap = new HashMap<>();
        //Double defaultValue = Double.valueOf(1/integerList.size());
        Double defaultValue = (double)(1.0/integerList.size());
        for(Integer elem: integerList){
            double count = frequencyMap.getOrDefault(elem,0.0);
            frequencyMap.put(elem, count + defaultValue);
        }
        return frequencyMap;
     }
}
