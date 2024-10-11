import java.util.regex.Pattern;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {

        System.out.println("Данная программа проверяет является ли введённая строка десятичным шестизначным числом.");
        Check();
    }
    public static void Check(){
        System.out.println("Введите число для проверки: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        boolean bIsInt = Pattern.matches("^[1-9]\\d{5}$", input);

        if (bIsInt) {
            System.out.println("Да. Вы ввели шестизначное число, и притом, в десятичной системе!");
        } else {
            if (input.charAt(0) == '0') {
                System.out.println("Нет. Вы начали с нуля, а числа с него не начинаются");
            } else {
                try {
                    Integer.parseInt(input);
                    System.out.println("Нет. Вы ввели " + input.length() + " -значное число");
                } catch (NumberFormatException e) {
                    System.out.println("Нет. Десятичные числа состоят только из цифр.");
                }
            }

        }
        OnceAgain();
    }
    public static void OnceAgain() {
        System.out.println("Хотите проверить ещё одно число?\nВведите \"yes\" или \"no\"");
        Scanner scanner = new Scanner(System.in);
        String sOnceAgain = scanner.nextLine();

        switch (sOnceAgain) {
            case ("yes"):
                Check();
            case ("no"):
                System.out.println("Пока-пока!");
                System.exit(0);
            default:
                System.out.println("Вы ввели что-то не то.");
                OnceAgain();
                break;
        }
    }
}
