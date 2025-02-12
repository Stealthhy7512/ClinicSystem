package Main;

import java.util.Date;
import java.io.Serializable;

public class Rendezvous implements Serializable {
    private Date dateTime;
    private Doctor doctor;
    private Patient patient;

    public Rendezvous(Date dateTime, Doctor doctor, Patient patient) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return dateTime.toString().substring(0, 10) + " " + dateTime.toString().substring(dateTime.toString().length() - 4) + " " + patient.toString();
    }
}
