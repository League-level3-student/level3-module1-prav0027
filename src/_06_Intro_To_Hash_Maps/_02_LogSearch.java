package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	public static void main(String[] args) {
		_02_LogSearch log = new _02_LogSearch();
		log.setup();
		
		
	}
	
	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	
	void setup() {
		add.setText("Add");
		search.setText("Search");
		view.setText("View");
		remove.setText("Remove");
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add){
			int idnum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a new ID."));
			String name = JOptionPane.showInputDialog("Please enter a name.");
			hashmap.put(idnum, name);
		}
		else if(e.getSource()==search) {
			int idnum = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number."));
			if(hashmap.containsKey(idnum)==true) {
			JOptionPane.showMessageDialog(null, "The person with the ID number is "+idnum+" is "+hashmap.get(idnum));
		}
			else {
				JOptionPane.showMessageDialog(null, "This entry does not exist.");
			}
	}
		else if(e.getSource()==view) {
			for(Integer i : hashmap.keySet()){
				JOptionPane.showMessageDialog(null, "ID: "+i+"  Name: "+hashmap.get(i));
			}
		}
		else if(e.getSource()==remove) {
			int idnum = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number."));
			if(hashmap.containsKey(idnum)==true) {
				hashmap.remove(idnum);
			}
			else {
				JOptionPane.showMessageDialog(null, "This ID number is not on the list.");
			}
		}
	
}
}
