import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This view will prompt the user 
 *if they want to save their results as binary or text
 */
public class BinaryIOView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 880308253230243726L;
	//private Frame exportF = new Frame("Export");
	private JPanel jpExport = new JPanel();
	private JLabel jlInfo = new JLabel("Enter the name of the file to save/load.");
	public JTextField jtfFileName = new JTextField();
	public Button bSave = new Button("Save");
	public Button bLoad = new Button("Load");
	public Button bCancel = new Button ("Cancel");
	
	
	public BinaryIOView(){
		jpExport.setLayout(new GridLayout(4,2, 5, 15));
		setTitle("Binary Import/Export");
		jpExport.add(jlInfo);
		jpExport.add(jtfFileName);
		jpExport.add(bSave);
		jpExport.add(bLoad);
		jpExport.add(bCancel);
		add(jpExport);
		setSize(300,500);
		setLocationRelativeTo(null);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void registerSaveButtonListener(ActionListener al){
		bSave.addActionListener(al);
	}
	
	public void registerLoadButtonListener(ActionListener al){
		bLoad.addActionListener(al);
	}
	
}