/*
 * Copyright (c) 2024 John Bryson
 */

 import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

    private String id, description;
    private String tooLongId, tooLongDescription;
    private Date date, pastDate;

    @BeforeEach
    void setUp() {
        id = "1234567890";
        description = "The appt object shall have a required description.";
        
        Calendar futureDate = Calendar.getInstance();
        futureDate.set(3021, Calendar.JANUARY, 1);
        date = futureDate.getTime();

        tooLongId = "111222333444555666777888999";
        tooLongDescription = "This description is too long for the appointment requirements but good for testing.";

        Calendar past = Calendar.getInstance();
        past.setTimeInMillis(0);  // Set the pastDate to the epoch (January 1, 1970)
        pastDate = past.getTime();
    }

    @Test
    void testUpdateAppointmentId() {
        Appointment appt = new Appointment();
        assertThrows(IllegalArgumentException.class, () -> appt.updateAppointmentId(null));
        assertThrows(IllegalArgumentException.class, () -> appt.updateAppointmentId(tooLongId));
        appt.updateAppointmentId(id);
        assertEquals(id, appt.getAppointmentId());
    }

    @Test
    void testGetAppointmentId() {
        Appointment appt = new Appointment(id);
        assertNotNull(appt.getAppointmentId());
        assertEquals(10, appt.getAppointmentId().length());
        assertEquals(id, appt.getAppointmentId());
    }

    @Test
    void testUpdateDate() {
        Appointment appt = new Appointment();
        assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
        assertThrows(IllegalArgumentException.class, () -> appt.updateDate(pastDate));
        appt.updateDate(date);
        assertEquals(date, appt.getAppointmentDate());
    }

    @Test
    void testGetAppointmentDate() {
        Appointment appt = new Appointment(id, date);
        assertNotNull(appt.getAppointmentDate());
        assertEquals(date, appt.getAppointmentDate());
    }

    @Test
    void testUpdateDescription() {
        Appointment appt = new Appointment();
        assertThrows(IllegalArgumentException.class, () -> appt.updateDescription(null));
        assertThrows(IllegalArgumentException.class, () -> appt.updateDescription(tooLongDescription));
        appt.updateDescription(description);
        assertEquals(description, appt.getDescription());
    }

    @Test
    void testGetDescription() {
        Appointment appt = new Appointment(id, date, description);
        assertNotNull(appt.getDescription());
        assertTrue(appt.getDescription().length() <= 50);
        assertEquals(description, appt.getDescription());
    }
}
