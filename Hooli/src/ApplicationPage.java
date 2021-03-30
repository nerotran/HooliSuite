import javax.swing.JFrame;

public class ApplicationPage extends JFrame{
	private Application app;
	
	public ApplicationPage(Application app) {
		super();
		this.app = app;
		this.setBounds(50, 50, 800, 600);
		this.setResizable(true);
	}

}
