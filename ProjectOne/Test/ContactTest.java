/*
 * Copyright (c) 2024 John Bryson
 */

 import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
    protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

    @BeforeEach
    void setUp() {
        contactId = "1029F847A6";
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
    void testDefaultConstructor() {
        Contact contact = new Contact();
        assertAll("constructor",
            () -> assertNotNull(contact.getContactId(), "Contact ID should not be null"),
            () -> assertNotNull(contact.getFirstName(), "First name should not be null"),
            () -> assertNotNull(contact.getLastName(), "Last name should not be null"),
            () -> assertNotNull(contact.getPhoneNumber(), "Phone number should not be null"),
            () -> assertNotNull(contact.getAddress(), "Address should not be null")
        );
    }

    @Test
    void testContactIdConstructor() {
        Contact contact = new Contact(contactId);
        assertAll("constructor one",
            () -> assertEquals(contactId, contact.getContactId(), "Contact ID should match input"),
            () -> assertNotNull(contact.getFirstName(), "First name should not be null"),
            () -> assertNotNull(contact.getLastName(), "Last name should not be null"),
            () -> assertNotNull(contact.getPhoneNumber(), "Phone number should not be null"),
            () -> assertNotNull(contact.getAddress(), "Address should not be null")
        );
    }

    @Test
    void testContactIdAndFirstNameConstructor() {
        Contact contact = new Contact(contactId, firstNameTest);
        assertAll("constructor two",
            () -> assertEquals(contactId, contact.getContactId(), "Contact ID should match input"),
            () -> assertEquals(firstNameTest, contact.getFirstName(), "First name should match input"),
            () -> assertNotNull(contact.getLastName(), "Last name should not be null"),
            () -> assertNotNull(contact.getPhoneNumber(), "Phone number should not be null"),
            () -> assertNotNull(contact.getAddress(), "Address should not be null")
        );
    }

    @Test
    void testContactIdAndFullNameConstructor() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
        assertAll("constructor three",
            () -> assertEquals(contactId, contact.getContactId(), "Contact ID should match input"),
            () -> assertEquals(firstNameTest, contact.getFirstName(), "First name should match input"),
            () -> assertEquals(lastNameTest, contact.getLastName(), "Last name should match input"),
            () -> assertNotNull(contact.getPhoneNumber(), "Phone number should not be null"),
            () -> assertNotNull(contact.getAddress(), "Address should not be null")
        );
    }

    @Test
    void testContactIdFullNamePhoneNumberConstructor() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        assertAll("constructor four",
            () -> assertEquals(contactId, contact.getContactId(), "Contact ID should match input"),
            () -> assertEquals(firstNameTest, contact.getFirstName(), "First name should match input"),
            () -> assertEquals(lastNameTest, contact.getLastName(), "Last name should match input"),
            () -> assertEquals(phoneNumberTest, contact.getPhoneNumber(), "Phone number should match input"),
            () -> assertNotNull(contact.getAddress(), "Address should not be null")
        );
    }

    @Test
    void testAllFieldsConstructor() {
        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
        assertAll("constructor all",
            () -> assertEquals(contactId, contact.getContactId(), "Contact ID should match input"),
            () -> assertEquals(firstNameTest, contact.getFirstName(), "First name should match input"),
            () -> assertEquals(lastNameTest, contact.getLastName(), "Last name should match input"),
            () -> assertEquals(phoneNumberTest, contact.getPhoneNumber(), "Phone number should match input"),
            () -> assertEquals(addressTest, contact.getAddress(), "Address should match input")
        );
    }

    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact();
        contact.updateFirstName(firstNameTest);
        assertAll("first name",
            () -> assertEquals(firstNameTest, contact.getFirstName(), "First name should be updated"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null), "Should throw exception for null first name"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(tooLongFirstName), "Should throw exception for too long first name")
        );
    }

    @Test
    void testUpdateLastName() {
        Contact contact = new Contact();
        contact.updateLastName(lastNameTest);
        assertAll("last name",
            () -> assertEquals(lastNameTest, contact.getLastName(), "Last name should be updated"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null), "Should throw exception for null last name"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(tooLongLastName), "Should throw exception for too long last name")
        );
    }

    @Test
    void testUpdatePhoneNumber() {
        Contact contact = new Contact();
        contact.updatePhoneNumber(phoneNumberTest);
        assertAll("phone number",
            () -> assertEquals(phoneNumberTest, contact.getPhoneNumber(), "Phone number should be updated"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null), "Should throw exception for null phone number"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooLongPhoneNumber), "Should throw exception for too long phone number"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(tooShortPhoneNumber), "Should throw exception for too short phone number"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(contactId), "Should throw exception for invalid phone number format")
        );
    }

    @Test
    void testUpdateAddress() {
        Contact contact = new Contact();
        contact.updateAddress(addressTest);
        assertAll("address",
            () -> assertEquals(addressTest, contact.getAddress(), "Address should be updated"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null), "Should throw exception for null address"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(tooLongAddress), "Should throw exception for too long address")
        );
    }

    @Test
    void testUpdateContactId() {
        Contact contact = new Contact();
        contact.updateContactId(contactId);
        assertAll("contact ID",
            () -> assertEquals(contactId, contact.getContactId(), "Contact ID should be updated"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null), "Should throw exception for null contact ID"),
            () -> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(tooLongContactId), "Should throw exception for too long contact ID")
        );
    }
}
