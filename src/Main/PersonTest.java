package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testGetter() {
        var person = new Person("test", 123);
        assertEquals("test", person.getName());
        assertEquals(123, person.getNationalId());
    }
}