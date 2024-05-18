//NAME: CRISTIAN PARRA 


package Main;

public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtimeMinutes;
	
	// Constructor
	public Movie(String title, String actor1, String actor2, String director, int year, int runtimeMinutes){
		 this.title = title;
	       this.year = year;
	       this.runtimeMinutes = runtimeMinutes;
	       this.actor1 = actor1;
	       this.actor2 = actor2;
	       this.director = director;
	}
	
	// Methods
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getActor1(){
//		System.out.println(actor1); debug
		return actor1;
	}
	
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}
	
	
	public String getActor2(){
		return actor2;
	}
	
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	
	public String getDirector(){
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getRuntime(){
		return runtimeMinutes;
	}
	
	public void setRunTime(int runtime) {
		this.runtimeMinutes = runtimeMinutes;
		
	}
	
	// For when new entry is added, lists all inputted data
	public String toString() {
    return "Title: " + title +
            ", Actor 1: " + actor1 +
            ", Actor 2: " + actor2 +
            ", Director: " + director +
            ", Year: " + year +
            ", Runtime: " + runtimeMinutes + " minutes";
 }
	
	// Optional
	//public boolean isActorInMovie(String actor){
		// TODO
	//}
}
