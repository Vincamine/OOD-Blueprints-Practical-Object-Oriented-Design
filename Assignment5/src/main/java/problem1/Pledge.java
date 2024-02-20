package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pledge extends Donation{
    //time that the pledge will happen. It is a certain date or uncertain that we need to wait for their death.
    private LocalDateTime pledgeTime;

    private final static int UNSET_AMOUNT = 0;

    public Pledge(LocalDateTime createdTime, float amountOfMoney, LocalDateTime pledgeTime) {
        super(createdTime, amountOfMoney);
        this.pledgeTime = pledgeTime;
    }

    public Pledge(LocalDateTime createdTime){
        this(createdTime, UNSET_AMOUNT, null);
    }

    public Pledge(LocalDateTime createdTime, LocalDateTime pledgeTime){
        this(createdTime, UNSET_AMOUNT, pledgeTime);
    }

    public void setPledgeTime(LocalDateTime pledgeTime) {
        this.pledgeTime = pledgeTime;
    }

    /**
     * @param year
     * @return
     */
    @Override
    public float getYearlyDonation(int year) {
        if(pledgeTime != null){
            if(year == pledgeTime.getYear()){
                return amountOfMoney;
            }
            return 0;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pledge pledge)) {
            return false;
        }
        return Objects.equals(pledgeTime, pledge.pledgeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pledgeTime);
    }

    @Override
    public String toString() {
        return "Pledge{" +
            "pledgeTime=" + pledgeTime +
            ", createdTime=" + createdTime +
            ", amountOfMoney=" + amountOfMoney +
            '}';
    }
}
