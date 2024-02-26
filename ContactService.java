package main;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) throws Exception {
        if (contacts.get(contact.getContactId()) != null) {
        	throw new Exception("Contact Id must be unique");
        } else {
        	contacts.put(contact.getContactId(), contact);
        	return true;
        }
        
    }

    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

    public boolean updateContactField(String contactId, String fieldName, String value) throws Exception {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
        	switch (fieldName) {
        	case "firstName":
        		contact.setFirstName(value);
        		break;
        	case "lastName":
        		contact.setLastName(value);
        		break;
        	case "phone":
        		contact.setPhone(value);
        		break;
        	case "address":
        		contact.setAddress(value);
        		break;
        	case "contactId":
        		throw new Exception("Contact Id cannot be updated.");
        	}
        	return true;
        }
        
        return false;
        
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}