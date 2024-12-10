package PR3;
import java.util.Scanner;

public class Main {
    static TaskList tasks = new TaskList();

    public static void main(String[] args) {
        System.out.println("Вот ваш список дел: ");
        tasks.getTasks();
        System.out.println("для просмотра списка команд введите \"cmd\": ");

        get_cmd();
    }

    public static void get_cmd() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] cmd_elems = input.split(" ");
        String command = null;
        int number = 0;

        switch (cmd_elems.length) {
            case 2:
                try {
                    number = Integer.parseInt(cmd_elems[1]) - 1;
                } catch(NumberFormatException e) {
                    System.out.println("Вы где-то ошиблись. Попробуйте снова: ");
                    get_cmd();
                }
                if (number < 0) {
                    System.out.println("Вы указали неверный номер. Попробуйте снова: ");
                    get_cmd();
                    break;
                }
            case 1:
                command = cmd_elems[0];
                break;
            default:
                System.out.println("Что-то пошло не так. Попробуйте снова: ");
                get_cmd();
                break;
        }

        switch (command) {
            case "add":
                System.out.println("Введите текст задания: ");
                String new_task = scanner.nextLine();
                tasks.addTask(new Task(new_task));
                tasks.getTasks();
                get_cmd();
                break;
            case "del":
                tasks.delTask(number);
                tasks.getTasks();
                get_cmd();
                break;
            case "edit":
                System.out.println("Введите текст задания: ");
                String new_title = scanner.nextLine();
                tasks.editTask(number, new_title);
                tasks.getTasks();
                get_cmd();
                break;
            case "cmd":
                tasks.cmd();
                get_cmd();
                break;
            default:
                System.out.println("Что-то пошло не так. Попробуйте снова: ");
                get_cmd();
                break;
        }
    }
}

