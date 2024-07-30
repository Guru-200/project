/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package austranut;

/**
 *
 * @author ss
 */
import java.util.Scanner;

public class AstronautDailyScheduleOrganizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();

        while (true) {
            System.out.println("\nAstronaut Daily Schedule Organizer");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:mm): ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time (HH:mm): ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority: ");
                    String priority = scanner.nextLine();
                    try {
                        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
                        manager.addTask(task);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String taskDescription = scanner.nextLine();
                    manager.removeTask(taskDescription);
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



