package lab_Polymorphism_Vehicle;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle[] vh = new Vehicle[3];
		
		vh[0] = new Vehicle();
		vh[1] = new Vehicle(220,4);
		vh[2] = new Bicycle(90,6);
		
		for(int i=0; i<vh.length; i++) {
			System.out.println("No." + i + " is : " + vh[i].toString());
		}

	}

}
