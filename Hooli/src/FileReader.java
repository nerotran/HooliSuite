import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to read the application info from a file and display it on main Suite
 * page
 * 
 * @author Scott
 */
public class FileReader extends Reader {

	/**
	 * Unimplemented constructor
	 * 
	 * @param File the file to use
	 */
	public FileReader(File file) {
	}

	/**
	 * Reads from a file and turns the lines into application objects
	 * 
	 * @param inputFile The file to read
	 * @return an array list of application objects read from the file
	 */
	public static ArrayList<Application> readAppFile(String inputFile) {
		ArrayList<Application> arrlist = new ArrayList<Application>();
		try {
			File file = new File(inputFile);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {
				String tempStr = scanner.nextLine();
				String name = tempStr.substring(0, tempStr.indexOf("~"));
				tempStr = tempStr.substring(tempStr.indexOf("~") + 1);
				String publisher = tempStr.substring(0, tempStr.indexOf("~"));
				tempStr = tempStr.substring(tempStr.indexOf("~") + 1);
				String platform = tempStr.substring(0, tempStr.indexOf("~"));
				tempStr = tempStr.substring(tempStr.indexOf("~") + 1);
				String desc = tempStr.substring(0, tempStr.indexOf("~"));
				tempStr = tempStr.substring(tempStr.indexOf("~") + 1);
				String tempPrice = tempStr.substring(0, tempStr.indexOf("~"));
				tempStr = tempStr.substring(tempStr.indexOf("~") + 1);
				double price = Double.parseDouble(tempPrice);
				String link = tempStr.substring(0, tempStr.indexOf("~"));
				tempStr = tempStr.substring(tempStr.indexOf("~") + 1);
				String release = tempStr.substring(0);
				Application temp = new Application(name, publisher, platform, desc, price, link, release);
				arrlist.add(temp);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return arrlist;
	}

	/**
	 * Unimplemented override method
	 */
	@Override
	public void close() throws IOException {
	}

	/**
	 * Unimplemented override method
	 */
	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		return 0;
	}

}
