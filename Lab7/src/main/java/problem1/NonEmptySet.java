package problem1;

public class NonEmptySet<T> implements Set<T>{
    private T firstElement;
    private Set<T> restOfTheSet;

    public NonEmptySet(T firstElement, Set<T>){
        this.firstElement = firstElement;
        this.restOfTheSet = this.emptySet();
    }

    public NonEmptySet(T firstElement, Set<T>){
        this.firstElement = firstElement;
        this.restOfTheSet = new EmptySet<>();
    }

    @Override
    public Set<T> emptySet() {
        return new EmptySet();
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.False;
    }

    @Override
    public Set<T> add(T element) {
        if(this.contains(element))
            return this;
        else return new NonEmptySet(element, this);
    }

    @Override
    public Boolean contains(T element) {
        if(this.firstElement.equals(element))
            return Boolean.TRUE;
        else return this.restOfTheSet.contains(element);
    }

    @Override
    public Set<T> remove(T element) {

        if(this.contains(element))
            return this;
        else if (this.firstElement.equals(element))
            return this.restOfTheSet;
        else return new NonEmptySet<>(this.firstElement, this.restOfTheSet.remove(element));
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NonEmptySet)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        NonEmptySet<?> that = (NonEmptySet<?>) object;
        return java.util.Objects.equals(firstElement, that.firstElement)
            && java.util.Objects.equals(
            restOfTheSet, that.restOfTheSet);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), firstElement, restOfTheSet);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "NonEmptySet{" +
            "firstElement=" + firstElement +
            ", restOfTheSet=" + restOfTheSet +
            '}';
    }
}
