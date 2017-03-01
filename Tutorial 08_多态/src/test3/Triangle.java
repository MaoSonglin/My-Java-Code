package test3;

public class Triangle extends Shape {

	public Triangle() {
		// TODO Auto-generated constructor stub
		side_one = 0;
		side_tow = 0;
		side_three = 0;
	}
	public Triangle(double one,double tow,double three){
		side_one = one;
		side_tow = tow;
		side_three = three;
	}
	void setSide(double one,double tow,double three){
		side_one = one;
		side_tow = tow;
		side_three = three;
	}
	public double getArea(){
		double p;
		p = (side_one+side_tow+side_three)/2.0;
		return Math.sqrt(p*(p-side_one)*(p-side_tow)*(p-side_three));
	}
	private double side_one,side_tow,side_three;
}
