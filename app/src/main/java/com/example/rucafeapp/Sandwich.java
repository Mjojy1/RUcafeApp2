/**
 * @Author: Jack Zhong and Mathew Jojy
 */
package com.example.rucafeapp;

/**
 * Sandwich class that extends MenuItem
 */
public class Sandwich extends MenuItem{
    private String bread;
    private String protein;
    private String[] addOns;
    private Double price;

    /**
     * Constructor for Sandwich
     *
     * @param bread   bread of the sandwich
     * @param protein protein of the sandwich
     * @param addOns  add-ons for the sandwich
     * @param price   price of the sandwich
     */
    public Sandwich(String bread, String protein, String[] addOns, double price){
        this.bread = bread;
        this.protein = protein;
        this.addOns = addOns;
        this.price = price;
    }
    /**
     * Returns the price of the sandwich
     * @return price of the sandwich
     */
    @Override
    public Double price() {
        return price;
    }

    /**
     * Returns string representation of the add-ons
     * @return string representation of the add-ons
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
     * Returns the string representation of the sandwich
     * @return string representation of the sandwich
     */
    @Override
    public String toString() {
        return "Sandwich {" +
                bread + ", "+
                protein + 
                ", " + getAddOns() +
                ", price=" + price +
                '}';
    }
}
