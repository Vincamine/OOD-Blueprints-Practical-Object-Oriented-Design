package problem2;

public class TermNode {
    private Term term;
    private TermNode nextNode;

    public TermNode(Term term, TermNode nextNode) {
        this.term = term;
        this.nextNode = nextNode;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public TermNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TermNode nextNode) {
        this.nextNode = nextNode;
    }
}
