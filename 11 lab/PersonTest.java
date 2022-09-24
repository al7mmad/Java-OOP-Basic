package lab_Inheritance_Person;

public class PersonTest {
	
	public static void main(String[] args) {
		
		Person pr = new Person("Abdullah", "0555", "a.fh@gmail.com");
		Student st = new Student("Mhummad", "0444", "m@gmail.com", 3.2, "freshman");
		Employee em = new Employee("Saad", "0333", "ss@gmail.com", 212 , 1000.0 , "12/1/2020");

		
		System.out.println(pr.toString());
		System.out.println(st.toString());
		System.out.println(em.toString());

	}
	
}
