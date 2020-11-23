package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	FileReader fr;
	FileWriter fw; 

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
			String s = "Which task would you like to remove? ";
			for (int i = 0; i < t.size(); i++) {
				s+= "\n" + (i+1) + ": " + t.get(i).getMethod();
			}
			String remove = JOptionPane.showInputDialog(null, s);
			int remover = Integer.parseInt(remove);
			for (int i = 0; i <= t.size(); i++) {
				if (remover == (i+1)) {
					Task k = t.get(i);
					t.remove(t.get(i));
					if (remover > t.size() ||remover <= 0) {
						JOptionPane.showMessageDialog(null, "Invalid response");
					}
					else {
					JOptionPane.showMessageDialog(null, (i+1) + ": " + k.getMethod() + " was TERMINATED!");
					}
				}
			}
			
			
		} else if (e.getSource() == b5) {
			
		String FileLocation = JOptionPane.showInputDialog(null, "");
		try {
			fr = new FileReader(FileLocation);
			t.clear();
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			while (s != null) {
				t.add(new Task(s));
				s = br.readLine();
			}
			fr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		} else if (e.getSource() == b4) {
			String xio = "";
			for (int i = 0; i < t.size(); i++) {
				xio += t.get(i).getMethod() + "\n";
			}
			
			try {
				fw = new FileWriter("list.txt");
				fw.write(xio);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
