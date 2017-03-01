package test3;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle tri2 = null;
		Scanner input = new Scanner(System.in);
		System.out.print("第一条边：");
		int sideone = input.nextInt();
		System.out.print("第二条边：");
		int sidetow = input.nextInt();
		System.out.print("第三条边：");
		int sidethree = input.nextInt();
		try{
			tri2 = new Triangle(sideone,sidetow,sidethree);
			tri2.showInfo();
			System.out.println("该三角形的面积为："+tri2.getArea());
		}catch(NotTriangleException e){
			System.out.println("出现异常"+e.getMessage());
		}
		input.close();
	}

}
