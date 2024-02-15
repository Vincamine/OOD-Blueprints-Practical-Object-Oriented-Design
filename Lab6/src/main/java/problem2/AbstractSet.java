package problem2;

public abstract class AbstractSet implements Set {

    @Override
    public Set emptySet() {
        return new EmptySet();
    }

}