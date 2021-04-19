import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SortBox extends JComboBox implements ItemListener {
	ArrayList<Application> list;
	JFrame frame;

	public SortBox(ArrayList<Application> list, JFrame frame) {
		this.list = list;
		this.frame = frame;
		this.addItem("Name");
		this.addItem("Publisher");
		this.addItem("Platform");
		this.addItem("Price");
		this.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
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
