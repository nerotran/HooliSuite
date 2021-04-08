public class Application {
	private String name;
	private String publisher;
	private String platform;
	private String description;
	private double price;
	private String link;
	private String date;
	
	public Application(String name, String publisher) {
		this(name, publisher, "", "", 0, "", "");
	}
	
	public Application(String name, String publisher, String platform) {
		this(name, publisher, platform, "", 0, "", "");
	}
	
	public Application(String name, String publisher, String platform, String description) {
		this(name, publisher, platform, description, 0, "", "");
	}
	
	public Application(String name, String publisher, String platform, String description, double price) {
		this(name, publisher, platform, description, price, "", "");
	}
	
	public Application(String name, String publisher, String platform, String description, double price, String link) {
		this(name, publisher, platform, description, price, link, "");
	}
	
	public Application(String name, String publisher, String platform, String description, double price, String link,
			String date) {
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
		if (date != null)
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
	
	public String getPrice() {
		return String.format("$%,.2f", price);
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
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
