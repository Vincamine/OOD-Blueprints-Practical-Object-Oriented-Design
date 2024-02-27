package problem1;

import java.util.Objects;

/**
 * Class Runner stores information about a runner's best 5k run time, best half-marathon run time,
 * and their favorite running event.
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Constructor for class Runner.
   * @param athletesName runner's name, represented as custom class Name
   * @param height runner's height, represented as Double
   * @param weight runner's weight, represented as Double
   * @param league runner's league, represented as String
   * @param best5KTime runner's best 5k time, represented as Double
   * @param bestHalfMarathonTime runner's best half-marathon time, represented as a Double
   * @param favoriteRunningEvent runner's favorite running event, represented as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league, Double best5KTime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Anothre constructor for class Runner.
   * @param athletesName runner's name, represented as custom class Name
   * @param height runner's height, represented as Double
   * @param weight runner's weight, represented as Double
   * @param best5KTime runner's best 5k time, represented as Double
   * @param bestHalfMarathonTime runner's best half-marathon time, represented as a Double
   * @param favoriteRunningEvent runner's favorite running event, represented as a String
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5KTime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Getter for the best 5k running time.
   * @return 5k running time, as Double
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * Getter for the best half-marathon time.
   * @return half-marathon time, as Double
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * Getter for the favorite running event.
   * @return favorite running event, as String.
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(best5KTime, runner.best5KTime) && Objects.equals(
        bestHalfMarathonTime, runner.bestHalfMarathonTime) && Objects.equals(
        favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5KTime, bestHalfMarathonTime, favoriteRunningEvent);
  }

  @Override
  public String toString() {
    return "Runner{" +
        "best5KTime=" + best5KTime +
        ", bestHalfMarathonTime=" + bestHalfMarathonTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        ", athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }

}
