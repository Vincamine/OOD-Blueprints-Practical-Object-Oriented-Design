package problem1;

import java.util.Arrays;

public class Filmmaker extends MultimediaArtist {

    public Filmmaker(Name artistName, Integer age, String[] genres, String[] awards,
        String[] movies,
        String[] series, String[] otherMultimedia) throws InvalidAgeException {
        super(artistName, age, genres, awards, movies, series, otherMultimedia);
    }

    @Override
    public String toString() {
        return "Filmmaker{" +
            "movies=" + Arrays.toString(movies) +
            ", series=" + Arrays.toString(series) +
            ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
            ", artistName=" + artistName +
            ", age=" + age +
            ", genres=" + Arrays.toString(genres) +
            ", awards=" + Arrays.toString(awards) +
            '}';
    }
}
