/*
 * Copyright (c) 2024 John Bryson
 */

 import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

    private String id, name, description;
    private String tooLongId, tooLongName, tooLongDescription;

    @BeforeEach
    void setUp() {
        id = "1234567890";
        name = "This is Twenty Chars";
        description = "The task object shall have a required description.";
        tooLongId = "111222333444555666777888999";
        tooLongName = "This is way too long to be a task name";
        tooLongDescription = "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
    }

    @Test
    void testGetTaskId() {
        Task task = new Task(id);
        assertEquals(id, task.getTaskId(), "Task ID should match the provided ID");
    }

    @Test
    void testGetName() {
        Task task = new Task(id, name);
        assertEquals(name, task.getName(), "Task name should match the provided name");
    }

    @Test
    void testGetDescription() {
        Task task = new Task(id, name, description);
        assertEquals(description, task.getDescription(), "Task description should match the provided description");
    }

    @Test
    void testSetName() {
        Task task = new Task();
        task.setName(name);
        assertEquals(name, task.getName(), "Task name should be updated correctly");
    }

    @Test
    void testSetDescription() {
        Task task = new Task();
        task.setDescription(description);
        assertEquals(description, task.getDescription(), "Task description should be updated correctly");
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task(tooLongId), "Should throw an exception for too long Task ID");
    }

    @Test
    void testSetTooLongName() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> task.setName(tooLongName), "Should throw an exception for too long Task name");
    }

    @Test
    void testSetTooLongDescription() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(tooLongDescription), "Should throw an exception for too long Task description");
    }

    @Test
    void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null), "Should throw an exception for null Task ID");
    }

    @Test
    void testTaskNameNull() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> task.setName(null), "Should throw an exception for null Task name");
    }

    @Test
    void testTaskDescriptionNull() {
        Task task = new Task();
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null), "Should throw an exception for null Task description");
    }
}

