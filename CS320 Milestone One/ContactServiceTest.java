import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        assertTrue(contactService.addContact(contact));
        assertNotNull(contactService.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        Contact contact2 = new Contact("12345", "Jane", "Doe", "0987654321", "456 Maple Avenue");
        contactService.addContact(contact1);
        assertFalse(contactService.addContact(contact2));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("12345"));
        assertNull(contactService.getContact("12345"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        assertFalse(contactService.deleteContact("67890"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("12345", "Jane", "Smith", "0987654321", "456 Maple Avenue"));
        Contact updatedContact = contactService.getContact("12345");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Maple Avenue", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(contactService.updateContact("67890", "Jane", "Smith", "0987654321", "456 Maple Avenue"));
    }
}
