import java.time.LocalDate;

public class Rendezvous {
    private LocalDate  dateTime;

    public Rendezvous(LocalDate dateTime) {
        this.dateTime = dateTime;

    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Date: " + dateTime;
    }
}
