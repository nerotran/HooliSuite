import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Application {
	private String name;
	private String publisher;
	private String platform;
	private String description;
	private double price;
	private String link;
	private Date date;
	public ArrayList<Comment> comments;
	
	public Application(String name, String publisher) {
		this(name, publisher, "", "", 0, "", null);
	}
	
	public Application(String name, String publisher, String platform) {
		this(name, publisher, platform, "", 0, "", null);
	}
	
	public Application(String name, String publisher, String platform, String description) {
		this(name, publisher, platform, description, 0, "", null);
	}
	
	public Application(String name, String publisher, String platform, String description, double price) {
		this(name, publisher, platform, description, price, "", null);
	}
	
	public Application(String name, String publisher, String platform, String description, double price, String link) {
		this(name, publisher, platform, description, price, link, null);
	}
	
	public Application(String name, String publisher, String platform, String description, double price, String link,
			Date date) {
		this.name = name;
		this.publisher = publisher;
		this.platform = platform;
		this.description = description;
		this.price = price;
		this.link = link;
		this.date = date;
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
		
		result += " Released: ";
		result += getDate();
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return new Double(price);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDate() {
		if (this.date == null) {
			return "";
		}
		return this.date.toString();
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
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
