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

/**
 * Creates an AddEntry page where users can enter details about an application
 * they'd like to add to the repository.
 * 
 * @author Scott
 */
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

	/**
	 * Default constructor
	 */
	public AddEntry() {
		super("Add Entry");
		this.setBounds(450, 400, 700, 600);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		requests = pullRequestInfo("Request.csv");
	}

	/**
	 * Builds the AddEntry page, adds all of the components to the JFrame
	 */
	public void buildPage() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(0, 1);
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

	/**
	 * Reads Application data from a Set containing all the Applications in the
	 * repository and writes their information to a file.
	 * 
	 * @param fileName the name of the file to write to as a String
	 * @param data     the Set to pull data from
	 */
	public void writeToFile(String fileName, Set<Application> data) {
		File file = new File(fileName);
		try {
			PrintWriter output = new PrintWriter(file);
			output.append("Name, Publisher, Platform, Description, Price, Link, Release, \n");

			for (Application app : data) {
				output.append(
						app.getName() + "," + app.getPublisher() + "," + app.getPlatform() + "," + app.getDescription()
								+ "," + app.getPrice() + "," + app.getLink() + "," + app.getDate() + ",\n");
			}

			output.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}

	}

	/**
	 * Reads Application data from a file and puts it into a Set so that Application
	 * data can be displayed in the main Suite window.
	 * 
	 * @param fileName the name of the file to read data from as a String
	 * @return a Set that stores Application objects and their associated data
	 */
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
			for (int i = 0; i + 6 < userArray.length; i += 7) {
				Application user = new Application(userArray[i], userArray[i + 1], userArray[i + 2], (userArray[i + 3]),
						Double.parseDouble(userArray[i + 4]), userArray[i + 5], userArray[i + 6]);
				requests.add(user);
			}
			input.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}

		return requests;
	}

	/**
	 * Checks that none of the fields have been left blank (none of the supplied
	 * strings are empty strings)
	 * 
	 * @param name    the name of the application
	 * @param publish the publisher of the application
	 * @param plat    the platform of the application
	 * @param price   the price of the application
	 * @param release the release date as a string
	 * @param desc    the description of the application
	 * @param link    a link to the application as a string
	 * @return true if one or more of the strings is an empty string, false
	 *         otherwise
	 */
	public boolean textFieldEmpty(String name, String publish, String plat, String price, String release, String desc,
			String link) {
		if (name.equals("") || publish.equals("") || plat.equals("") || price.equals("") || release.equals("")
				|| desc.equals("") || link.equals("")) {
			JOptionPane.showMessageDialog(this, "One or more field is empty");
			return true;
		}

		return false;
	}

	/**
	 * ActionPerformer for the Add button. If Add is pressed, the program checks
	 * that none of the text fields were left blank, creates a new Application with
	 * the information given, and adds it to the Set of requested Applications. This
	 * information is then written to the Requests file, and the AddEntry page's
	 * visibility is set to false and disappears.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addBut)) {
			if (!textFieldEmpty(nameInfo.getText(), publishInfo.getText(), platformInfo.getText(), priceInfo.getText(),
					releaseInfo.getText(), descInfo.getText(), linkInfo.getText())
					&& !priceInfo.getText().contains("$")) {
				Application request = new Application(nameInfo.getText(), publishInfo.getText(), platformInfo.getText(),
						descInfo.getText(), Double.parseDouble(priceInfo.getText()), linkInfo.getText(),
						releaseInfo.getText());
				requests.add(request);
				writeToFile("Request.csv", requests);
				this.setVisible(false);
				JOptionPane.showMessageDialog(this, "Request sent to Admins");
			}

		}

	}

}
