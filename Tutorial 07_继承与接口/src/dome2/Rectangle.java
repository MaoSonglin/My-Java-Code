package dome2;

public class Rectangle extends Shape{

	public Rectangle() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
	}
	
	public Rectangle(double a,double b){
		x = a;
		y = b;
	}

	@Override
	public double showArea() {
		// TODO Auto-generated method stub
		return x*y;
	}

	private double x,y;
}
