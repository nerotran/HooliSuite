import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 * @author Nero
 * Format for each application on the list
 */
public class ApplicationCell extends JPanel implements ListCellRenderer<Application> {
	Color background;
	Color foreground;
	private JLabel name, publisher, price, platform;
	
	public ApplicationCell() {
		//GridLayout: ||Name||Publisher||Price||Platform
		this.setLayout(new GridLayout(1,4));
		name = new JLabel();
		publisher = new JLabel();
		price = new JLabel();
		platform = new JLabel();
		this.add(name);
        this.add(publisher);
        this.add(price);
        this.add(platform);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Application> list, Application value, int index,
			boolean isSelected, boolean cellHasFocus) {	
		// TODO Auto-generated method stub
		
		name.setText(value.getName());
		publisher.setText(value.getPublisher());
		price.setText("$" + value.getPrice());
		platform.setText(value.getPlatform());

        
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
        
        name.setBackground(background);
        name.setForeground(foreground);
        name.setFont(name.getFont().deriveFont(15.0f));
        
        publisher.setBackground(background);
        publisher.setForeground(foreground);
        publisher.setFont(publisher.getFont().deriveFont(15.0f));
        
        price.setBackground(background);
        price.setForeground(foreground);
        price.setFont(price.getFont().deriveFont(15.0f));
        
        platform.setBackground(background);
        platform.setForeground(foreground);
        platform.setFont(platform.getFont().deriveFont(15.0f));
        
        return this;
	}

}
