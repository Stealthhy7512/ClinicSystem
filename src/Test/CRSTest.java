package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Main.*;

import java.util.Date;

class CRSTest {

    @Test
    void addPatient() {
        var crs = new CRS();
        var patient = new Patient("test", 123);

        assertNull(crs.getPatients().get(123));
        crs.addPatient(patient);
        assertEquals(patient, crs.getPatients().get(123L));

    }

    @Test
    void addHospital() {
        var crs = new CRS();
        var hospital = new Hospital(1, "test");

        assertNull(crs.getHospitals().get(1));
        crs.addHospital(hospital);
        assertEquals(hospital, crs.getHospitals().get(1));
    }


    @Test
    void testMakeRendezvous() {
        var crs = new CRS();
        var patient = new Patient("patient", 123);
        var doctor = new Doctor("doctor", 1234, 1);
        var schedule = new Schedule(1);
        doctor.setSchedule(schedule);
        var section = new Section(1, "section");
        section.addDoctor(doctor);
        // Jan 1, 2025
        var date = new Date(2025 - 1900, 0, 0);
        var hospital = new Hospital(1, "hospital");
        var rendezvous = new Rendezvous(date, doctor, patient);
        hospital.addSection(section);
        crs.addHospital(hospital);
        crs.addPatient(patient);
        crs.addRendezvous(rendezvous);

        try {
            assertTrue(crs.makeRendezvous(patient.getNationalId(), hospital.getId(), section.getId(), doctor.getDiplomaId(), date));
        } catch (IdException idErr) {

        }
        // Wrong section id
        assertThrows(IdException.class, () -> {
            crs.makeRendezvous(patient.getNationalId(), hospital.getId(), 2, doctor.getDiplomaId(), date);
        });
        // Wrong doctor id
        assertThrows(IdException.class, () -> {
            crs.makeRendezvous(patient.getNationalId(), hospital.getId(), section.getId(), 2, date);
        });
        // Wrong hospital id
        assertThrows(IdException.class, () -> {
            crs.makeRendezvous(patient.getNationalId(), 2, section.getId(), doctor.getDiplomaId(), date);
        });

    }

}