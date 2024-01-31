package problem1;

import java.time.LocalDate;

public class ParttimeEmployee extends Employee {
    private double contractualNumberOfWorkedHours;
    private double actualNumberOfWorkedHours;
    private double bonusAndOvertimeEarnings;

    public ParttimeEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double contractualNumberOfWorkedHours, double actualNumberOfWorkedHours,
        double bonusAndOvertimeEarnings) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning);
        this.contractualNumberOfWorkedHours = contractualNumberOfWorkedHours;
        this.actualNumberOfWorkedHours = actualNumberOfWorkedHours;
        this.bonusAndOvertimeEarnings = bonusAndOvertimeEarnings;
    }

}
