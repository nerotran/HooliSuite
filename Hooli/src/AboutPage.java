import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Creates the AboutPage that gives the user information about the program
 * 
 * @author Joe
 */
public class AboutPage extends JFrame {

	private JPanel panel;
	private JTextArea area;

	/**
	 * Default constructor
	 */
	public AboutPage() {
		super("About Hooli Suite");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
		makePanel();
	}

	/**
	 * Displays text from a file on the About page
	 */
	public void showText() {
		File file = new File("about.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scan.hasNext()) {
			area.append(scan.nextLine() + "\n");
		}
		scan.close();
	}

	/**
	 * Adds components to the JFrame
	 */
	public void makePanel() {
		panel = new JPanel();
		area = new JTextArea(30, 30);
		area.setEditable(false);
		showText();
		panel.add(area);
		this.add(panel);
	}

}
