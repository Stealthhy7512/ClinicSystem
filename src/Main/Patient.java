package Main;

public class Patient extends Person {
    Rendezvous rendezvous;
    public Patient(String name, long nationalId) {
        super(name, nationalId);

    }

    public void setRendezvous(Rendezvous rendezvous) {
        this.rendezvous = rendezvous;
    }
}
