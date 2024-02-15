package problem2;

public class EmptySet extends AbstractSet{

    protected EmptySet() {
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.TRUE;
    }

    @Override
    public Set add(Integer element) {
        return new NonEmptySet(element);
    }

    @Override
    public Boolean contains(Integer element) {
        return Boolean.FALSE;
    }

    @Override
    public Set remove(Integer element) {
        return this;
    }

    @Override
    public Integer size() {
        return 0;
    }
}