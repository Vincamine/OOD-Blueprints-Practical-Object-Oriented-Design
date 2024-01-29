package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

//Perishable Food Item is child of Food Item
public abstract class PerishableFoodItem extends FoodItem{
    protected LocalDateTime orderDate;
    protected LocalDateTime expirationDate;

    //Create class structure for Perishable Food Item
    public PerishableFoodItem (String name, Double currentPrice, Integer currentQuantity, Integer maxAllowedQuantity, LocalDateTime orderDate, LocalDateTime expirationDate) {
        super(name, currentPrice, currentQuantity, maxAllowedQuantity);
        this.orderDate = orderDate;  //?encoded as an Integer, representing the number of days since May15, 2021
        this.expirationDate = expirationDate;  //?encoded as an Integer, representing the number of days since December31, 2021
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    //Equals Code
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PerishableFoodItem that = (PerishableFoodItem) o;
        return Objects.equals(orderDate, that.orderDate) && Objects.equals(
            expirationDate, that.expirationDate);
    }

    //Hash Code
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderDate, expirationDate);
    }

    //String code
    @Override
    public String toString() {
        return "PerishableFoodItem{" +
            "orderDate=" + orderDate +
            ", expirationDate=" + expirationDate +
            '}';
    }
}