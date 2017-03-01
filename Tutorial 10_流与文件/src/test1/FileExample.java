package test1;
import java.io.*;
import java.util.*;

public class FileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入你想创建的文件名：");
		@SuppressWarnings("resource")
		String filename = (new Scanner(System.in)).nextLine();
		File file = new File(filename);
		
		if(file.exists()){
			if(file.isFile()){
				System.out.println("文件名："+file.getName());
				System.out.println("决对路径："+file.getAbsolutePath());
				System.out.println("文件大小："+file.length());
			}
			else{
				String s[]= file.list();
				System.out.println("文件夹"+filename+"共有"+s.length+"个对象");
				for(String ss:s)
					System.out.println(ss);
			}
		}else{
			file.mkdir();
		}
	}

}
