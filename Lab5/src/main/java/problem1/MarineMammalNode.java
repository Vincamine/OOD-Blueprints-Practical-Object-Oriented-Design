package problem1;

import java.util.Objects;

public class MarineMammalNode {
    private MarineMammal marineMammal;
    private MarineMammalNode nextNode;

    public MarineMammalNode(MarineMammal marineMammal, MarineMammalNode nextNode) {
        this.marineMammal = marineMammal;
        this.nextNode = nextNode;
    }

    public MarineMammal getMarineMammal() {
        return marineMammal;
    }

    public MarineMammalNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(MarineMammalNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MarineMammalNode that)) {
            return false;
        }
        return Objects.equals(marineMammal, that.marineMammal) && Objects.equals(
            nextNode, that.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marineMammal, nextNode);
    }
}
