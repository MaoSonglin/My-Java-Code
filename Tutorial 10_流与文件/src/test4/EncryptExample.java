package test4;
import java.util.Scanner;
public class EncryptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ҫ���ܵ��ַ���");
		String str = scan.nextLine();
		
		byte b[] = str.getBytes();
		int i = 0,len = b.length;
		for(i = 0; i < len; i ++)
			b[i]++;
		
		System.out.println("���ܺ���ַ���Ϊ");
		System.out.println(new String(b));
		
		System.out.println("������Ҫ���ܵ��ַ���");
		str = scan.nextLine();
		b = str.getBytes();
		
		len = b.length;
		for(i = 0; i < len; i++)
			b[i]--;
		
		System.out.println("���ܺ���ַ�������");
		System.out.println(new String(b));
		scan.close();
	}

}
