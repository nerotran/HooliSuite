
public class Comment {
	private String author;
	private String content;
	
	public Comment(String content) {
		this("Anonymous", content);
	}
	
	public Comment(String author, String content) {
		this.author = author;
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String toString() {
		return String.format("Author: %-40s Comment: %s", this.author, this.content);
	}
}
