package dome2;

public class Circle extends Shape {

	public Circle() {
		// TODO Auto-generated constructor stub
		r = 0;
	}
	
	public Circle(double x)
	{
		r = x;
	}
	
	public double getR(){return r;}     //get����
	public void setR(double x){r = x;}  //set����
	
	
	public double showArea(){
		return 3.1415 * r * r;
	}
	
	private double r;
}
