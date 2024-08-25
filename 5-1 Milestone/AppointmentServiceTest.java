import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentServiceTest {
    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "Test Description");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("1234567890"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "Test Description");
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("1234567890", new Date(System.currentTimeMillis() + 1000), "Test Description");
        service.addAppointment(appointment);
        service.deleteAppointment("1234567890");
        assertNull(service.getAppointment("1234567890"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("nonexistent");
        });
    }
}
