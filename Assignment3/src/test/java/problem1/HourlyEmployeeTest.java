package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import problem1.*;


class HourlyEmployeeTest {
    HourlyEmployee employee;
    @BeforeEach
    void setUp() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);
        double lastYearEarning = 1000000;
        double baseProductivityEstimate = 5.0;
        double contractualNumberOfWorkedHours = 40;
        double actualNumberOfWorkedHours = 42;
        double bonusAndOvertimeEarnings = 200;
        Double hourlyEarnings = 13.0;

        employee = new HourlyEmployee("001", contactInfo, employmentDate, EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, lastYearEarning,
            baseProductivityEstimate, contractualNumberOfWorkedHours, actualNumberOfWorkedHours, bonusAndOvertimeEarnings, hourlyEarnings);
    }

    @Test
    void testEstimateProductivity_WithBonus() {
        double expected = 8.0;
        double actual = employee.estimateProductivity();
        assertEquals(expected, actual, "Productivity estimate should include hourly rate bonus.");
    }

    @Test
    void testEstimateProductivity_WithoutBonus() {
        double noBonusHourlyEarnings = 15.0; // Assume this value is above the threshold for bonus
        // Re-initialize employee with noBonusHourlyEarnings to test the scenario without bonus
        Name name = new Name("Alex", "King");
        ContactInfo contactInfo = new ContactInfo(name, "234 Danny St", "111-456", "alexking@gmail.com", name);
        LocalDate employmentDate = LocalDate.of(2022, 1, 1);
        double lastYearEarning = 30000;
        double baseProductivityEstimate = 5.0;
        double contractualNumberOfWorkedHours = 40;
        double actualNumberOfWorkedHours = 42;
        double bonusAndOvertimeEarnings = 200;

        employee = new HourlyEmployee("002", contactInfo, employmentDate, EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL, lastYearEarning,
            baseProductivityEstimate, contractualNumberOfWorkedHours, actualNumberOfWorkedHours, bonusAndOvertimeEarnings, noBonusHourlyEarnings);

        double expected = 5.0;
        double actual = employee.estimateProductivity();
        assertEquals(expected, actual, "Productivity estimate should not include hourly rate bonus.");
    }
}