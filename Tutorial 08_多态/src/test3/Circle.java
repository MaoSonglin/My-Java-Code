package test3;

public class Circle extends Shape {

	public Circle() {
		// TODO Auto-generated constructor stub
		super();
		radius = 0;
	}
	public Circle(double r){radius=r;}
	public void setRadius(double r){radius = r;}
	public double getRadius(){return radius;}
	public double getArea(){
		return 3.1415*radius*radius;
	}
	private double radius;
}
