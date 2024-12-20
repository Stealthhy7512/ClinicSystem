import java.util.Date;
import java.util.LinkedList;
import java.util.HashMap;

public class Schedule {
    private LinkedList<Rendezvous> sessions;
    private int maxPatientPerDay;
    private Doctor doctor;

    public Schedule(int maxPatientPerDay) {
        this.maxPatientPerDay = maxPatientPerDay;
        sessions = new LinkedList<>();
    }

    public boolean addRendezvous(Patient p, Date desiredDate) {
        return false;
    }

}
