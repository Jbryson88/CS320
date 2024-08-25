import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentID);
    }

    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}
