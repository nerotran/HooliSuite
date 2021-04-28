import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JComboBox;
import javax.swing.JFrame;
/**
 * Creates sort algorithm for application list
 * @author joejanaskie
 *
 */
public class SortBox extends JComboBox implements ActionListener {
	ArrayList<Application> list;
	JFrame frame;

	/**
	 * SortBox Constructor
	 * @param list list of applications
	 * @param frame frame for choices of what to sort list by
	 */
	public SortBox(ArrayList<Application> list, JFrame frame) {
		this.list = list;
		this.frame = frame;
		this.addItem("Name");
		this.addItem("Publisher");
		this.addItem("Platform");
		this.addItem("Price");
		this.addActionListener(this);
	}

	/**
	 * Sorts based on what user chooses to sort by
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String getItem = (String)this.getSelectedItem();
		
		if (getItem.equals("Name")) {
			list.sort(Comparator.comparing(Application::getName));
		}
		if (getItem.equals("Publisher")) {
			list.sort(Comparator.comparing(Application::getPublisher));
		}
		if (getItem.equals("Platform")) {
			list.sort(Comparator.comparing(Application::getPlatform));
		}
		if (getItem.equals("Price")) {
			list.sort(Comparator.comparing(Application::getPrice));
		}
		
		frame.repaint();
	}
}
