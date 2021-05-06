import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Creates the Create Account Page that allows a user to enter in a username and password
 * into textfields. Allows the user to interact with a Create Account button which creates
 * a new User object when clicked and adds their info to the UserInfo file. 
 * Login page pops back up when the create account button is pressed.
 * 
 * @author Corrina Martinez
 *
 */
public class CreateAccountPage extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel userName;
	private JLabel password;
	private JLabel retypePass;
	private JTextField userField;
	private JTextField passField;
	private JTextField retypeField;
	private JButton create;
	Set<User> userInfo;
	
	/**
	 * CreateAccountPage constructor
	 */
	public CreateAccountPage() {
		super("Create An Account");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		userInfo = Suite.pullUserInfo("UserInfo.csv");
		build();
	}
	
	/**
	 * Reads User data from a Set containing all verified Users and writes
	 * their information to a file. 
	 * @param fileName the name of the file to write to as a String
	 * @param info the Set to pull data from
	 */
	public void writeToFile(String fileName, Set<User> info) {
		File file = new File(fileName);
		try {
			PrintWriter output = new PrintWriter(file);
			output.append("Username, Password, Permission, \n");
			
			for (User entry : info) {
				output.append(entry.getUsername() + "," + entry.getPassword() + "," + convertPermission(entry.getPermission()) + ",\n");
			}
			
			output.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
	}
	
	/**
	 * Takes in an int and converts it to the string version of the permission level.
	 * Will return "user" if permission is 1, "mod" if permission is 2, and "admin" if permission is 3.
	 * @param level the permission level as an int
	 * @return String version of the permission level
	 */
	public static String convertPermission(int level) {
		if (level == 1) {
			return "user";
		} else {
			if (level == 2) {
				return "mod";
			} else {
				if (level == 3) {
					return "admin";
				}
			}
		}
		return "user";
	}
	
	/**
	* Builds the CreateAccountPage, adds all of the components to the JFrame
	*/
	public void build() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(0,1);
		panel.setLayout(layout);
		
		userName = new JLabel("Username: ");
		password = new JLabel("Password: ");
		userField = new JTextField(20);
		passField = new JTextField(20);
		retypePass = new JLabel("Confirm password: ");
		retypeField = new JTextField(20);
		create = new JButton("Create Account");
		
		panel.add(userName);
		panel.add(userField);
		panel.add(password);
		panel.add(passField);
		panel.add(retypePass);
		panel.add(retypeField);
		panel.add(create);
		
		create.addActionListener(this);
		this.add(panel);
	}
	
	/**
	 * Checks to make sure none of the entries have been left blank (empty string).
	 * @param user username as a String
	 * @param pass1 password as a String
	 * @param pass2 password retype as a string
	 * @return true if none of the strings are empty strings, false otherwise
	 */
	public boolean textFieldEmpty(String user, String pass1, String pass2) {
		if (user.equals("") || pass1.equals("") || pass2.equals("")) {
			JOptionPane.showMessageDialog(this, "One or more field is empty");
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to make sure the user entered matching passwords (strings match).
	 * @param pass1 the password as a String
	 * @param pass2 the retyped password as a String
	 * @return true if the strings match, false otherwise
	 */
	public boolean passwordsMatch(String pass1, String pass2) {
		if (pass1.equals(pass2)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Passwords do not match");
			return false;
		}
	}
	
	/**
	 * Checks if the username is available by checking to see if there is already a User with that username.
	 * @param user username as a String
	 * @return true if no other user has the username, false otherwise
	 */
	public boolean userNameAvailable(String user) {
		for (User entry : userInfo) {
			if (entry.getUsername().equals(user.toLowerCase())) { //username is not case sensitive
				JOptionPane.showMessageDialog(this, "This username is taken");
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * ActionPerformer for createAccount button. If createAccount is pressed, program checks that 
	 * no text fields were left blank, the entered username is available, and the passwords entered match.
	 * If all of this is true, a new User is created and added to our Set of Users. This information
	 * is then written to our UserInfo file, the CreateAccountPage's visibility is set to false
	 * and the LoginPage reappears so the user can log in with their new credentials.  
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(create)) {
			if (!textFieldEmpty(userField.getText(), passField.getText(), retypeField.getText())) {
				if (userNameAvailable(userField.getText())) {
					if (passwordsMatch(passField.getText(), retypeField.getText())) {
						User user = new User(userField.getText().toLowerCase(), passField.getText());
						userInfo.add(user);
						writeToFile("UserInfo.csv", userInfo);
						this.setVisible(false);
						JOptionPane.showMessageDialog(this, "Account successfully created");
						LoginPage loginP = new LoginPage();
						loginP.setVisible(true);
					}
				}
			}
			
		}
		
	}
}
