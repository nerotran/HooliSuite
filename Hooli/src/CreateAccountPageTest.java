import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreateAccountPageTest {
	CreateAccountPage page = new CreateAccountPage();

	@Test
	void testCreateAccountPage() {
		fail("Not yet implemented");
	}

	@Test
	void testPullUserInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testWriteToFile() {
		fail("Not yet implemented");
	}

	@Test
	void testBuild() {
		fail("Not yet implemented");
	}

	@Test
	void testTextFieldEmpty() {
		assertTrue(page.textFieldEmpty("", "password12", "password12"));
		assertTrue(page.textFieldEmpty("useruser", "", "password12"));
		assertTrue(page.textFieldEmpty("useruser", "password12", ""));
		assertTrue(page.textFieldEmpty("", "", ""));
		assertFalse(page.textFieldEmpty("useruser", "pass1", "pass2"));
	}

	@Test
	void testPasswordsMatch() {
		assertTrue(page.passwordsMatch("password12", "password12"));
		assertFalse(page.passwordsMatch("Password12", "passWord12"));
	}

	@Test
	void testUserNameAvailable() {
		fail("Not yet implemented");
	}

	@Test
	void testActionPerformed() {
		fail("Not yet implemented");
	}

}
