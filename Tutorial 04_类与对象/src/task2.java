
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
		System.out.println("Բ���ܳ���"+length);
		
		area = circle.getArea();
		System.out.println("Բ�������"+area);
		
		length = trangle.getLength();
		System.out.println("�����ε��ܳ���"+length);
		
		area = trangle.getArea();
		System.out.println("�����ε������"+area);
		
		length = lader.getArea();
		System.out.println("���ε������"+area);
		
		trangle.setABC(12,34, 1);
		area = trangle.getArea();
		System.out.println("�����ε������"+area);
		
		length = trangle.getLength();
		System.out.println("�����ε��ܳ���"+length);
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
			System.out.println("����һ�������Σ����ܼ��������");
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
	
	Lader(double a/*�ϵ�*/,double b/*�µ�*/,double h/*��*/){
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