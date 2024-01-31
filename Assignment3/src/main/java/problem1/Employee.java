package problem1;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String id;
    private ContactInfo contactInfo;
    private LocalDate employmentDate;
    private EducationLevel educationLevel;
    private EmploymentLevel employmentLevel;
    private double lastYearEarning;

    public Employee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning) {
        this.id = id;
        this.contactInfo = contactInfo;
        this.employmentDate = employmentDate;
        this.educationLevel = educationLevel;
        this.employmentLevel = employmentLevel;
        this.lastYearEarning = lastYearEarning;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public EmploymentLevel getEmploymentLevel() {
        return employmentLevel;
    }

    public void setEmploymentLevel(EmploymentLevel employmentLevel) {
        this.employmentLevel = employmentLevel;
    }

    public double getLastYearEarning() {
        return lastYearEarning;
    }

    public void setLastYearEarning(double lastYearEarning) {
        this.lastYearEarning = lastYearEarning;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id='" + id + '\'' +
            ", contactInfo=" + contactInfo +
            ", employmentDate=" + employmentDate +
            ", educationLevel=" + educationLevel +
            ", employmentLevel=" + employmentLevel +
            ", lastYearEarning=" + lastYearEarning +
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
            && Objects.equals(id, employee.id) && Objects.equals(contactInfo,
            employee.contactInfo) && Objects.equals(employmentDate, employee.employmentDate)
            && educationLevel == employee.educationLevel
            && employmentLevel == employee.employmentLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactInfo, employmentDate, educationLevel, employmentLevel,
            lastYearEarning);
    }

}
