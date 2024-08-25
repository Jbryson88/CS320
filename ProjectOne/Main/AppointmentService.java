/*
 * Copyright (c) 2024 John Bryson
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();

    // Generates a new unique ID with a maximum length of 10 characters
    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    // Adds a new appointment with a generated unique ID
    public void addAppointment() {
        Appointment appointment = new Appointment(generateUniqueId());
        appointments.add(appointment);
    }

    // Adds a new appointment with a specific date and a generated unique ID
    public void addAppointment(Date date) {
        Appointment appointment = new Appointment(generateUniqueId(), date);
        appointments.add(appointment);
    }

    // Adds a new appointment with a specific date and description, and a generated unique ID
    public void addAppointment(Date date, String description) {
        Appointment appointment = new Appointment(generateUniqueId(), date, description);
        appointments.add(appointment);
    }

    // Deletes an appointment by its ID
    public void deleteAppointment(String id) throws Exception {
        Appointment appointment = findAppointmentById(id);
        if (appointment != null) {
            appointments.remove(appointment);
        } else {
            throw new Exception("Appointment with ID " + id + " does not exist.");
        }
    }

    // Returns the list of appointments
    protected List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }

    // Finds an appointment by its ID
    private Appointment findAppointmentById(String id) throws Exception {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(id)) {
                return appointment;
            }
        }
        throw new Exception("Appointment with ID " + id + " not found.");
    }
}
