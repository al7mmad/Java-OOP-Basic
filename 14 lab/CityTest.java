package lab_Interface_City;

public class CityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		City[] city = new City[4];
		city[0] = new City("Dammmam", 28);
		city[1] = new City("Riyadh", 29);
		city[2] = (City) city[0].clone();
		city[3] = (City) city[1].clone();
		
		
		for(int i=0; i<city.length; i++) {
			System.out.println((city[i]).toString());
		}
		
		System.out.println("The comparable is : " + city[0].compareTo(city[1]));
		System.out.println("The comparable is : " + city[0].compareTo(city[2]));

	}

}
