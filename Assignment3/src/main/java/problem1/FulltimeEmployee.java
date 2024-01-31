package problem1;

import java.time.LocalDate;

public class FulltimeEmployee extends Employee {
    private double basePay;
    private double bonuses;
    private double overtime;
    private LocalDate dataOfLastPromotion;
    private Integer numberOfProjects;

    public FulltimeEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double basePay, double bonuses, double overtime, LocalDate dataOfLastPromotion,
        Integer numberOfProjects) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning);
        this.basePay = basePay;
        this.bonuses = bonuses;
        this.overtime = overtime;
        this.dataOfLastPromotion = dataOfLastPromotion;
        this.numberOfProjects = numberOfProjects;
    }


}
