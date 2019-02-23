/*
 * CS1021 - 051
 * Winter 2018-2019
 * Lab 3 - Interfaces
 * Name: Brendan Ecker
 * Created: 12/13/2018
 */
package eckerb;

/**
 * This is an interface for the classes
 * Produce and Beverage.
 */
public interface Sellable {
    /**
     * The amount of tax that the Milwaukee county charges.
     */
    public static final double MKE_COUNTY_TAX_RATE = 0.005;
    /**
     * The amount of tax that the state of Wisconsin charges.
     */
    public static final double WI_STATE_TAX_RATE = 0.05;

    /**
     * An abstract method that allows the classes that
     * implemented Sellable can use.
     *
     * @return nothing.
     */
    public double price();

    /**
     * An abstract method that allows the classes
     * that implemented Sellable to use.
     *
     * @return nothing.
     */
    public double tax();
}



