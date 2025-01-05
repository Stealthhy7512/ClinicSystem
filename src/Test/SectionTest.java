package Test;

import Main.Doctor;
import Main.DuplicateInfoException;
import Main.Section;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {

    @Test
    void testAddDoctor() {
        var section = new Section(1, "testSection");
        var doctor1 = new Doctor("testDoctor1", 1, 1);
        var doctor2 = new Doctor("testDoctor2", 2, 1);

        section.addDoctor(doctor1);
        assertThrows(DuplicateInfoException.class, () -> {
            section.addDoctor(doctor2);
        });
    }

    @Test
    void testGetDoctor() {
        var section = new Section(1, "testSection");
        var doctor1 = new Doctor("testDoctor1", 1, 1);
        section.addDoctor(doctor1);

        assertEquals(doctor1, section.getDoctor(1));
    }
}