package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
public class ParttimeEmployeeTest {
    private ParttimeEmployee employee;
    @BeforeEach
    void setUp() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);
        EducationLevel educationLevel = EducationLevel.BACHELORS_DEGREE;
        EmploymentLevel employmentLevel = EmploymentLevel.ENTRY_LEVEL;
        double lastYearEarning = 30000;
        double baseProductivityEstimate = 0;
        double contractualNumberOfWorkedHours = 40;
        double actualNumberOfWorkedHours = 40;
        double bonusAndOvertimeEarnings = 500;
        employee = new ParttimeEmployee("123", contactInfo, employmentDate,
            educationLevel, employmentLevel, lastYearEarning,
            baseProductivityEstimate, contractualNumberOfWorkedHours,
            actualNumberOfWorkedHours, bonusAndOvertimeEarnings);
    }

    @Test
    void getContractualNumberOfWorkedHours() {
        assertEquals(40, employee.getContractualNumberOfWorkedHours(), "The contractual number of worked hours should match the initialized value.");
    }

    @Test
    void getActualNumberOfWorkedHours() {
        assertEquals(40, employee.getActualNumberOfWorkedHours(), "The actual number of worked hours should match the initialized value.");
    }

    @Test
    void getBonusAndOvertimeEarnings() {
        assertEquals(500, employee.getBonusAndOvertimeEarnings(), "The bonus and overtime earnings should match the initialized value.");
    }

    @Test
    void testEstimateProductivity_NormalCase() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);

        employee = new ParttimeEmployee("123", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 30000,
            0, 40, 42, 500);
        double expectedProductivity = 3.7 * (42.0 / 40.0);
        double actualProductivity = employee.estimateProductivity();
        assertEquals(expectedProductivity, actualProductivity, "The productivity estimate should match the expected value.");
    }

    @Test
    void testEstimateProductivity_EqualHours() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);

        employee = new ParttimeEmployee("123", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 30000,
            0, 40, 40, 500);
        double expectedProductivity = 3.7;
        double actualProductivity = employee.estimateProductivity();
        assertEquals(expectedProductivity, actualProductivity, "The productivity estimate should be equal to the rate of productivity estimate.");
    }

    @Test
    void testEstimateProductivity_ZeroActualHours() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);

        employee = new ParttimeEmployee("123", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, 30000,
            0, 40, 0, 500);
        double expectedProductivity = 0; // As the actual hours are zero
        double actualProductivity = employee.estimateProductivity();
        assertEquals(expectedProductivity, actualProductivity, "The productivity estimate should be zero when actual worked hours are zero.");
    }
}