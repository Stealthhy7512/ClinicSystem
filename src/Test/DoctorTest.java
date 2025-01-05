package Test;

import Main.Schedule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Main.Doctor;

import javax.print.Doc;

class DoctorTest {

    @Test
    void testSetSchedule() {
        var schedule = new Schedule(1);
        var doctor = new Doctor("test", 123, 1);

        assertNotEquals(schedule, doctor.getSchedule());
        doctor.setSchedule(schedule);
        assertEquals(schedule, doctor.getSchedule());
    }

    @Test
    void testSetName() {
        var doctor = new Doctor("test", 123, 1);

        assertNotEquals("newName", doctor.getName());
        doctor.setName("newName");
        assertEquals("newName", doctor.getName());
    }

    @Test
    void testGetSchedule() {
        var schedule = new Schedule(1);
        var doctor = new Doctor("test", 123, 1, schedule);

        assertEquals(schedule, doctor.getSchedule());

    }

    @Test
    void testGetDiplomaId() {
        Doctor doctor = new Doctor("test", 123, 1);

        assertEquals(1, doctor.getDiplomaId());
    }
}