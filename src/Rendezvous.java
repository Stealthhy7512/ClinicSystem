import java.util.Date;

public class Rendezvous {
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
        return "Date: " + dateTime;
    }
}
