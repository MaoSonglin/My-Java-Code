/*************************************************************
 * 
 * ��дһ�����򣬽��绰���������ļ���
 * 
 * ************************************************************/

package test2;
import java.io.*;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("����һ���绰���룺");
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
