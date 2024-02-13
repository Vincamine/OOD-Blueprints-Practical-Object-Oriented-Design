package problem1;

import java.util.Date;
import java.util.Objects;

/*
 * MarineMammal class encodes relevant information 
 *about states and behavior of a single marine 
 *mammal encountered in the Juan de Fuca Strait.
 */
public class MarineMammal {

  private String mammalName;
  private Date sightingDate;
  private String sightingLocation;
  private Double height;
  private Double length;
  private Double weight; //mass
  private MarineMammalGroup mammalGroup;

  /*
   * Constructs a new object MarineMammal 
   based on the provided input arguments
   * @param mammalName - unique mammal name
   * @param sightingDate - date of the sighting, 
   							as a Date
   * @param sightingLocation - location of the 
   *						sighting, as a String
   * @param height - a mammal's height, as a Double
   * @param length - a mammal's length, as a Double
   * @param weight - a mammal's weight, as a Double
   * @param mammalGroup - a group that a mammal 
   *belongs to, represented as an 
   *enum MarineMammalGroup
   */
  public MarineMammal(String mammalName,
      Date sightingDate,
      String sightingLocation,
      Double height,
      Double length, Double weight,
      MarineMammalGroup mammalGroup) {
    this.mammalName = mammalName;
    this.sightingDate = sightingDate;
    this.sightingLocation = sightingLocation;
    this.height = height;
    this.length = length;
    this.weight = weight;
    this.mammalGroup = mammalGroup;
  }

  /*
   * @return - mammal's unique name, as a String
   */
  public String getMammalName() {
    return mammalName;
  }

  /*
   * @return - the sighting date of a mammal (Date)
   */
  public Date getSightingDate() {
    return sightingDate;
  }

  /*
   * @return - the sighting location of a mammal
   */
  public String getSightingLocation() {
    return sightingLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MarineMammal that)) {
      return false;
    }
    return Objects.equals(mammalName, that.mammalName) && Objects.equals(
        sightingDate, that.sightingDate) && Objects.equals(sightingLocation,
        that.sightingLocation) && Objects.equals(height, that.height)
        && Objects.equals(length, that.length) && Objects.equals(weight,
        that.weight) && mammalGroup == that.mammalGroup;
  }

  @Override
  public int hashCode() {
    return Objects.hash(mammalName, sightingDate, sightingLocation, height, length, weight,
        mammalGroup);
  }
}
