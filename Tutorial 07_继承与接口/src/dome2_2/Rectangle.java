package dome2_2;

public class Rectangle implements DiagArea{

	public Rectangle() {
		// TODO Auto-generated constructor stub
		w = 0; h = 0;
	}
	public Rectangle(double a,double b){
		w = a;
		h = b;
	}
	
	
	public double getW(){return w;}
	public double getH(){return h;}
	
	public void setW(double x){w = x;}
	public void setH(double x){h = x;}
	
	@Override
	public double getDiagonal() {
	// TODO Auto-generated method stub
		return Math.sqrt(w*w+h*h);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return w*h;
	}
	
	public void show(){
		System.out.println("对角线长为："+getDiagonal());
		System.out.println("面积为："+getArea());
	}
	
	protected double w,h;
}
