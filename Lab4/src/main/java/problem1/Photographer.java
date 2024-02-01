package problem1;

import java.util.Arrays;

public class Photographer extends GraphicArtist{

    public Photographer(Name artistName, Integer age, String[] genres, String[] awards,
        String[] exhibits) throws InvalidAgeException {
        super(artistName, age, genres, awards, exhibits);
    }

    @Override
    public String toString() {
        return "Photographer{" +
            "exhibits=" + Arrays.toString(exhibits) +
            ", artistName=" + artistName +
            ", age=" + age +
            ", genres=" + Arrays.toString(genres) +
            ", awards=" + Arrays.toString(awards) +
            '}';
    }



}
