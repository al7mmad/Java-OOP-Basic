package lab_Inheritance_Person;

public class Employee extends Person{
	// Variables
	private int office; 
	private double salary; 
	private String dateHired; 
	
	//Constructor
	Employee(String name, String phoneNumber, String emailAddress, int office, double salary, String daString){
		super(name, phoneNumber, emailAddress);
		
		this.office = office; 
		this.salary = salary; 
		this.dateHired = daString; 
		
	}
	
	//Methods
	public String toString() {	
		return  super.toString() + " The office number is : " + office + " The salary is : " + salary + " The date of hired is : " + dateHired ; 
		
	}
	
	

}
