import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void testApplicationStringString() {
		Application a = new Application ("H1", "Hooli");
		assertEquals(a.getName(), "H1");
		assertEquals(a.getPublisher(), "Hooli");
	}

	@Test
	void testApplicationStringStringString() {
		Application a = new Application ("H1", "Hooli", "PC", "This our CSE201 project.");
		assertEquals(a.getName(), "H1");
		assertEquals(a.getPublisher(), "Hooli");
		assertEquals(a.getPlatform(), "PC");
		assertEquals(a.getDescription(), "This our CSE201 project.");
	}

	@Test
	void testApplicationStringStringStringString() {
		Application a = new Application ("H1", "Hooli", "PC", "This our CSE201 project.");
		assertEquals(a.getName(), "H1");
		assertEquals(a.getPublisher(), "Hooli");
		assertEquals(a.getPlatform(), "PC");
		assertEquals(a.getDescription(), "This our CSE201 project.");
	}

	@Test
	void testApplicationStringStringStringStringDouble() {
		Application a = new Application ("H1", "Hooli", "PC", "This our CSE201 project.", 10);
		assertEquals(a.getName(), "H1");
		assertEquals(a.getPublisher(), "Hooli");
		assertEquals(a.getPlatform(), "PC");
		assertEquals(a.getDescription(), "This our CSE201 project.");
		assertEquals(a.getPrice(), "$10.00");
	}

	@Test
	void testApplicationStringStringStringStringDoubleString() {
		Application a = new Application ("H1", "Hooli", "PC", "This our CSE201 project.", 10, "https://www.google.com");
		assertEquals(a.getName(), "H1");
		assertEquals(a.getPublisher(), "Hooli");
		assertEquals(a.getPlatform(), "PC");
		assertEquals(a.getDescription(), "This our CSE201 project.");
		assertEquals(a.getPrice(), "$10.00");
		assertEquals(a.getLink(), "https://www.google.com");
	}

	@Test
	void testApplicationStringStringStringStringDoubleStringString() {
		Application a = new Application ("H1", "Hooli", "PC", "This our CSE201 project.", 10, "https://www.google.com", new Date("4/9/2021"));
		assertEquals(a.getName(), "H1");
		assertEquals(a.getPublisher(), "Hooli");
		assertEquals(a.getPlatform(), "PC");
		assertEquals(a.getDescription(), "This our CSE201 project.");
		assertEquals(a.getPrice(), "$10.00");
		assertEquals(a.getLink(), "https://www.google.com");
		assertEquals(a.getDate(), "4/9/2021");
	}

	@Test
	void testToString() {
		Application a = new Application ("H1", "Hooli", "PC", "This our CSE201 project.", 10, "https://www.google.com", new Date("4/9/2021"));
		assertEquals("Name: H1 Publisher: Hooli Platform: PC Description:"
				+ " This our CSE201 project. Price: 10.0 Link: https://www.google.com Released: 4/9/2021", a.toString());
	}


}
