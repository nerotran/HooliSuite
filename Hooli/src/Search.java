import java.util.ArrayList;
/**
 * Search algorithm
 * @author joejanaskie
 *
 */
public class Search {

	private String string;
	private ArrayList<Application> list;
	private ArrayList<Application> finList;

	/**
	 * Search constructor
	 * @param s the string that the user wants to search for
	 * @param l the list of applications
	 */
	public Search(String s, ArrayList<Application> l) {
		string = s;
		list = l;
		finList = new ArrayList<>();
		check(string, list);
	}

	/**
	 * Checks to see if user's searched word is found, adds it to a new array list
	 * @param s the string the user wants to search for.
	 * @param appList the list of applications to search through
	 */
	public void check(String s, ArrayList<Application> appList) {
		int count = 0;
		for (int i = 0; i < appList.size(); i++) {

			if (appList.get(i).getName().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
				continue;
			}
			if (appList.get(i).getPlatform().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
				continue;
			}
			if (appList.get(i).getPublisher().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
				continue;
			}
		}
	}


	/**
	 * gives the original application list
	 * @return original application list to when the application was loaded
	 */
	public ArrayList<Application> originalList() {
		return list;
	}
	/**
	 * gives the new application list based on what was searched
	 * @return new application list of all applications that have the searched string in it
	 */
	public ArrayList<Application> newList() {
		return finList;
	}


}




