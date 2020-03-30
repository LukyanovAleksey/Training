package lukyanov.creational.factory;

import lukyanov.creational.factory.car.CarType;

public class FactoryExample {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        CarType[] garage = {CarType.LADA, CarType.FERRARI, CarType.MERCEDES};

        for (CarType carType : garage) {
            factory.createCar(carType).drive();
        }
    }
}
