第1行：	package test1;
第2行：	import java.io.*;
第3行：	import java.util.*;
第4行：	
第5行：	public class FileExample {
第6行：	
第7行：		public static void main(String[] args) {
第8行：			// TODO Auto-generated method stub
第9行：			System.out.println("输入你想创建的文件名：");
第10行：			@SuppressWarnings("resource")
第11行：			String filename = (new Scanner(System.in)).nextLine();
第12行：			File file = new File(filename);
第13行：			
第14行：			if(file.exists()){
第15行：				if(file.isFile()){
第16行：					System.out.println("文件名："+file.getName());
第17行：					System.out.println("决对路径："+file.getAbsolutePath());
第18行：					System.out.println("文件大小："+file.length());
第19行：				}
第20行：				else{
第21行：					String s[]= file.list();
第22行：					System.out.println("文件夹"+filename+"共有"+s.length+"个对象");
第23行：					for(String ss:s)
第24行：						System.out.println(ss);
第25行：				}
第26行：			}else{
第27行：				file.mkdir();
第28行：			}
第29行：		}
第30行：	
第31行：	}
