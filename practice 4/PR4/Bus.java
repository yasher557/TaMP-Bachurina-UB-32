package PR4.PR4;

public class Bus extends Car {

    private int capacity;
    private int comfort;

    public Bus(String model, int weight, int speed, int capacity, int comfort) {
        super(model, weight, speed);
        this.capacity = capacity;
        this.comfort = comfort;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    public int getComfort() {
        return comfort;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int count_rent() {
        return 15 * capacity * comfort;
    }

    @Override
    public int count_expnese() {
        return speed/50 * 10;
    }
}
