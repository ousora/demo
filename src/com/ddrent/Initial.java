package com.ddrent;
import java.util.*;
/**
 * Initialize class
 */
public class Initial {
    private HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    private Scanner scan = new Scanner(System.in);
    private void inz(){
        // set up cars for rent
        cars.put(1, new PassengerCar("奥迪A4",500,4));
        cars.put(2, new PassengerCar("马自达6",400,4));
        cars.put(3, new PicaCar("皮卡雪6",450, 4,2));
        cars.put(4, new PassengerCar("金龙",800,20));
        cars.put(5, new CarryCar("松花江",400,4));
        cars.put(6, new CarryCar("依维柯",1000,20));
    }

    private void Process() {
        inz();
        int input;
        do {
            System.out.println("欢迎使用答答租车系统：\n您是否要租车：1是 0否");
            if ((input = getInput( )) == 0) return;
        }while (input != 1);

        listCars();
        do {
            System.out.println("请输入您要租汽车的数量：");
            if ((input = getInput( )) == 0) return;
        }while (input < 0);

        int[] choices = new int[input];
        for (int i = 0; i < input; i++) {
            System.out.println("请输入第" + (i + 1) + "辆车的序号:");
            if ((choices[i] = getInput()) == -1) --i;
        }

        int days;
        do {
            System.out.println("请输入租车天数:");
            if ((days = getInput( )) == 0) return;
        }while (days < 0);
        listBill(days, choices);
    }

    private void listCars(){
        System.out.println("您可租车的类型及其价目表：\n序号\t汽车名称\t租金\t容量");
        cars.forEach((i, car) ->{
            System.out.print(String.valueOf(i) + '\t' + car.getName() + '\t' + Integer.toString(car.getPrice()) +"/天\t");
            if(car instanceof CarryCar) System.out.println("载货：" + ((CarryCar) car).getCarrie()+ "吨");
            if(car instanceof PassengerCar) System.out.println("载人：" + ((PassengerCar) car).getQuantity()+ "人");
            if(car instanceof PicaCar) System.out.println("载人：" + ((PicaCar) car).getQuantity() + "人 载货：" + ((PicaCar) car).getCarrie()+ "吨");
        });
    }

    private void listBill(int days, int[] choices){
        int totalPrice = 0, totalPeople = 0, totalCarry = 0;
        StringBuilder passengerCars = new StringBuilder();
        StringBuilder carryCars = new StringBuilder();

        for (int choice : choices) {
            try {
                totalPrice += cars.get(choice).getPrice( );
            }catch (Exception e){
                System.out.println("无效的选项" + String.valueOf(choice) + "已忽略");
                continue;
            }
            if (cars.get(choice) instanceof PassengerCar) {
                passengerCars.append(cars.get(choice).getName( )).append(' ');
                totalPeople += ((PassengerCar) cars.get(choice)).getQuantity();
            }
            if (cars.get(choice) instanceof CarryCar) {
                carryCars.append(cars.get(choice).getName( )).append(' ');
                totalCarry += ((CarryCar) cars.get(choice)).getCarrie();
            }
            if (cars.get(choice) instanceof PicaCar) {
                passengerCars.append(cars.get(choice).getName( )).append(' ');
                carryCars.append(cars.get(choice).getName( )).append(' ');
                totalPeople += ((PicaCar) cars.get(choice)).getQuantity();
                totalCarry += ((PicaCar) cars.get(choice)).getCarrie();
            }
        }
        totalPrice *= days;
        System.out.println("您的账单：");
        if (passengerCars.length() != 0) System.out.println("***可载人的车有：\n " + passengerCars + " 共载人：" + totalPeople + "人");
        if (carryCars.length() != 0) System.out.println("***可载货的车有：\n " + carryCars + " 共载重：" + totalCarry + "吨");
        System.out.println("***租车总天数：" + days +" 租车总价格：" + totalPrice + "元");
    }

    private int getInput(){
        int input;
        try {
            input = scan.nextInt( );
        } catch (Exception e) {
            System.out.println("请输入一个数字");
            scan.next();
            return -1;
        }
        if(input < 0) System.out.println("请不要输入负数");
        return input;
    }

    public static void main(String[] args){
        Initial i1 = new Initial();
        i1.Process();
    }
}