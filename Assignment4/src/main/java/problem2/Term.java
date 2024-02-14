package problem2;

import java.util.Objects;

public class Term {
    private Integer termPower;
    private Integer termCoefficient;

    public Term(Integer power, Integer termCoefficient) {
        this.termPower = power;
        this.termCoefficient = termCoefficient;
    }

    public Integer getTermPower() {
        return termPower;
    }

    public Integer getTermCoefficient() {
        return termCoefficient;
    }


    public void setTermPower(Integer power) {
        this.termPower = power;
    }

    public void setTermCoefficient(Integer termCoefficient) {
        this.termCoefficient = termCoefficient;
    }

    @Override
    public String toString() {
        return "Term{" +
            "power=" + termPower +
            ", coefficient=" + termCoefficient +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Term term)) {
            return false;
        }
        return Objects.equals(termPower, term.termPower) && Objects.equals(termCoefficient,
            term.termCoefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(termPower, termCoefficient);
    }
}
