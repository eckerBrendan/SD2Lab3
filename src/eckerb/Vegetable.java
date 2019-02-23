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
 * A class that extends the produce class.
 * Stores the sell by date, price, and type.
 *
 * @author Brendan Ecker
 * @version 1
 */
public class Vegetable extends Produce {
    private static final int MINIMUM_DAYS_TO_SELL = 5;

    private enum VeggieType {
        UNKNOWN, LEAFY_VEGETABLE, PODDED_VEGETABLE,
        STEM_VEGETABLE, ROOT_VEGETABLE, SEA_VEGETABLE
    }

    private final VeggieType veggieType;

    /**
     * Constructor
     *
     * @param name        Name of the vegetable
     * @param weight      Total weight of the vegetable
     * @param harvestDate Date on which the vegetable was harvested
     */
    public Vegetable(String name, double weight, LocalDate harvestDate) {
        super(name, weight, harvestDate);
        veggieType = setType(name);
    }

    /**
     * Returns the last date on which this product can be sold
     *
     * @return the last date on which this product can be sold
     */
    @Override
    public LocalDate getSellByDate() {
        double sellByFactor = 1.0;
        switch (veggieType) {
            case SEA_VEGETABLE:
                sellByFactor = 1.2;
                break;
            case PODDED_VEGETABLE:
            case STEM_VEGETABLE:
                sellByFactor = 1.5;
                break;
            case ROOT_VEGETABLE:
                sellByFactor = 4.0;
                break;
        }
        return getHarvestDate().plus((long) (MINIMUM_DAYS_TO_SELL * sellByFactor),
                ChronoUnit.DAYS);
    }

    /**
     * Determines the type of vegetable based on the name of the vegetable
     *
     * @param name the name of the vegetable
     * @return the type of vegetable based on the name of the vegetable
     */
    private VeggieType setType(String name) {
        VeggieType type = VeggieType.UNKNOWN;
        switch (name.toLowerCase()) {
            case "lettuce":
            case "spinach":
            case "mustard greens":
            case "collard greens":
                type = VeggieType.LEAFY_VEGETABLE;
                break;
            case "peas":
            case "green beans":
            case "snow peas":
                type = VeggieType.PODDED_VEGETABLE;
                break;
            case "asparagus":
            case "broccoli":
            case "celery":
                type = VeggieType.STEM_VEGETABLE;
                break;
            case "sweet potato":
            case "beet":
            case "yam":
                type = VeggieType.ROOT_VEGETABLE;
                break;
            case "kelp":
            case "kombu":
            case "nori":
                type = VeggieType.SEA_VEGETABLE;
                break;
        }
        return type;
    }

    /**
     * Calculates the price of the vegetables.
     *
     * @return the total amount of the all
     * vegetables per kg.
     */
    public double price() {
        switch (veggieType) {
            case SEA_VEGETABLE:
                return 20 * getWeightInKg();

            case PODDED_VEGETABLE:
                return 2 * getWeightInKg();

            case STEM_VEGETABLE:
                return 1.50 * getWeightInKg();

            case ROOT_VEGETABLE:
                return 0.30 * getWeightInKg();

            default:
                return getWeightInKg();
        }
    }
}
