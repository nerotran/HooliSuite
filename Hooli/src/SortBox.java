import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SortBox extends JComboBox implements ActionListener {
	ArrayList<Application> list;
	JFrame frame;

	public SortBox(ArrayList<Application> list, JFrame frame) {
		this.list = list;
		this.frame = frame;
		this.addItem("Name");
		this.addItem("Publisher");
		this.addItem("Platform");
		this.addItem("Price");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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

		frame.repaint();
	}
}
