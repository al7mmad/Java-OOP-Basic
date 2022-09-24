package lab_Inheritance_Person;

public class Student extends Person {
	// Variables
	private double GPA ; 
	private String status; 
	
	
	//Constructor
	Student(String name, String phoneNumber, String emailAddress, double GPA, String status){
		super(name, phoneNumber, emailAddress);
		
		
		this.GPA = GPA; 
		this.status = status; 
		
	}
	
	//Methods
	@Override
	public String toString() {
		return  super.toString() + " The GPA is : " + GPA + " The status is : "+ status;
	}
	
	

}
