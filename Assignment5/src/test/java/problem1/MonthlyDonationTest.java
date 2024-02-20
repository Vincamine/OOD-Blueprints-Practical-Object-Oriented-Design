package problem1;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MonthlyDonationTest {

    @Test
    void testGetYearlyDonationNoCancellation() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        assertEquals(1200, donation.getYearlyDonation(2023), "Should calculate full year's donation for 2023.");
    }

    @Test
    void testGetYearlyDonationCancelledSameYear() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        donation.setCancelTime(LocalDateTime.of(2023, 6, 2, 0, 0));
        assertEquals(500, donation.getYearlyDonation(2023), "Should calculate donation until May for 2023.");
    }

    @Test
    void testGetYearlyDonationCancelledNextYear() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        donation.setCancelTime(LocalDateTime.of(2024, 1, 1, 1, 0));
        assertEquals(1200, donation.getYearlyDonation(2023), "Should calculate full year's donation for 2023.");
        assertEquals(100, donation.getYearlyDonation(2024), "Should calculate donation for January 2024.");
    }

    @Test
    void testGetYearlyDonationCancelledAfterSeveralYears() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        donation.setCancelTime(LocalDateTime.of(2025, 1, 1, 1, 0));
        assertEquals(1200, donation.getYearlyDonation(2023), "Should calculate full year's donation for 2023.");
        assertEquals(1200, donation.getYearlyDonation(2024), "Should calculate full year's donation for 2024.");
        assertEquals(100, donation.getYearlyDonation(2025), "Should calculate donation for January 2025.");
    }

    @Test
    void testGetYearlyDonationBeforeCreation() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        assertEquals(0, donation.getYearlyDonation(2022), "Should return 0 for years before the donation was created.");
    }

    @Test
    void testCancellationBeforeCreationThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100)
                .setCancelTime(LocalDateTime.of(2022, 12, 31, 23, 59));
        });
        assertEquals("The cancel time shouldn't before created time!", exception.getMessage());
    }

    @Test
    void testGetYearlyDonationCancellationOnCreationDate() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        donation.setCancelTime(LocalDateTime.of(2023, 1, 1, 0, 1));
        assertEquals(0, donation.getYearlyDonation(2023), "Should return 0 if cancelled on the creation date.");
    }

    @Test
    void testGetYearlyDonationCancellationEndOfYear() {
        MonthlyDonation donation = new MonthlyDonation(LocalDateTime.of(2023, 1, 1, 0, 0), 100);
        donation.setCancelTime(LocalDateTime.of(2023, 12, 31, 23, 59));
        assertEquals(1100, donation.getYearlyDonation(2023),
            "Should calculate full year's donation for 2023");
    }
}