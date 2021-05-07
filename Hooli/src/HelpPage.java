import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Creates the HelpPage that gives users information about how to use the
 * program
 * 
 * @author Joe
 */
public class HelpPage extends JFrame {
	private JPanel panel;
	private JTextArea area;

	/**
	 * Default constructor
	 */
	public HelpPage() {
		super("Help Page");
		this.setBounds(100, 100, 600, 400);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
		makePanel();
	}

	/**
	 * Displays text from a file on the Help page
	 */
	public void showText() {
		File file = new File("help.txt");
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
