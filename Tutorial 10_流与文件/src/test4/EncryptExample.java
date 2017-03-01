package test4;
import java.util.Scanner;
public class EncryptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("输入你要加密的字符串");
		String str = scan.nextLine();
		
		byte b[] = str.getBytes();
		int i = 0,len = b.length;
		for(i = 0; i < len; i ++)
			b[i]++;
		
		System.out.println("加密后的字符串为");
		System.out.println(new String(b));
		
		System.out.println("输入你要解密的字符串");
		str = scan.nextLine();
		b = str.getBytes();
		
		len = b.length;
		for(i = 0; i < len; i++)
			b[i]--;
		
		System.out.println("解密后的字符串如下");
		System.out.println(new String(b));
		scan.close();
	}

}
