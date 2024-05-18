//NAME: CRISTIAN PARRA 


package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Database {
	// Fields
	private static ArrayList<Movie> movies; //Make <movie> to string maybe
	
	// Constructor
	public Database(String filename){
		movies = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String raw = fr.getLine(i);
			//System.out.println(raw); //debug
			// TODO: Parse using the StringTokenizer here and place into movies as single entries...
			StringTokenizer st = new StringTokenizer(raw, "*");
			String title = st.nextToken().trim();
			String actor1 = st.nextToken().trim();
			String actor2 = st.nextToken().trim();
			String director  = st.nextToken().trim();
			int year = Integer.parseInt(st.nextToken().trim());
			int runtimeMinutes = Integer.parseInt(st.nextToken().trim());
			
			
			Movie m = new Movie(title, actor1, actor2, director, year, runtimeMinutes);
			movies.add(m);
			
			//System.out.println(m); //Debug
		}
	}
	
	public static void addEntry(Movie newEntry){
		movies.add(newEntry);
	    fileWrite writer = new fileWrite("src/db.txt");
	    writer.writeLine(newEntry.toString());
	    writer.saveFile();
	}
	
	public List<Movie> searchByTitle(String title) {
	    List<Movie> results = new ArrayList<Movie>();
	    for (Movie movie : movies) {
	        if (movie.getTitle().trim().equalsIgnoreCase(title)) {
	            results.add(movie);
	        }
	    }
	    return results;
	}
	
	public List<Movie> searchByActor(String actorName) {
	    List<Movie> result = new ArrayList<>();
	    for (Movie movie : movies) {
	        if (movie.getActor1().trim().equalsIgnoreCase(actorName)) {
	            result.add(movie);
	        }else if (movie.getActor2().trim().equalsIgnoreCase(actorName)) { 
	        	result.add(movie);
	        }
	    }
	
	    return result;
	}

	
	public List<Movie> searchByDirector(String director) {
	    List<Movie> results = new ArrayList<Movie>();
	    for (Movie movie : movies) {
	        if (movie.getDirector().trim().equalsIgnoreCase(director)) {
	            results.add(movie);
	        }
	    }
	    return results;
	}
	
	public List<Movie> searchByYear(int year) {
	    List<Movie> results = new ArrayList<>();
	    for (Movie movie : movies) {
	        if (movie.getYear() == year) {
	            results.add(movie);
	        }
	    }
	    return results;
	}
	public List<Movie> searchByRuntime(int runtime) {
	    List<Movie> results = new ArrayList<Movie>();
	    for (Movie movie : movies) {
	        if (movie.getRuntime() == runtime) {
	            results.add(movie);
	        }
	    }
	    return results;
	}
	
	 
	

}


