import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutPage extends JFrame {
	
	private JPanel panel;
	private JTextArea area;
	public AboutPage() {
		
		
		super("About Hooli Suite");
		this.setBounds(250, 200, 400, 300);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
		makePanel();
	}
	
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
	
	public void makePanel() {
		panel = new JPanel();
		area = new JTextArea(30, 30);
		area.setEditable(false);
		showText();
		panel.add(area);
		this.add(panel);
	}

}
