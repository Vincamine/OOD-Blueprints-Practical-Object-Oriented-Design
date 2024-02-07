package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class IndividualContributorTest {
    IndividualContributor contributorWithBonus;
    IndividualContributor contributorWithoutBonus;

    @BeforeEach
    void setUp() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);
        LocalDate dateOfLastPromotion = LocalDate.of(2023, 1, 1);

        contributorWithBonus = new IndividualContributor("123", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.MID_LEVEL, 60000,
            10.0, 90000, 3000, 250, dateOfLastPromotion, 3, 2, 5, 1); // numberOfPublications is 5

        contributorWithoutBonus = new IndividualContributor("124", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.MID_LEVEL, 60000,
            10.0, 90000, 3000, 250, dateOfLastPromotion, 3, 2, 4, 1); // numberOfPublications is 4
    }

    @Test
    void testEstimateProductivity_WithBonus() {
        double expected = 11.3; // 10.0 + RATE_OF_PUBLICATION_BONUS
        double actual = contributorWithBonus.estimateProductivity();
        assertEquals(expected, actual, "Productivity estimate should include publication bonus.");
    }

    @Test
    void testEstimateProductivity_WithoutBonus() {
        double expected = 10.0; // Base productivity estimate without bonus
        double actual = contributorWithoutBonus.estimateProductivity();
        assertEquals(expected, actual, "Productivity estimate should not include publication bonus.");
    }
}