package problem1;

import java.util.Objects;

/**
 * Class BaseballPlayer stores information about a baseball player, includding their team,
 * their average batting score and the number of home runs they had in a season.
 */
public class BaseballPlayer extends Athlete{

  private static final Double AVG_BATTING_SCORE_LIMIT = 0.0;
  private String team;
  private Double avgBattingScore;
  private Integer seasonHomeRuns;

  /**
   * Constructor for BaseballPlayer.
   * @param athletesName baseball player's name, as Name
   * @param height baseball player's height, as Double
   * @param weight baseball player's weight, as Double
   * @param league baseball player's league, as String
   * @param team baseball player's team, as String
   * @param avgBattingScore average batting score, as Double
   * @param seasonHomeRuns season home runs, as Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double avgBattingScore, Integer seasonHomeRuns) throws InvalidBattingScoreException {
    super(athletesName, height, weight, league);
    if(this.validateAvgBattingScore(avgBattingScore)) {
      this.team = team;
      this.avgBattingScore = avgBattingScore;
      this.seasonHomeRuns = seasonHomeRuns;
    }
  }

  /**
   * Another constructor for BaseballPlayer.
   * @param athletesName baseball player's name, as Name
   * @param height baseball player's height, as Double
   * @param weight baseball player's weight, as Double
   * @param team baseball player's team, as String
   * @param avgBattingScore average batting score, as Double
   * @param seasonHomeRuns season home runs, as Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBattingScore, Integer seasonHomeRuns) throws InvalidBattingScoreException {
    super(athletesName, height, weight);
    if(this.validateAvgBattingScore(avgBattingScore)) {
      this.team = team;
      this.avgBattingScore = avgBattingScore;
      this.seasonHomeRuns = seasonHomeRuns;
    }
  }

  private Boolean validateAvgBattingScore(Double avgBattingScore) throws InvalidBattingScoreException {
    if(avgBattingScore > AVG_BATTING_SCORE_LIMIT)
      return Boolean.TRUE;
    else throw new InvalidBattingScoreException("This is not a valid batting score!");
  }

  /**
   * Getter for the team.
   * @return team, as String
   */
  public String getTeam() {
    return this.team;
  }

  /**
   * Getter for the average batting score.
   * @return average batting score, as Double
   */
  public Double getAvgBattingScore() {
    return this.avgBattingScore;
  }

  /**
   * Getter for season home runs.
   * @return season home runs, as Integer.
   */
  public Integer getSeasonHomeRuns() {
    return this.seasonHomeRuns;
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
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) && Objects.equals(avgBattingScore,
        that.avgBattingScore) && Objects.equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBattingScore, seasonHomeRuns);
  }

  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", avgBattingScore=" + avgBattingScore +
        ", seasonHomeRuns=" + seasonHomeRuns +
        ", athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
