package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a Full-time Employee extending the Employee class. It includes
 * additional properties and calculations specific to full-time employees,
 * such as base pay, bonuses, overtime, date of last promotion, and the number
 * of projects involved in. The productivity estimate for full-time employees
 * is calculated based on their last year's earnings relative to their base pay,
 * with adjustments for the number of projects and the time since their last promotion.
 */
public class FulltimeEmployee extends Employee {
    private final static int THIS_YEAR = 2024;
    private final static int NUMBER_OF_PROJECTS_TO_GET_BONUS = 2;
    private static final int NUMBER_OF_YEARS_TO_GET_LAST_PROMOTION_PENALTY = 3;
    private static final double RATE_OF_PROJECTS_BONUS = 1.5;
    private static final double RATE_OF_LAST_PROMOTION_PENALTY = 0.8;

    private double basePay;
    private double bonuses;
    private double overtime;
    private LocalDate dataOfLastPromotion;
    private Integer numberOfProjects;

    /**
     * Constructs a FulltimeEmployee object with specified details.
     *
     * @param id The unique identifier of the full-time employee.
     * @param contactInfo The contact information of the full-time employee.
     * @param employmentDate The date of employment of the full-time employee.
     * @param educationLevel The education level of the full-time employee.
     * @param employmentLevel The employment level of the full-time employee.
     * @param lastYearEarning The earnings of the full-time employee in the last year.
     * @param baseProductivityEstimate The base productivity estimate of the full-time employee.
     * @param basePay The base pay of the full-time employee.
     * @param bonuses The bonuses of the full-time employee.
     * @param overtime The overtime hours of the full-time employee.
     * @param dataOfLastPromotion The date of the last promotion of the full-time employee.
     * @param numberOfProjects The number of projects the full-time employee is involved in.
     */
    public FulltimeEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double baseProductivityEstimate, double basePay, double bonuses, double overtime,
        LocalDate dataOfLastPromotion, Integer numberOfProjects) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            baseProductivityEstimate);
        this.basePay = basePay;
        this.bonuses = bonuses;
        this.overtime = overtime;
        this.dataOfLastPromotion = dataOfLastPromotion;
        this.numberOfProjects = numberOfProjects;
    }

    /**
     * 1.Base productivity estimate for full-time employees:
     * Base productivity of full-time employees is calculated as
     * a ratio between an employee’s last year’s earnings,
     * and their base pay.
     * 2.Number of projects bonus:
     * Every full-time employee involved in more than 2 projects gets a bonus boost
     * where 1.5 is added to their base productivity estimate.
     * 3.Last promotion penalty:
     * For every full-time employee,
     * if more than three years have passed since their last promotion, they get a penalty,
     * where 0.8 is subtracted from their current productivity estimate.
     * @return The estimated productivity value of the full-time employee.
     * */
    @Override
    public double estimateProductivity() {
        double baseProductivityEstimate = lastYearEarning / basePay;
        if (numberOfProjects > NUMBER_OF_PROJECTS_TO_GET_BONUS) {
            //baseProductivityEstimate = 5000/4000 * 1.5;
            baseProductivityEstimate += RATE_OF_PROJECTS_BONUS;
        }

        if ((THIS_YEAR - dataOfLastPromotion.getYear())
            > NUMBER_OF_YEARS_TO_GET_LAST_PROMOTION_PENALTY) {
            baseProductivityEstimate -= RATE_OF_LAST_PROMOTION_PENALTY;
        }
        return baseProductivityEstimate;
    }

    /*getters*/
    public double getBasePay() {
        return basePay;
    }

    public double getBonuses() {
        return bonuses;
    }

    public double getOvertime() {
        return overtime;
    }

    public LocalDate getDataOfLastPromotion() {
        return dataOfLastPromotion;
    }

    public Integer getNumberOfProjects() {
        return numberOfProjects;
    }

    // Override methods such as equals, hashCode, and toString as needed.
    @Override
    public String toString() {
        return "FulltimeEmployee{" +
            "basePay=" + basePay +
            ", bonuses=" + bonuses +
            ", overtime=" + overtime +
            ", dataOfLastPromotion=" + dataOfLastPromotion +
            ", numberOfProjects=" + numberOfProjects +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FulltimeEmployee that)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return Double.compare(basePay, that.basePay) == 0
            && Double.compare(bonuses, that.bonuses) == 0
            && Double.compare(overtime, that.overtime) == 0 && Objects.equals(
            dataOfLastPromotion, that.dataOfLastPromotion) && Objects.equals(numberOfProjects,
            that.numberOfProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePay, bonuses, overtime, dataOfLastPromotion,
            numberOfProjects);
    }

}
