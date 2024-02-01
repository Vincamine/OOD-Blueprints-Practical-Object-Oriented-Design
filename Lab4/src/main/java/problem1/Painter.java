package problem1;

import java.util.Arrays;

public class Painter extends GraphicArtist{

    public Painter(Name artistName, Integer age, String[] genres, String[] awards,
        String[] exhibits)
        throws InvalidAgeException {
        super(artistName, age, genres, awards, exhibits);
    }

    @Override
    public String toString() {
        return "Painter{" +
            "exhibits=" + Arrays.toString(exhibits) +
            ", artistName=" + artistName +
            ", age=" + age +
            ", genres=" + Arrays.toString(genres) +
            ", awards=" + Arrays.toString(awards) +
            '}';
    }

}
