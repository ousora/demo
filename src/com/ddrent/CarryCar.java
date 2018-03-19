package com.ddrent;

/**
 * Cars only for carries class
 */
class CarryCar extends Car implements ICarrie{
    private int carrie;
    CarryCar(String name, int price, int carrie) {
        super(name, price);
        this.carrie = carrie;
    }

    /**
     * get car carrie tons
     * @return
     */
    public int getCarrie() {
        return carrie;
    }

}
