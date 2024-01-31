package problem1;

import java.time.LocalDate;

public class HourlyEmployee extends ParttimeEmployee{
    private Double hourlyEarnings;

    public HourlyEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double contractualNumberOfWorkedHours, double actualNumberOfWorkedHours,
        double bonusAndOvertimeEarnings, Double hourlyEarnings) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            contractualNumberOfWorkedHours, actualNumberOfWorkedHours, bonusAndOvertimeEarnings);
        this.hourlyEarnings = hourlyEarnings;
    }
}
