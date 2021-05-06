/**
 * Comment class that stores the comment's content and the username of the
 * comment's author as strings.
 * 
 * @author Nero
 */
public class Comment {
	private String author;
	private String content;

	/**
	 * Constructor that takes in a string to use as the content of the comment. Sets
	 * the author to Anonymous.
	 * 
	 * @param content the value to set the content variable equal to
	 */
	public Comment(String content) {
		this("Anonymous", content);
	}

	/**
	 * Constructor that takes in two strings, author and content.
	 * 
	 * @param author  the value to set author equal to
	 * @param content the value to set content equal to
	 */
	public Comment(String author, String content) {
		this.author = author;
		this.content = content;
	}

	/**
	 * Returns the comment author
	 * 
	 * @return the value of author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Updates the value of author
	 * 
	 * @param author the value to set author equal to
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the value of content (the comment text)
	 * 
	 * @return the value of content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Updates the comment's content
	 * 
	 * @param content the value to set content equal to
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns a formatted String representation of a Comment object
	 */
	public String toString() {
		return String.format("Author: %-40s Comment: %s", this.author, this.content);
	}
}
