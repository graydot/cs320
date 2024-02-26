package test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;



class ContactTest {
	private Contact defaultContact;

	@BeforeEach
	void setUp() throws Exception {
		defaultContact = new Contact("1", "Jeba", "Emmanuel", "1234567890", "Location");
	}

	@Test
	void testGetContactId() {
		assertEquals(defaultContact.getContactId(), "1");
	}

	@Test
	void testGetFirstName() {
		assertEquals(defaultContact.getFirstName(), "Jeba");
	}

	@Test
	void testSetFirstName() throws Exception {
		defaultContact.setFirstName("New Name");
		assertEquals(defaultContact.getFirstName(), "New Name");
		
		
		assertThrows(Exception.class, () -> {defaultContact.setFirstName("Very Long Name");});
		assertThrows(Exception.class, () -> {defaultContact.setFirstName("");});
	}

	@Test
	void testGetLastName() {
		assertEquals(defaultContact.getLastName(), "Emmanuel");
	}

	@Test
	void testSetLastName() throws Exception {
		defaultContact.setLastName("New Name");
		assertEquals(defaultContact.getLastName(), "New Name");
		
		
		assertThrows(Exception.class, () -> {defaultContact.setLastName("Very Long Name");});
		assertThrows(Exception.class, () -> {defaultContact.setLastName("");});
	}

	@Test
	void testGetPhone() {
		assertEquals(defaultContact.getPhone(), "1234567890");
	}

	@Test
	void testSetPhone() throws Exception {
		defaultContact.setPhone("0987654321");
		assertEquals(defaultContact.getPhone(), "0987654321");
		
		// long phone number
		assertThrows(Exception.class, () -> {defaultContact.setPhone("12345678900");});
		// short phone number
		assertThrows(Exception.class, () -> {defaultContact.setPhone("123456789");});
	}

	@Test
	void testGetAddress() {
		assertEquals(defaultContact.getAddress(), "Location");
	}

	@Test
	void testSetAddress() throws Exception {
		defaultContact.setAddress("New Place");
		assertEquals(defaultContact.getAddress(), "New Place");
		
		
		assertThrows(Exception.class, () -> {defaultContact.setAddress("Very Long Address.Very Long Address.Very Long Address.");});
		assertThrows(Exception.class, () -> {defaultContact.setAddress("");});
	}

}
