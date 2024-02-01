package problem1;

import java.time.LocalDate;

public class HourlyEmployee extends ParttimeEmployee{
    private static final int NUMBER_OF_HOURLY_RATE = 14;
    private static final int RATE_OF_HOURLY_RATE_BONUS = 3;
    private Double hourlyEarnings;

    public HourlyEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double baseProductivityEstimate, double contractualNumberOfWorkedHours,
        double actualNumberOfWorkedHours, double bonusAndOvertimeEarnings, Double hourlyEarnings) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            baseProductivityEstimate, contractualNumberOfWorkedHours, actualNumberOfWorkedHours,
            bonusAndOvertimeEarnings);
        this.hourlyEarnings = hourlyEarnings;
    }

    @Override
    public double estimateProductivity() {
        if(hourlyEarnings < NUMBER_OF_HOURLY_RATE){
            baseProductivityEstimate +=  RATE_OF_HOURLY_RATE_BONUS;
        }
        return baseProductivityEstimate;
    }
}
