package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class representing ingredients and nutritional information of a cookie.
 */
public class Cookie {

    private String name;
    private String[] ingredients;
    private Double quantityPerServing;
    private Double caloriesPerServing;
    private Double sugarPerServing;
    private Double fatPerServing;
    private Double proteinPerServing;
    private Double fiberPerServing;
    private Boolean containsNuts;
    private Boolean containsDairy;
    private Boolean glutenFree;

    /**
     * Constructor for class Cookie.
     * @param name name of the cookie
     * @param ingredients list of ingredients, where each ingredient is represented as a String
     * @param quantityPerServing quantity per serving, represented as Double
     * @param caloriesPerServing calories per serving, represented as Double
     * @param sugarPerServing sugar per serving, represented as Double
     * @param fatPerServing fat per serving, represented as Double
     * @param proteinPerServing protein per serving, represented as Double
     * @param fiberPerServing fiber per serving, represented as Double
     * @param containsNuts Boolean flag, set to True if the cookie contains nuts
     * @param containsDairy Boolean flag, set to True if the cookie contains dairy
     * @param glutenFree Boolean flag, set to True if the cookie is gluten free
     */
    public Cookie(String name, String[] ingredients, Double quantityPerServing,
        Double caloriesPerServing, Double sugarPerServing, Double fatPerServing,
        Double proteinPerServing, Double fiberPerServing, Boolean containsNuts,
        Boolean containsDairy,
        Boolean glutenFree) {
        this.name = name;
        this.ingredients = ingredients;
        this.quantityPerServing = quantityPerServing;
        this.caloriesPerServing = caloriesPerServing;
        this.sugarPerServing = sugarPerServing;
        this.fatPerServing = fatPerServing;
        this.proteinPerServing = proteinPerServing;
        this.fiberPerServing = fiberPerServing;
        this.containsNuts = containsNuts;
        this.containsDairy = containsDairy;
        this.glutenFree = glutenFree;
    }

    /**
     * Getter for the name of the cookie (this name has to be unique).
     * @return name of the cookie, represented as String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the list of ingredients.
     * @return String array, representing all the cookie's ingredients.
     */
    public String[] getIngredients() {
        return ingredients;
    }

    /**
     * Getter for the serving quantity.
     * @return quantity, represented as Double
     */
    public Double getQuantityPerServing() {
        return quantityPerServing;
    }

    /**
     * Getter for calories per serving
     * @return calories, represented as Double
     */
    public Double getCaloriesPerServing() {
        return caloriesPerServing;
    }

    /**
     * Getter for the amount of sugar per serving.
     * @return sugar, represented as Double.
     */
    public Double getSugarPerServing() {
        return sugarPerServing;
    }

    /**
     * Getter for fat per serving.
     * @return far, represented as Double.
     */
    public Double getFatPerServing() {
        return fatPerServing;
    }

    /**
     * Getter for protein per serving.
     * @return protein, represented as Double.
     */
    public Double getProteinPerServing() {
        return proteinPerServing;
    }

    /**
     * Getter for fiber per serving.
     * @return fiber, represented as Double.
     */
    public Double getFiberPerServing() {
        return fiberPerServing;
    }

    /**
     * Getter for a Boolean flag, indicating if the cookie contains nuts.
     * @return Boolean true if the cookie contains nuts.
     */
    public Boolean getContainsNuts() {
        return containsNuts;
    }

    /**
     * Getter for a Boolean flag, indicating if the cookie contains dairy.
     * @return Boolean true if the cookie contains dairy.
     */
    public Boolean getContainsDairy() {
        return containsDairy;
    }

    /**
     * Getter for a Boolean flag, indicating if the cookie is gluten-free.
     * @return Boolean true if the cookie is gluten-free.
     */
    public Boolean getGlutenFree() {
        return glutenFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cookie cookie = (Cookie) o;
        return Objects.equals(name, cookie.name) && Arrays.equals(ingredients,
            cookie.ingredients) && Objects.equals(quantityPerServing, cookie.quantityPerServing)
            && Objects.equals(caloriesPerServing, cookie.caloriesPerServing)
            && Objects.equals(sugarPerServing, cookie.sugarPerServing)
            && Objects.equals(fatPerServing, cookie.fatPerServing) && Objects.equals(
            proteinPerServing, cookie.proteinPerServing) && Objects.equals(fiberPerServing,
            cookie.fiberPerServing) && Objects.equals(containsNuts, cookie.containsNuts)
            && Objects.equals(containsDairy, cookie.containsDairy) && Objects.equals(
            glutenFree, cookie.glutenFree);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, quantityPerServing, caloriesPerServing, sugarPerServing,
            fatPerServing, proteinPerServing, fiberPerServing, containsNuts, containsDairy,
            glutenFree);
        result = 31 * result + Arrays.hashCode(ingredients);
        return result;
    }

    @Override
    public String toString() {
        return "Cookie{" +
            "name='" + name + '\'' +
            ", ingredients=" + Arrays.toString(ingredients) +
            ", quantityPerServing=" + quantityPerServing +
            ", caloriesPerServing=" + caloriesPerServing +
            ", sugarPerServing=" + sugarPerServing +
            ", fatPerServing=" + fatPerServing +
            ", proteinPerServing=" + proteinPerServing +
            ", fiberPerServing=" + fiberPerServing +
            ", containsNuts=" + containsNuts +
            ", containsDairy=" + containsDairy +
            ", glutenFree=" + glutenFree +
            '}';
    }
}
