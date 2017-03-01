package test3;

public class Trapezoid extends Shape{

	public Trapezoid() {
		// TODO Auto-generated constructor stub
		bottom = top = high = 0;
	}
	public Trapezoid(double bo,double to,double hi){
		bottom = bo;
		top = to;
		high = hi;
	}
	public double getArea(){
		return (bottom+top)*high/2;
	}
	public void setBorder(double bo,double to,double hi){
		bottom = bo;
		top = to;
		high = hi;
	}
	private double bottom;
	private double top;
	private double high;
}
