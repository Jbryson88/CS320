import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Elm Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm Street");
        });
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Elm Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Johnathon", "Doe", "1234567890", "123 Elm Street");
        });
    }

    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Elm Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doeington", "1234567890", "123 Elm Street");
        });
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Elm Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Elm Street");
        });
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street, Long City Name, State, Country");
        });
    }
}
