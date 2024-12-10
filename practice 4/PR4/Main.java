package PR4.PR4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Park park = new Park();
        park.addCar(new Truck("Scania", 18000, 89, 15000));
        park.addCar(new Truck("Volvo", 18000, 90, 12000));
        park.addCar(new Truck("Scania", 18000, 89, 15000));
        park.addCar(new Bus("Volkswagen", 3500, 120, 20, 8));
        park.addCar(new Bus("Iveco", 3500, 130, 20, 7));
        park.addCar(new Bus("Setra", 14000, 100, 50, 9));
        System.out.println("Самый дешёвый грузовик:\n" + park.cheapestTruck());
        System.out.println("\nСамый быстрый автобус:\n" + park.fastestBus());
        findByModel(park);
    }

    public static void findByModel(Park park) {
        System.out.println("\nВведите марку автомобиля:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Car car = park.getByModel(input);
        if (car == null) {
            System.out.println("Машин такой марки не найдено");
            return;
        }
        System.out.println(car);
    }
}
