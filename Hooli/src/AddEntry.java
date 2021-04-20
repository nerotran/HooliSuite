import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEntry extends JFrame implements ActionListener {
	
	private JPanel panel;
	private JLabel name;
	private JLabel publish;
	private JLabel platform;
	private JLabel price;
	private JLabel release;
	private JTextField nameInfo;
	private JTextField publishInfo;
	private JTextField platformInfo;
	private JTextField priceInfo;
	private JTextField releaseInfo;
	
	public AddEntry() {
		super("Add Entry");
		this.setBounds(450, 400, 700, 600);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void buildPage() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(0,1);
		panel.setLayout(layout);
		
		name = new JLabel("Name: ");
		publish = new JLabel("Publisher: ");
		platform = new JLabel("Platform: ");
		price = new JLabel("Price: ");
		release = new JLabel("Released: ");
		nameInfo = new JTextField(20);
		publishInfo = new JTextField(20);
		platformInfo = new JTextField(20);
		priceInfo = new JTextField(20);
		releaseInfo = new JTextField(20);
		
		panel.add(name);
		panel.add(nameInfo);
		panel.add(publish);
		panel.add(publishInfo);
		panel.add(platform);
		panel.add(platformInfo);
		panel.add(price);
		panel.add(priceInfo);
		panel.add(release);
		panel.add(releaseInfo);
		layout.setVgap(3);
		
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
