import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1"));
    }

    @Test
    public void testAddDuplicateTaskId() {
        Task task1 = new Task("1", "Task Name", "Task Description");
        Task task2 = new Task("1", "Another Task", "Another Description");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTaskName() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.updateTaskName("1", "New Task Name");
        assertEquals("New Task Name", taskService.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("1", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.updateTaskDescription("1", "New Task Description");
        assertEquals("New Task Description", taskService.getTask("1").getDescription());
    }
}
