package dome2;

public class Square extends Shape{

	public Square() {
		// TODO Auto-generated constructor stub
	}
	public Square(double a){
		x = a;
	}
	
	public double getX(){return x;}
	public void setX(double x){this.x = x;}
	@Override
	public double showArea() {
		// TODO Auto-generated method stub
		return x*x;
	}
	private double x;//±Ì æ±ﬂ≥§
}
