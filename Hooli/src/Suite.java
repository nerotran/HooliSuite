import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * Suite Class
 * @author joejanaskie
 *
 */
public class Suite implements ActionListener,MouseListener {
	
	static JFrame frame;
	private static JLabel user;
	private JPanel panel;
	private JTextField searchBar;
	private JComboBox filter;
	private SortBox sort;
	private static JButton login;
	private JButton search;
	private JButton addEntry;
	private JScrollPane listScroll;
	private JList<Application> listView;
	ArrayList<Application> originalList;
	ArrayList<Application> list;
	ApplicationList<Application> appList;
	private JMenu about;
	private JMenuItem aboutItem;
	private JMenuItem helpItem;
	private static JTabbedPane tabs;
	
	private JButton entryAccept, entryDeny;
	private JPanel entryPanel;
	private JScrollPane entryScroll;
	private JList<Application> entryView;
	ArrayList<Application> entries;
	ApplicationList<Application> entryList;
	
	//username
	public static String username = "Anonymous";
	//Permission level
	public static int pLevel = 3;

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
		entries = AddEntry.pullRequestInfo("Request.csv");
		list.sort(Comparator.comparing(Application::getName));
		
		makeFrame();
		makeMenuBar();
		makePanel();
		appList();
		entryList();
		tabs = new JTabbedPane();
		tabs.addTab("Applications", listScroll);
		tabs.addTab("Requests", entryPanel);
		topPanel();
		
		//Disable the entries tab if not an admin
		
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(tabs, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * Creates main frame
	 */
	public void makeFrame() {
		frame = new JFrame("Hooli Suite");
		frame.setLayout(new BorderLayout());
		frame.setBounds(50, 50, 1280, 720);
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
		
		user = new JLabel();
		updateUser();
		
		user.setFont(user.getFont().deriveFont(20.0f));
		topPanel.add(user);

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
		entryDeny = new JButton("Deny");
		entryAccept.addActionListener(this);
		entryDeny.addActionListener(this);
		
		entryScroll = new JScrollPane(entryView);
		entryPanel.add(entryScroll);
		entryPanel.add(entryAccept);
		entryPanel.add(entryDeny);
	}
	
	/**
	 * Reads User data from a file and puts it into a Set so that usernames,
	 * passwords, and permission levels can be validated when logging in.
	 * @param fileName the name of the file that holds user data as a string
	 * @return a Set that stores User objects and their associated data 
	 */
	public static Set<User> pullUserInfo(String fileName) {
		File file = new File(fileName);
		String userData = "";
		Set<User> data = new HashSet<>();
		try {
			Scanner input = new Scanner(file);
			if (input.hasNextLine()) {
				input.nextLine();
			}
			while (input.hasNext()) {
				userData = userData + input.next();
			}
			
			// for testing purposes
			System.out.println(userData);
			
			String[] userArray = userData.split(",");
			for (int i = 0; i+2 < userArray.length; i+=3) {
				User user = new User(userArray[i], userArray[i+1]);
				pLevel = convertLevel(userArray[i+2]);
				user.updatePermission(pLevel);
				data.add(user);
			}
			
			input.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
		return data;
	}
	
	/**
	 * Takes in a string representation of the user's permission level
	 * and converts it to an int. Returns 1 if permission is "user", 
	 * 2 if permission is "mod", and 3 if permission is "admin". 
	 * Otherwise returns 1 (basic user permissions).
	 * @param level the user's permission level as a string
	 * @return permission level as an int
	 */
	public static int convertLevel(String level) {
		if (level.equals("user")) {
			pLevel = 1;
		} else {
			if (level.equals("mod")) {
				pLevel = 2;
			} else {
				if (level.equals("admin")) {
					pLevel = 3;
				} else {
					pLevel = 1;
				}
			}
		}
		
		return pLevel;
	}
	
	/**
	 * Updates the permission level
	 * @param level the value to change pLevel to
	 */
	public static void setPLevel(int level) {
		pLevel = level;
	}
	
	/**
	 * Returns the value of pLevel.
	 * @return pLevel as an int
	 */
	public static int getPLevel() {
		return pLevel;
	}
	
	/**
	 * Updates the value of the username string
	 * @param name the value to change the username string to
	 */
	public static void setUsername(String name) {
		username = name;
	}
	
	/**
	 * Returns the value of username
	 * @return username as a String
	 */
	public static String getUsername() {
		return username;
	}
	
	/** 
	 * Changes Suite's look and permissions after user logs in. 
	 * Updates the username and permission level displayed at the 
	 * top of the Suite window and enables the Entries tab if 
	 * user's permission is at least 3 (admin).
	 */
	public static void updateUser() {
		switch (pLevel) {
		case 0:
			user.setText(username + "(Guest)");
			user.setForeground(Color.GRAY);
			break;
		case 1:
			user.setText(username + "(User)");
			user.setForeground(Color.BLACK);
			break;
		case 2:
			user.setText(username + "(Moderator)");
			user.setForeground(Color.BLUE);
			break;
		case 3:
			user.setText(username + "(Admin)");
			user.setForeground(Color.RED);
			break;
		}
		
		if (pLevel > 0) {
			login.setEnabled(false);
		}
		
		if (pLevel < 3) {
			tabs.setEnabledAt(1, false);
		} else {
			tabs.setEnabledAt(1,true);
		}
		
		frame.validate();
		frame.repaint();
		
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
		
		if (e.getSource().equals(entryAccept)) {
			Application selectedItem = (Application) entryView.getSelectedValue();
			list.add(selectedItem);
			entries.remove(entryView.getSelectedIndex());
			AddEntry.writeToFile("ApplicationData.txt", list);
			AddEntry.removeRequest(selectedItem);
			frame.repaint();
		}
		if (e.getSource().equals(entryDeny)) {
			Application selectedItem = (Application) entryView.getSelectedValue();
			AddEntry.removeRequest(selectedItem);
			entries.remove(entryView.getSelectedIndex());
			frame.repaint();
		}

		if (e.getSource().equals(helpItem)) {
			new HelpPage();
		}
		if (e.getSource().equals(aboutItem)) {
			new AboutPage();
			
		}

	}

	/**
	 * Need to click an application multiple times 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Need to click twice for first page
		if (e.getClickCount() == 2) {
			Application selectedItem = (Application) listView.getSelectedValue();
		    ApplicationPage appPage = new ApplicationPage(selectedItem);
		    appPage.setVisible(true);
		    
		}
		// Need to click thrice for second page
		if (e.getClickCount() == 3) {
			Application selectedItem = (Application) entryView.getSelectedValue();
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
