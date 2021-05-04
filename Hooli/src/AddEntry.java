import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEntry extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel name;
	private JLabel publish;
	private JLabel platform;
	private JLabel price;
	private JLabel release;
	private JLabel desc;
	private JLabel link;
	private JTextField nameInfo;
	private JTextField publishInfo;
	private JTextField platformInfo;
	private JTextField priceInfo;
	private JTextField releaseInfo;
	private JTextField descInfo;
	private JTextField linkInfo;
	private JButton addBut;
	Set<Application> requests;
	
	public AddEntry() {
		super("Add Entry");
		this.setBounds(450, 400, 700, 600);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		requests = pullRequestInfo("Request.csv");
	}
	
	public void buildPage() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(0,1);
		panel.setLayout(layout);
		
		name = new JLabel("Name: ");
		publish = new JLabel("Publisher: ");
		platform = new JLabel("Platform(s): ");
		price = new JLabel("Price (Example 2.0; No $): ");
		release = new JLabel("Released (Format xx/xx/xxxx): ");
		desc = new JLabel("Description: ");
		link = new JLabel("Link: ");
		nameInfo = new JTextField(10);
		publishInfo = new JTextField(10);
		platformInfo = new JTextField(10);
		priceInfo = new JTextField(10);
		releaseInfo = new JTextField(10);
		descInfo = new JTextField(30);
		linkInfo = new JTextField(10);
		addBut = new JButton("Add Entry");
		
		panel.add(name);
		panel.add(nameInfo);
		panel.add(publish);
		panel.add(publishInfo);
		panel.add(platform);
		panel.add(platformInfo);
		panel.add(price);
		panel.add(priceInfo);
		panel.add(release);
		panel.add(releaseInfo);
		panel.add(desc);
		panel.add(descInfo);
		panel.add(link);
		panel.add(linkInfo);
		layout.setVgap(3);
		panel.add(addBut);
		
		addBut.addActionListener(this);
		this.add(panel);
	}
	
	public void writeToFile(String fileName, Set<Application> data) {
		File file = new File(fileName);
		try {
			PrintWriter output = new PrintWriter(file);
			output.append("Name, Publisher, Platform, Description, Price, Link, Release, \n");
			
			for (Application app : data) {
				output.append(app.getName() + "," + app.getPublisher() + "," + app.getPlatform() + "," + 
						app.getDescription() + "," + app.getPrice() + "," + app.getLink() + "," + app.getDate() + ",\n");
			}
			
			output.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
	}
	
	public static Set<Application> pullRequestInfo(String fileName) {
		File file = new File(fileName);
		String appData = "";
		Set<Application> requests = new HashSet<>();
		try {
			Scanner input = new Scanner(file);
			if (input.hasNextLine()) {
				input.nextLine();
			}
			while (input.hasNext()) {
				appData = appData + input.next();
			}
			
			String[] userArray = appData.split(",");
			for (int i = 0; i+6 < userArray.length; i+=7) {
				Application user = new Application(userArray[i], userArray[i+1], userArray[i+2], (userArray[i+3]), 
						Double.parseDouble(userArray[i+4]), userArray[i+5], userArray[i+6]);
				requests.add(user);
			}
			input.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
		return requests;
	}
	
	/**
	 * 
	 * @param name
	 * @param publish
	 * @param plat
	 * @param price
	 * @param release
	 * @param desc
	 * @param link
	 * @return
	 */
	public boolean textFieldEmpty(String name, String publish, String plat, String price, String release,
			String desc, String link) {
		if (name.equals("") || publish.equals("") || plat.equals("") || price.equals("") || 
				release.equals("") || desc.equals("") || link.equals("")) {
			JOptionPane.showMessageDialog(this, "One or more field is empty");
			return true;
		}
		
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addBut)) {
			if (!textFieldEmpty(nameInfo.getText(), publishInfo.getText(), platformInfo.getText(), priceInfo.getText(),
					releaseInfo.getText(), descInfo.getText(), linkInfo.getText()) && !priceInfo.getText().contains("$")) {
				Application request = new Application(nameInfo.getText(), publishInfo.getText(), platformInfo.getText(), 
						descInfo.getText(), Double.parseDouble(priceInfo.getText()), linkInfo.getText(), releaseInfo.getText());
				requests.add(request);
				writeToFile("Request.csv", requests);
				this.setVisible(false);
				JOptionPane.showMessageDialog(this, "Request sent to Admins");
			}
			
		}
		
	}

}
