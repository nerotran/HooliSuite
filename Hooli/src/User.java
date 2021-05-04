
public class User {
	String username;
	String password;
	int permission;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		permission = 1;
	}
	
	public User(String username, String password, int permission) {
		this.username = username;
		this.password = password;
		this.permission = permission;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void updatePermission(int permission) {
		this.permission = permission;
	}
	
	public int getPermission() {
		return permission;
	}
}
