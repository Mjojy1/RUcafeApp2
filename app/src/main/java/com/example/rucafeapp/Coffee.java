/**
 * @Author: Jack Zhong and Mathew Jojy
 */
package com.example.rucafeapp;

/**
 * Coffee class that extends MenuItem
 */
public class Coffee extends MenuItem{
    private double price;
    private String[] addOns;
    private String size;

    /**
     * Constructor for Coffee
     *
     * @param size   size of the coffee
     * @param addOns add-ons for the coffee
     * @param price  price of the coffee
     */
    public Coffee(String size, String[] addOns, double price){
        this.size = size;
        this.addOns = addOns;
        this.price = price;
    }
    /**
     * Returns the add-ons for the coffee
     * @return add-ons for the coffee
     */
    private String getAddOns(){
        String addOnsString = "";
        for(int i = 0; i < addOns.length; i++){
            if(addOns[i] != null)
            {
                addOnsString += addOns[i];
                if(i != addOns.length - 1 && addOns[i + 1] != null){
                    addOnsString += ", ";
                }
            }
        }
        if(addOnsString.equals("")){
            return "no add-ons";
        }
        return addOnsString;
    }
    /**
     * Returns the price of the coffee
     * @return price of the coffee
     */
    @Override
    public Double price() {
        return price;
    }
    /**
     * Returns the string representation of the coffee
     * @return string representation of the coffee
     */
    @Override
    public String toString() {
        return "Coffee {" +
                size + ", "+
                getAddOns() +
                ", price=" + price +
                '}';
    }
}
