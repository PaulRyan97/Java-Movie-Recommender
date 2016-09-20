class Movie{
	
	int movieID;
	String name;
	
	public Movie( int id, String name){
		this.movieID = id;
		this.name = name;
	}

	public String toString(){
		String details = "";
		details = "Movie " + movieID + ": " + name;
		return details;
	}
}