package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PledgeTest {
    private Pledge pledgeWithAmountAndTime;
    private Pledge pledgeWithUnsetAmount;
    private Pledge pledgeWithUnsetAmountAndTime;

    @BeforeEach
    void setUp() {
        LocalDateTime createdTime = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime pledgeTime = LocalDateTime.of(2024, 1, 1, 0, 0);
        pledgeWithAmountAndTime = new Pledge(createdTime, 100, pledgeTime);
        pledgeWithUnsetAmount = new Pledge(createdTime);
        pledgeWithUnsetAmountAndTime = new Pledge(createdTime, pledgeTime);
    }

    @Test
    void testGetYearlyDonationWithPledge() {
        assertEquals(0, pledgeWithAmountAndTime.getYearlyDonation(2023), "Should return 0 for year before pledge.");
        assertEquals(100, pledgeWithAmountAndTime.getYearlyDonation(2024), "Should return amount for year of pledge.");
        assertEquals(0, pledgeWithAmountAndTime.getYearlyDonation(2025), "Should return 0 for year after pledge.");
    }

    @Test
    void testGetYearlyDonationWithUnsetAmount() {
        assertEquals(0, pledgeWithUnsetAmount.getYearlyDonation(2023), "Should return 0 as amount is unset.");
    }

    @Test
    void testSetPledgeTime() {
        LocalDateTime newPledgeTime = LocalDateTime.of(2025, 1, 1, 0, 0);
        pledgeWithUnsetAmount.setPledgeTime(newPledgeTime);
        assertEquals(0, pledgeWithUnsetAmount.getYearlyDonation(2024), "Should return 0 before new pledge time.");
        assertEquals(0, pledgeWithUnsetAmount.getYearlyDonation(2025), "Should return 0 as amount is unset.");
    }

    @Test
    void testEquals() {
        Pledge anotherPledgeWithSameTime = new Pledge(LocalDateTime.of(2023, 1, 1, 0, 0), 100, LocalDateTime.of(2024, 1, 1, 0, 0));
        assertTrue(pledgeWithAmountAndTime.equals(anotherPledgeWithSameTime), "Should be equal if pledge time is the same.");

        Pledge differentPledgeTime = new Pledge(LocalDateTime.of(2023, 1, 1, 0, 0), 100, LocalDateTime.of(2024, 12, 31, 23, 59));
        assertFalse(pledgeWithAmountAndTime.equals(differentPledgeTime), "Should not be equal if pledge time is different.");
    }

    @Test
    void testHashCode() {
        Pledge anotherPledge = new Pledge(LocalDateTime.of(2023, 1, 1, 0, 0), 100, LocalDateTime.of(2024, 1, 1, 0, 0));
        assertEquals(pledgeWithAmountAndTime.hashCode(), anotherPledge.hashCode(), "Hash codes should be equal for equal objects.");
    }

    @Test
    void testToString() {
        String expected = "Pledge{pledgeTime=2024-01-01T00:00, createdTime=2023-01-01T00:00, amountOfMoney=100.0}";
        assertEquals(expected, pledgeWithAmountAndTime.toString(), "ToString should return the correct string representation.");
    }
}
