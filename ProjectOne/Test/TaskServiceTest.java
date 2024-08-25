/*
 * Copyright (c) 2024 John Bryson
 */

 import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    private String id, name, description;
    private String tooLongName, tooLongDescription;

    @BeforeEach
    void setUp() {
        id = "1234567890";
        name = "This is Twenty Chars";
        description = "The task object shall have a required description.";
        tooLongName = "This is way too long to be a task name";
        tooLongDescription = "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
    }

    @Test
    void testNewTask() {
        TaskService service = new TaskService();
        service.newTask();
        assertNotNull(service.getTaskList().get(0).getTaskId(), "Task ID should not be null");
        assertNotEquals("INITIAL", service.getTaskList().get(0).getTaskId(), "Task ID should be unique");
    }

    @Test
    void testNewTaskWithName() {
        TaskService service = new TaskService();
        service.newTask(name);
        assertNotNull(service.getTaskList().get(0).getName(), "Task name should not be null");
        assertEquals(name, service.getTaskList().get(0).getName(), "Task name should match input");
    }

    @Test
    void testNewTaskWithDescription() {
        TaskService service = new TaskService();
        service.newTask(name, description);
        assertNotNull(service.getTaskList().get(0).getDescription(), "Task description should not be null");
        assertEquals(description, service.getTaskList().get(0).getDescription(), "Task description should match input");
    }

    @Test
    void testNewTaskWithTooLongName() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(tooLongName), "Should throw exception for too long name");
    }

    @Test
    void testNewTaskWithTooLongDescription() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(name, tooLongDescription), "Should throw exception for too long description");
    }

    @Test
    void testNewTaskWithNullName() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(null), "Should throw exception for null name");
    }

    @Test
    void testNewTaskWithNullDescription() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(name, null), "Should throw exception for null description");
    }

    @Test
    void testDeleteTask() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertEquals(1, service.getTaskList().size(), "Task list should contain one task");
        service.deleteTask(service.getTaskList().get(0).getTaskId());
        assertEquals(0, service.getTaskList().size(), "Task list should be empty after deletion");
    }

    @Test
    void testDeleteTaskNotFound() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertEquals(1, service.getTaskList().size(), "Task list should contain one task");
        assertThrows(Exception.class, () -> service.deleteTask(id), "Should throw exception when deleting non-existing task");
        assertEquals(1, service.getTaskList().size(), "Task list should still contain one task");
    }

    @Test
    void testUpdateName() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        service.updateName(service.getTaskList().get(0).getTaskId(), name);
        assertEquals(name, service.getTaskList().get(0).getName(), "Task name should be updated");
    }

    @Test
    void testUpdateDescription() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        service.updateDescription(service.getTaskList().get(0).getTaskId(), description);
        assertEquals(description, service.getTaskList().get(0).getDescription(), "Task description should be updated");
    }

    @Test
    void testUpdateNameNotFound() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertThrows(Exception.class, () -> service.updateName(id, name), "Should throw exception when updating non-existing task");
    }

    @Test
    void testUpdateDescriptionNotFound() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertThrows(Exception.class, () -> service.updateDescription(id, description), "Should throw exception when updating non-existing task");
    }

    @Test
    void testUuidUniqueness() {
        TaskService service = new TaskService();
        service.newTask();
        service.newTask();
        service.newTask();
        assertEquals(3, service.getTaskList().size(), "Task list should contain three tasks");
        assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(1).getTaskId(), "Task IDs should be unique");
        assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(2).getTaskId(), "Task IDs should be unique");
        assertNotEquals(service.getTaskList().get(1).getTaskId(), service.getTaskList().get(2).getTaskId(), "Task IDs should be unique");
    }
}
