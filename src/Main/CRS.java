package Main;

import java.io.*;
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

    public void addPatient(Patient patient) {
        if (patient != null) {
            patients.put(patient.getNationalId(), patient);
        }
    }

    public void addHospital(Hospital hospital) {
        if (hospital != null) {
            hospitals.put(hospital.getId(), hospital);
        }
    }

    public void addRendezvous(Rendezvous rendezvous) {
        if (rendezvous != null) {
            rendezvousLinkedList.add(rendezvous);
        }
    }

    public boolean makeRendezvous(long patientId, int hospitalId, int sectionId, int diplomaId, Date desiredDate)
            throws IdException {
        try {
            hospitals.get(hospitalId).getSection(sectionId).getDoctor(diplomaId).getSchedule().addRendezvous(patients.get(patientId), desiredDate);
        } catch (NullPointerException e) {
            throw new IdException("Illegal ID");
        }
        return false;
    }

    public void saveTablesToDisk(String fullPath) {
        try {
            FileOutputStream file = new FileOutputStream(fullPath);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(patients);
            out.writeObject(hospitals);
            out.writeObject(rendezvousLinkedList);

            out.close();
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadTablesToDisk(String fullPath) {
        try {
            FileInputStream file = new FileInputStream(fullPath);
            ObjectInputStream in = new ObjectInputStream(file);

            patients = (HashMap)in.readObject();
            hospitals = (HashMap)in.readObject();
            rendezvousLinkedList = (LinkedList)in.readObject();
            
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
    }

    public HashMap<Long, Patient> getPatients() {
        return patients;
    }

    public HashMap<Integer, Hospital> getHospitals() {
        return hospitals;
    }

    public LinkedList<Rendezvous> getRendezvousLinkedList() {
        return rendezvousLinkedList;
    }
}
