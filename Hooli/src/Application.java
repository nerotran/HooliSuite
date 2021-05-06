import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Nero
 * The class for applications
 */
public class Application {
	private String name;
	private String publisher;
	private String platform;
	private String description;
	private double price;
	private String link;
	private String release;
	public ArrayList<Comment> comments;
	
	/**
	 * @param name The application's name
	 * @param publisher The application's publisher
	 */
	public Application(String name, String publisher) {
		this(name, publisher, "", "", 0, "", "");
	}
	
	/**
	 * @param name The application's name
	 * @param publisher The application's publisher
	 * @param platform The application's platform
	 */
	public Application(String name, String publisher, String platform) {
		this(name, publisher, platform, "", 0, "", "");
	}
	
	/**
	 * @param name The application's name
	 * @param publisher The application's publisher
	 * @param platform The application's platform
	 * @param description The application's description
	 */
	public Application(String name, String publisher, String platform, String description) {
		this(name, publisher, platform, description, 0, "", "");
	}
	
	/**
	 * @param name The application's name
	 * @param publisher The application's publisher
	 * @param platform The application's platform
	 * @param description The application's description
	 * @param price The application's price
	 */
	public Application(String name, String publisher, String platform, String description, double price) {
		this(name, publisher, platform, description, price, "", "");
	}
	
	/**
	 * @param name The application's name
	 * @param publisher The application's publisher
	 * @param platform The application's platform
	 * @param description The application's description
	 * @param price The application's price
	 * @param link The link to the application's page
	 */
	public Application(String name, String publisher, String platform, String description, double price, String link) {
		this(name, publisher, platform, description, price, link, "");
	}
	
	/**
	 * @param name The application's name
	 * @param publisher The application's publisher
	 * @param platform The application's platform
	 * @param description The application's description
	 * @param price The application's price
	 * @param link The link to the application's page
	 * @param release The application's release date
	 */
	public Application(String name, String publisher, String platform, String description, double price, String link,
			String release) {
		this.name = name;
		this.publisher = publisher;
		this.platform = platform;
		this.description = description;
		this.price = price;
		this.link = link;
		this.release = release;
		comments = new ArrayList<Comment>();
		readFromFile();
	}
	
	@Override
	public String toString() {
		String result = "Name: " + name;
		result += " Publisher: " + publisher;
		
		result += " Platform: ";
		if (platform != null)
			result += platform;
		
		result += " Description: ";
		if (description != null)
			result += description;
		
		
		result += " Price: " + price;
		
		result += " Link: ";
		if (link != null)
			result += link;
		
		result += " Released: " + release;
		
		return result;
	}
	
	/**
	 * Name getter
	 * @return name The application's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Name setter
	 * @param name The application's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * publisher getter
	 * @return publisher The application's publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * publisher setter
	 * @param publisher The application's publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Platform getter
	 * @return platform The application's platform
	 */
	public String getPlatform() {
		return platform;
	}
	
	/**
	 * Platform setter
	 * @param platform The application's platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	/**
	 * Description getter
	 * @return description The application's description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Description setter
	 * @param description The application's description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Price getter
	 * @return price The application's price returned as the wrapper class for sorting purpose.
	 */
	public Double getPrice() {
		return new Double(price);
	}
	
	/**
	 * Price setter
	 * @param price The application's price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Link getter
	 * @return link The link to the application's page
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Link setter
	 * @param link The link to the application's page.
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Release date getter
	 * @return release The application's release date
	 */
	public String getDate() {
		return release;
	}
	
	/**
	 * comments getter
	 * @return comments ArrayList of all the application's comments.
	 */
	public ArrayList<Comment> getComments() {
		return comments;
	}

	/**
	 * Release date setter
	 * @param release The application's release date
	 */
	public void setDate(String release) {
		this.release = release;
	}
	
	/**
	 * Read the application's comments from .comment files.
	 */
	public void readFromFile() {
		
		File file = null;
		Scanner scanner = null;
		
		try {
			file = new File("comments\\" + this.name + ".comment");
			scanner = new Scanner(file);
			//scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String tempStr = scanner.nextLine();
				String author = tempStr.substring(0, tempStr.indexOf(","));
				String content = tempStr.substring(tempStr.indexOf(",") + 1);
				Comment temp = new Comment(author, content);
				comments.add(temp);
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
		} finally {
			
		}
	}
	
	

}
