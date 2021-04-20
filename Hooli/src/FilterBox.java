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
	static ArrayList<Application> list;
	static Suite s;
	ArrayList<Application> OriginalList;
	JFrame frame, barFrame;
	JTextField fSearchBar;
	JButton fSearch;
	JPanel fPanel;
	static String filter, filterWord;
	
	public FilterBox(ArrayList<Application> list, Suite s) {
		this.s = s;
		this.OriginalList = list;
		this.list = list;
		this.frame = frame;
		this.addItem("[Filter By: ]");
		this.addItem("Publisher");
		this.addItem("Platform");
		this.addItem("Default");
		this.addActionListener(this);
	}
	
	class AddFSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			filterWord = fSearchBar.getText();
			if (filter.equals("Publisher")) {
				System.out.println(filterWord);
				OrgFilter oFilter = new OrgFilter(filterWord, list);
				s.appList.appList = oFilter.newList();
				s.list = oFilter.newList();
				s.frame.repaint();
				
				
			}
			if (filter.equals("Platform")) {
				System.out.println(filterWord);
				PlatFilter pFilter = new PlatFilter(filterWord, list);
				s.appList.appList = pFilter.newList();
				s.list = pFilter.newList();
				s.frame.repaint();
				
			}
			
			System.out.println("TESTING ONE");
		}
	}
	
	public FilterBox() {
		super(); 
		JFrame barFrame = new JFrame("Filter");
		
		fSearchBar = new JTextField(20);
		fSearch = new JButton("Filter Search");
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
		
		if (getItem2.equals("Publisher")) {
			filter = "Publisher";
			//filterWord = fSearchBar.getText();
			FilterBox popUp = new FilterBox();
		}
		if (getItem2.equals("Platform")) {
			filter = "Platform";
			FilterBox popUp = new FilterBox();
		}
		if (getItem2.equals("Default")) {
			s.appList.appList = s.originalList;
			s.list = s.originalList;
			s.frame.repaint();
		}
		
	}

}
