

class Rating{


	int custID;
	int movID;
	int stars;
	
	public Rating( int c, int m, int score ){
		this.custID = c;
		this.movID = m;
		this.stars = score;
	}

	public String toString(){
		String details = "";
		details = "Customer " + custID + "gave movie " + movID + " " + stars + "stars";
		return details;
	}
	
	

}