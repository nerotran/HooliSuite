import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Suite {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField searchBar;
	private JButton filter;
	private JButton sort;
	private JButton login;
	private JButton search;

	public static void main(String[] args) {
		new Suite();

	}
	
	public Suite() {
		makeFrame();
		makePanel();
		topPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public void makeFrame() {
		frame = new JFrame("Hooli Suite");
		frame.setBounds(50, 50, 800, 600);
		frame.setAlwaysOnTop(true);
		frame.setResizable(true);
	}
	
	public void makePanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Hooli Suite"));
	}
	
	public void topPanel() {
		JPanel topPanel = new JPanel();
        	    
		searchBar = new JTextField(20);
		topPanel.add(searchBar);
		
		
	    search = new JButton("Search");
	    topPanel.add(search);

		filter = new JButton("Filter");
		topPanel.add(filter);

		sort = new JButton("Sort");
		topPanel.add(sort);

		
		login = new JButton("Login");
		topPanel.add(login);

		panel.add(topPanel, BorderLayout.NORTH);
	}
	

}
