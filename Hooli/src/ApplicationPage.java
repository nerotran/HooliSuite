import java.awt.BorderLayout; 
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class ApplicationPage extends JFrame implements ActionListener, WindowListener {
	private Application app;
	private JLabel name, publisher, platform, price, date, descLabel;
	private JButton link, delete;
	private JPanel info;
	private JTabbedPane tabs;
	private JScrollPane comments;
	private JList cListView;
	private ApplicationList<Comment> cList;
	private JTextArea commentBox, description;
	private JPanel commentTab;
	
	public ApplicationPage(Application app) {
		super();
		this.app = app;
		this.setLayout(new BorderLayout());
		this.setBounds(50, 50, 800, 650);
		this.setResizable(true);
		this.setAlwaysOnTop(true);
		this.addWindowListener(this);
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

		price = new JLabel("Price: $" + this.app.getPrice());
		info.add(price);
			
		date = new JLabel("Released: " + this.app.getDate());
		info.add(date);
		
		link = new JButton("Link");
		link.addActionListener(this);
		info.add(link);
		
		descLabel = new JLabel("Description: ");
		info.add(descLabel);
		
		description = new JTextArea();
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setText(app.getDescription());
		description.setEditable(false);
		
		JPanel post = new JPanel();
		post.setLayout(new BoxLayout(post, BoxLayout.Y_AXIS));
		commentBox = new JTextArea(20,70);
		commentBox.setLineWrap(true);
		commentBox.setWrapStyleWord(true);
		post.add(commentBox);
		JButton postButton = new JButton("Post");
		post.add(postButton);
		postButton.addActionListener(this);
		
		cList = new ApplicationList<Comment>(app.getComments());
		cListView = new JList(cList);
		comments = new JScrollPane(cListView);
		commentTab = new JPanel();
		commentTab.setLayout(new BoxLayout(commentTab, BoxLayout.Y_AXIS));
		commentTab.add(comments);
		delete = new JButton("Delete");
		commentTab.add(delete);
		delete.addActionListener(this);
		
		tabs = new JTabbedPane();
		tabs.addTab("Comments", commentTab);
		tabs.addTab("Post a comment", post);
		
		this.add(info, BorderLayout.NORTH);
		this.add(description, BorderLayout.CENTER);
		this.add(tabs, BorderLayout.SOUTH);
		
		

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
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getActionCommand().equals("Link")) {
			try {
				if (!app.getLink().equals(""))
					openWebpage(new URI(app.getLink()));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (event.getActionCommand().equals("Delete")) {
			Comment selectedItem = (Comment) cListView.getSelectedValue();
			app.getComments().remove(selectedItem);
			this.repaint();
		}
		
		if (event.getActionCommand().equals("Post")) {
			Comment temp = new Comment(Suite.username, commentBox.getText());
			app.getComments().add(temp);
			this.repaint();
			commentBox.setText("");
			comments.repaint();
		}
		
		this.repaint();
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		if (delete != null) {
			if (Suite.pLevel < 1) {
				delete.setEnabled(false);
			}
			else {
				delete.setEnabled(true);
			}
		}
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new FileOutputStream("comments\\" + app.getName() + ".comment", false));
			for (Comment c : app.getComments()) {
				out.write(String.format("%s,%s\n", c.getAuthor(), c.getContent()));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error in writing to file");
		} finally {
			
			try {
				out.close();
				
			} catch (Exception e) {
				//
			}
			
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
