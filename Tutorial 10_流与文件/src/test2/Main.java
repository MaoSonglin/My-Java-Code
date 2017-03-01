/*************************************************************
 * 
 * 编写一个程序，将电话号码输入文件。
 * 
 * ************************************************************/

package test2;
import java.io.*;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("输入一个电话号码：");
		long phone = (new Scanner(System.in)).nextLong();
		
		File f = new File("telephone directory.txt");
		if(!f.exists())
			f.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(f,true);
		PrintStream ps = new PrintStream(fos);
		
		ps.println(phone);
		ps.close();
		fos.close();
	}

}
