package problem1;

import java.util.Arrays;

public class MultimediaArtist extends AbstractArtist {
    protected String[] movies;
    protected String[] series;
    protected String[] otherMultimedia;

    public MultimediaArtist(Name artistName, Integer age, String[] genres, String[] awards,
        String[] movies, String[] series, String[] otherMultimedia) throws InvalidAgeException {
        super(artistName, age, genres, awards);
        this.movies = movies;
        this.series = series;
        this.otherMultimedia = otherMultimedia;
    }

    public String[] getMovies() {
        return movies;
    }

    public String[] getSeries() {
        return series;
    }

    public String[] getOtherMultimedia() {
        return otherMultimedia;
    }

    @Override
    public String toString() {
        return "MultimediaArtist{" +
            "movies=" + Arrays.toString(movies) +
            ", series=" + Arrays.toString(series) +
            ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MultimediaArtist that)) {
            return false;
        }
        return Arrays.equals(movies, that.movies) && Arrays.equals(series,
            that.series) && Arrays.equals(otherMultimedia, that.otherMultimedia);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(movies);
        result = 31 * result + Arrays.hashCode(series);
        result = 31 * result + Arrays.hashCode(otherMultimedia);
        return result;
    }

    @Override
    public void receiveAward(String award) {
    }
}
