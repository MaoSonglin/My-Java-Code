package test3;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle tri2 = null;
		Scanner input = new Scanner(System.in);
		System.out.print("��һ���ߣ�");
		int sideone = input.nextInt();
		System.out.print("�ڶ����ߣ�");
		int sidetow = input.nextInt();
		System.out.print("�������ߣ�");
		int sidethree = input.nextInt();
		try{
			tri2 = new Triangle(sideone,sidetow,sidethree);
			tri2.showInfo();
			System.out.println("�������ε����Ϊ��"+tri2.getArea());
		}catch(NotTriangleException e){
			System.out.println("�����쳣"+e.getMessage());
		}
		input.close();
	}

}
