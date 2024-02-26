package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

class ContactServiceTest {
	private ContactService service;
	private Contact defaultContact;

	@BeforeEach
	void setUp() throws Exception {
		defaultContact = new Contact("1", "Jeba", "Emmanuel", "1234567890", "Location");
		service = new ContactService();
		service.addContact(defaultContact);
	}
	
	@AfterEach
	void teardown() throws Exception {
		
	}


	@Test
	void testAddContact() throws Exception {
		Contact newContact = new Contact("2", "J", "E", "2222222222", "Address");
		assertTrue(service.addContact(newContact));
		
		assertThrows(Exception.class, () -> {service.addContact(defaultContact);});
	}

	@Test
	void testDeleteContact() {
		assertTrue(service.deleteContact("1"));
		// 1 should no longer exist
		assertFalse(service.deleteContact("1"));
	}

	@Test
	void testUpdateContactField() throws Exception {
		assertThrows(Exception.class, ()-> {service.updateContactField("1", "contactId", "2");});
		
		String fieldName;
		fieldName = "firstName";
		service.updateContactField("1", fieldName, "newValln10");
		assertEquals(service.getContact("1").getFirstName(), "newValln10");
		
		fieldName = "lastName";
		service.updateContactField("1", fieldName, "newValln10");
		assertEquals(service.getContact("1").getLastName(), "newValln10");
		
		fieldName = "phone";
		service.updateContactField("1", fieldName, "newValln10");
		assertEquals(service.getContact("1").getPhone(), "newValln10");
		
		fieldName = "address";
		service.updateContactField("1", fieldName, "newValln10");
		assertEquals(service.getContact("1").getAddress(), "newValln10");
	}

	@Test
	void testGetContact() {
		assertSame(service.getContact("1"), defaultContact);
	}

}
