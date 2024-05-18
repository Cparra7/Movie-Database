//NAME: CRISTIAN PARRA 



package Main;

import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import Main.Database;
import Main.fileRead;
import Main.fileWrite;
import Main.keyboardInput;
import java.io.IOException;


public class Main {
	public static void main(String[] args) {
	    Database database = new Database("src/db.txt"); // create a new Database instance
	    keyboardInput keyboard = new keyboardInput(); // create a new KeyboardInput instance
	    
	   
	    
	    String input;
	    do {
	    	
	    	System.out.println("----+-----+-----+-----+----"); //Acts as a padding for next input by user so it doesnt looked stacked on top eachother
	    	//also looks cool imo^
	    	System.out.print("Cristian's Movie Database");
	    	
	    	System.out.println("\na.) Input a new entry!");

	        System.out.println("b.) Search by Actor");

	        System.out.println("c.) Search by Year");

	        System.out.println("d.) Search by Runtime (in minutes)");

	        System.out.println("e.) Search by Director");

	        System.out.println("f.) Search by Movie Title");

	        System.out.println("g.) Quit Program");
	        
	        System.out.print("Enter Choice via Keyboard:");
	        input = keyboard.getKeyboardLine();
	       
	        
	        // primary and secondary commands
	        switch (input) {
	          
	        case "A":
	        case "a":
	        	System.out.println("Generate New Entry Below");
	            System.out.print("Enter title: ");
	            String title = keyboard.getKeyboardLine();
	            System.out.print("Enter actor 1: ");
	            String actor1 = keyboard.getKeyboardLine();
	            System.out.print("Enter actor 2: ");
	            String actor2 = keyboard.getKeyboardLine();
	            System.out.print("Enter director: ");
	            String director = keyboard.getKeyboardLine();
	            int year = 0;
	            boolean yearIsValid = false;
	            while (!yearIsValid) {
	                System.out.print("Enter year: ");
	                
	                //only integer to be inputted by user 
	                try {
	                    year = Integer.parseInt(keyboard.getKeyboardLine());
	                    yearIsValid = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid year entered. Please enter a valid year.");
	                }
	            }
	            int runtime = 0;
	            boolean runtimeIsValid = false;
	            while (!runtimeIsValid) {
	                System.out.print("Enter runtime (minutes): ");
	                
	                //so if a letter is inputted this try/catch block stops that 
	                try {
	                    runtime = Integer.parseInt(keyboard.getKeyboardLine());
	                    runtimeIsValid = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid runtime entered. Please enter a valid runtime in minutes.");
	                }
	            }
	//         Movie newMovie = new Movie(title, actor1, actor2, director, year, runtime); //not needed
//	            Database.addEntry(newMovie);// not needed
	           
	            fileWrite writer = new fileWrite("src/db.txt");
				writer.writeLine(title + "*" + actor1 + "*" + actor2 + "*" + director + "*" + year + "*" + runtime);
				writer.saveFile();
	           
	        
	            System.out.println("Entry added to database.");
	            break;

	          //  TODO MAKE SURE IT ADDS TO DB.TXT
	              
	            
	            case "B":
	            case "b":
	                System.out.print("Enter actor's name: ");
	                String actorName = keyboard.getKeyboardLine();
	                List<Movie> moviesByActor = database.searchByActor(actorName);
	                if (moviesByActor.isEmpty()) {
	                    System.out.println("No movies found.");
	                } else {
	                    System.out.println("Movies with " + actorName + ":");
	                    for (Movie movie : moviesByActor ) {
	                        System.out.println("- " + movie.getTitle()); //gets method
	                    }
	                }
	                break;

	            case "C":
	            case "c":
	                System.out.print("Enter year: ");
	                int searchYear = 0;
	               //allow only integer to be put in
	               
	                try {
	                    searchYear = Integer.parseInt(keyboard.getKeyboardLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Please enter an integer.");
	                    continue;
	                }
	                List<Movie> moviesByYear = database.searchByYear(searchYear);
	                if (moviesByYear.isEmpty()) {
	                    System.out.println("No movies found.");
	                } else {
	                    System.out.println("Movies made that year:");
	                    for (Movie movie : moviesByYear) {
	                        System.out.println("- " + movie.getTitle());
	                    }
	                }
	                break;

	            case "D":
	            case "d":
	                System.out.print("Enter runtime (minutes): ");
	                int searchRuntime = 0;
	                try {
	                    searchRuntime = Integer.parseInt(keyboard.getKeyboardLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Please enter a valid runtime.");
	                    continue;
	                }
	                List<Movie> moviesByRuntime = database.searchByRuntime(searchRuntime);
	                if (moviesByRuntime.isEmpty()) {
	                    System.out.println("No movies found.");
	                } else {
	                    System.out.println("Movies with that runtime:");
	                    for (Movie movie : moviesByRuntime) {
	                        System.out.println("- " + movie.getTitle());
	                    }
	                }
	                break;

	           
	            case "E":
	            case "e":
	                System.out.print("Enter director's name: ");
	            
	                String directorName = keyboard.getKeyboardLine();
	                List<Movie> moviesByDirector = database.searchByDirector(directorName);
	                if (moviesByDirector.isEmpty()) {
	                    System.out.println("No movies found.");
	                } else {
	                	System.out.println("Movies by that Director:");
	                    for (Movie movie : moviesByDirector) {
	                        System.out.println("- " +movie.getTitle());
	                    }
	                }
	                break;
	            case "F":
	            case "f":
	                System.out.print("Enter title: ");
	                String searchTitle = keyboard.getKeyboardLine();
	                List<Movie> moviesByTitle = database.searchByTitle(searchTitle);
	                if (moviesByTitle.isEmpty()) {
	                    System.out.println("No movies found.");
	                } else {
	                	System.out.println("Movies with same title:");
	                    for (Movie movie : moviesByTitle) {
	                        System.out.println("-" + movie.getTitle());
	                    }
	                }
	        
	        }
	        
	        
	    }
	    
	  
	    //quits the program and stops running
	    while (!input.equalsIgnoreCase("g"));
	    
	
	}
}

	      

	        
	      
	
	
	
	
	
	
	
	
   
	


