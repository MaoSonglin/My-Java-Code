
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[5];
	
		for(int i = 0; i < 5; i++)
		{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			try{
			System.out.println("����һ������");
			//if(scan.hasNextInt())
				array[i] = scan.nextInt();
			}catch(InputMismatchException e){
				System.out.println("����������������룡");
				i--;
			}
			//scan.close();
		}
		for(int i = 0; i < 5; i++)
			System.out.print(array[i]+"\t");
		
	}
}
