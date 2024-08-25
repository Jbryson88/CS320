import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    
    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Task Name", "Task Description");
        assertEquals("1", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name longer than twenty characters", "Task Description"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task Name", "Description longer than fifty characters is not allowed in this task object"));
    }

    @Test
    public void testSetName() {
        Task task = new Task("1", "Task Name", "Task Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("1", "Task Name", "Task Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
}
