package main;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) throws Exception {
        setContactId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    private void setContactId(String contactId) throws Exception {
    	if (this.contactId!= null) {
    		throw new Exception("Contact Id already set");
    	}
    	if (contactId.length() > 10 || contactId.length() < 1) {
    		throw new Exception("Contact Id cannot be longer than 10 characters or empty.");
    	}
        this.contactId = contactId;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
    	if (firstName == null || firstName.length() > 10 || firstName.length() < 1) {
    		throw new Exception("First Name cannot be longer than 10 characters or empty.");
    	}
        this.firstName = firstName;
       
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
    	if (lastName == null || lastName.length() > 10 || lastName.length() < 1) {
    		throw new Exception("Last Name cannot be longer than 10 characters or empty.");
    	}
        this.lastName = lastName;
        
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
    	if (phone == null || phone.length() != 10) {
    		throw new Exception("Phone should be 10 characters.");
    	}
        this.phone = phone;
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
    	if (address == null || address.length() > 30 || address.length() < 1) {
    		throw new Exception("Address cannot be longer than 10 characters or empty.");
    	}
        this.address = address;
        
    }
}