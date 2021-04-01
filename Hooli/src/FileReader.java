import java.io.*;
import java.util.ArrayList;

public class FileReader extends Reader {
	
	public static final String delimiter = ",";

	public FileReader(File file) {
		// TODO Auto-generated constructor stub
	}
	
	 public static ArrayList<Application> readAppFile(String csvFile) {
		 ArrayList<Application> list = new ArrayList<Application>();
		    try {
		      File file = new File(csvFile);
		      FileReader fr = new FileReader(file);
		      BufferedReader br = new BufferedReader(fr);
		      String line = "";
		      String[] tempArr;
		      
		      while ((line = br.readLine()) != null) {
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
