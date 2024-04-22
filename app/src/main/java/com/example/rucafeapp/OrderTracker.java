/**
 * @Author: Jack Zhong and Mathew Jojy
 */
package com.example.rucafeapp;

/**
 * OrderTracker class that keeps track of all orders
 */
public class OrderTracker {
    private static Order currentOrder;
    private static Order[] allOrders;
    private static int orderCount;

    /**
     * Constructor for OrderTracker
     */
    public OrderTracker(){
        currentOrder = new Order(0);
        allOrders = new Order[1];
        orderCount = 0;
    }
    /**
     * Increases the size of the allOrders array by 1
     */
    private static void grow(){
        Order[] newAllOrders = new Order[allOrders.length + 1];
        for(int i = 0; i < allOrders.length; i++){
            newAllOrders[i] = allOrders[i];
        }
        allOrders = newAllOrders;
    }

    /**
     * Main method that runs the OrderTracker
     */
    public void run(){
        OrderTracker tracker = new OrderTracker();
    }

    /**
     * Adds a donut to the current order
     *
     * @param flavor flavor of the donut
     * @param price  price of the donut
     */
    public static void addDonut(String flavor, double price,int image){
        Donut donut = new Donut(flavor, price,image);
        currentOrder.add(donut);
    }

    /**
     * Adds a coffee to the current order
     *
     * @param size   size of the coffee
     * @param addOns add-ons for the coffee
     * @param price  price of the coffee
     */
    public static void addCoffee(String size, String[] addOns, double price){
        Coffee coffee = new Coffee(size, addOns, price);
        currentOrder.add(coffee);
    }

    /**
     * Adds a sandwich to the current order
     *
     * @param bread   bread of the sandwich
     * @param protein protein of the sandwich
     * @param addOns  add-ons for the sandwich
     * @param price   price of the sandwich
     */
    public static void addSandwich(String bread, String protein, String[] addOns, double price){
        Sandwich sandwich = new Sandwich(bread, protein, addOns, price);
        currentOrder.add(sandwich);
    }

    /**
     * Removes an item from the current order
     *
     * @param item item to be removed
     */
    public static void removeItem(MenuItem item){
        currentOrder.remove(item);
    }

    /**
     * Returns the current order number
     *
     * @return current order number
     */
    public static int getCurrentOrderNumber(){
        return currentOrder.getOrderNumber();
    }

    /**
     * Places the current order into the allOrders array
     */
    public static void placeOrder(){
        if(orderCount == allOrders.length){
            grow();
        }
        allOrders[orderCount++] = currentOrder;
        currentOrder = new Order(currentOrder.getOrderNumber() + 1);
    }

    /**
     * Removes an order from the allOrders array
     *
     * @param orderNumber order number of the order to be removed
     */
    public static void removeOrder(int orderNumber){
        for(int i = 0; i < orderCount; i++){
            if(allOrders[i].getOrderNumber() == orderNumber){
                allOrders[i] = null;
                for(int j = i; j < orderCount - 1; j++){
                    allOrders[j] = allOrders[j + 1];
                }
                orderCount--;
                break;
            }
        }
    }

    /**
     * Returns all orders
     *
     * @return all orders
     */
    public static Order[] getAllOrders(){
        return allOrders;
    }

    /**
     * Returns the current order
     *
     * @return current order
     */
    public static Order getCurrentOrder(){
        return currentOrder;
    }

    /**
     * Returns the order numbers of all orders
     *
     * @return order numbers of all orders
     */
    public static int[] getOrderNumbers(){
        int[] orderNumbers = new int[orderCount];
        for(int i = 0; i < orderCount; i++){
            orderNumbers[i] = allOrders[i].getOrderNumber();
        }
        return orderNumbers;
    }

    /**
     * Returns an order with a specific order number
     *
     * @param orderNumber order number of the order
     * @return order with the specific order number
     */
    public static Order getOrder(int orderNumber){
        for(int i = 0; i < orderCount; i++){
            if(allOrders[i].getOrderNumber() == orderNumber){
                return allOrders[i];
            }
        }
        return null;
    }

    /**
     * Returns the number of orders
     *
     * @return number of orders
     */
    public static int getOrderCount(){
        return orderCount;
    }

    /**
     * Prints all orders
     *
     * @return all orders
     */
    public static String printAllOrders(){
        String allOrdersString = "";
        for(int i = 0; i < orderCount; i++){
            allOrdersString += allOrders[i] + "\n";
        }
        return allOrdersString;
    }
}
