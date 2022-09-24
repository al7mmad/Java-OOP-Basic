package lab_Abstract_Student;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ID ; 
		double GPA ;
		
		Student[] st = new Student[2]; 
		Scanner scan = new Scanner(System.in); 


		System.out.println("Enter ID");
		ID = scan.nextInt();
		System.out.println("Enter GPA");
		GPA = scan.nextDouble();
		st[0] = new Undergraduate(ID, GPA);

		
		System.out.println("Enter ID");
		ID = scan.nextInt();
		System.out.println("Enter GPA");
		GPA = scan.nextDouble();
		st[1] = new Graduate(ID, GPA);
		
		
		for(int i=0; i<st.length; i++) {

			//Output
			System.out.println("The ID is : " + st[i].getID() + 
								" The GPA is : " + st[i].getGPA() + 
								" The status is : " + st[i].getStatus());
			
			
		}

	}

}
