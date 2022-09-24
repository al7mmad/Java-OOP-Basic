package lab_ObjectAndClass_Rectangle;

public class Rectangle {
	// Variables
	public double width;
	public double hight; 
	
	
	//Constructor
	Rectangle(){
		this.width = 1.0;
		this.hight = 1.0;
		
	}
	Rectangle(double x, double y){
		this.width = x;
		this.hight = y;
	}
	
	//Methods 
	public double getArea() {
		return this.width * this.hight;
	}
	
	public double getPerimeter() {
		return this.width * 2 + this.hight * 2 ; 
	}

}
