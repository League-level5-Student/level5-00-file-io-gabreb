package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	ArrayList<Task> t = new ArrayList<Task>();

	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public static void main(String[] args) {
		ToDoList d = new ToDoList();
		d.run();
	}

	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b1.setText("add tast");
		b2.setText("view tasks");
		b3.setText("remove task");
		b4.setText("save list");
		b5.setText("load list");
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			String k = JOptionPane.showInputDialog("Enter a task");
			t.add(new Task(k));
		} else if (e.getSource() == b2) {
			for (int i = 0; i < t.size(); i++) {
				JOptionPane.showMessageDialog(null, t.get(i).getMethod());
			}
		} else if (e.getSource() == b3) {

		} else if (e.getSource() == b4) {

		} else if (e.getSource() == b5) {

		}

	}
}
