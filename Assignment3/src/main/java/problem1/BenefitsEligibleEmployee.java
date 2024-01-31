package problem1;

import java.time.LocalDate;

public class BenefitsEligibleEmployee extends ParttimeEmployee{

    public BenefitsEligibleEmployee(String id, ContactInfo contactInfo,
        LocalDate employmentDate, EducationLevel educationLevel,
        EmploymentLevel employmentLevel, double lastYearEarning,
        double contractualNumberOfWorkedHours,
        double actualNumberOfWorkedHours, double bonusAndOvertimeEarnings) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            contractualNumberOfWorkedHours, actualNumberOfWorkedHours, bonusAndOvertimeEarnings);
    }
}
