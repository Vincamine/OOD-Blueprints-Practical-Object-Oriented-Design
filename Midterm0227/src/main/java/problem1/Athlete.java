package problem1;

import java.util.Objects;

/**
Class Athlete stores information about an athlete.
 **/
public class  Athlete {

  protected Name athletesName;
  protected Double height;
  protected Double weight;
  protected String league;

  /**
  Constructor for the class Athlete.
  @param athletesName - String, representing athlete's name
  @param height - Double, representing athlete's height
  @param weight - Double, representing athlete's weight
  @param league - String, representing athlete's league
   **/
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
 Constructor for the class Athlete.
 @param athletesName - String, representing athlete's name
 @param height - Double, representing athlete's height
 @param weight - Double, representing athlete's weight
  **/
  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
  @return - Name, giving athlete's name
   **/
  public Name getAthletesName() {
    return athletesName;
  }

  /**
 @return - Double, giving athlete's height
  **/
  public Double getHeight() {
    return height;
  }

  /**
 @return - Double, giving athlete's weight
  **/
  public Double getWeight() {
    return weight;
  }

  /**
 @return - String, giving athlete's league
  **/
  public String getLeague() {
    return league;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Athlete athlete = (Athlete) o;
    return Objects.equals(this.athletesName, athlete.athletesName) && Objects.equals(
        this.height, athlete.height) && Objects.equals(this.weight, athlete.weight)
        && Objects.equals(this.league, athlete.league);
  }

  @Override
  /**
   * {@inheritdoc}
   */
  public int hashCode() {
    return Objects.hash(this.athletesName, this.height, this.weight, this.league);
  }

  @Override
  public String toString() {
    return "Athlete{" +
        "athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
