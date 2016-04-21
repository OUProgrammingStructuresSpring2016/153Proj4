import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class DatabaseModel extends Database implements Serializable{
	
	private static final long serialVersionUID = -380182387196408449L;
	
	

	//ArrayList of ActionListeners to be registered later on
	ArrayList<ActionListener> actionListenerList; 
	
	public DatabaseModel(MediaDatabase mdb, MediaPersonDatabase mpdb){
		super(mdb, mpdb);
	}
	
	public DatabaseModel(String fileName) throws IOException, ClassNotFoundException{
		super(null, null);
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		DatabaseModel d = (DatabaseModel) ois.readObject();
		ois.close();
		
		this.mdb = d.mdb;
		this.mpdb = d.mpdb;
		
	}
	
	//methods that belong to the DatabaseModel Class
	/** Register an action event listener */
	public synchronized void addActionListener(ActionListener aL){
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(aL);
	}
	
	/** Remove an action event listener */
	public synchronized void removeActionListener(ActionListener aL){
		if (actionListenerList != null && actionListenerList.contains(aL)) {
			actionListenerList.remove(aL);
		}
	}
	
	public void processEvent(ActionEvent e){
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			// Do not worry about the cast warning here.
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
	
	public void saveDatabase(String fileName) throws IOException{
		FileOutputStream filer = new FileOutputStream(fileName);
		ObjectOutputStream bw = new ObjectOutputStream(filer);
		bw.writeObject(this);
		bw.close();
	}
	
}
