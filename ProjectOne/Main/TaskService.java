/*
 * Copyright (c) 2024 John Bryson
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {

    private final List<Task> taskList = new ArrayList<>();

    // Generates a new unique ID with a maximum length of 10 characters
    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    // Searches for a task by ID
    private Task findTaskById(String id) throws Exception {
        for (Task task : taskList) {
            if (task.getTaskId().equals(id)) {
                return task;
            }
        }
        throw new Exception("The Task does not exist!");
    }

    // Method to add a new task with default values
    public void addTask() {
        Task task = new Task(generateUniqueId());
        taskList.add(task);
    }

    // Method to add a new task with a name
    public void addTask(String name) {
        Task task = new Task(generateUniqueId(), name);
        taskList.add(task);
    }

    // Method to add a new task with a name and description
    public void addTask(String name, String description) {
        Task task = new Task(generateUniqueId(), name, description);
        taskList.add(task);
    }

    // Method to delete a task by ID
    public void deleteTask(String id) throws Exception {
        Task task = findTaskById(id);
        taskList.remove(task);
    }

    // Method to update the name of a task by ID
    public void updateTaskName(String id, String name) throws Exception {
        Task task = findTaskById(id);
        task.setName(name);
    }

    // Method to update the description of a task by ID
    public void updateTaskDescription(String id, String description) throws Exception {
        Task task = findTaskById(id);
        task.setDescription(description);
    }

    // Returns a copy of the task list
    public List<Task> getTaskList() {
        return new ArrayList<>(taskList);
    }
}
