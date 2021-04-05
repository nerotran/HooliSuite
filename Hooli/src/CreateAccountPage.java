import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateAccountPage extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel userName;
	private JLabel password;
	private JLabel retypePass;
	private JTextField userField;
	private JTextField passField;
	private JTextField retypeField;
	private JButton create;
	
	public CreateAccountPage() {
		super("Create An Account");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(create)) {
			this.setVisible(false);
		}
		
	}
}
