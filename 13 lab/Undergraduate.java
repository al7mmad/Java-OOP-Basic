package lab_Abstract_Student;

public class Undergraduate extends Student  {
		
	private String status; 

	//Constructors
	Undergraduate(int ID, double GPA) {
		super(ID, GPA);
	}

	//Methods
	@Override
	public String getStatus() {
		if(getGPA() >= 3.0)
			status = "Honor";
		else if(getGPA() >= 2.0)
			status = "Good";
		else 
			status = "probation"; 
		
		return status; 
	}

	
	
	

}
