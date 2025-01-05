package Test;

import Main.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testGetter() {
        var person = new Person("test", 123);
        assertEquals("test", person.getName());
        assertEquals(123, person.getNationalId());
    }

    @Test
    void testSetter() {
        var person = new Person("test", 123);
        person.setName("newName");
        assertEquals("newName", person.getName());
    }
}