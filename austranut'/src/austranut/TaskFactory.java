/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package austranut;

/**
 *
 * @author ss
 */
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        try {
            LocalTime start = LocalTime.parse(startTime);
            LocalTime end = LocalTime.parse(endTime);
            return new Task(description, start, end, priority);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error: Invalid time format.");
        }
    }
}
