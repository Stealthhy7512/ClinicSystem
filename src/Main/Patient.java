package Main;

public class Patient extends Person {
    Rendezvous rendezvous;
    public Patient(String name, long nationalId) {
        super(name, nationalId);

    }

    // TODO Inform client to overwrite previous rendezvous if new is set in GUI
    public void setRendezvous(Rendezvous rendezvous) {
        this.rendezvous = rendezvous;
    }
}
