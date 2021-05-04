import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class CreateAccountPage extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel userName;
	private JLabel password;
	private JLabel retypePass;
	private JTextField userField;
	private JTextField passField;
	private JTextField retypeField;
	private JButton create;
	Map<Pair<String, String>, String> userInfo;
	
	public CreateAccountPage() {
		super("Create An Account");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		userInfo = Suite.pullUserInfo("UserInfo.csv");
		build();
	}
	
	public void writeToFile(String fileName, Map<Pair<String, String>, String> info) {
		File file = new File(fileName);
		try {
			PrintWriter output = new PrintWriter(file);
			output.append("Username, Password, Permission \n");
			
			Set<Entry<Pair<String, String>, String>> infoSet = info.entrySet();
			for (Entry<Pair<String, String>, String> entry : infoSet) {
				output.append(entry.getKey().getLeft() + "," + entry.getKey().getRight() + "," + entry.getValue() + ",\n");
			}
			
			output.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
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
	
	public boolean textFieldEmpty(String user, String pass1, String pass2) {
		if (user.equals("") || pass1.equals("") || pass2.equals("")) {
			JOptionPane.showMessageDialog(this, "One or more field is empty");
			return true;
		}
		
		return false;
	}
	
	public boolean passwordsMatch(String pass1, String pass2) {
		if (pass1.equals(pass2)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Passwords do not match");
			return false;
		}
	}
	
	public boolean userNameAvailable(String user) {
		if (userInfo.containsKey(user.toLowerCase())) { //username is not case sensitive
			JOptionPane.showMessageDialog(this, "This username is taken");
			return false;
		} 
		
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(create)) {
			if (!textFieldEmpty(userField.getText(), passField.getText(), retypeField.getText())) {
				if (userNameAvailable(userField.getText())) {
					if (passwordsMatch(passField.getText(), retypeField.getText())) {
						Pair<String, String> p = new ImmutablePair<>(userField.getText().toLowerCase(), passField.getText());
						userInfo.put(p, "user");
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
