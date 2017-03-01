package test3;

public class Triangle {

	public Triangle() {
		// TODO Auto-generated constructor stub
		x=1;y=1;z=1;
	}
	public Triangle(double xx,double yy,double zz){
		x = xx;
		y = yy;
		z = zz;
	}
	public double getArea()throws NotTriangleException{
		if(x >= y+z || y >= x+z || z >= x + y)
			throw new NotTriangleException(x+","+","+y+","+z+"三条边不能构成三角形");
		double p;
		p = (x+y+z)/2.0;
		return Math.sqrt(p*(p-x)*(p-y)*(p-z));
	}
	public void showInfo()throws NotTriangleException{
		if(x >= y+z || y >= x+z || z >= x + y)
			throw new NotTriangleException(x+","+","+y+","+z+"三条边不能构成三角形");
		System.out.println("三角形的三边长分别为："+x+","+y+","+z);
	}
	private double x,y,z;
}
