import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class CRS {
    private HashMap<Long, Patient> patients;
    private HashMap<Integer, Hospital> hospitals;
    private LinkedList<Rendezvous> rendezvousLinkedList;

    public CRS() {
        patients = new HashMap<>();
        hospitals = new HashMap<>();
        rendezvousLinkedList = new LinkedList<>();
    }

    // TODO Creates rendezvous if everything OK, throws exception if and of the IDs don't match; catch and raise alert in GUI
    public boolean makeRendezvous(long patientId, int hospitalId, int sectionId, int diplomaId, Date desiredDate)
            throws IdException {
        return false;
    }

    public void saveTablesToDisk(String fullPath) {

    }

    public void loadTablesToDisk(String fullPath) {

    }
}
