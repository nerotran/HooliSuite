/**
 * User class that stores user data such as username, password, and permission
 * level. Used to verify login information.
 * 
 * @author Corrina Martinez
 *
 */
public class User {
	String username;
	String password;
	int permission;

	/**
	 * Constructor that only takes username and password
	 * @param username user's username
	 * @param password user's password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		permission = 1;
	}

	/**
	 * Constructor that also takes in permission level
	 * @param username user's username
	 * @param password user's password
	 * @param permission user's permission level
	 */
	public User(String username, String password, int permission) {
		this.username = username;
		this.password = password;
		this.permission = permission;
	}

	/**
	 * returns the user's username
	 * @return username as a String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * returns the user's password
	 * @return password as a string
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets the user's permission level
	 * @param permission the level to set the user's permissions to
	 */
	public void updatePermission(int permission) {
		this.permission = permission;
	}

	/**
	 * returns the user's permission level
	 * @return permission as an int
	 */
	public int getPermission() {
		return permission;
	}
}
