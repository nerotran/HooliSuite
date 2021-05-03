import java.util.ArrayList;
/**
 * OrgFilter uses a search algorithm to filter through and Application's publishers
 * Used in FilterBox.java and returns a list of filtered results for searched publishers
 * @author Hooli
 *
 */
public class OrgFilter {
	
	private String string;
	private ArrayList<Application> list;
	private ArrayList<Application> finList;
	
	/**
	 * OrgFilter Constructor
	 * @param s string to be searched
	 * @param l list of Applications to filter through
	 */
	public OrgFilter(String s, ArrayList<Application> l) {
		string = s;
		list = l;
		finList = new ArrayList<>();
		check(string, list);
	}

	/**
	 * Checks through the list to see if the searched string is found for an Application's publisher
	 * If the string is found, it adds the Application to a new list to be used later
	 * @param s string to be searched
	 * @param appList list of applications
	 */
	public void check(String s, ArrayList<Application> appList) {
		int count = 0;
		for (int i = 0; i < appList.size(); i++) {
			System.out.println(appList.get(i).getName().toUpperCase().contains(s.toUpperCase()));
			
			if (appList.get(i).getPublisher().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
				continue;
			}
		}
	}

	/** 
	 * Returns the original Application list
	 * @return list original Application list
	 */
	public ArrayList<Application> originalList() {
		return list;
	}
	
	/**
	 * Returns a list with Applications that match the searched results of publishers
	 * @return finList a new list with the searched results
	 */
	public ArrayList<Application> newList() {
		return finList;
	}

}
