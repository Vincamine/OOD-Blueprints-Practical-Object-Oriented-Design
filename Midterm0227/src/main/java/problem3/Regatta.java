package problem3;

import java.time.LocalDate;
import java.util.Objects;
import problem3.RegattaLevel;


/**
 * Class Regatta stores relevant information about sailing regattas.
 */
public class Regatta {

  private String regattaID;
  private String regattaName;
  private String country;
  private String startingPoint;
  private String stoppingPoint;
  private Double mileageDuration;
  private LocalDate dateOfEvent;
  private RegattaLevel regattaLevel;
  private Boolean annualEvent;

  /**
   * Constructor for the class Regatta.
   * @param regattaID unique identifier of a regatta, represented as a String.
   * @param regattaName regatta's name, represented as a String.
   * @param country country where the regatta is being held, represented as a String.
   * @param startingPoint starting point of the regatta, represented as a String.
   * @param stoppingPoint stopping point of the regatta, represented as a String.
   * @param mileageDuration duration of the regatta in miles, represented as a Double.
   * @param dateOfEvent date of the regatta, represented as LocalDate.
   * @param regattaLevel regatta level, represented as custom data type RegattaLevel.
   * @param annualEvent Boolean flag indicating if the regatta is annual.
   */
  public Regatta(String regattaID, String regattaName, String country, String startingPoint,
      String stoppingPoint, Double mileageDuration, LocalDate dateOfEvent,
      RegattaLevel regattaLevel,
      Boolean annualEvent) {
    this.regattaID = regattaID;
    this.regattaName = regattaName;
    this.country = country;
    this.startingPoint = startingPoint;
    this.stoppingPoint = stoppingPoint;
    this.mileageDuration = mileageDuration;
    this.dateOfEvent = dateOfEvent;
    this.regattaLevel = regattaLevel;
    this.annualEvent = annualEvent;
  }

  /**
   * Getter for the regatta's ID.
   * @return regatta's ID, represented as a String.
   */
  public String getRegattaID() {
    return regattaID;
  }

  /**
   * Getter for the regatta's name.
   * @return regatta's name, represented as a String.
   */
  public String getRegattaName() {
    return regattaName;
  }

  /**
   * Getter for the country of the regatta.
   * @return country, represented as a String.
   */
  public String getCountry() {
    return country;
  }

  /**
   * Getter for the staring point of the regatta.
   * @return starting point, represented as a String.
   */
  public String getStartingPoint() {
    return startingPoint;
  }

  /**
   * Getter for the end point of the regatta.
   * @return end points, represented as a String.
   */
  public String getStoppingPoint() {
    return stoppingPoint;
  }

  /**
   * Getter for teh duration of the regatta, in miles.
   * @return mileage of the regatta, represented as Doubles.
   */
  public Double getMileageDuration() {
    return mileageDuration;
  }

  /**
   * Getter for the date of the regatta.
   * @return date of the regatta, represented as LocalDate.
   */
  public LocalDate getDateOfEvent() {
    return dateOfEvent;
  }

  /**
   * Getter for the regatta level.
   * @return regatta level, represented as custom data type RegattaLevel.
   */
  public RegattaLevel getRegattaLevel() {
    return regattaLevel;
  }

  /**
   * Getter for a Boolean flag indicating if the regatta is an annual event.
   * @return Boolean true if the regatta is an annual event.
   */
  public Boolean getAnnualEvent() {
    return annualEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Regatta regatta = (Regatta) o;
    return Objects.equals(regattaID, regatta.regattaID) && Objects.equals(
        regattaName, regatta.regattaName) && Objects.equals(country, regatta.country)
        && Objects.equals(startingPoint, regatta.startingPoint) && Objects.equals(
        stoppingPoint, regatta.stoppingPoint) && Objects.equals(mileageDuration,
        regatta.mileageDuration) && Objects.equals(dateOfEvent, regatta.dateOfEvent)
        && regattaLevel == regatta.regattaLevel && Objects.equals(annualEvent,
        regatta.annualEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regattaID, regattaName, country, startingPoint, stoppingPoint,
        mileageDuration, dateOfEvent, regattaLevel, annualEvent);
  }

  @Override
  public String toString() {
    return "Regatta{" +
        "regattaID='" + regattaID + '\'' +
        ", regattaName='" + regattaName + '\'' +
        ", country='" + country + '\'' +
        ", startingPoint='" + startingPoint + '\'' +
        ", stoppingPoint='" + stoppingPoint + '\'' +
        ", mileageDuration=" + mileageDuration +
        ", dateOfEvent=" + dateOfEvent +
        ", regattaLevel=" + regattaLevel +
        ", annualEvent=" + annualEvent +
        '}';
  }
}
