/*
 * Copyright (c) 2024 John Bryson
 */

public class Contact {

    private static final int PHONE_NUMBER_LENGTH = 10;
    private static final int ID_LENGTH = 10;
    private static final int NAME_LENGTH = 10;
    private static final int ADDRESS_LENGTH = 30;
    private static final String DEFAULT_STRING = "INITIAL";
    private static final String DEFAULT_PHONE = "1235559999";

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Default constructor
    public Contact() {
        this.contactId = DEFAULT_STRING;
        this.firstName = DEFAULT_STRING;
        this.lastName = DEFAULT_STRING;
        this.phoneNumber = DEFAULT_PHONE;
        this.address = DEFAULT_STRING;
    }

    // Constructor with contactId
    public Contact(String contactId) {
        this.contactId = validateContactId(contactId);
        this.firstName = DEFAULT_STRING;
        this.lastName = DEFAULT_STRING;
        this.phoneNumber = DEFAULT_PHONE;
        this.address = DEFAULT_STRING;
    }

    // Constructor with contactId and firstName
    public Contact(String contactId, String firstName) {
        this.contactId = validateContactId(contactId);
        this.firstName = validateFirstName(firstName);
        this.lastName = DEFAULT_STRING;
        this.phoneNumber = DEFAULT_PHONE;
        this.address = DEFAULT_STRING;
    }

    // Constructor with contactId, firstName, and lastName
    public Contact(String contactId, String firstName, String lastName) {
        this.contactId = validateContactId(contactId);
        this.firstName = validateFirstName(firstName);
        this.lastName = validateLastName(lastName);
        this.phoneNumber = DEFAULT_PHONE;
        this.address = DEFAULT_STRING;
    }

    // Constructor with contactId, firstName, lastName, and phoneNumber
    public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
        this.contactId = validateContactId(contactId);
        this.firstName = validateFirstName(firstName);
        this.lastName = validateLastName(lastName);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.address = DEFAULT_STRING;
    }

    // Full constructor
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        this.contactId = validateContactId(contactId);
        this.firstName = validateFirstName(firstName);
        this.lastName = validateLastName(lastName);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.address = validateAddress(address);
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Validation methods
    private String validateContactId(String contactId) {
        if (contactId == null || contactId.length() > ID_LENGTH) {
            throw new IllegalArgumentException("Contact ID must be non-null and no longer than " + ID_LENGTH + " characters.");
        }
        return contactId;
    }

    private String validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("First name must be non-null and no longer than " + NAME_LENGTH + " characters.");
        }
        return firstName;
    }

    private String validateLastName(String lastName) {
        if (lastName == null || lastName.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("Last name must be non-null and no longer than " + NAME_LENGTH + " characters.");
        }
        return lastName;
    }

    private String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != PHONE_NUMBER_LENGTH || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be non-null, exactly " + PHONE_NUMBER_LENGTH + " digits, and contain only numbers.");
        }
        return phoneNumber;
    }

    private String validateAddress(String address) {
        if (address == null || address.length() > ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must be non-null and no longer than " + ADDRESS_LENGTH + " characters.");
        }
        return address;
    }

    // Update methods
    public void updateFirstName(String firstName) {
        this.firstName = validateFirstName(firstName);
    }

    public void updateLastName(String lastName) {
        this.lastName = validateLastName(lastName);
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = validatePhoneNumber(phoneNumber);
    }

    public void updateAddress(String address) {
        this.address = validateAddress(address);
    }
}
