package test3;

public class Rectangle extends Shape{

	public Rectangle() {
		// TODO Auto-generated constructor stub
		super();
		length = 0;
		width = 0;
	}
	public Rectangle(double l,double w){
		length = l;
		width = w;
	}
	public double getArea(){return length*width;}
	public void setLength(double l){length = l;}
	public void setWidth(double w){width = w;}
	public double getLength(){return length;}
	public double getWidth(){return width;}
	private double length;
	private double width;
}
