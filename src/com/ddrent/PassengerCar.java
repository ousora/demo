package com.ddrent;

/**
 * Cars only for passengers class
 */
class PassengerCar extends Car implements IQuantity{
    private int quantity;
    PassengerCar(String name, int price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }
    /**
     * get car passenger quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

}
