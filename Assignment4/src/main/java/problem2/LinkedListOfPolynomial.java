package problem2;

public class LinkedListOfPolynomial implements Polynomial{
    private TermNode head;
    private Integer degree;

    /**
     *
     * @param head
     */
    public LinkedListOfPolynomial(TermNode head) {
        this.head = head;
        this.degree = (head != null) ? head.getTerm().getTermPower() : 0;
    }

    /**
     *
     * @return
     */
    @Override
    public Integer getDegree() {
        return this.degree;
    }

    /**
     *
     * @param requestPower
     * @return
     */
    @Override
    public Integer getCoefficient(Integer requestPower) {
        TermNode current = this.head;
        while(current != null){
            if(current.getTerm().getTermPower().equals(requestPower)){
                return current.getTerm().getTermCoefficient();
            }
            current = current.getNextNode();
        }
        return 0;
    }

    /**
     *
     * @param requestDegree
     * @return
     */
    @Override
    public Polynomial setDegree(Integer requestDegree){
        if(requestDegree > this.degree){
            this.degree = requestDegree;
        }
        return this;
    }

    /**
     *
     * @param requestPower
     * @param requestCoef
     * @return
     * @throws InvalidPolynomialPowerException
     */
    @Override
    public Polynomial addTerm(Integer requestPower, Integer requestCoef)
        throws InvalidPolynomialPowerException {
        if(requestPower < 0 ){ throw new InvalidPolynomialPowerException();}

        Term newTerm = new Term(requestPower, requestCoef);
        TermNode newTermNode = new TermNode(newTerm, null);

        if(this.head == null){
            this.head = newTermNode;
            return this;
        }
        if(requestPower > this.head.getTerm().getTermPower()){

            //newTermNode.setNextNode(this.head);
            //this.head = newTermNode;
            this.head = new TermNode(newTerm, this.head);

            this.setDegree(requestPower);
        } else if (requestPower.equals(this.head.getTerm().getTermPower())){
            this.head.getTerm().setTermCoefficient(requestCoef + this.head.getTerm().getTermCoefficient());
        }
        else {
            TermNode prev = this.head;
            TermNode current = this.head.getNextNode();
            if(current == null){
                this.head.setNextNode(newTermNode);
            }
            while(current != null){
                if(current.getTerm().getTermPower().equals(requestPower)){
                    current.getTerm().setTermCoefficient(current.getTerm().getTermCoefficient() + requestCoef);
                    return this;
                } else if (current.getTerm().getTermPower() < requestPower) {
                    prev.setNextNode(newTermNode);
                    newTermNode.setNextNode(current);
                    return this;
                }
                prev = current;
                current = current.getNextNode();
            }
            if(current == null || prev != null || prev.getTerm().getTermPower() > requestPower){
                prev.setNextNode(newTermNode);
            }
        }
        this.setDegree(requestPower);
        return this;
    }

    /**
     *
     * @param requestPower
     * @return
     */
    @Override
    public Polynomial removeTerm(Integer requestPower) {
        if(this.head.getTerm().getTermPower().equals(requestPower)){
            this.head = this.head.getNextNode();
        }
        else{
            TermNode prev = this.head;
            TermNode cur = this.head.getNextNode();
            while(cur != null){
                if(cur.getTerm().getTermPower().equals(requestPower)){
                    prev.setNextNode(cur.getNextNode());
                    break;
                }
                prev = cur;
                cur = cur.getNextNode();
            }
        }
        return this;
    }

    @Override
    public Boolean isSame(LinkedListOfPolynomial anotherPolynomial) {
        TermNode oneNode = this.head;
        TermNode anotherTermNode = anotherPolynomial.head;
        while(oneNode != null && anotherTermNode != null){
            if (oneNode.getTerm().getTermPower().equals(anotherTermNode.getTerm().getTermPower()) && oneNode.getTerm().getTermCoefficient().equals(anotherTermNode.getTerm().getTermCoefficient())) {
                oneNode = oneNode.getNextNode();
                anotherTermNode = anotherTermNode.getNextNode();
            }
            else{
                return false;
            }
        }
        return oneNode == null && anotherTermNode == null;
    }

    @Override
    public Polynomial add(LinkedListOfPolynomial anotherPolynomial)
        throws InvalidPolynomialPowerException {
        TermNode oneNode = anotherPolynomial.head;
        while(oneNode != null){
            this.addTerm(oneNode.getTerm().getTermPower(), oneNode.getTerm().getTermCoefficient());
            oneNode = oneNode.getNextNode();
        }
        return this;
    }
}
