package problem1;

import java.util.Arrays;

/**
 * NonProfitOrganizationDesigners
 */
public class NPODesigner extends AbstractArtist{
    protected String orgTitle;
    protected ProficiencyLevel proficiencyLevel;

    public NPODesigner(Name artistName, Integer age, String[] genres, String[] awards,
        String orgTitle,
        ProficiencyLevel proficiencyLevel) throws InvalidAgeException {
        super(artistName, age, genres, awards);
        this.orgTitle = orgTitle;
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public String toString() {
        return "NPODesigner{" +
            "orgTitle='" + orgTitle + '\'' +
            ", proficiencyLevel=" + proficiencyLevel +
            ", artistName=" + artistName +
            ", age=" + age +
            ", genres=" + Arrays.toString(genres) +
            ", awards=" + Arrays.toString(awards) +
            '}';
    }
}
