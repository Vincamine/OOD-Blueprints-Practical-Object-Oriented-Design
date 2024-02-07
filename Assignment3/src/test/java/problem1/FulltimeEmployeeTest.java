package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class FulltimeEmployeeTest {
    private FulltimeEmployee fulltimeEmployee;
    private static final double RATE_OF_PROJECTS_BONUS = 1.5;
    private final static int NUMBER_OF_PROJECTS_TO_GET_BONUS = 2;


    /**
     * FulltimeEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
     * EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
     * double baseProductivityEstimate, double basePay, double bonuses, double overtime,
     * LocalDate dataOfLastPromotion, Integer numberOfProjects)
     *
     * */
    @BeforeEach
    public void setUp() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);
        LocalDate lastPromotionDate = LocalDate.of(2022, 1, 1);

        fulltimeEmployee = new FulltimeEmployee("123", contactInfo, LocalDate.now(),
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL,
            50000.0, 100.0, 40000.0, 5000.0,
            200.0, lastPromotionDate, 3);
    }

    @Test
    public void testConstructorAndFields() {
        assertEquals("123", fulltimeEmployee.getId());
        assertEquals(40000.0, fulltimeEmployee.getBasePay());
        assertEquals(5000.0, fulltimeEmployee.getBonuses());
        assertEquals(200.0, fulltimeEmployee.getOvertime());
        assertEquals(LocalDate.of(2022, 1, 1), fulltimeEmployee.getDataOfLastPromotion());
        assertEquals(3, fulltimeEmployee.getNumberOfProjects());
        // Add assertions for other inherited fields if necessary
    }

    @Test
    public void testProductivityEstimateWithBonus() {
        double productivity = fulltimeEmployee.estimateProductivity();
        assertEquals(50000.0 / 40000.0 + 1.5,
            productivity);
    }

    @Test
    public void testProductivityEstimateWithPenalty() {
        int NUMBER_OF_PROJECTS_TO_GET_BONUS = 2;
        int NUMBER_OF_YEARS_TO_GET_LAST_PROMOTION_PENALTY = 3;
        double RATE_OF_PROJECTS_BONUS = 1.5;
        double RATE_OF_LAST_PROMOTION_PENALTY = 0.8;

        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);

        LocalDate employmentDate = LocalDate.of(2020, 1, 1); // Example date
        LocalDate dateOfLastPromotion = LocalDate.of(2018, 1, 1); // More than 3 years ago to trigger penalty

        FulltimeEmployee fulltimeEmployee = new FulltimeEmployee("123", contactInfo, employmentDate,
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.MID_LEVEL, 50000.0,
            10.0, 40000.0, 5000.0, 200.0, dateOfLastPromotion, 3);

        // Correct calculation based on provided logic
        double baseProductivityEstimate = 50000.0 / 40000.0; // lastYearEarning / basePay
        baseProductivityEstimate += RATE_OF_PROJECTS_BONUS;
        baseProductivityEstimate -= RATE_OF_LAST_PROMOTION_PENALTY;

        double expectedProductivity = baseProductivityEstimate;
        double actualProductivity = fulltimeEmployee.estimateProductivity();

        assertEquals(expectedProductivity, actualProductivity, 0.01, "Productivity estimate should reflect the last promotion penalty.");
    }


}