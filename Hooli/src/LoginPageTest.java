import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

class LoginPageTest {

	@Test
	void validateLoginTest() {
		LoginPage l = new LoginPage();
		String user = "marti730";
		String pass = "password12";
		Pair<String, String> p = new ImmutablePair<String, String>(user, pass);
		assertFalse(l.validateLogin(p));
	}

}
