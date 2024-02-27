package problem2;

import java.util.Objects;

public class Superhero {

  private static final Double COMBAT_POWER_LIMIT = 0.0;
  private static final Double MIN_WEALTH_LEVEL = 0.0;
  private static final Double MAX_WEALTH_LEVEL = 100.0;
  protected Name name;
  protected Integer age;
  protected Double combatPower;
  protected Double healthLevel;
  protected Double wealthLevel;

  /**
   * Constructs a new Superhero with specified name, age, combat power, and wealth level.
   * Initializes health level to 100.0. Validates the combat power and wealth level to ensure
   * they meet the defined criteria; combat power must be greater than 0.0, and wealth level
   * must be within the range of 0.0 to 100.0. If the validations fail, appropriate exceptions
   * are thrown.
   *
   * @param name the name of the superhero, encapsulated in a Name object
   * @param age the age of the superhero as an Integer
   * @param combatPower the combat power of the superhero as a Double, must be greater than 0.0
   * @param wealthLevel the wealth level of the superhero as a Double, must be within 0.0 to 100.0
   * @throws CombatPowerException if the combat power is below the allowed limit
   * @throws WealthLevelException if the wealth level is outside the allowed range
   */
  public Superhero(Name name, Integer age, Double combatPower, Double wealthLevel)
      throws CombatPowerException, WealthLevelException {
    if(this.validateCombatPower(combatPower) && this.validateWealthLevel(wealthLevel)) {
      this.name = name;
      this.age = age;
      this.combatPower = combatPower;
      this.wealthLevel = wealthLevel;
      this.healthLevel = 100.0;
    }
  }

  private Boolean validateCombatPower(Double combatPower) throws CombatPowerException {
    if (combatPower > COMBAT_POWER_LIMIT)
      return Boolean.TRUE;
    else throw new CombatPowerException("Invalid combat power limit");
  }

  private Boolean validateWealthLevel(Double wealthLevel) throws WealthLevelException {
    if ((wealthLevel >= MIN_WEALTH_LEVEL) && (wealthLevel <= MAX_WEALTH_LEVEL))
      return Boolean.TRUE;
    else throw new WealthLevelException("Invalid wealth level");
  }

  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Double getCombatPower() {
    return combatPower;
  }

  public Double getHealthLevel() {
    return healthLevel;
  }

  public Double getWealthLevel() {
    return wealthLevel;
  }

  //YOUR CODE HERE
  public void decreaseHealthLevel(Double healthLevel) throws HealthLevelException {
    if(healthLevel < 0) throw new HealthLevelException("Input HealthLevel must bigger than 0!");

    double newHealthLevel = this.healthLevel - healthLevel;
    if(newHealthLevel < 0) throw new HealthLevelException("Input decrease value is too much!");
    this.healthLevel = newHealthLevel;
  }


  /**
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameCharacter that = (GameCharacter) o;
    return Objects.equals(name, that.name) && Objects.equals(age, that.age)
        && Objects.equals(combatPower, that.combatPower) && Objects.equals(
        healthLevel, that.healthLevel) && Objects.equals(wealthLevel, that.wealthLevel);
  }
  */

  @Override
  public int hashCode() {
    return Objects.hash(name, age, combatPower, healthLevel, wealthLevel);
  }

  @Override
  public String toString() {
    return "GameCharacter{" +
        "name=" + name +
        ", age=" + age +
        ", combatPower=" + combatPower +
        ", healthLevel=" + healthLevel +
        ", wealthLevel=" + wealthLevel +
        '}';
  }
}
