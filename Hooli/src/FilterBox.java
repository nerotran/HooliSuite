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
	ArrayList<Application> list, finList, originalList;
	ApplicationList<Application> appList;
	JFrame frame, barFrame;
	public JTextField fSearchBar;
	public JButton fSearch;
	JPanel fPanel;

	String string;
	
	
	
//	public FilterBox() {
//		super();
//		JFrame barFrame = new JFrame("Filter");
//
//		JTextField fSearchBar = new JTextField(20);
//		JButton fSearch = new JButton("Filter Search");
//		// ActionListener listener = new AddFSearchListener();
//		fSearch.addActionListener(this);
//
//		fPanel = new JPanel();
//
//		fPanel.add(fSearchBar);
//		fPanel.add(fSearch);
//
//		barFrame.add(fPanel);
//
//		barFrame.setBounds(150, 150, 400, 400);
//		barFrame.setResizable(true);
//		barFrame.setVisible(true);
//	}
	
	

	public FilterBox(ArrayList<Application> list) {
		this.list = list;
		this.frame = frame;
		this.addItem("[Filter By: ]");
		this.addItem("Organization");
		this.addItem("Platform");
		this.addItem("Genre");
		this.addActionListener(this);
		
		
//		this.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JComboBox<String> combo = (JComboBox<String>) e.getSource();
//		        String selectedBook = (String) combo.getSelectedItem();
//		 
//		        if (selectedBook.equals("Organization")) {
//		        	FilterBox popUp = new FilterBox();
//		            System.out.println("Good choice!");
//		        }
//		    }
//		});
			
	} // end of FilterBOX(STUFF) method
	
	public void filtering1(String s, ArrayList<Application> l) {
		
	}

//	class AddFSearchListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			
//			if (event.getSource().equals(fSearch)) {
//				System.out.println("TESTING ONE");
//
//			}
//		}
//	}
//
//	public FilterBox() {
//		super();
//		JFrame barFrame = new JFrame("Filter");
//
//		JTextField fSearchBar = new JTextField(20);
//		JButton fSearch = new JButton("Filter Search");
//	    ActionListener listener = new AddFSearchListener();
//		fSearch.addActionListener(listener);
//
//		fPanel = new JPanel();
//
//		fPanel.add(fSearchBar);
//		fPanel.add(fSearch);
//
//		barFrame.add(fPanel);
//
//		barFrame.setBounds(150, 150, 400, 400);
//		barFrame.setResizable(true);
//		barFrame.setVisible(true);
//	}
//
//	public FilterBox(String string, ArrayList<Application> list) {
//		System.out.println("Tester Text");
//	}

	public void actionPerformed(ActionEvent e) {
		String getItem2 = (String) this.getSelectedItem();
		
//		if (e.getSource().equals(fSearch)) {
//			System.out.println("PAIN PEKO");
//		}
		
		if (getItem2.equals("[Filter By: ]")) {
			//set to original list
//			appList.appList = originalList;
//			list = originalList;
//			frame.repaint();
		}

		if (getItem2.equals("Organization")) {
			//FilterBox popUp = new FilterBox();
			//list.sort(Comparator.comparing(Application::getPrice));

			System.out.println("HI");
			

		}

//		if (getItem2.equals("Platform")) {
//			FilterBox popUp = new FilterBox();
//
//		}
//
//		if (getItem2.equals("Genre")) {
//			FilterBox popUp = new FilterBox();
//
//		}

		//frame.repaint();
	}

}
