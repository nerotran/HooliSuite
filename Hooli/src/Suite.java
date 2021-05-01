import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Suite Class
 * @author joejanaskie
 *
 */
public class Suite implements ActionListener,MouseListener {
	
	JFrame frame;
	private JPanel panel;
	private JTextField searchBar;
	private JComboBox filter;
	private SortBox sort;
	private JButton login;
	private JButton search;
	private JButton addEntry;
	private JScrollPane listScroll;
	private JList<Application> listView;
	ArrayList<Application> originalList;
	ArrayList<Application> list;
	ApplicationList<Application> appList;
	private boolean loggedIn;
	private JMenu about;
	private JMenuItem aboutItem;
	private JMenuItem helpItem;
	private JTabbedPane tabs;
	
	private JButton entryAccept, entryDeny;
	private JPanel entryPanel;
	private JScrollPane entryScroll;
	private JList<Application> entryView;
	ArrayList<Application> entries;
	ApplicationList<Application> entryList;
	
	//Permission level
	public static int pLevel = 0;

	public static void main(String[] args) {
		File file = new File("comments");
		file.mkdirs();
		new Suite();
	}
	/**
	 * Constructor
	 */
	public Suite() {
		super();
		list = FileReader.readAppFile("ApplicationData.txt");
		list.sort(Comparator.comparing(Application::getName));
		
		//Read entries requested from a text file
		entries = FileReader.readAppFile("ApplicationData.txt");
		entries.sort(Comparator.comparing(Application::getName));
		
		makeFrame();
		makeMenuBar();
		makePanel();
		topPanel();
		appList();
		entryList();
		
		
		tabs = new JTabbedPane();
		tabs.addTab("Applications", listScroll);
		tabs.addTab("Entries", entryPanel);
		
		//Disable the entries tab if not an admin
		if (pLevel < 2) {
			tabs.setEnabledAt(1, false);
		}
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(tabs, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		loggedIn = false;
	}
	
	/**
	 * Creates main frame
	 */
	public void makeFrame() {
		frame = new JFrame("Hooli Suite");
		frame.setLayout(new BorderLayout());
		frame.setBounds(50, 50, 800, 600);
		frame.setResizable(true);
	}
	
	/**
	 * Creates menu bar
	 */
	public void makeMenuBar() {
		JMenuBar jMBar = new JMenuBar();
		about = new JMenu("About");
		aboutItem = new JMenuItem("About HooliSuite");
		aboutItem.addActionListener(this);
		helpItem = new JMenuItem("Help");
		helpItem.addActionListener(this);
		about.add(aboutItem);
		about.add(helpItem);
		jMBar.add(about);
		frame.setJMenuBar(jMBar);
	}
	/**
	 * Create main panel for suite
	 */
	public void makePanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Hooli Suite"));
	}
	
	/**
	 * Create top panel which includes search, login, sort buttons, etc.
	 */
	public void topPanel() {
		JPanel topPanel = new JPanel();
        	    
		searchBar = new JTextField(20);
		topPanel.add(searchBar);
		
	    search = new JButton("Search");
	    search.addActionListener(this);
	    topPanel.add(search);

		filter = new FilterBox(list, this);
		topPanel.add(filter);
		

		sort = new SortBox(list, frame);
		topPanel.add(sort);

		
		login = new JButton("Login");
		login.addActionListener(this);
		topPanel.add(login);
		
		addEntry = new JButton("Add Entry");
		addEntry.addActionListener(this);
		topPanel.add(addEntry);

		panel.add(topPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Makes applications visible in list
	 */
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
	
	/**
	 * Makes requested entries visible in list
	 */
	public void entryList() {
		entryPanel = new JPanel();
		entryPanel.setLayout(new BoxLayout(entryPanel, BoxLayout.Y_AXIS));
		entryList = new ApplicationList<Application>(entries);
		
		entryView = new JList<Application>(entryList);
		entryView.addMouseListener(this);
		entryView.setCellRenderer(new ApplicationCell());
		entryView.setVisibleRowCount(1);
		entryView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		entryAccept = new JButton("Accept");
		
		entryScroll = new JScrollPane(entryView);
		entryPanel.add(entryScroll);
		entryPanel.add(entryAccept);
	}
	
	/**
	 * Sets user's authorization
	 * @param loggedIn sets value of whether user is logged in or not
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	/**
	 * Returns logged in value
	 * @return the value of whether the user is logged in
	 */
	public boolean getLoggedIn() {
		return loggedIn;
	}

	/**
	 * Adds functionality to buttons and other active listeners
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(addEntry)) {
			AddEntry addEntr = new AddEntry();
			addEntr.buildPage();
			addEntr.setVisible(true);
		}
		if (e.getSource().equals(login)) {
			LoginPage loginP = new LoginPage();
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

		if (e.getSource().equals(helpItem)) {
			new HelpPage();
		}
		if (e.getSource().equals(aboutItem)) {
			new AboutPage();
			
		}

	}

	/**
	 * Need to click an application in the list twice
	 */
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

}