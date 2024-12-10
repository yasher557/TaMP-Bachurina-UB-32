package PR4.PR4;

public abstract class Car {
    protected String model;
    protected int weight;
    protected int speed;

    public Car(String model, int weight, int speed) {
        this.model = model;
        this.weight = weight;
        this.speed = speed;
    }

    public void SetModel(String model) {
        this.model = model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public abstract int count_rent();
    public abstract int count_expnese();

    public int count_rent(int hours) {
        int gas_price = 58;
        return (count_rent() + count_expnese() * gas_price) * hours;
    }

    @Override
    public String toString() {
        return "Модель: " + model + "\nВес: " + weight + "\nСкорость: " + speed + "\nАренда в час: " + count_rent() +
                "\nЗатраты топлива в час: " + count_expnese();
    }
}

