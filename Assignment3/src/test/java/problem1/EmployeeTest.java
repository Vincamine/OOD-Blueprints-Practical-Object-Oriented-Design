package problem1;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    private Employee testEmployee;

    @BeforeEach
    public void setUp(){
        ContactInfo contactInfo = new ContactInfo(/* parameters if needed */);
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


    @Test
    public void testEqualsAndHashCode() {
        Employee anotherEmployee = new Employee("123", new ContactInfo(),
            LocalDate.of(2020, 1, 1),
            EducationLevel.BACHELORS_DEGREE,
            EmploymentLevel.INTERMEDIATE_LEVEL,
            50000.0, 100.0);
        assertEquals(testEmployee, anotherEmployee);
        assertEquals(testEmployee.hashCode(), anotherEmployee.hashCode());
    }
    @Test
    public void testToString() {
        String expected = "Employee{id='123', contactInfo=ContactInfo{...}, " +
            "employmentDate=2020-01-01, educationLevel=BACHELORS_DEGREE, " +
            "employmentLevel=INTERMEDIATE_LEVEL, lastYearEarning=50000.0, " +
            "baseProductivityEstimate=100.0}";
        assertEquals(expected, testEmployee.toString());
    }

    @Test
    public void testEstimateProductivity() {
        double productivity = testEmployee.estimateProductivity();
        assertEquals(101.4, productivity);
    }

    @Test
    public void testConstructorWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, new ContactInfo(), LocalDate.now(),
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL,
            30000, 80.0));
    }

    @Test
    public void testConstructorWithNullContactInfo() {
        assertThrows(NullPointerException.class, () -> new Employee("123", null, LocalDate.now(),
            EducationLevel.BACHELORS_DEGREE, EmploymentLevel.ENTRY_LEVEL,
            30000, 80.0));
    }

}