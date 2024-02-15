package problem2;

public interface Set {

    Set emptySet();
    Boolean isEmpty();
    Set add(Integer element);
    Boolean contains(Integer element);
    Set remove(Integer element);
    Integer size();

}