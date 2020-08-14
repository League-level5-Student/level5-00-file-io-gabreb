package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
public static void main(String[] args) {
	

	String message1 = JOptionPane.showInputDialog("Do message");
	try {
		FileWriter message = new FileWriter("src/_01_File_Recorder/Gandalf.txt");
		message.write(message1);
		message.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
