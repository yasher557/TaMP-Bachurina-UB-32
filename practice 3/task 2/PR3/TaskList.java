package PR3;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void delTask(int idx) {
        tasks.remove(idx);
    }

    public void editTask(int idx, String newTitle) {
        Task t = tasks.get(idx);
        t.setTitle(newTitle);
    }

    public void getTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\nТут пока ничего нет\n");
        } else {
            int number = 1;
            for (Task task : tasks) {
                System.out.println(number + ". " + task);
                number += 1;
            }
        }
    }

    public void cmd() {
        System.out.println(
                "add — добавить задачу\n" +
                        "edit num — изменить задачу.\n" +
                        "del num — удалить задачу. num — номер задачи\n" +
                        "\tnum — номер задачи");
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Task task : tasks) {
            out.append(task);
            out.append("\n");
        }
        return out.toString();
    }
}