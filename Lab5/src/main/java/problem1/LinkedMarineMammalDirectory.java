package problem1;

import java.util.Objects;

public class LinkedMarineMammalDirectory implements MarineMammalDirectory{
    private MarineMammalNode headNode;
    private Integer numMarineMammals;

    public LinkedMarineMammalDirectory(MarineMammalNode headNode, Integer numMarineMammals) {
        this.headNode = headNode;
        this.numMarineMammals = numMarineMammals;
    }

    public LinkedMarineMammalDirectory() {
        this.headNode = null;
        this.numMarineMammals = 0;
    }

    @Override
    public MarineMammalDirectory createEmpty() {
        return new LinkedMarineMammalDirectory();
    }

    @Override
    public MarineMammalDirectory add(MarineMammal marineMammal) {
        if(this.containsMammal(marineMammal)){
            return this;
        }
        else{
            MarineMammalNode newMammalNode = new MarineMammalNode(marineMammal,this.headNode);
            return new LinkedMarineMammalDirectory(newMammalNode,this.numMarineMammals+1);
        }
    }

    @Override
    public Boolean isEmpty() {
        return this.numMarineMammals.equals(0);
    }

    @Override
    public Integer size() {
        return this.numMarineMammals;
    }

    @Override
    public Boolean containsMammal(MarineMammal marineMammal) {
        MarineMammalNode cur = this.headNode;
        for(int i = 0; i < this.numMarineMammals-1; i++){
            if(cur.getMarineMammal().equals(marineMammal)){
                return true;
            }
            else {
                cur = cur.getNextNode();
            }
        }
        //return cur.getMarineMammal().equals(marineMammal);
        return false;
    }

    @Override
    public MarineMammalDirectory remove(MarineMammal marineMammal) {
        if(!this.containsMammal(marineMammal)){
            return this;
        }
        if(this.headNode.getMarineMammal().equals(marineMammal)){
            return new LinkedMarineMammalDirectory(this.headNode.getNextNode(),this.numMarineMammals-1);
        }
        else {
            MarineMammalNode cur = this.headNode;
            while(cur.getNextNode() != null){
                MarineMammalNode toRemove = cur.getNextNode();
                if(toRemove.getMarineMammal().equals(marineMammal)){
                    cur.setNextNode(toRemove.getNextNode());
                    break;
                }
                cur = cur.getNextNode();
            }
            return new LinkedMarineMammalDirectory(this.headNode,numMarineMammals-1);

            /*
            MarineMammalNode cur = this.headNode;
            MarineMammalNode toRemove = cur.getNextNode();
            while(toRemove != null){
                if(toRemove.getMarineMammal().equals(marineMammal)){
                    cur.setNextNode(toRemove.getNextNode());
                    return (new LinkedMarineMammalDirectory(this.headNode, this.numMarineMammals-1));
                }
                else {
                    cur = cur.getNextNode();
                    toRemove = toRemove.getNextNode();
                }
            }*/
            return this;
        }
    }

    @Override
    public MarineMammal getSomeMammal() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedMarineMammalDirectory that)) {
            return false;
        }
        return Objects.equals(headNode, that.headNode) && Objects.equals(
            numMarineMammals, that.numMarineMammals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headNode, numMarineMammals);
    }
}
