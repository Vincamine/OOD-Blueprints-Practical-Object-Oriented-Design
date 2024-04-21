package problem1;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {

    private static final Integer DEFAULT_COUNT = 1;

    public  static Map<String, Integer> countTopics_traditional(List<String> topics){
        Map<String, Integer> resultingMap = new HashMap<>();
        Integer topicCount = 0;
        for(String topic: topics){
            topicCount = resultingMap.getOrDefault(topic, DEFAULT_COUNT);
            resultingMap.put(topic, topicCount++);
        }
        return resultingMap;
    }

    public static Map<String, Long> countTopics(List<String> topics){
        return topics.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting() ));
    }
}
