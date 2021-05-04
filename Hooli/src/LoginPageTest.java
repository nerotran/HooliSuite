import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginPageTest {

	@Test
	void validateLoginTest() {
		LoginPage l = new LoginPage();
		String user = "marti730";
		String pass = "password12";
		User u = new User(user, pass);
		assertFalse(l.validateLogin(u));
	}

}
