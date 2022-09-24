package lab_Polymorphism_Vehicle;

public class Vehicle {
	// Variables
	private int maximumSpeed ;
	private int numberWheel ;
	
	
	//Constructor
	Vehicle() {
		this.maximumSpeed = 0;
		this.numberWheel = 0 ; 
	
	}
	Vehicle(int mixSpeed, int numWheel) {
		this.maximumSpeed = mixSpeed;
		this.numberWheel = numWheel ; 

	}
	
	
	//Method
	@Override
	public String toString() {
		return "The maximum speed is : " + maximumSpeed + " The number of wheel is : " + numberWheel;
	}

}
