package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Poet extends AbstractArtist{
    private String publishingCompany;
    private String lastPublishedCollection;

    public Poet(Name artistName, Integer age, String[] genres, String[] awards,
        String publishingCompany, String lastPublishedCollection) throws InvalidAgeException {
        super(artistName, age, genres, awards);
        this.publishingCompany = publishingCompany;
        this.lastPublishedCollection = lastPublishedCollection;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public String getLastPublishedCollection() {
        return lastPublishedCollection;
    }

    @Override
    public String toString() {
        return "Poet{" +
            "publishingCompany='" + publishingCompany + '\'' +
            ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
            ", artistName=" + artistName +
            ", age=" + age +
            ", genres=" + Arrays.toString(genres) +
            ", awards=" + Arrays.toString(awards) +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Poet poet)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return Objects.equals(publishingCompany, poet.publishingCompany)
            && Objects.equals(lastPublishedCollection, poet.lastPublishedCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
    }
}
