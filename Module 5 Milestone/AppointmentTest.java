import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's appointment");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "Description");
        });
    }

    @Test
    void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() - 100000), "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    @Test
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(), null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(), "This description is way too long to be allowed because it exceeds fifty characters.");
        });
    }
}
