import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.LinkedList;

public class Section {
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

    // TODO Adds doctor if unique, throws error if not unique, catch this in GUI and raise alert
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

    public int getId() {
        return id;
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
