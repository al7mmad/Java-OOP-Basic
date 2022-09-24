package lab_ObjectAndClass_Rectangle;

public class mainRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle rc1 = new Rectangle();
		Rectangle rc2 = new Rectangle(4 , 40);
		Rectangle rc3 = new Rectangle(3.5 , 35.9);
		

		System.out.println("Width = " + rc1.width);
		System.out.println("Hight = " + rc1.hight);
		System.out.println("Area = " + rc1.getArea());
		System.out.println("Perimeter = " + rc1.getPerimeter());
		
		System.out.println();
		
		System.out.println("Width = " + rc2.width);
		System.out.println("Hight = " + rc2.hight);
		System.out.println("Area = " + rc2.getArea());
		System.out.println("Perimeter = " + rc2.getPerimeter());
		
		System.out.println();

		
		System.out.println("Width = " + rc3.width);
		System.out.println("Hight = " + rc3.hight);
		System.out.println("Area = " + rc3.getArea());
		System.out.println("Perimeter = " + rc3.getPerimeter());

	}

}
