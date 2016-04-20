package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DatabaseModel {
	
	//private data fields
	//ArrayList of ActionListeners to be registered later on
	ArrayList<ActionListener> actionListenerList; 
	
	//methods that belong to the DatabaseModel Class
	/** Register an action event listener */
	public void addActionListener(ActionListener aL){
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(aL);
	}
	
	/** Remove an action event listener */
	public void removeActionListener(ActionListener aL){
		if (actionListenerList != null && actionListenerList.contains(aL)) {
			actionListenerList.remove(aL);
		}
	}
	
	public void processEvent(ActionEvent event){
			if (actionListenerList == null){
				return;
			}
			
		for (int i = 0; i < actionListenerList.size(); i++) {
			ActionListener listener = actionListenerList.get(i);
			listener.actionPerformed(event);
		}
	}
}
