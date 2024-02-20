package problem1;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NonProfitTest {
    NonProfit nonProfit;

    @BeforeEach
    void setUp() {
        nonProfit = new NonProfit("Helping Hands");
    }

    @Test
    void testGetTotalDonationForYearWithNoDonations() {
        assertEquals(0, nonProfit.getTotalDonationForYear(2023), "Total donations should be 0 for no donations.");
    }

    @Test
    void testGetTotalDonationForYearWithDonations() {
        nonProfit.donationsCollection.add(new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100));
        nonProfit.donationsCollection.add(new MonthlyDonation(LocalDateTime.of(2023, 6, 1, 0, 0), 200));
        assertEquals(1200+1400, nonProfit.getTotalDonationForYear(2023), "Total donations calculation is incorrect.");
    }

    @Test
    void testEquals() {
        NonProfit sameNonProfit = nonProfit;
        NonProfit differentNonProfit = new NonProfit("Other Organization");
        NonProfit identicalNonProfit = new NonProfit("Helping Hands");

        assertEquals(nonProfit, sameNonProfit, "Should be equal to itself.");
        assertNotEquals(null, nonProfit, "Should not be equal to null.");
        assertFalse(nonProfit.equals("string"), "Should not be equal to an object of a different type.");
        assertNotEquals(nonProfit, differentNonProfit,
            "Should not be equal to a different NonProfit.");
        assertEquals(nonProfit, identicalNonProfit,
            "Should be equal to another NonProfit with the same name.");
    }

    @Test
    void testHashCode() {
        NonProfit identicalNonProfit = new NonProfit("Helping Hands");
        assertEquals(nonProfit.hashCode(), identicalNonProfit.hashCode(), "Hash codes should be the same for equal objects.");
    }

    @Test
    void testToString() {
        String expected = "NonProfit{organizationName='Helping Hands', donationsCollection=[]}";
        assertEquals(expected, nonProfit.toString(), "toString does not match the expected format.");
    }
}
