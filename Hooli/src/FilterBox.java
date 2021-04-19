import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FilterBox extends JComboBox implements ItemListener {
	ArrayList<Application> list;
	JFrame frame;
	
	public FilterBox(ArrayList<Application> list, JFrame frame) {
		this.list = list;
		this.frame = frame;
		this.addItem("[Filter By: ]");
		this.addItem("Organization");
		this.addItem("Platform");
		this.addItem("Genre");
		this.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		String getItem2 = (String)this.getSelectedItem();
		
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
