package problem1;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    private Employee testEmployee;

    @BeforeEach
    public void setUp(){
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        ContactInfo contactInfo = new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2);

        testEmployee = new Employee("123", contactInfo, LocalDate.of(2020, 1, 1),
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.INTERMEDIATE_LEVEL,
            50000.0, 100.0);
    }

    @Test
    public void testConstructorAndGetter() {
        assertEquals("123", testEmployee.getId());
        assertNotNull(testEmployee.getContactInfo());
        assertEquals(LocalDate.of(2020, 1, 1), testEmployee.getEmploymentDate());
        assertEquals(EducationLevel.BACHELORS_DEGREE, testEmployee.getEducationLevel());
        assertEquals(EmploymentLevel.INTERMEDIATE_LEVEL, testEmployee.getEmploymentLevel());
        assertEquals(50000.0, testEmployee.getLastYearEarning());
        assertEquals(100.0, testEmployee.getBaseProductivityEstimate());
    }

    /*
    @Test
    public void testEqualsAndHashCode() {
        Name name1 = new Name("Barbie", "B");
        Name name2 = new Name("Ken", "K");
        Employee anotherEmployee = new Employee("123", new ContactInfo(name1, "225 Danny street", "111-123", "barbie@barbie.com", name2),
            LocalDate.of(2020, 1, 1),
            EducationLevel.BACHELORS_DEGREE,
            EmploymentLevel.INTERMEDIATE_LEVEL,
            50000.0, 100.0);
        assertEquals(testEmployee, anotherEmployee);
        assertEquals(testEmployee.hashCode(), anotherEmployee.hashCode());
    }
    */


    @Test
    public void testEstimateProductivity() {
        double productivity = testEmployee.estimateProductivity();
        assertEquals(101.4, productivity);
    }


}