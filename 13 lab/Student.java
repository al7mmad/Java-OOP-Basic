package lab_Abstract_Student;

abstract class Student {
	// Variables
	private int ID ; 
	private double GPA; 
	
	//Constructors
	Student(int ID, double GPA){
		this.ID = ID; 
		this.GPA = GPA; 
	}
	
	//Abstract methods
	abstract String getStatus();
	
	
	//Method
	public int getID() {
		return ID; 
	}
	
	public double getGPA() {
		return GPA; 
	}

}
