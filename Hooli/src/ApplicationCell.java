import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ApplicationCell extends JLabel implements ListCellRenderer<Application> {
	Color background;
	Color foreground;
	
	public ApplicationCell() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Application> list, Application value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		// TODO Auto-generated method stub
		this.setText(value.getName() + "   by  " + value.getPublisher());
		JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null && !dropLocation.isInsert() && dropLocation.getIndex() == index) {
            background = Color.BLUE;
            foreground = Color.WHITE;
        // check if this cell is selected
        } else if (isSelected) {
            background = Color.RED;
            foreground = Color.WHITE;
        // unselected
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        };

        this.setBackground(background);
        this.setForeground(foreground);

        return this;
	}

}
