package problem1;

import java.util.Objects;

public class PriorityQueueElement {

    protected Integer priority;
    protected String value;

    public PriorityQueueElement(Integer priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PriorityQueueElement{" +
            "priority=" + priority +
            ", value='" + value + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PriorityQueueElement that)) {
            return false;
        }
        return Objects.equals(priority, that.priority) && Objects.equals(value,
            that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, value);
    }
}
