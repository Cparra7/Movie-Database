/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

//NAME:CRISTIAN PARRA

package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine) {
        this.writeBuffer.add(newLine);
    }
    
	
	public void saveFile(){
		try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));
	        
	        // write all lines from the writeBuffer to the file
	        //Prints new line under already exisiting movies with propper appending
	        for (String line : writeBuffer) {
	        	writer.write("\n"+line); 
	            writer.newLine();
	        }
	        
	        writer.close();
	        System.out.println("File saved successfully!");
	    } catch (IOException e) {
	        System.out.println("Error Occured: " + e.getMessage());
	    }
	}
}
