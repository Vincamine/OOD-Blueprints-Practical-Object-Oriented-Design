package problem1;

import java.time.LocalDate;

public class IndividualContributor extends FulltimeEmployee{
    private Integer numberOfPatents;
    private Integer numberOfPublications;
    private Integer numberOfExternalCollaborations;

    public IndividualContributor(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double basePay, double bonuses, double overtime, LocalDate dataOfLastPromotion,
        Integer numberOfProjects, Integer numberOfPatents, Integer numberOfPublications,
        Integer numberOfExternalCollaborations) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            basePay, bonuses, overtime, dataOfLastPromotion, numberOfProjects);
        this.numberOfPatents = numberOfPatents;
        this.numberOfPublications = numberOfPublications;
        this.numberOfExternalCollaborations = numberOfExternalCollaborations;
    }
}
