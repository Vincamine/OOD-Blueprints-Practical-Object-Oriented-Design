package problem1;

import java.time.LocalDate;

public class IndividualContributor extends FulltimeEmployee{
    private static final int NUMBERS_OF_PUBLICATIONS = 4;
    private static final double RATE_OF_PUBLICATION_BONUS = 1.3;
    private Integer numberOfPatents;
    private Integer numberOfPublications;
    private Integer numberOfExternalCollaborations;

    public IndividualContributor(String id, ContactInfo contactInfo, LocalDate employmentDate,
        EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
        double baseProductivityEstimate, double basePay, double bonuses, double overtime,
        LocalDate dataOfLastPromotion, Integer numberOfProjects, Integer numberOfPatents,
        Integer numberOfPublications, Integer numberOfExternalCollaborations) {
        super(id, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
            baseProductivityEstimate, basePay, bonuses, overtime, dataOfLastPromotion,
            numberOfProjects);
        this.numberOfPatents = numberOfPatents;
        this.numberOfPublications = numberOfPublications;
        this.numberOfExternalCollaborations = numberOfExternalCollaborations;
    }

    @Override
    public double estimateProductivity(){
        if (numberOfPublications > NUMBERS_OF_PUBLICATIONS){
            baseProductivityEstimate += RATE_OF_PUBLICATION_BONUS;
        }
        return baseProductivityEstimate;
    }


}
