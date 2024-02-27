package problem4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import problem4.VideoGameRating;

/**
 * Class VideoGame contains information about a video game - its name, creators, dates of creations
 * and revision, as well as its rating.
 */
public class VideoGame {

  private String gameID;
  private String name;
  private String[] creators;
  private LocalDate dateOfCreation;
  private LocalDate dateOfLastVersion;
  private Integer numDownloads;
  private VideoGameRating videoGameRating;
  private Boolean containsViolence;

  /**
   * Constructor for a class VideoGame.
   * @param gameID unique ID of the game, represented as a String.
   * @param name video game's name, represented as a String.
   * @param creators list of game's creators, represented as an array of Strings.
   * @param dateOfCreation date of the game's creation, represented as a LocalDate.
   * @param dateOfLastVersion date of the game's last version, represented as a LocalDate.
   * @param numDownloads number of downloads, represented as an Integer.
   * @param videoGameRating rating of the video game, represented as a custom data type
   *                        VideoGameRating.
   * @param containsViolence Boolean flag set to True if teh game contains violence.
   */
  public VideoGame(String gameID, String name, String[] creators, LocalDate dateOfCreation,
      LocalDate dateOfLastVersion, Integer numDownloads, VideoGameRating videoGameRating,
      Boolean containsViolence) {
    this.gameID = gameID;
    this.name = name;
    this.creators = creators;
    this.dateOfCreation = dateOfCreation;
    this.dateOfLastVersion = dateOfLastVersion;
    this.numDownloads = numDownloads;
    this.videoGameRating = videoGameRating;
    this.containsViolence = containsViolence;
  }

  /**
   * Getter for the unique ID of the video game.
   * @return ID, represented as String
   */
  public String getGameID() {
    return gameID;
  }

  /**
   * Getter for the name of the video game.
   * @return name, represented as String.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter for the list of the game's creators.
   * @return creators, represented as an array of Strings.
   */
  public String[] getCreators() {
    return creators;
  }

  /**
   * Getter for the date of the game's original creation.
   * @return date of creation, represented as LocalDate.
   */
  public LocalDate getDateOfCreation() {
    return dateOfCreation;
  }

  /**
   * Getter for the date of the game's latest version.
   * @return date of the latest version, represented as LocalDate.
   */
  public LocalDate getDateOfLastVersion() {
    return dateOfLastVersion;
  }

  /**
   * Getter for the total number of downloads for the game.
   * @return number of downloads, represented as an Integer.
   */
  public Integer getNumDownloads() {
    return numDownloads;
  }

  /**
   * Getter for the game's rating.
   * @return game's rating, represented as a custom data type VideoGameRating.
   */
  public VideoGameRating getVideoGameRating() {
    return videoGameRating;
  }

  /**
   * Getter for a Boolean flag indicating if the game contains violence.
   * @return Boolean true if the game contains violence.
   */
  public Boolean getContainsViolence() {
    return containsViolence;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VideoGame videoGame = (VideoGame) o;
    return Objects.equals(gameID, videoGame.gameID) && Objects.equals(name,
        videoGame.name) && Arrays.equals(creators, videoGame.creators)
        && Objects.equals(dateOfCreation, videoGame.dateOfCreation)
        && Objects.equals(dateOfLastVersion, videoGame.dateOfLastVersion)
        && Objects.equals(numDownloads, videoGame.numDownloads)
        && videoGameRating == videoGame.videoGameRating && Objects.equals(containsViolence,
        videoGame.containsViolence);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(gameID, name, dateOfCreation, dateOfLastVersion, numDownloads,
        videoGameRating, containsViolence);
    result = 31 * result + Arrays.hashCode(creators);
    return result;
  }

  @Override
  public String toString() {
    return "VideoGame{" +
        "gameID='" + gameID + '\'' +
        ", name='" + name + '\'' +
        ", creators=" + Arrays.toString(creators) +
        ", dateOfCreation=" + dateOfCreation +
        ", dateOfLastVersion=" + dateOfLastVersion +
        ", numDownloads=" + numDownloads +
        ", videoGameRating=" + videoGameRating +
        ", containsViolance=" + containsViolence +
        '}';
  }
}
