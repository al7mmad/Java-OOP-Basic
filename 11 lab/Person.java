package lab_Inheritance_Person;

public class Person {
	
	// Variables
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	
	//Constructor
	Person(String name, String phoneNumber, String emailAddress){
		this.name = name; 
		this.phoneNumber = phoneNumber; 
		this.emailAddress = emailAddress; 
	}
	
	
	//Methods
	public String toString() {
		return "The name is : " + name + " The phone number is : " + phoneNumber + " The email is : " + emailAddress;
	}

}
