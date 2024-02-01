package problem1;

import java.util.Arrays;
import java.util.Objects;

public class AbstractArtist implements Artist{

    protected Name artistName;
    protected Integer age;
    protected String[] genres;
    protected String[] awards;
    private Integer MIN_AGE = 0;
    private Integer MAX_AGE = 128;

    public AbstractArtist(Name artistName, Integer age, String[] genres, String[] awards)
        throws InvalidAgeException {
        if(!this.validateAge(age))
            throw new InvalidAgeException("The give age is not valid!");
        else {
            this.artistName = artistName;
            this.age = age;
            this.genres = genres;
            this.awards = awards;
        }
    }

    // restrict age range
    private Boolean validateAge(Integer age){
        return age >= MIN_AGE && age <= MAX_AGE;
    }

    // 4 getters
    public Name getArtistName() {
        return artistName;
    }

    public Integer getAge() {
        return age;
    }

    public String[] getGenres() {
        return genres;
    }

    public String[] getAwards() {
        return awards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractArtist that)) {
            return false;
        }
        return Objects.equals(artistName, that.artistName) && Objects.equals(age,
            that.age) && Arrays.equals(genres, that.genres) && Arrays.equals(awards,
            that.awards);
    }

    /**
     * Explanation
     * "It balances computational efficiency with the mathematical benefits of using a prime number to achieve a wide and uniform distribution of hash code values, thereby enhancing the performance of hash-based data structures."
     * 1. Using a prime number as a multiplier reduces the likelihood of collisions between generated hash codes.
     * 2. be efficiently implemented by JVM
     * 3.
     * */
    @Override
    public int hashCode() {
        int result = Objects.hash(artistName, age);
        result = 31 * result + Arrays.hashCode(genres);
        result = 31 * result + Arrays.hashCode(awards);
        return result;
    }

    /**
     *
     * */
    public void receiveAward(String award){
        String[] newAwards = new String[this.awards.length + 1];
        for(int i = 0; i < this.awards.length; i++){
            newAwards[i] = this.awards[i];
        }
        newAwards[this.awards.length + 1] = award;
        this.awards = newAwards;
    }
}
