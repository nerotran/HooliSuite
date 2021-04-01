import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Scanner;

public class Suite implements ActionListener,MouseListener,ItemListener {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField searchBar;
	private JButton filter;
	private JComboBox sort;
	private JButton login;
	private JButton search;
	private JScrollPane listScroll;
	JList<Application> listView;

	public static void main(String[] args) {
		new Suite();

	}
	
	public Suite() {
		super();
		makeFrame();
		makePanel();
		topPanel();
		appList();
		frame.add(panel, BorderLayout.NORTH);
		frame.add(listScroll, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
	    topPanel.add(search);

		filter = new JButton("Filter");
		topPanel.add(filter);

		sort = new JComboBox();
		sort.addItem("[Sort By: ] ");
		sort.addItem("Alphabet");
		sort.addItem("Publisher");
		sort.addItem("Date Added");
		sort.addItem("Price");
		sort.addItemListener(this);
		topPanel.add(sort);

		
		login = new JButton("Login");
		login.addActionListener(this);
		topPanel.add(login);

		panel.add(topPanel, BorderLayout.NORTH);
	}
	
	public void appList() {
		Application h1 = new Application("Suite1", "Hooli");
		Application h2 = new Application("Suite2", "Hooli");
		Application h3 = new Application("Suite3", "Hooli");
		Application h4 = new Application("Suite4", "Hooli");
		
		Application[] list = new Application[] {h1, h2, h3, h4};
		
		listView = new JList<Application>(list);
		listView.addMouseListener(this);
		listView.setCellRenderer(new ApplicationCell());
		listView.setVisibleRowCount(1);
		listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listScroll = new JScrollPane(listView);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LoginPage login = new LoginPage();
		login.buildPage();
		login.setVisible(true);
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
		
	}
	

}
