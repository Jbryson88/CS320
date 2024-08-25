/*
 * Copyright (c) 2024 John Bryson
 */

 import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
    private String id, description, tooLongDescription;
    private Date date, pastDate;

    @BeforeEach
    void setUp() {
        id = "1234567890";
        description = "The appt object shall have a required description.";
        Calendar futureDate = Calendar.getInstance();
        futureDate.set(3021, Calendar.JANUARY, 1);
        date = futureDate.getTime();
        tooLongDescription =
            "This description is too long for the appointment requirements but good for testing.";
        Calendar past = Calendar.getInstance();
        past.setTimeInMillis(0);  // Set the pastDate to the epoch (January 1, 1970)
        pastDate = past.getTime();
    }

    @Test
    void testNewAppointment() {
        AppointmentService service = new AppointmentService();

        service.newAppointment();
        assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
        assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
        assertNotNull(service.getAppointmentList().get(0).getDescription());

        service.newAppointment(date);
        assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
        assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
        assertNotNull(service.getAppointmentList().get(1).getDescription());

        service.newAppointment(date, description);
        assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
        assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
        assertEquals(description, service.getAppointmentList().get(2).getDescription());

        assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(), service.getAppointmentList().get(1).getAppointmentId());
        assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(), service.getAppointmentList().get(2).getAppointmentId());
        assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(), service.getAppointmentList().get(2).getAppointmentId());

        assertThrows(IllegalArgumentException.class, () -> service.newAppointment(pastDate));
        assertThrows(IllegalArgumentException.class, () -> service.newAppointment(date, tooLongDescription));
    }

    @Test
    void testDeleteAppointment() throws Exception {
        AppointmentService service = new AppointmentService();

        service.newAppointment();
        service.newAppointment();
        service.newAppointment();

        String firstId = service.getAppointmentList().get(0).getAppointmentId();
        String secondId = service.getAppointmentList().get(1).getAppointmentId();
        String thirdId = service.getAppointmentList().get(2).getAppointmentId();

        assertNotEquals(firstId, secondId);
        assertNotEquals(firstId, thirdId);
        assertNotEquals(secondId, thirdId);
        assertNotEquals(id, firstId);
        assertNotEquals(id, secondId);
        assertNotEquals(id, thirdId);

        assertThrows(Exception.class, () -> service.deleteAppointment(id));

        service.deleteAppointment(firstId);
        assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
        assertTrue(service.getAppointmentList().stream().noneMatch(appt -> appt.getAppointmentId().equals(firstId)));
    }
}
