package problem1;

import java.time.LocalDate;

public class Manager extends FulltimeEmployee{
    private Integer numberOfManagee;

    public Manager(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double basePay, double bonuses, double overtime, LocalDate dataOfLastPromotion,
        Integer numberOfProjects, Integer numberOfManagee) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            basePay, bonuses, overtime, dataOfLastPromotion, numberOfProjects);
        this.numberOfManagee = numberOfManagee;
    }
}
