package Main;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    void testCountSessionsForDay() {
        var patient = new Patient("testPatient", 123);
        var patient1 = new Patient("testPatient1", 12);
        var schedule = new Schedule(2);
        var doctor = new Doctor("testDoctor", 1234, 1, schedule);
        try {
            schedule.addRendezvous(patient, new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2002"));
            schedule.addRendezvous(patient1, new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2002"));
        } catch (ParseException parseException) {

        }
        assertEquals(2, schedule.countSessionsForDay(new Date(2002 - 1900, 6, 12)));
    }

    @Test
    void testAddRendezvous() {
        var patient = new Patient("testPatient", 123);
        var patient1 = new Patient("testPatient1", 12);
        var schedule = new Schedule(2);
        var doctor = new Doctor("testDoctor", 1234, 1, schedule);

        try {
            schedule.addRendezvous(patient, new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2002"));
            schedule.addRendezvous(patient1, new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2002"));
        } catch (ParseException parseException) {

        }
        assertFalse(schedule.addRendezvous(new Patient("testPatient2", 1), new Date(2002 - 1900, 6, 12)));
    }
}