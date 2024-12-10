package PR4.PR4;

public class Truck extends Car {

    private int capacity;
    private int cargoWeight;

    public Truck(String model, int weight, int speed, int capacity) {
        super(model, weight, speed);
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    };

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public int count_rent() {
        return capacity * 10;
    }

    @Override
    public int count_expnese() {
        return (cargoWeight + weight) / 100 * 10;
    }

}
