import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationPage extends JFrame implements MouseListener {
	private Application app;
	private JLabel name, publisher, platform, description, price, date;
	private JButton link;
	private JPanel info;
	
	public ApplicationPage(Application app) {
		super();
		this.app = app;
		this.setBounds(50, 50, 800, 600);
		this.setResizable(true);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		graphics();
	}
	
	private void graphics() {
		info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		name = new JLabel("Name: " + this.app.getName());
		info.add(name);
		
		publisher = new JLabel("Publisher: " + this.app.getPublisher());
		info.add(publisher);

		platform = new JLabel("Platform: " + this.app.getPlatform());
		info.add(platform);

		price = new JLabel("Price: " + this.app.getPrice());
		info.add(price);
			
		date = new JLabel("Released: " + this.app.getDate());
		info.add(date);
		
		link = new JButton("Link");
		link.addMouseListener(this);
		info.add(link);
		
		description = new JLabel("Description: " + this.app.getDescription());
		info.add(description);
		
		this.add(info);

	}
	
	public static boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			if (!app.getLink().equals(""))
				openWebpage(new URI(app.getLink()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
