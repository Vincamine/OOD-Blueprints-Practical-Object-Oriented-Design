package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Musician extends AbstractArtist{
    private String recordingCompany;
    private String lastRecordedAlbum;

    public Musician(Name artistName, Integer age, String[] genres, String[] awards,
        String recordingCompany, String lastRecordedAlbum) throws InvalidAgeException {
        super(artistName, age, genres, awards);
        this.recordingCompany = recordingCompany;
        this.lastRecordedAlbum = lastRecordedAlbum;
    }

    public String getRecordingCompany() {
        return recordingCompany;
    }

    public String getLastRecordedAlbum() {
        return lastRecordedAlbum;
    }

    @Override
    public String toString() {
        return "Musician{" +
            "recordingCompany='" + recordingCompany + '\'' +
            ", lastRecordedAlbum='" + lastRecordedAlbum + '\'' +
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
        if (!(o instanceof Musician musician)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return Objects.equals(recordingCompany, musician.recordingCompany)
            && Objects.equals(lastRecordedAlbum, musician.lastRecordedAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordingCompany, lastRecordedAlbum);
    }
}
