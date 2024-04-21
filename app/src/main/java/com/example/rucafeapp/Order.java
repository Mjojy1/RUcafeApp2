/**
 * @Author: Jack Zhong and Mathew Jojy
 */
package com.example.rucafeapp;

/**
 * The type Order.
 */
public class Order {
    private int orderNumber;
    private MenuItem[] menuItems;

    /**
     * Constructor for Order
     *
     * @param orderNumber order number
     */
    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        menuItems = new MenuItem[0];
    }

    /**
     * Returns the order number
     *
     * @return order number
     */
    public int getOrderNumber(){
        return orderNumber;
    }

    /**
     * Returns the menu items
     *
     * @return menu items
     */
    public MenuItem[] getMenuItems(){
        return menuItems;
    }
    /**
     * Increases the size of the menuItems array by 1
     */
    private void grow(){
        MenuItem[] newMenuItems = new MenuItem[menuItems.length + 1];
        for(int i = 0; i < menuItems.length; i++){
            newMenuItems[i] = menuItems[i];
        }
        menuItems = newMenuItems;
    }

    /**
     * Adds an item to the menuItems array
     *
     * @param item item to be added
     */
    public void add(MenuItem item){
        if(!contains(item)){
            grow();
            menuItems[menuItems.length - 1] = item;
        }
    }

    /**
     * Removes an item from the menuItems array
     *
     * @param item item to be removed
     */
    public void remove(MenuItem item){
        int index = find(item);
        if(index != -1){
            MenuItem[] newMenuItems = new MenuItem[menuItems.length - 1];
            for(int i = 0, j = 0; i < menuItems.length; i++){
                if(i != index){
                    newMenuItems[j++] = menuItems[i];
                }
            }
            menuItems = newMenuItems;
        }
    }

    /**
     * Calculates the total price of the menuItems array
     *
     * @return total price of the menuItems array
     */
    public Double calculateTotal(){
        double total = 0;
        for(MenuItem item : menuItems){
            total += item.price();
        }
        return total;
    }
    /**
     * Finds the index of an item in the menuItems array
     * @param item item to be found
     * @return index of the item in the menuItems array
     */
    private int find(MenuItem item){
        for(int i = 0; i < menuItems.length; i++){
            if(menuItems[i].equals(item)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Checks if the menuItems array contains an item
     * @param item item to be checked
     * @return true if the menuItems array contains the item, false otherwise
     */
    private boolean contains(MenuItem item){
        return find(item) != -1;
    }

    /**
     * Returns the menuItems array
     *
     * @return menuItems array
     */
    public MenuItem[] getItems(){
        return menuItems;
    }

    /**
     * Calculates the grand total of the menuItems array
     *
     * @return grand total of the menuItems array
     */
    public String calculateGrandTotal(){
        return String.format("%.2f", calculateTotal() * 1.06625);
    }
    /**
     * Returns the string representation of the order
     * @return string representation of the order
     */
    @Override
    public String toString() {
        String items = "";
        for(MenuItem item : menuItems){
            items += item.toString() + "\n";
        }
        return "Order {" +
                "orderNumber=" + orderNumber +
                ", menuItems=\n" + items +
                ", total=" + calculateGrandTotal() +
                '}';
    }
}
