package PR4.PR4;

import java.util.ArrayList;

public class Park {
    private ArrayList<Car> cars;

    public Park() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getCar(int idx) {
        return cars.get(idx);
    }

    public Car cheapestTruck() {
        int cheapest = Integer.MAX_VALUE;
        Car out = null;
        for (Car car : cars) {
            if (car instanceof Truck) {
                int cost = car.count_rent();
                if (cost < cheapest) {
                    cheapest = cost;
                    out = car;
                }
            }
        }
        return out;
    }

    public Car fastestBus() {
        int fastest = 0;
        Car out = null;
        for (Car car : cars) {
            if (car instanceof Bus) {
                int speed = car.getSpeed();
                if (speed > fastest) {
                    fastest = speed;
                    out = car;
                }
            }
        }
        return out;
    }

    public Car getByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }
}

