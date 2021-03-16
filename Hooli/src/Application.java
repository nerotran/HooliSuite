import java.time.LocalDateTime;

public class Application {
	private String name;
	private String publisher;
	private String platform;
	private String description;
	private double price;
	private String link;
	private LocalDateTime date;
	
	public Application(String name, String publisher) {
		this(name, publisher, null, "", 0, null, null);
	}
	
	public Application(String name, String publisher, String platform) {
		this(name, publisher, platform, "", 0, null, null);
	}
	
	public Application(String name, String publisher, String platform, String description) {
		this(name, publisher, platform, description, 0, null, null);
	}
	
	public Application(String name, String publisher, String platform, String description, double price) {
		this(name, publisher, platform, description, price, null, null);
	}
	
	public Application(String name, String publisher, String platform, String description, double price, String link) {
		this(name, publisher, platform, description, price, link, null);
	}
	
	public Application(String name, String publisher, String platform, String description, double price, String link,
			LocalDateTime date) {
		this.name = name;
		this.publisher = publisher;
		this.platform = platform;
		this.description = description;
		this.price = price;
		this.link = link;
		this.date = date;
	}
	
	@Override
	public String toString() {
		String result = "Name: " + name;
		result += "\nPublisher: " + publisher;
		result += "\nPlatform: " + platform;
		result += "\nDescription: " + description;
		result += "\nPrice: $" + price;
		result += "\nLink: " + link;
		result += "\nReleased: " + date.toLocalDate();
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
	
	public double getPrice() {
		return price;
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
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

}
