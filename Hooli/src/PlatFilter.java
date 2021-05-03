import java.util.ArrayList;
/**
 * PlatFilter uses a search algorithm to filter through an Application's
 * platforms Used in FilterBox.java and returns a list of filtered results for
 * searched platforms
 * @author Hooli
 *
 */
public class PlatFilter {
	
	private String string;
	private ArrayList<Application> list;
	private ArrayList<Application> finList;
	
	/**
	 * PlatFilter Constructor
	 * @param s string searched for
	 * @param l list of Applications
	 */
	public PlatFilter(String s, ArrayList<Application> l) {
		string = s;
		list = l;
		finList = new ArrayList<>();
		check(string, list);
	}

	/**
	 * Checks through the list to see if the searched string is found for an Application's platform
	 * If the string is found, it adds the Application to a new list to be used later
	 * @param s string searched for
	 * @param appList list of Applications
	 */
	public void check(String s, ArrayList<Application> appList) {
		int count = 0;
		for (int i = 0; i < appList.size(); i++) {
			System.out.println(appList.get(i).getName().toUpperCase().contains(s.toUpperCase()));
			
			if (appList.get(i).getPlatform().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
				System.out.println(s + " " + appList.get(i).getPlatform());
				continue;
			}
			
		}
	}

	/**
	 * Returns the original list of Applications
	 * @return list original Application list
	 */
	public ArrayList<Application> originalList() {
		return list;
	}
	
	/**
	 * Returns a list with Applications that match the searched results of platforms
	 * @return finList a new list with the searched results
	 */
	public ArrayList<Application> newList() {
		return finList;
	}

}
