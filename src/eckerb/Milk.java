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
 * A class that extends the beverage class that
 * gets the type of milk, the brand, the price,
 * and tax.
 *
 * @author Brendan Ecker
 * @version 1
 */
public class Milk extends Beverage {
    private enum FatContent { SKIM, ONE_PERCENT, TWO_PERCENT, WHOLE, HALF_AND_HALF, CREAM}
    private final FatContent fatContent;

    /**
     * Constructor
     * @param volume Total number of fluid ounces
     * @param sellByDate Last date on which this product can be sold
     * @param fatContent A string representing the amount of fat content
     */
    public Milk(double volume, LocalDate sellByDate, String fatContent) {
        super(volume, "milk", sellByDate);
        switch (fatContent.toLowerCase()) {
            case "cream":
                this.fatContent = FatContent.CREAM;
                break;
            case "half and half":
                this.fatContent = FatContent.HALF_AND_HALF;
                break;
            case "2%":
                this.fatContent = FatContent.TWO_PERCENT;
                break;
            case "1%":
                this.fatContent = FatContent.ONE_PERCENT;
                break;
            default:
                this.fatContent = FatContent.SKIM;
        }
    }

    /**
     * Returns a description of the brand name including the fat content
     * @return a description of the brand name including the fat content
     */
    @Override
    public String getBrand() {
        String descriptor = super.getBrand();
        switch (fatContent) {
            case CREAM:
                descriptor = "cream";
                break;
            case HALF_AND_HALF:
                descriptor = "half and half";
                break;
            case WHOLE:
                descriptor = "whole " + descriptor;
                break;
            case TWO_PERCENT:
                descriptor = "2% " + descriptor;
                break;
            case ONE_PERCENT:
                descriptor = "1% " + descriptor;
                break;
            default:
                descriptor = "fat free " + descriptor;
        }
        return descriptor;
    }

    /**
     * Calculates the price of differnt types of milk.
     *
     * @return the price of the milk that was added to the cart.
     */
    public double price(){
        switch(fatContent){
            case HALF_AND_HALF: return 3.0 * (getVolumeInFlOz()/128);

            case CREAM: return 4.50 * (getVolumeInFlOz()/128);

            default: return 2.50 * (getVolumeInFlOz()/128);
        }
    }

    /**
     * Calculated the tax of the milk.
     *
     * @return 0 because there is no tax on milk.
     */
    public double tax(){
        return 0;
    }

}
