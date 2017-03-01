package dome2_2;

public class Square extends Rectangle {

	public Square() {
		// TODO Auto-generated constructor stub
		w = 0;
		h = 0;
	}
	
	public Square(double x){
		w = x;
		h = x;
	}
	
	public double getX(){return w;}
	public void setX(double x){w = x;h = x;}
}
