package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ManagerTest {
    Manager managerWithBonus;
    Manager managerWithoutBonus;

    @BeforeEach
    void setUp() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);
        LocalDate dateOfLastPromotion = LocalDate.of(2023, 1, 1);

        // Manager with more than 8 managees, should receive bonus
        managerWithBonus = new Manager("123", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.SENIOR_LEVEL, 50000,
            10.0, 80000, 5000, 200, dateOfLastPromotion, 5, 9); // numberOfManagee is 9

        // Manager with 8 or fewer managees, should not receive bonus
        managerWithoutBonus = new Manager("124", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.SENIOR_LEVEL, 50000,
            10.0, 80000, 5000, 200, dateOfLastPromotion, 5, 8); // numberOfManagee is 8
    }

    @Test
    void testEstimateProductivity_WithBonus() {
        double expected = 11.8;
        double actual = managerWithBonus.estimateProductivity();
        assertEquals(expected, actual, "Productivity estimate should include managee bonus.");
    }

    @Test
    void testEstimateProductivity_WithoutBonus() {
        double expected = 10.0;
        double actual = managerWithoutBonus.estimateProductivity();
        assertEquals(expected, actual, "Productivity estimate should not include managee bonus.");
    }
}