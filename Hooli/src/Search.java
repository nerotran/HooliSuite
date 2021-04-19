import java.util.ArrayList;

public class Search {

	private String string;
	private ArrayList<Application> list;
	private ArrayList<Application> finList;

	public Search(String s, ArrayList<Application> l) {
		string = s;
		list = l;
		finList = new ArrayList<>();
		check(string, list);
	}

	public void check(String s, ArrayList<Application> appList) {
		int count = 0;
		for (int i = 0; i < appList.size(); i++) {
//			if (appList.get(i).getDate().toString().toUpperCase().contains(s.toUpperCase())) {
//				finList.add(appList.get(i));
//				return true;
//			}
			if (appList.get(i).getName().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
			}
			if (appList.get(i).getDescription().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
			}
			if (appList.get(i).getLink().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
			}
			if (appList.get(i).getPlatform().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
			}
			if (appList.get(i).getPrice().toString().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
			}
			if (appList.get(i).getPublisher().toUpperCase().contains(s.toUpperCase())) {
				finList.add(appList.get(i));
			}
		}
	}


	public ArrayList<Application> originalList() {
		return list;
	}
	public ArrayList<Application> newList() {
		return finList;
	}


}




