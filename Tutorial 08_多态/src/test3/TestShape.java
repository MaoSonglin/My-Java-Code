package test3;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle s1 = new Rectangle(18,32);
		Circle s2 = new Circle(24);
		Triangle s3 = new Triangle(15,17,19);
		Trapezoid s4 = new Trapezoid(28,21,18);
		countArea(s1);
		countArea(s2);
		countArea(s3);
		countArea(s4);
		System.out.println("面积和为："+area);
	}
	public static void countArea(Shape s){
		area += s.getArea();
	}
	static double area = 0;
}
