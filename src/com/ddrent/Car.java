package com.ddrent;
/**
 * car class
 */
public abstract class Car{
    private String name;
    private int price;

    /**
     * constructor
     * @param name car name
     * @param price rent price per day
     */
    Car(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
