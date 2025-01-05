package Test;

import Main.Hospital;
import Main.Section;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    @Test
    void testGetSectionById() {
        var hospital = new Hospital(1, "testHospital");
        var section1 = new Section(1, "testSection1");
        var section2 = new Section(2, "testSection2");
        hospital.addSection(section1);
        hospital.addSection(section2);

        assertEquals(section1, hospital.getSection(1));
        assertEquals(section2, hospital.getSection(2));
    }

    @Test
    void testGetSectionByName() {
        var hospital = new Hospital(1, "testHospital");
        var section1 = new Section(1, "testSection1");
        var section2 = new Section(2, "testSection2");
        hospital.addSection(section1);
        hospital.addSection(section2);

        assertEquals(section1, hospital.getSection("testSection1"));
        assertEquals(section2, hospital.getSection("testSection2"));
    }
}