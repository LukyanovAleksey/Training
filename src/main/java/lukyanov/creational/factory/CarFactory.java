package lukyanov.creational.factory;

import lukyanov.creational.factory.car.*;

import java.util.HashMap;

public class CarFactory {
    private HashMap map;

    CarFactory() {
        this.map = new HashMap();
        map.put(CarType.LADA, new LadaCar());
        map.put(CarType.MERCEDES, new MercedesCar());
        map.put(CarType.FERRARI, new FerrariCar());
    }

    public Car createCar(CarType type) {
        return (Car) map.get(type);
    }
}
