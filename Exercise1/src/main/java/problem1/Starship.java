package problem1;

public class Starship {
    protected Double fuelLevel;
    protected Double destructionLevel;

    private static final Double MIN_LEVEL = 0.0;
    private static final Double MAX_LEVEL = 100.0;

    /*
    public Starship(Double fuelLevel, Double destructionLevel) throws StarshipNotCreatedException{
        if (this.validateDestructionLevel(destructionLevel) && this.validateFuelLevel(fuelLevel)) {
            this.fuelLevel = fuelLevel;
            this.destructionLevel = destructionLevel;
        }
        else throw new StarshipNotCreatedException("Either fuel or destruction levels are not correct!");
    }
    */
    public Starship(){
        this.fuelLevel = MAX_LEVEL;
        this.destructionLevel = MIN_LEVEL;
    }

    public Starship(Double fuelLevel, Double destructionLevel) {
    }

    private Boolean validateFuelLevel(Double fuelLevel){
        return fuelLevel > MIN_LEVEL && (this.fuelLevel + fuelLevel) <= MIN_LEVEL;
    }

    private Boolean validateDestructionLevel(Double destructionLevel){
        return destructionLevel > 0 && (this.fuelLevel + fuelLevel <= MAX_LEVEL);
    }

    public Double changeFuelLevel(Double fuelLevel) throws InvalidFuelLevelException{ // void?
        //can be immutable manner.

        /* basic version
        if(validateFuelLevel(fuelLevel))
            this.fuelLevel += fuelLevel;
        return this.fuelLevel;
        */

        /* Expended version
        if(validateFuelLevel(fuelLevel)){
            this.fuelLevel += fuelLevel;
            return this.fuelLevel;
            }
        else return this.fuelLevel;
         */

        /* More user friendly design
        if(!validateFuelLevel(fuelLevel))
            System.out.println("This fuel level is not valid. Leaving the levels unchanged.");
        else
            this.fuelLevel += fuelLevel;
        return this.fuelLevel;
         */

        if(!validateFuelLevel(fuelLevel))
            throw new InvalidFuelLevelException("Invalid fuel level!");
        else
            this.fuelLevel += fuelLevel;
        return this.fuelLevel;
    }

    public Starship changeDestructionLevel(Double destructionLevel) throws InvalidDestructionLevel {
        if(!validateDestructionLevel(destructionLevel))
            throw new InvalidDestructionLevel("Invalid destruction level!");
        else
            return new Starship(this.fuelLevel,this.destructionLevel + destructionLevel);

    }
}
