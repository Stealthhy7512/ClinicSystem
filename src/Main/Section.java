package Main;

import java.util.LinkedList;
import java.io.Serializable;

public class Section implements Serializable {
    private final int id;
    private String name;
    private LinkedList<Doctor> doctorLinkedList;

    public Section(int id, String name) {
        this.id = id;
        this.name = name;
        doctorLinkedList = new LinkedList<>();
    }

    public void listDoctors() {
        if (doctorLinkedList != null) {
            System.out.println("Doctors");
            System.out.println("****************");
            for (Doctor doctor : doctorLinkedList) {
                System.out.println(doctor);
            }
        }
        System.out.println("****************");
    }

    public Doctor getDoctor(int diplomaId) {
        if (doctorLinkedList != null) {
            for (Doctor doctor : doctorLinkedList) {
                if (doctor.getDiplomaId() == diplomaId) {
                    return doctor;
                }
            }
        }
        return null;
    }

    // TODO add unit test
    public synchronized void addDoctor(Doctor doctor) throws DuplicateInfoException {
        if (doctorLinkedList != null) {
            for (Doctor dr : doctorLinkedList) {
                if(dr.getDiplomaId() == doctor.getDiplomaId()) {
                    throw new DuplicateInfoException("Doctor already exists");
                }
            }
        }
        doctorLinkedList.add(doctor);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public LinkedList<Doctor> getDoctorLinkedList() {
        return doctorLinkedList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Section ID: " + id +
                " | Section Name: " + name;
    }
}
