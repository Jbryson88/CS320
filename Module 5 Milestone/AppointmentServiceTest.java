import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 100000), "Checkup");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("12345"));
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 100000), "Checkup");
        service.addAppointment(appointment);
        service.deleteAppointment("12345");
        assertNull(service.getAppointment("12345"));
    }

    @Test
    void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("12345", new Date(System.currentTimeMillis() + 100000), "Checkup");
        Appointment appointment2 = new Appointment("12345", new Date(System.currentTimeMillis() + 100000), "Meeting");

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("12345");
        });
    }
}
