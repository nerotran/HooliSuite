import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel userName;
	private JLabel password;
	private JTextField userField;
	private JTextField passField;
	private JButton signIn;
	private JButton createAccount;
	
	public LoginPage() {
		super("Login");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void buildPage() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(0,1);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(signIn)) {
			this.setVisible(false);
		}
		
		
		
	}

}
