import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader extends Reader {
	
	public static final String delimiter = ",";

	public FileReader(File file) {
		// TODO Auto-generated constructor stub
	}
	
	 /*public static ArrayList<Application> readAppFile(String csvFile) {
		 ArrayList<Application> list = new ArrayList<Application>();
		    try {
		    	File file = new File(csvFile);
		        FileReader fr = new FileReader(file);
		        BufferedReader br = new BufferedReader(fr);
		        String line = "";
		        String[] tempArr;
		        System.out.print(csvFile);
		        line = br.readLine();
		        System.out.print("test");
		        System.out.print(line);
		        while ((line = br.readLine()) != null) {
		        	System.out.print("test");
		        	tempArr = line.split(delimiter);
		        	Application temp = new Application(tempArr[0], tempArr[1], tempArr[2], tempArr[3], Double.parseDouble(tempArr[4]),
		        			tempArr[5]);
		        	list.add(temp);
		        }
		        br.close();
		    }
		    catch(IOException ioe) {
		    	ioe.printStackTrace();
		    }
		    
		    return list;
		  } */
	
	public static ArrayList<Application> readAppFile(String csvFile) {
		ArrayList<Application> arrlist = new ArrayList<Application>();
		try {
			File file = new File("ApplicationData.txt");
			Scanner scanner = new Scanner(file);
			//scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String tempStr = scanner.nextLine();
				String first = tempStr.substring(0, tempStr.indexOf(","));
				tempStr = tempStr.substring(tempStr.indexOf(",") + 1);
				String last = tempStr.substring(0, tempStr.indexOf(","));
				tempStr = tempStr.substring(tempStr.indexOf(",") + 1);
				String platform = tempStr.substring(0, tempStr.indexOf(","));
				tempStr = tempStr.substring(tempStr.indexOf(",") + 1);
				String desc = tempStr.substring(0, tempStr.indexOf(","));
				tempStr = tempStr.substring(tempStr.indexOf(",") + 1);
				String tempPrice = tempStr.substring(0, tempStr.indexOf(","));
				tempStr = tempStr.substring(tempStr.indexOf(",") + 1);
				double price = Double.parseDouble(tempPrice);
				String link = tempStr.substring(0, tempStr.indexOf(","));
				tempStr = tempStr.substring(tempStr.indexOf(",") + 1);
				/*String first = scanner.next();
				String last = scanner.next();
				String platform = scanner.next();
				String desc = scanner.next();
				//System.out.println(desc);
				String tempPrice = scanner.next();
				System.out.println(tempPrice);
				//System.out.println(tempPrice);
				//tempPrice = tempPrice.substring(1);
				System.out.println(tempPrice + " TESTING ");
				double price = Double.parseDouble(tempPrice);
				String link = scanner.next();
				String date = scanner.next();*/
				Application temp = new Application(first, last, platform, desc, price, link);
				arrlist.add(temp);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		return arrlist;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
