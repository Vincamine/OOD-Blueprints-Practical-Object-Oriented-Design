package problem2;

import java.util.List;
import java.util.Objects;

/*Class Swimmer contains information about a swimmer, and the list of their swimming times, when swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and freestyle.
 */
public class Swimmer implements Comparable<Swimmer> {
    private String name;
    private List<Double> butterfly50mTimes;
    private List<Double> backstroke50mTimes;
    private List<Double> breaststroke50mTimes;
    private List<Double> freestyle50mTimes;

    public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
        List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
        this.name = name;
        this.butterfly50mTimes = butterfly50mTimes;
        this.backstroke50mTimes = backstroke50mTimes;
        this.breaststroke50mTimes = breaststroke50mTimes;
        this.freestyle50mTimes = freestyle50mTimes;
    }
    public String getName() {
        return name;
    }
    public List<Double> getButterfly50mTimes() {
        return butterfly50mTimes;
    }
    public List<Double> getBackstroke50mTimes() {
        return backstroke50mTimes;
    }
    public List<Double> getBreaststroke50mTimes() {
        return breaststroke50mTimes;
    }
    public List<Double> getFreestyle50mTimes() {
        return freestyle50mTimes;
    }
    @Override
    //YOUR CODE HERE
    public int compareTo(Swimmer otherSwimmer) {
        return (int) (this.computerAverageSwimTime(this.getFreestyle50mTimes())
            - this.computerAverageSwimTime(otherSwimmer.getFreestyle50mTimes()));
    }

    private double computerAverageSwimTime(List<Double> swimTimes){
        Double runningAvg = 0.0;
        for(Double swimTime:swimTimes){
            runningAvg += swimTime;
        }
        return Math.round(runningAvg / swimTimes.size());
    }
    @Override
    public String toString() {
        return "Swimmer{" +
            "name='" + name + '\'' +
            ", butterfly50mTimes=" + butterfly50mTimes +
            ", backstroke50mTimes=" + backstroke50mTimes +
            ", breaststroke50mTimes=" + breaststroke50mTimes +
            ", freestyle50mTimes=" + freestyle50mTimes +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Swimmer swimmer)) {
            return false;
        }
        return Objects.equals(freestyle50mTimes, swimmer.freestyle50mTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freestyle50mTimes);
    }
}