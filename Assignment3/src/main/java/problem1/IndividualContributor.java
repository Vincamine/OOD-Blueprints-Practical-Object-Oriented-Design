package problem1;

import java.time.LocalDate;
import java.util.Objects;

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

    /**
     * return numberOfPatents
     * @return numberOfPatents
     */
    public Integer getNumberOfPatents() {
        return numberOfPatents;
    }

    public void setNumberOfPatents(Integer numberOfPatents) {
        this.numberOfPatents = numberOfPatents;
    }

    public Integer getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(Integer numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }

    public Integer getNumberOfExternalCollaborations() {
        return numberOfExternalCollaborations;
    }

    public void setNumberOfExternalCollaborations(Integer numberOfExternalCollaborations) {
        this.numberOfExternalCollaborations = numberOfExternalCollaborations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IndividualContributor that)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return Objects.equals(numberOfPatents, that.numberOfPatents)
            && Objects.equals(numberOfPublications, that.numberOfPublications)
            && Objects.equals(numberOfExternalCollaborations,
            that.numberOfExternalCollaborations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfPatents, numberOfPublications,
            numberOfExternalCollaborations);
    }

}
