import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates the LoginPage that allows a user to enter in a username and password
 * into textfields Allows the user to interact with a sign in button or a create
 * account button CreateAccountPage pops up when the create account button is
 * pressed
 * 
 * @author Corrina Martinez
 *
 */
public class LoginPage extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel userName;
	private JLabel password;
	private JTextField userField;
	private JTextField passField;
	private JButton signIn;
	private JButton createAccount;
	int level = 0;

	Set<User> userInfo;

	/**
	 * LoginPage Constructor
	 */
	public LoginPage() {
		super("Login");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		userInfo = Suite.pullUserInfo("UserInfo.csv");

		buildPage();
	}

	/**
	 * Builds the LoginPage, adds all of the components to the JFrame
	 */
	public void buildPage() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
		panel.setLayout(layout);

		userName = new JLabel("Username: ");
		password = new JLabel("Password: ");
		userField = new JTextField(20);
		passField = new JTextField(20);
		signIn = new JButton("Sign In");
		createAccount = new JButton("Create an Account");
		panel.add(userName);
		panel.add(userField);
		panel.add(password);
		panel.add(passField);
		layout.setVgap(3);
		panel.add(signIn);
		panel.add(createAccount);

		signIn.addActionListener(this);
		createAccount.addActionListener(this);

		this.add(panel);
	}

	/**
	 * Validates a user's login information by checking if the 
	 * username and password match a User in the userInfo Set
	 * 
	 * @param user string for a username
	 * @param password string for a password
	 * @return boolean true if Login info is valid, false otherwise
	 */
	public boolean validateLogin(String user, String password) {
		for (User entry : userInfo) {
			if (entry.getUsername().equals(user.toLowerCase()) && entry.getPassword().equals(password)) {
				level = entry.getPermission();
				return true;
			}
		}

		JOptionPane.showMessageDialog(this, "Username and password do not belong to an existing account");
		return false;
	}

	/**
	 * ActionPerformer for signIn and createAccount button If signIn is pressed, the
	 * LoginPage's visibility is set to false and disappears If createAccount is
	 * pressed, CreateAccountPage pops up
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(signIn)) {
			if (validateLogin(userField.getText(), passField.getText())) {
				Suite.setUsername(userField.getText());
				Suite.setPLevel(level);
				Suite.updateUser();
				this.setVisible(false);
				JOptionPane.showMessageDialog(this, "Login successful");
			}
		} else {
			if (e.getSource().equals(createAccount)) {
				this.setVisible(false);
				CreateAccountPage createPage = new CreateAccountPage();
				createPage.setVisible(true);
			}
		}

	}

}
