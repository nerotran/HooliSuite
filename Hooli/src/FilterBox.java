import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterBox extends JComboBox implements ActionListener {
	ArrayList<Application> list;
	JFrame frame, barFrame;
	JTextField fSearchBar;
	JButton fSearch;
	JPanel fPanel;
	String filter;
	
	public FilterBox(ArrayList<Application> list, JFrame frame) {
		this.list = list;
		this.frame = frame;
		this.addItem("[Filter By: ]");
		this.addItem("Organization");
		this.addItem("Platform");
		this.addItem("Genre");
		this.addActionListener(this);
	}
	
	class AddFSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (filter.equals("Organization")) {
				//filter by organization
			}
			System.out.println("TESTING ONE");
		}
	}
	
	public FilterBox() {
		super(); 
		JFrame barFrame = new JFrame("Filter");
		
		JTextField fSearchBar = new JTextField(20);
		JButton fSearch = new JButton("Filter Search");
		AddFSearchListener l = new AddFSearchListener();
		fSearch.addActionListener(l);
		
		fPanel = new JPanel();
		//fPanel.setLayout(new BorderLayout());
		
		
		fPanel.add(fSearchBar);
		fPanel.add(fSearch);
		
		barFrame.add(fPanel);
		
		//barFrame.setLayout(new BorderLayout());
		barFrame.setBounds(150, 150, 400, 400);
		barFrame.setResizable(true);
		barFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String getItem2 = (String)this.getSelectedItem();
		
		if (getItem2.equals("Organization")) {
			filter = "Organization";
			FilterBox popUp = new FilterBox();
		}
		if (getItem2.equals("Platform")) {
			FilterBox popUp = new FilterBox();
		}
		if (getItem2.equals("Genre")) {
			FilterBox popUp = new FilterBox();
		}
	}

}
