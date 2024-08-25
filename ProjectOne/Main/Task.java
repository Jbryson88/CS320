/*
 * Copyright (c) 2024 John Bryson
 */

public class Task {

    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 50;
    private static final String DEFAULT_ID = "INITIAL";
    private static final String DEFAULT_NAME = "INITIAL";
    private static final String DEFAULT_DESCRIPTION = "INITIAL DESCRIPTION";

    private final String taskId;
    private String name;
    private String description;

    // Default constructor
    public Task() {
        this.taskId = DEFAULT_ID;
        this.name = DEFAULT_NAME;
        this.description = DEFAULT_DESCRIPTION;
    }

    // Constructor with taskId
    public Task(String taskId) {
        this.taskId = validateTaskId(taskId);
        this.name = DEFAULT_NAME;
        this.description = DEFAULT_DESCRIPTION;
    }

    // Constructor with taskId and name
    public Task(String taskId, String name) {
        this.taskId = validateTaskId(taskId);
        this.name = validateName(name);
        this.description = DEFAULT_DESCRIPTION;
    }

    // Constructor with taskId, name, and description
    public Task(String taskId, String name, String description) {
        this.taskId = validateTaskId(taskId);
        this.name = validateName(name);
        this.description = validateDescription(description);
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters with validation
    protected void setName(String name) {
        this.name = validateName(name);
    }

    protected void setDescription(String description) {
        this.description = validateDescription(description);
    }

    // Validation methods
    private String validateTaskId(String taskId) {
        if (taskId == null || taskId.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Task ID must be non-null and no longer than " + MAX_ID_LENGTH + " characters.");
        }
        return taskId;
    }

    private String validateName(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Task name must be non-null and no longer than " + MAX_NAME_LENGTH + " characters.");
        }
        return name;
    }

    private String validateDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Task description must be non-null and no longer than " + MAX_DESCRIPTION_LENGTH + " characters.");
        }
        return description;
    }
}
