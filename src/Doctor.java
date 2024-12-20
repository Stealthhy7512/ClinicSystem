
public class Doctor extends Person {
    private final int diplomaId;
    private Schedule schedule;

    public Doctor(String name, long nationalId, int diplomaId) {
        super(name, nationalId);
        this.diplomaId = diplomaId;
    }

    public void setSchedule(Schedule schedule) {
        if (schedule != null) {
            this.schedule = schedule;
        }
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public int getDiplomaId() {
        return diplomaId;
    }

    @Override
    public String toString() {
        return super.toString() + " | Diploma ID: " + diplomaId;
    }
}
