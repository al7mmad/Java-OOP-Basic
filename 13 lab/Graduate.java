package lab_Abstract_Student;

public class Graduate extends Student {
	
	private String status; 

	//Constructors
	Graduate(int ID, double GPA) {
		super(ID, GPA);
	}

	//Methods
	@Override
	public String getStatus() {
		if(getGPA() >= 3.0)
			status = "Good";
		else 
			status = "string"; 
		
		return status; 
	}

}
