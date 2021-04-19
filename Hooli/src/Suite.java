import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Suite implements ActionListener,MouseListener,ItemListener {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField searchBar;
	private JComboBox filter;
	private SortBox sort;
	private JButton login;
	private JButton search;
	private JScrollPane listScroll;
	private JList<Application> listView;
	private ArrayList<Application> originalList;
	private ArrayList<Application> list;
	private ApplicationList<Application> appList;
	private boolean loggedIn;

	public static void main(String[] args) {
		File file = new File("comments");
		file.mkdirs();
		new Suite();

	}
	
	public Suite() {
		super();
		list = FileReader.readAppFile("ApplicationData.txt");
		list.sort(Comparator.comparing(Application::getName));
		makeFrame();
		makePanel();
		topPanel();
		appList();
		frame.add(panel, BorderLayout.NORTH);
		frame.add(listScroll, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		loggedIn = false;
	}
	
	
	public void makeFrame() {
		frame = new JFrame("Hooli Suite");
		frame.setLayout(new BorderLayout());
		frame.setBounds(50, 50, 800, 600);
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
	    search.addActionListener(this);
	    topPanel.add(search);

		filter = new JComboBox();
		filter.addItem("[Filter By: ] ");
		filter.addItem("Organization");
		filter.addItem("Platform");
		filter.addItem("Genre");
		filter.addItemListener(this);
		topPanel.add(filter);
		

		sort = new SortBox(list, frame);
		topPanel.add(sort);

		
		login = new JButton("Login");
		login.addActionListener(this);
		topPanel.add(login);

		panel.add(topPanel, BorderLayout.NORTH);
	}
	
	public void appList() {
		// Attempting to implement FileReader class
		appList = new ApplicationList<Application>(list);
		originalList = list;
		
		listView = new JList<Application>(appList);
		listView.addMouseListener(this);
		listView.setCellRenderer(new ApplicationCell());
		listView.setVisibleRowCount(1);
		listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listScroll = new JScrollPane(listView);
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public boolean getLoggedIn() {
		return loggedIn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(login)) {
			LoginPage loginP = new LoginPage();
			loginP.buildPage();
			loginP.setVisible(true);
		}
		if (e.getSource().equals(search)) {
			String text = searchBar.getText();
			Search search = new Search(text, list);
			if (text.equals("")) {
				appList.appList = originalList;
				list = originalList;
			}
			else {
				appList.appList = search.newList();
				list = search.newList();
			}
			
			frame.repaint();
			list = originalList;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			Application selectedItem = (Application) listView.getSelectedValue();
		    ApplicationPage appPage = new ApplicationPage(selectedItem);
		    appPage.setVisible(true);
		    
		}
       
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		String getItem = (String)sort.getSelectedItem();
		String getItem2 = (String)filter.getSelectedItem();
		
		// ItemListener for sort
		if (getItem.equals("Alphabet")) {
			JOptionPane.showMessageDialog(frame, "Alphabet sort would be here");
		}
		if (getItem.equals("Publisher")) {
			JOptionPane.showMessageDialog(frame, "Publisher sort would be here");
		}
		if (getItem.equals("Date Added")) {
			JOptionPane.showMessageDialog(frame, "Date Added sort would be here");
		}
		if (getItem.equals("Price")) {
			JOptionPane.showMessageDialog(frame, "Price sort would be here");
		}
		
		// ItemListener for filter
		if (getItem2.equals("Organization")) {
			JOptionPane.showMessageDialog(frame, "Organization filter would be here");
		}
		if (getItem2.equals("Platform")) {
			JOptionPane.showMessageDialog(frame, "Platform filter would be here");
		}
		if (getItem2.equals("Genre")) {
			JOptionPane.showMessageDialog(frame, "Genre filter would be here");
		}
		
	}
	

}
