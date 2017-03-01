package dome2_2;
import java.util.Scanner;
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("输入矩形的长和宽：");
		double a = input.nextDouble();
		double b = input.nextDouble();
		
		Rectangle m = new Rectangle(a,b);
		m.show();
		
		System.out.println("输入正方形的边长：");
		a = input.nextDouble();
		
		Square n = new Square(a);
		n.show();
		input.close();
	}

}
