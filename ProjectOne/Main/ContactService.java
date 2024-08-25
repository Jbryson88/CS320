/*
 * Copyright (c) 2024 John Bryson
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

    private final List<Contact> contactList = new ArrayList<>();

    // Generates a new unique ID with a maximum length of 10 characters
    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    // Method to add a new contact with default values
    public void addContact() {
        Contact contact = new Contact(generateUniqueId());
        contactList.add(contact);
    }

    // Method to add a new contact with a first name
    public void addContact(String firstName) {
        Contact contact = new Contact(generateUniqueId(), firstName);
        contactList.add(contact);
    }

    // Method to add a new contact with first and last name
    public void addContact(String firstName, String lastName) {
        Contact contact = new Contact(generateUniqueId(), firstName, lastName);
        contactList.add(contact);
    }

    // Method to add a new contact with first name, last name, and phone number
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(generateUniqueId(), firstName, lastName, phoneNumber);
        contactList.add(contact);
    }

    // Method to add a new contact with all fields
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = new Contact(generateUniqueId(), firstName, lastName, phoneNumber, address);
        contactList.add(contact);
    }

    // Method to delete a contact by ID
    public void deleteContact(String id) throws Exception {
        contactList.remove(findContactById(id));
    }

    // Method to update the first name of a contact by ID
    public void updateFirstName(String id, String firstName) throws Exception {
        findContactById(id).updateFirstName(firstName);
    }

    // Method to update the last name of a contact by ID
    public void updateLastName(String id, String lastName) throws Exception {
        findContactById(id).updateLastName(lastName);
    }

    // Method to update the phone number of a contact by ID
    public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
        findContactById(id).updatePhoneNumber(phoneNumber);
    }

    // Method to update the address of a contact by ID
    public void updateAddress(String id, String address) throws Exception {
        findContactById(id).updateAddress(address);
    }

    // Method to retrieve the list of contacts
    public List<Contact> getContacts() {
        return new ArrayList<>(contactList);
    }

    // Private method to find a contact by ID
    private Contact findContactById(String id) throws Exception {
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(id)) {
                return contact;
            }
        }
        throw new Exception("The Contact does not exist!");
    }
}
