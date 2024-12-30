package Main;

public class Doctor extends Person {
    private final int diplomaId;
    private Schedule schedule;

    public Doctor(String name, long nationalId, int diplomaId) {
        super(name, nationalId);
        this.diplomaId = diplomaId;
        this.schedule = null;
    }

    public Doctor(String name, long nationalId, int diplomaId, Schedule schedule) {
        super(name, nationalId);
        this.diplomaId = diplomaId;
        this.setSchedule(schedule);
    }

    public void setSchedule(Schedule schedule) {
        if (schedule != null) {
            this.schedule = schedule;
            if (schedule.getDoctor() != this) {
                schedule.setDoctor(this);
            }
        }
    }

    public void setName(String name) {
        super.setName(name);
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public int getDiplomaId() {
        return diplomaId;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Diploma ID: " + diplomaId;
    }
}
