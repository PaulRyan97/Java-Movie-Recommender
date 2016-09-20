class Customer{

	int customerID;
	String name;
	
	public Customer( int id, String name){
		this.customerID = id;
		this.name = name;
	}

	public String toString(){
		String details = "";
		details = "Customer " + customerID + ": " + name;
		return details;
	}



}