package dome2;
import java.util.Scanner;
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("���볤���εĳ�a:");
		double a = input.nextDouble();
		System.out.println("���볤���εĿ�b:");
		double b = input.nextDouble();
		
		
		//����һ��������
		Rectangle xx = new Rectangle(a,b);
		System.out.println("�����ε�����ǣ�"+xx.showArea());
		
		
		//����һ��������
		System.out.println("���������εı߳�");
		double l = input.nextDouble();
		Square ll = new Square(l);
		System.out.println("�����ε�����ǣ�"+ll.showArea());
		
		
		System.out.println("����Բ�İ뾶��");
		double r = input.nextDouble();
		
		//����һ��Բ
		Circle yy = new Circle(r);
		System.out.println("Բ������ǣ�"+yy.showArea());
		
		input.close();
	}

}
