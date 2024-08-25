import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentTest {
    @Test
    public void testAppointmentCreation() {
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "Test Description");
        assertEquals("1234567890", appointment.getAppointmentID());
        assertNotNull(appointment.getAppointmentDate());
        assertEquals("Test Description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(System.currentTimeMillis() + 1000), "Test Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(System.currentTimeMillis() + 1000), "Test Description");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(System.currentTimeMillis() - 1000), "Test Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Test Description");
        });
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "This description is way too long and should trigger an exception because it exceeds 50 characters.");
        });
    }
}
