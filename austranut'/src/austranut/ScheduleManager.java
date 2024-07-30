/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package austranut;

/**
 *
 * @author ss
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleManager {
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final ScheduleManager INSTANCE = new ScheduleManager();
    }

    public static ScheduleManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (t.getStartTime().isBefore(task.getEndTime()) && task.getStartTime().isBefore(t.getEndTime())) {
                System.out.println("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        Collections.sort(tasks, (t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}


