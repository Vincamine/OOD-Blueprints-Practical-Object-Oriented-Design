package problem1;

import java.time.LocalDate;

public class Manager extends FulltimeEmployee{
    private static final int NUMBERS_OF_MANAGEE = 8;
    private static final double RATE_OF_MANAGEE_BONUS = 1.8;
    private Integer numberOfManagee;

    public Manager(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double baseProductivityEstimate, double basePay, double bonuses, double overtime,
        LocalDate dataOfLastPromotion, Integer numberOfProjects, Integer numberOfManagee) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            baseProductivityEstimate, basePay, bonuses, overtime, dataOfLastPromotion,
            numberOfProjects);
        this.numberOfManagee = numberOfManagee;
    }

    @Override
    public double estimateProductivity(){
        if (numberOfManagee > NUMBERS_OF_MANAGEE){
            baseProductivityEstimate += RATE_OF_MANAGEE_BONUS;
        }
        return baseProductivityEstimate;
    }
}
