package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a Part-time Employee, extending the Employee class. This class
 * includes properties specific to part-time employees such as the contractual
 * and actual number of worked hours, and bonus and overtime earnings. The
 * productivity estimate for part-time employees is calculated based on the ratio
 * of their actual worked hours to their contractual hours, multiplied by a
 * constant productivity rate.
 */
public class ParttimeEmployee extends Employee {
    private static final double RATE_OF_PRODUCTIVITY_ESTIMATE_FOR_PARTTIME_EMPLOYEE = 3.7;
    protected static final double RATE_OF_EMPLOYMENT_LEVEL_BONUS = 1.4;
    private double contractualNumberOfWorkedHours;
    private double actualNumberOfWorkedHours;
    private double bonusAndOvertimeEarnings;

    /**
     * Constructs a ParttimeEmployee object with specified details.
     *
     * @param id The unique identifier of the part-time employee.
     * @param contactInfo The contact information of the part-time employee.
     * @param employmentDate The date of employment of the part-time employee.
     * @param educationLevel The education level of the part-time employee.
     * @param employmentLevel The employment level of the part-time employee.
     * @param lastYearEarning The earnings of the part-time employee in the last year.
     * @param baseProductivityEstimate The base productivity estimate of the part-time employee.
     * @param contractualNumberOfWorkedHours The contractual number of hours the part-time employee is expected to work.
     * @param actualNumberOfWorkedHours The actual number of hours worked by the part-time employee.
     * @param bonusAndOvertimeEarnings The bonus and overtime earnings of the part-time employee.
     */
    public ParttimeEmployee(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double baseProductivityEstimate, double contractualNumberOfWorkedHours,
        double actualNumberOfWorkedHours, double bonusAndOvertimeEarnings) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            baseProductivityEstimate);
        this.contractualNumberOfWorkedHours = contractualNumberOfWorkedHours;
        this.actualNumberOfWorkedHours = actualNumberOfWorkedHours;
        this.bonusAndOvertimeEarnings = bonusAndOvertimeEarnings;
    }

    public double getContractualNumberOfWorkedHours() {
        return contractualNumberOfWorkedHours;
    }

    public double getActualNumberOfWorkedHours() {
        return actualNumberOfWorkedHours;
    }

    public double getBonusAndOvertimeEarnings() {
        return bonusAndOvertimeEarnings;
    }

    // Override methods such as equals, hashCode, and toString as needed.


    @Override
    public String toString() {
        return "ParttimeEmployee{" +
            "contractualNumberOfWorkedHours=" + contractualNumberOfWorkedHours +
            ", actualNumberOfWorkedHours=" + actualNumberOfWorkedHours +
            ", bonusAndOvertimeEarnings=" + bonusAndOvertimeEarnings +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParttimeEmployee that)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return Double.compare(contractualNumberOfWorkedHours,
            that.contractualNumberOfWorkedHours) == 0
            && Double.compare(actualNumberOfWorkedHours, that.actualNumberOfWorkedHours) == 0
            && Double.compare(bonusAndOvertimeEarnings, that.bonusAndOvertimeEarnings) == 0;
    }


    /**
     * Base productivity estimate for part-time employees:
     * Base productivity of part-time employees is calculated as a ratio
     * between an employee’s actual number of worked hours,
     * and their contractual number of worked hours,
     * and the result is multiplied by 3.7.
     *
     * @return The estimated productivity of the part-time employee.
     * */
    @Override
    public double estimateProductivity(){
        baseProductivityEstimate =  RATE_OF_PRODUCTIVITY_ESTIMATE_FOR_PARTTIME_EMPLOYEE * (actualNumberOfWorkedHours / contractualNumberOfWorkedHours);
        return baseProductivityEstimate;
    }
}
