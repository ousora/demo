package com.ddrent;

/**
 * Cars for carries and passengers class
 */
class PicaCar extends Car implements IQuantity, ICarrie{
    private int quantity;
    private int carrie;
    PicaCar(String name, int price, int quantity, int carrie) {
        super(name, price);
        this.quantity = quantity;
        this.carrie = carrie;
    }
    /**
     * get car passenger quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * get car carrie tons
     * @return
     */
    public int getCarrie() {
        return carrie;
    }
}
