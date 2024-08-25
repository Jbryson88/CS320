/*
 * Copyright (c) 2024 John Bryson
 */

 import static org.junit.jupiter.api.Assertions.*;

 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 
 public class ContactServiceTest {
     protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
     protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;
 
     @BeforeEach
     void setUp() {
         contactId = "10293A475F";
         firstNameTest = "John";
         lastNameTest = "Smith";
         phoneNumberTest = "5553331234";
         addressTest = "1 Audrey Jersey City NJ 07305";
         tooLongContactId = "112233445566778899";
         tooLongFirstName = "John Jacob Jingle";
         tooLongLastName = "-heimer Schmidt";
         tooLongPhoneNumber = "55512341234";
         tooShortPhoneNumber = "1234567";
         tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
     }
 
     @Test
     void testNewContact() {
         ContactService service = new ContactService();
         service.newContact();
         assertAll("service",
             () -> assertNotNull(service.getContactList().get(0).getContactId(), "Contact ID should not be null"),
             () -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName(), "First name should be INITIAL"),
             () -> assertEquals("INITIAL", service.getContactList().get(0).getLastName(), "Last name should be INITIAL"),
             () -> assertEquals("1235559999", service.getContactList().get(0).getPhoneNumber(), "Phone number should be 1235559999"),
             () -> assertEquals("INITIAL", service.getContactList().get(0).getAddress(), "Address should be INITIAL")
         );
 
         service.newContact(firstNameTest);
         assertAll("service",
             () -> assertNotNull(service.getContactList().get(1).getContactId(), "Contact ID should not be null"),
             () -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName(), "First name should match input"),
             () -> assertEquals("INITIAL", service.getContactList().get(1).getLastName(), "Last name should be INITIAL"),
             () -> assertEquals("1235559999", service.getContactList().get(1).getPhoneNumber(), "Phone number should be 1235559999"),
             () -> assertEquals("INITIAL", service.getContactList().get(1).getAddress(), "Address should be INITIAL")
         );
 
         service.newContact(firstNameTest, lastNameTest);
         assertAll("service",
             () -> assertNotNull(service.getContactList().get(2).getContactId(), "Contact ID should not be null"),
             () -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName(), "First name should match input"),
             () -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName(), "Last name should match input"),
             () -> assertEquals("1235559999", service.getContactList().get(2).getPhoneNumber(), "Phone number should be 1235559999"),
             () -> assertEquals("INITIAL", service.getContactList().get(2).getAddress(), "Address should be INITIAL")
         );
 
         service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
         assertAll("service",
             () -> assertNotNull(service.getContactList().get(3).getContactId(), "Contact ID should not be null"),
             () -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName(), "First name should match input"),
             () -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName(), "Last name should match input"),
             () -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber(), "Phone number should match input"),
             () -> assertEquals("INITIAL", service.getContactList().get(3).getAddress(), "Address should be INITIAL")
         );
 
         service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
         assertAll("service",
             () -> assertNotNull(service.getContactList().get(4).getContactId(), "Contact ID should not be null"),
             () -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName(), "First name should match input"),
             () -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName(), "Last name should match input"),
             () -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber(), "Phone number should match input"),
             () -> assertEquals(addressTest, service.getContactList().get(4).getAddress(), "Address should match input")
         );
     }
 
     @Test
     void testDeleteContact() {
         ContactService service = new ContactService();
         service.newContact();
         assertThrows(Exception.class, () -> service.deleteContact(contactId), "Exception should be thrown when deleting non-existing contact");
         service.deleteContact(service.getContactList().get(0).getContactId());
         assertEquals(0, service.getContactList().size(), "Contact list should be empty after deletion");
     }
 
     @Test
     void testUpdateFirstName() throws Exception {
         ContactService service = new ContactService();
         service.newContact();
         service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
         assertEquals(firstNameTest, service.getContactList().get(0).getFirstName(), "First name should be updated");
 
         assertThrows(IllegalArgumentException.class,
             () -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName),
             "Exception should be thrown for too long first name"
         );
         assertThrows(IllegalArgumentException.class,
             () -> service.updateFirstName(service.getContactList().get(0).getContactId(), null),
             "Exception should be thrown for null first name"
         );
         assertThrows(Exception.class,
             () -> service.updateFirstName(contactId, firstNameTest),
             "Exception should be thrown when updating non-existing contact"
         );
     }
 
     @Test
     void testUpdateLastName() throws Exception {
         ContactService service = new ContactService();
         service.newContact();
         service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
         assertEquals(lastNameTest, service.getContactList().get(0).getLastName(), "Last name should be updated");
 
         assertThrows(IllegalArgumentException.class,
             () -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName),
             "Exception should be thrown for too long last name"
         );
         assertThrows(IllegalArgumentException.class,
             () -> service.updateLastName(service.getContactList().get(0).getContactId(), null),
             "Exception should be thrown for null last name"
         );
         assertThrows(Exception.class,
             () -> service.updateLastName(contactId, lastNameTest),
             "Exception should be thrown when updating non-existing contact"
         );
     }
 
     @Test
     void testUpdatePhoneNumber() throws Exception {
         ContactService service = new ContactService();
         service.newContact();
         service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
         assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber(), "Phone number should be updated");
 
         assertThrows(IllegalArgumentException.class,
             () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber),
             "Exception should be thrown for too long phone number"
         );
         assertThrows(IllegalArgumentException.class,
             () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooShortPhoneNumber),
             "Exception should be thrown for too short phone number"
         );
         assertThrows(IllegalArgumentException.class,
             () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId),
             "Exception should be thrown for invalid phone number format"
         );
         assertThrows(IllegalArgumentException.class,
             () -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null),
             "Exception should be thrown for null phone number"
         );
         assertThrows(Exception.class,
             () -> service.updatePhoneNumber(contactId, lastNameTest),
             "Exception should be thrown when updating non-existing contact"
 