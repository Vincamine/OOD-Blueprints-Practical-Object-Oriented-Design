package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class FulltimeEmployeeTest {
    private FulltimeEmployee fulltimeEmployee;

    /**
     * FulltimeEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
     * EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
     * double baseProductivityEstimate, double basePay, double bonuses, double overtime,
     * LocalDate dataOfLastPromotion, Integer numberOfProjects)
     *
     * */
    @BeforeEach
    public void setUp() {
        ContactInfo contactInfo = new ContactInfo(/* parameters if needed */);
        LocalDate lastPromotionDate = LocalDate.of(2020, 1, 1);

        fulltimeEmployee = new FulltimeEmployee("123", contactInfo, LocalDate.now(),
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.SENIOR_LEVEL,
            50000.0, 100.0, 40000.0, 5000.0,
            200.0, lastPromotionDate, 3);
    }

    @Test
    public void testConstructorAndFields() {
        assertEquals("123", fulltimeEmployee.getId());
        assertEquals(40000.0, fulltimeEmployee.getBasePay());
        assertEquals(5000.0, fulltimeEmployee.getBonuses());
        assertEquals(200.0, fulltimeEmployee.getOvertime());
        assertEquals(LocalDate.of(2020, 1, 1), fulltimeEmployee.getDataOfLastPromotion());
        assertEquals(3, fulltimeEmployee.getNumberOfProjects());
        // Add assertions for other inherited fields if necessary
    }

    @Test
    public void testProductivityEstimateWithBonus() {
        double productivity = fulltimeEmployee.estimateProductivity();
        assertEquals((50000.0 / 40000.0) * 1.5, productivity, 0.01);
    }

    @Test
    public void testProductivityEstimateWithPenalty() {
        // Change the last promotion date to trigger penalty
        fulltimeEmployee = new FulltimeEmployee("123", /* other parameters */,
            LocalDate.of(2018, 1, 1), /* other parameters */);
        double productivity = fulltimeEmployee.estimateProductivity();
        assertEquals((50000.0 / 40000.0) * 0.8, productivity, 0.01);
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "FulltimeEmployee{basePay=40000.0, bonuses=5000.0, overtime=200.0, " +
            "dataOfLastPromotion=2020-01-01, numberOfProjects=3, id='123', " +
            /* other fields */ "}";
        assertEquals(expectedString, fulltimeEmployee.toString());
    }

}