package dome2;
import java.util.Scanner;
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("输入长方形的长a:");
		double a = input.nextDouble();
		System.out.println("输入长方形的宽b:");
		double b = input.nextDouble();
		
		
		//构造一个长方形
		Rectangle xx = new Rectangle(a,b);
		System.out.println("长方形的面积是："+xx.showArea());
		
		
		//构造一个正方形
		System.out.println("输入正方形的边长");
		double l = input.nextDouble();
		Square ll = new Square(l);
		System.out.println("正方形的面积是："+ll.showArea());
		
		
		System.out.println("输入圆的半径：");
		double r = input.nextDouble();
		
		//构造一个圆
		Circle yy = new Circle(r);
		System.out.println("圆的面积是："+yy.showArea());
		
		input.close();
	}

}
