/*
 * Copyright (c) 2024 John Bryson
 */

import java.util.Date;

public class Appointment {

    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_DESCRIPTION_LENGTH = 50;
    private static final String DEFAULT_VALUE = "DEFAULT";

    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    // Default constructor initializing fields with default values
    public Appointment() {
        this.appointmentId = DEFAULT_VALUE;
        this.appointmentDate = new Date();
        this.description = DEFAULT_VALUE;
    }

    // Constructor that accepts only an appointment ID
    public Appointment(String id) {
        validateAppointmentId(id);
        this.appointmentId = id;
        this.appointmentDate = new Date();
        this.description = DEFAULT_VALUE;
    }

    // Constructor that accepts an appointment ID and a date
    public Appointment(String id, Date date) {
        validateAppointmentId(id);
        validateDate(date);
        this.appointmentId = id;
        this.appointmentDate = date;
        this.description = DEFAULT_VALUE;
    }

    // Constructor that accepts an appointment ID, date, and description
    public Appointment(String id, Date date, String description) {
        validateAppointmentId(id);
        validateDate(date);
        validateDescription(description);
        this.appointmentId = id;
        this.appointmentDate = date;
        this.description = description;
    }

    // Private method to validate the appointment ID
    private void validateAppointmentId(String id) {
        if (id == null || id.length() > MAX_ID_LENGTH) {
            throw new IllegalArgumentException("Appointment ID must be non-null and no longer than " + MAX_ID_LENGTH + " characters.");
        }
    }

    // Private method to validate the appointment date
    private void validateDate(Date date) {
        if (date == null || date.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must be non-null and not in the past.");
        }
    }

    // Private method to validate the description
    private void validateDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Appointment description must be non-null and no longer than " + MAX_DESCRIPTION_LENGTH + " characters.");
        }
    }

    // Getter methods
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
