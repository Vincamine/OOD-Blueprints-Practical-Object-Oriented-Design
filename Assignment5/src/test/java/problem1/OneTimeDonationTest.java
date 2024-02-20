package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneTimeDonationTest {
    private OneTimeDonation donationMadeThisYear;
    private OneTimeDonation donationMadeLastYear;

    @BeforeEach
    void setUp() {
        // Assume the current year is 2023
        donationMadeThisYear = new OneTimeDonation(LocalDateTime.of(2023, 6, 1, 0, 0), 100);
        donationMadeLastYear = new OneTimeDonation(LocalDateTime.of(2022, 6, 1, 0, 0), 100);
    }

    @Test
    void testGetYearlyDonationForThisYear() {
        // Test donation made this year is counted for this year
        assertEquals(100, donationMadeThisYear.getYearlyDonation(2023), "Donation made this year should be counted for this year.");
    }

    @Test
    void testGetYearlyDonationForLastYear() {
        // Test donation made last year is not counted for this year
        assertEquals(0, donationMadeThisYear.getYearlyDonation(2022), "Donation made this year should not be counted for last year.");
    }

    @Test
    void testGetYearlyDonationForDonationMadeLastYear() {
        // Test donation made last year is counted for last year
        assertEquals(100, donationMadeLastYear.getYearlyDonation(2022), "Donation made last year should be counted for last year.");
    }

    @Test
    void testGetYearlyDonationForDonationMadeLastYearButQueriedForThisYear() {
        // Test donation made last year is not counted for this year
        assertEquals(0, donationMadeLastYear.getYearlyDonation(2023), "Donation made last year should not be counted for this year.");
    }

    @Test
    void testToStringMethod() {
        // Test the toString method
        assertEquals("OneTimeDonation{}", donationMadeThisYear.toString(), "toString method should return the correct string representation.");
    }
}
