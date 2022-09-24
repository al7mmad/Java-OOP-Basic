package lab_Polymorphism_Vehicle;

public class Bicycle extends Vehicle{
	
	// Variables
	private int numberGear; 
	
	//Constructor
	Bicycle(int mixSpeed, int numGear) {
		super(mixSpeed,2);
		
		this.numberGear = numGear; 
	}
	
	//Methods
	@Override
	public String toString() {
		return super.toString() + " The number of gears is : " + numberGear ;
	}

}
