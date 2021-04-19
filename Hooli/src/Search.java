
public class Search {
	
	private String string;
	private Application[] list;
	
	public Search(String s, Application[] l) {
		string = s;
		list = l;
		check(string, list);
	}
	
	public boolean check(String s, Application[] appList) {
		for (int i = 0; i < appList.length; i++) {
			if (appList[i].getDate().toUpperCase().contains(s.toUpperCase())) {
				return true;
			}
			if (appList[i].getName().toUpperCase().contains(s.toUpperCase())) {
				System.out.println(appList[i]);
				return true;
			}
			if (appList[i].getDescription().toUpperCase().contains(s.toUpperCase())) {
				System.out.println(appList[i]);
				return true;
			}
			if (appList[i].getLink().toUpperCase().contains(s.toUpperCase())) {
				System.out.println(appList[i]);
				return true;
			}
			if (appList[i].getPlatform().toUpperCase().contains(s.toUpperCase())) {
				System.out.println(appList[i]);
				return true;
			}
			if (appList[i].getPrice().toUpperCase().contains(s.toUpperCase())) {
				System.out.println(appList[i]);
				return true;
			}
			if (appList[i].getPublisher().toUpperCase().contains(s.toUpperCase())) {
				System.out.println(appList[i]);
				return true;
			}
		}
		
		return false;
	}
	
	public Application[] newList() {
		
		Application[] t = new Application[10];
		t[0] = new Application("hi", "yo", "there");
		return t;
	}

}
