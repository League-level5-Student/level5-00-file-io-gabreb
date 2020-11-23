package _04_Directory_Iteration;

import java.io.File;

import javax.swing.JFileChooser;

public class  DirectoryIterator {
	
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		JFileChooser jfc = new JFileChooser();  
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			DirectoryIterator.recursive(directory);
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2020 Supremest Pope Rebeiz)
		 
		 */
		//fw.write("", true);
	}
	
	static void recursive(File directory) {
		File[] files = directory.listFiles(); // kinda like this and giving each one a value new File[5];
		if(files != null) {
			for(File f : files) {
			  recursive(f);
			  System.out.println(f.getAbsolutePath());
			}
		}
	}
}