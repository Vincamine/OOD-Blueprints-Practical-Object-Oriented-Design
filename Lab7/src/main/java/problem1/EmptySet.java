package problem1;

public class EmptySet<T> implements Set<T>{
    public EmptySet(){
    }

    @Override
    public Set<T> emptySet() {
        return new EmptySet();
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.TRUE;
    }

    @Override
    public Set<T> add(T element) {
        return new NonEmptySet(element);
    }

    @Override
    public Boolean contains(T element) {
        return Boolean.False;
    }

    @Override
    public Set<T> remove(T element) {
        return this;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "EmptySet{}";
    }
}
