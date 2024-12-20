import java.util.Date;
import java.util.LinkedList;


public class Schedule {
    private LinkedList<Rendezvous> sessions;
    private int maxPatientPerDay;
    private Doctor doctor;

    public Schedule(int maxPatientPerDay) {
        this.maxPatientPerDay = maxPatientPerDay;
        sessions = new LinkedList<>();
    }

    public Schedule(int maxPatientPerDay, Doctor doctor) {
        this.maxPatientPerDay = maxPatientPerDay;
        sessions = new LinkedList<>();
        this.setDoctor(doctor);
    }

    public void setDoctor(Doctor doctor) {
        if (doctor != null) {
            this.doctor = doctor;
            if (doctor.getSchedule() != this) {
                doctor.setSchedule(this);
            }
        }
    }

    public int countSessionsForDay(Date desiredDate) {
        int count = 0;
        if (sessions != null) {
            for (Rendezvous session : sessions) {
                if (session.getDateTime().compareTo(desiredDate) == 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    // TODO Adds rendezvous if max per day is not reached, else returns false; give alert in GUI if false
    public boolean addRendezvous(Patient p, Date desiredDate) {
        if (countSessionsForDay(desiredDate) < maxPatientPerDay) {
            Rendezvous rendezvous = new Rendezvous(desiredDate, doctor, p);
            sessions.add(rendezvous);
            p.setRendezvous(rendezvous);
            return true;
        }
        return false;
    }

    public void listSessions() {
        if (sessions != null) {
            System.out.println("Sessions for Doctor " + doctor.getName());
            System.out.println("****************");
            for (Rendezvous session : sessions) {
                System.out.println(session);
            }
        }
        System.out.println("****************");
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Max patient per day: " + maxPatientPerDay;
    }
}
