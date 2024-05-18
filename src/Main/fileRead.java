//NAME: CRISTIAN PARRA 


package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename){
		//TODO: Open the filename, read in the data into the lines arraylist, and close the file when done...
		lines = new ArrayList<>();
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(filename));
	        String line = reader.readLine();
	        while (line != null) {
	            lines.add(line);
	            line = reader.readLine();
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
//    System.out.print(lines); debug
	}
	
	
	// Methods
	public int getNumberOfLines(){
		return lines.size();
	}
	
	public String getLine(int index){
		if (index < 0 || index >= lines.size()) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }
	    return lines.get(index);
	}
}
