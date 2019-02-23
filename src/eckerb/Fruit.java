/*
 * CS1021 - 051
 * Winter 2018-2019
 * Lab 3 - Interfaces
 * Name: Brendan Ecker
 * Created: 12/13/2018
 */
package eckerb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The fruit class that extends the produce, that
 * gets the fruit type
 *
 * @author Brendan Ecker
 * @version 1
 */
public class Fruit extends Produce {

    double randNum = Math.random();
    double randFruitTax;

    private static final int MINIMUM_DAYS_TO_SELL = 20;

    private enum FruitType {UNKNOWN, FLESHY, STONE, AGGREGATE}

    private final FruitType fruitType;
    private int quantity;

    /**
     * Constructor
     *
     * @param name        Name of the fruit
     * @param weight      Total weight of the fruit
     * @param harvestDate Date on which the fruit was harvested
     * @param quantity    The amount of each fruit
     */
    public Fruit(String name, double weight, LocalDate harvestDate, int quantity) {
        super(name, weight, harvestDate);
        fruitType = setType(name);
        this.quantity = quantity;
        randFruitTax = randNum * (2.00 - 0.10) - 0.10;
    }

    /**
     * Returns the last date on which this product can be sold
     *
     * @return the last date on which this product can be sold
     */
    @Override
    public LocalDate getSellByDate() {
        int daysToSell = fruitType == FruitType.STONE
                ? (int) (1.5 * MINIMUM_DAYS_TO_SELL)
                : MINIMUM_DAYS_TO_SELL;
        return getHarvestDate().plus(daysToSell, ChronoUnit.DAYS);
    }

    /**
     * Determines the type of fruit based on the name of the fruit
     *
     * @param name the name of the fruit
     * @return the type of fruit based on the name of the fruit
     */
    private FruitType setType(String name) {
        FruitType type = FruitType.UNKNOWN;
        switch (name.toLowerCase()) {
            case "apple":
            case "pear":
            case "orange":
            case "banana":
            case "grape":
                type = FruitType.FLESHY;
                break;
            case "peach":
            case "plum":
            case "mango":
                type = FruitType.STONE;
                break;
            case "strawberries":
            case "blackberries":
            case "grapes":
                type = FruitType.AGGREGATE;
                break;
        }
        return type;
    }

    /**
     * String representation of the fruit
     *
     * @return String representation of the fruit
     */
    @Override
    public String toString() {
        return "Quantity: " + quantity + " of " + super.toString();
    }

    /**
     * Calculates the price for differnt types of fruit.
     *
     * @return the price of the total amount of fruit.
     */
    public double price() {
        double price = 0;
        switch (fruitType) {
            case STONE:
                price += 0.50 * quantity;

            case FLESHY:
                price += 0.80 * quantity;

            case AGGREGATE:
                price += 2.30 * getWeightInKg();

            case UNKNOWN:
                price += randFruitTax * quantity;
        }
        return price;
    }
}

