class MovieRecommenderTester{
	
	public static void main(String[] args){
		MovieRecommender mr = new MovieRecommender();
		mr.insertCustomers("customers.txt");
		mr.insertMovies("movies.txt");
		mr.insertRatings("ratings.txt");
		mr.getRecommendation();
	}
}