
public class task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double length,area;
		Circle circle = null;
		Trangle trangle=null;
		Lader lader=null;
		
		circle = new Circle(5);
		trangle = new Trangle(3,4,5);
		lader = new Lader(2,3,2);
		
		length = circle.getLength();
		System.out.println("圆的周长："+length);
		
		area = circle.getArea();
		System.out.println("圆的面积："+area);
		
		length = trangle.getLength();
		System.out.println("三角形的周长："+length);
		
		area = trangle.getArea();
		System.out.println("三角形的面积："+area);
		
		length = lader.getArea();
		System.out.println("梯形的面积："+area);
		
		trangle.setABC(12,34, 1);
		area = trangle.getArea();
		System.out.println("三角形的面积："+area);
		
		length = trangle.getLength();
		System.out.println("三角形的周长："+length);
	}

}

class Trangle{
	//TODO
	private double sideA,sideB,sideC,area,length;
	private boolean boo;
	
	public Trangle(double a,double b,double c){
		sideA = a;
		sideB = b;
		sideC = c;
		
		if(sideA+sideB>sideC && sideA+sideC>sideB && sideB+sideC>sideA)
			boo = true;
		else 
			boo = false;
	}
	
	public double getLength(){
		length = sideA + sideB + sideC;
		return length;
	}
	
	public double getArea(){
		if(boo){
			double p = (sideA + sideC + sideB) / 2.0;
			area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
			return area;
		}else{
			System.out.println("不是一个三角形，不能计算面积！");
			return 0;
		}
	}
	
	public void setABC(double a,double b,double c){
		sideA = a;
		sideB = b;
		sideC = c;
		
		if(a+b>c && a+c>b && b+c>a)
			boo = true;
		else 
			boo = false;
	}
}

class Lader{
	//TODO
	private double abvoe,bottom,height,area;
	
	Lader(double a/*上底*/,double b/*下底*/,double h/*高*/){
		abvoe = a;
		bottom = b;
		height = h;
		
		area = (abvoe+bottom)*height/2;
	}
	
	public double getArea(){return area;}
}

class Circle{
	//TODO
	private double radius,area;
	
	Circle(double r){
		radius = r;
		area = 3.14159 * r * r;
	}
	
	public double getArea(){return area;}
	
	public double getLength(){return 2 * 3.13159 * radius;}
	
	public double getRadius(){return radius;}
}