import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


class MovieRecommender{
	
	List<Customer> customers =  new ArrayList<Customer>();
	List<Movie> movies =  new ArrayList<Movie>();
	List<Rating> ratings =  new ArrayList<Rating>();

	public void insertCustomers(String c){
		try{
			String line1 = "";
			BufferedReader br1 = new BufferedReader(new FileReader(new File(c)));
			line1 = br1.readLine();

			while ( line1 != null){
				try{
					int div = line1.indexOf("|");
					String s1 = line1.substring(0, div);
					int cID = Integer.parseInt(s1);
					String name = line1.substring(div + 1);
					customers.add(new Customer(cID, name));
					line1 = br1.readLine();
				}
				catch(NumberFormatException n){
					System.out.println("Parsing Issue");
				}
			}

		}
		catch (IOException e){
			System.out.println("IO Problem");
		}

	}

	public void insertMovies(String m){
		try{
			String line2 = "";
			BufferedReader br2 = new BufferedReader(new FileReader(new File(m)));
			line2 = br2.readLine();

			while ( line2 != null){
				try{
					int div2 = line2.indexOf("|");
					String s2 = line2.substring(0, div2);
					int mID = Integer.parseInt(s2);
					String name = line2.substring(div2 + 1);
					movies.add(new Movie(mID, name));
					line2 = br2.readLine();
				}
				catch(NumberFormatException n){
					System.out.println("Parsing Issue");
				}
			}

		}
		catch (IOException e){
			System.out.println("IO Problem");
		}

	}

	public void insertRatings(String r){
		try{
			String line3 = "";
			BufferedReader br3 = new BufferedReader(new FileReader(new File(r)));
			line3 = br3.readLine();

			while ( line3 != null){
				try{
					int firstDiv = line3.indexOf("|");
					String cu = line3.substring(0, firstDiv);
					int custID = Integer.parseInt(cu);
					String rest = line3.substring(firstDiv + 1);
					int secondDiv = rest.indexOf("|");
					String mo = rest.substring(0, secondDiv);
					int movID = Integer.parseInt(mo);
					String rat = rest.substring(secondDiv + 1);
					int rating = Integer.parseInt(rat);
					ratings.add(new Rating(custID, movID, rating ));
					
					line3 = br3.readLine();
				}

				catch(NumberFormatException n){
					System.out.println("Parsing Issue");
				}

			}
		}

		catch (IOException e){
			System.out.println("IO Problem");
			}

	}


	public void getRecommendation(){
		for(Customer customer : customers){
			Recommendation recom = new Recommendation(customer, ratings);
			recom.setRecommendation(movies);
		}
	}

	



}

