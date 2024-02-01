package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an Employee with details such as ID, contact information,
 * employment date, education and employment levels, earnings, and a base
 * productivity estimate. Implements the ProductivityEstimate interface
 * to calculate an employee's productivity estimate.
 */
public class Employee implements ProductivityEstimate {
    protected static final double RATE_OF_EMPLOYMENT_LEVEL_BONUS = 1.4;
    protected String id;
    protected ContactInfo contactInfo;
    protected LocalDate employmentDate;
    protected EducationLevel educationLevel;
    protected EmploymentLevel employmentLevel;
    protected double lastYearEarning;
    protected double baseProductivityEstimate;

    /**
     * Constructs an Employee object with specified details.
     *
     * @param id The unique identifier of the employee.
     * @param contactInfo The contact information of the employee.
     * @param employmentDate The date of employment of the employee.
     * @param educationLevel The education level of the employee.
     * @param employmentLevel The employment level of the employee.
     * @param lastYearEarning The earnings of the employee in the last year.
     * @param baseProductivityEstimate The base productivity estimate of the employee.
     */
    public Employee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double baseProductivityEstimate) {
        this.id = id;
        this.contactInfo = contactInfo;
        this.employmentDate = employmentDate;
        this.educationLevel = educationLevel;
        this.employmentLevel = employmentLevel;
        this.lastYearEarning = lastYearEarning;
        this.baseProductivityEstimate = baseProductivityEstimate;
    }

    public String getId() {
        return id;
    }
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }
    public EmploymentLevel getEmploymentLevel() {
        return employmentLevel;
    }
    public double getLastYearEarning() {
        return lastYearEarning;
    }
    public double getBaseProductivityEstimate() {
        return baseProductivityEstimate;
    }


    // Override methods such as equals, hashCode, and toString as needed.
    @Override
    public String toString() {
        return "Employee{" +
            "id='" + id + '\'' +
            ", contactInfo=" + contactInfo +
            ", employmentDate=" + employmentDate +
            ", educationLevel=" + educationLevel +
            ", employmentLevel=" + employmentLevel +
            ", lastYearEarning=" + lastYearEarning +
            ", baseProductivityEstimate=" + baseProductivityEstimate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee employee)) {
            return false;
        }
        return Double.compare(lastYearEarning, employee.lastYearEarning) == 0
            && Double.compare(baseProductivityEstimate, employee.baseProductivityEstimate)
            == 0 && Objects.equals(id, employee.id) && Objects.equals(contactInfo,
            employee.contactInfo) && Objects.equals(employmentDate, employee.employmentDate)
            && educationLevel == employee.educationLevel
            && employmentLevel == employee.employmentLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactInfo, employmentDate, educationLevel, employmentLevel,
            lastYearEarning, baseProductivityEstimate);
    }

    /**
     * Estimates the productivity of the employee. If the employee is at an
     * intermediate level, a bonus is added to their base productivity estimate.
     *
     * @return The estimated productivity value of the employee.
     */
    @Override
    public double estimateProductivity(){
        if (this.employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL){
            this.baseProductivityEstimate += RATE_OF_EMPLOYMENT_LEVEL_BONUS;
        }
        return this.baseProductivityEstimate;
    }
}

