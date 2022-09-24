package lab_Interface_City;

public class City implements Comparable<City>, Cloneable{
	
	private String cityName; 
	private int temperature; 
	
	City(String ctName, int temp){
		this.cityName = ctName; 
		this.temperature = temp; 
	}
	
	public String toString() {
		return "The city name is : " + cityName + " The temperature is : " + temperature;
	}
	
	
	@Override
	public int compareTo(City o) {
		
		if(temperature > o.temperature)
			return 1; 
		else if(temperature < o.temperature)
			return -1 ;
		else 
			return 0;
		
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException ex) {
			return null; 
		}
	}

}
