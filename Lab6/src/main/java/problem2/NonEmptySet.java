package problem2;

import java.util.Objects;

public class NonEmptySet extends AbstractSet {

    private Integer headElementsValue;
    private Set restOfSet;

    public NonEmptySet(Integer headElementsValue, Set restOfSet) {
        this.headElementsValue = headElementsValue;
        this.restOfSet = restOfSet;
    }

    public NonEmptySet(Integer headElementsValue) {
        this.headElementsValue = headElementsValue;
        this.restOfSet = this.emptySet();
    }

    public Integer getHeadElementsValue() {
        return headElementsValue;
    }

    public Set getRestOfSet() {
        return restOfSet;
    }

    @Override
    public Boolean isEmpty() {
        return Boolean.FALSE;
    }

    @Override
    //Set does not allow duplicates
    public Set add(Integer element) {
        if(this.contains(element))
            return this;
        else return new NonEmptySet(element, this);
    }

    @Override
    public Boolean contains(Integer element) {
        if(this.headElementsValue.equals(element))
            return Boolean.TRUE;
        else return this.restOfSet.contains(element);
    }

    @Override
    public Set remove(Integer element) {
        if(!this.contains(element))
            return this;
        else if(this.headElementsValue.equals(element))
            //just skip it means remove successfully?
            return this.restOfSet;
        else return new NonEmptySet(this.headElementsValue, this.restOfSet.remove(element));
    }

    @Override
    public Integer size() {
        return 1 + this.restOfSet.size();
    }
}