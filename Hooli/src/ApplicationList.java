import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Creates an ApplicationList backed by an ArrayList so we can store the apps we
 * want to display in the main Suite window.
 * 
 * @author Nero
 *
 * @param <T>
 */
public class ApplicationList<T> implements ListModel<T> {
	ArrayList<T> appList;
	private ArrayList<ListDataListener> listeners = new ArrayList<ListDataListener>();

	/**
	 * Default constructor
	 */
	public ApplicationList() {
		super();
		appList = new ArrayList<T>();
	}

	/**
	 * Constructor that takes in an arrayList
	 * 
	 * @param appList the ArrayList to set appList equal to
	 */
	public ApplicationList(ArrayList<T> appList) {
		super();
		this.appList = appList;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		listeners.add(arg0);
	}

	/**
	 * Returns the element at the specified index in the arraylist
	 * @param arg0 the index in the arraylist 
	 */
	@Override
	public T getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return appList.get(arg0);
	}

	/**
	 * Returns the size of the arraylist
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return appList.size();
	}

	/**
	 * Adds a value to the arraylist
	 * @param arg0 the value to add to the arraylist
	 */
	public void add(T arg0) {
		// TODO Auto-generated method stub
		appList.add(arg0);
		ListDataEvent addition = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, appList.size() - 1, appList.size() - 1);
        for (ListDataListener l : listeners) {
            l.intervalAdded(addition);
        }
	}
	
	/**
	 * Remove a value to the arraylist
	 * @param arg0 the value to be removed from the arraylist
	 */
	public void remove(T arg0) {
		// TODO Auto-generated method stub
		appList.remove(arg0);
        ListDataEvent removal = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, appList.size(), appList.size());
        for (ListDataListener l : listeners) {
            l.intervalRemoved(removal);
        }
	}
	

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		listeners.remove(arg0);

	}

}
