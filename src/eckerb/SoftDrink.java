/*
 * CS1021 - 051
 * Winter 2018-2019
 * Lab 3 - Interfaces
 * Name: Brendan Ecker
 * Created: 12/13/2018
 */
package eckerb;
import java.time.LocalDate;

/**
 * This class extends the behavior of the beverage class.
 * This class stores the package type, number of containers,
 * the price, and the tax of the soft drinks.
 *
 * @author Brendan Ecker
 * @version 1
 */
public class SoftDrink extends Beverage {
    /**
     * Package types for soft drinks
     */
    public enum PackageType {
        SINGLE, SIX_PACK, TWELVE_PACK, TWENTYFOUR_PACK
    }
    private double bottleTax = 0.05;
    private double singleFlOzTax = 0.10;
    private double multipleFlOzTax = 0.03125;
    private final PackageType packaging;

    /**
     * Constructor
     *
     * @param volume     Total number of fluid ounces
     * @param brand      The brand name of the beverage
     * @param sellByDate Last date on which this product can be sold
     */
    public SoftDrink(double volume, String brand, LocalDate sellByDate,
                     PackageType packaging) {
        super(volume, brand, sellByDate);
        this.packaging = packaging;
    }

    /**
     * Returns the number of containers that are part of this soft drink object
     *
     * @return the number of containers that are part of this soft drink object
     */
    @Override
    public int getNumberOfContainers() {
        int quantity = 1;
        switch (packaging) {
            case SIX_PACK:
                quantity = 6;
                break;
            case TWELVE_PACK:
                quantity = 12;
                break;
            case TWENTYFOUR_PACK:
                quantity = 24;
                break;
        }
        return quantity;
    }

    /**
     * Calculates the price of the soft drinks.
     *
     * @return the total price of all of the soft drinks.
     */
    public double price() {
        switch (packaging) {
            case SINGLE:
                return singleFlOzTax * getVolumeInFlOz();

            default:
                return multipleFlOzTax * getVolumeInFlOz();

        }
    }

    /**
     * Calculates the total amount of tax of the soft drinks.
     *
     * @return the amount of taxes of all of the soft drink.
     */
    public double tax() {
        double tax = 0;
        tax += price() * WI_STATE_TAX_RATE;
        tax += price() * MKE_COUNTY_TAX_RATE;
        switch (packaging) {
            case SINGLE:
                tax += bottleTax;
            case SIX_PACK:
                tax += bottleTax * 6;
            case TWELVE_PACK:
                tax += bottleTax * 12;
            case TWENTYFOUR_PACK:
                tax += bottleTax * 24;
        }
        return tax;
    }
}
