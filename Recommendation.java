import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Recommendation {
	
	List<Rating> recom =  new ArrayList<Rating>();
	List<Rating> custrat =  new ArrayList<Rating>();
	List<Rating> allrate =  new ArrayList<Rating>();
	int[] watched;
	int watchlength;
	Customer customer;


	public Recommendation( Customer c, List<Rating> r ){
		watched = new int[r.size()];
		int i = 0;
		customer = c;
		for ( Rating rate : r ){
			allrate.add(rate);
			if (rate.custID == customer.customerID){
				custrat.add(rate);
				watched[i] = rate.movID;
				watchlength += 1;
				i += 1;
			}
		}

		for (Rating rate2 : r){
			for(int h = 0; h < watchlength; h += 1){
				if (rate2.movID != watched[h]){
					if ( h == watchlength - 1){
						recom.add(rate2);
					}
					else{
						continue;
					}
				}

				else{
					break;
				}
				
			}
			
		}

	}

	public void setRecommendation(List<Movie> m){
		double highest = 0.0;
		String suggestion = "";

		for ( Movie mov : m ){
			List<Rating> movrate =  new ArrayList<Rating>();
			if (custrat.size() != 0){
				for ( Rating rat : recom ){
					if(mov.movieID == rat.movID){
							movrate.add(rat);
					}
				} 
			}
			else{
				for (Rating all : allrate){
					if(mov.movieID == all.movID){
						movrate.add(all);
					}
				}
			}
			double score = 0.0;
			double subweight = 0.0;
			double weight = 0.0;
			double top = 0.0;
			double bottom = 0.0;
			for (Rating movr : movrate){
				for (Rating a: allrate){
					if (a.custID == movr.custID ){
						for ( Rating c2 : custrat ){
							if(c2.movID == a.movID ){
								subweight += Math.pow((c2.stars - a.stars), 2);
							}
						}
					}
				}
				weight = 1/(1 + Math.sqrt(subweight));
		
				top += (weight * movr.stars);
				bottom += weight;
				subweight = 0.0;
			
			}
	
			score = top/bottom;
			if (score > highest){
				highest = score;
				suggestion = mov.name;
			}





		}
		
		System.out.println("I recommend customer " + customer.customerID + " watch: " + suggestion);
	}

}