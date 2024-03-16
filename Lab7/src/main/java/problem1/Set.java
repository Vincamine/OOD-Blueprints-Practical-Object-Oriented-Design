package problem1;

public interface Set<T> {
    Set<T> emptySet();
    Boolean isEmpty();
    Set<T> add(T element);
    Boolean contains(T element);
    Set<T> remove(T element);

}
