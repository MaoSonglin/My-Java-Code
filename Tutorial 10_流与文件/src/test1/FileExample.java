package test1;
import java.io.*;
import java.util.*;

public class FileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�������봴�����ļ�����");
		@SuppressWarnings("resource")
		String filename = (new Scanner(System.in)).nextLine();
		File file = new File(filename);
		
		if(file.exists()){
			if(file.isFile()){
				System.out.println("�ļ�����"+file.getName());
				System.out.println("����·����"+file.getAbsolutePath());
				System.out.println("�ļ���С��"+file.length());
			}
			else{
				String s[]= file.list();
				System.out.println("�ļ���"+filename+"����"+s.length+"������");
				for(String ss:s)
					System.out.println(ss);
			}
		}else{
			file.mkdir();
		}
	}

}
