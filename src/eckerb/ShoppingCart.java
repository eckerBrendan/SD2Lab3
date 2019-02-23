/*
 * CS1021 - 051
 * Winter 2018-2019
 * Lab 3 - Interfaces
 * Name: Brendan Ecker
 * Created: 12/13/2018
 */
package eckerb;

import java.util.ArrayList;

/**
 * This class has an arraylist of all
 * items that are added to the cart
 * and gets the price of the whole cart
 * and the tax of the whole cart.
 */
public class ShoppingCart {
    ArrayList<Sellable> cart = new ArrayList<>();

    /**
     * Constructor
     */
    public ShoppingCart(){
    }

    /**
     *  This method adds a sellable to the cart.
     *
     * @param item  Any type of sellable that is
     *              added to the cart.
     */
    public void add(Sellable item){
        cart.add(item);
    }

    /**
     * Calculates the total cost of all of the items
     * in the cart.
     *
     * @return  The total price.
     */
    public double cost(){
        double totalPrice = 0;
        for (int i = 0; i < cart.size(); i++){
            totalPrice += cart.get(i).price();
        }
        return totalPrice;
    }

    /**
     * Calculates the total tax on the cart.
     *
     * @return The total amount of tax.
     */
    public double taxDue(){
        double totalTax = 0;
        for(int i = 0; i<cart.size(); i++){
            totalTax += cart.get(i).tax();
        }
        return totalTax;
    }



}
