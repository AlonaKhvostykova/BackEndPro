package lesson02_2106.practice;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    findTaskById();
                    break;
                case 3:
                    findTasksByTitle();
                    break;
                case 4:
                    deleteTaskById();
                    break;
                case 5:
                    updateTaskDescription();
                    break;
                case 6:
                    displayAllTasks();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTask Manager");
        System.out.println("1. Add new task");
        System.out.println("2. Find task by ID");
        System.out.println("3. Find tasks by title");
        System.out.println("4. Delete task by ID");
        System.out.println("5. Update task description");
        System.out.println("6. Display all tasks");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        taskManager.addTask(title, description);
        System.out.println("Task added.");
    }

    private static void findTaskById() {
        System.out.print("Enter task ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Task> task = taskManager.findTaskById(id);
        task.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Task not found.")
        );
    }

    private static void findTasksByTitle() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        List<Task> tasks = taskManager.findTasksByTitle(title);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found with that title.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private static void deleteTaskById() {
        System.out.print("Enter task ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (taskManager.deleteTaskById(id)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void updateTaskDescription() {
        System.out.print("Enter task ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();
        if (taskManager.updateTaskDescription(id, newDescription)) {
            System.out.println("Task updated.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void displayAllTasks() {
        List<Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.forEach(System.out::println);
        }
    }
}
