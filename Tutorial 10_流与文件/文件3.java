��1�У�	package test1;
��2�У�	import java.io.*;
��3�У�	import java.util.*;
��4�У�	
��5�У�	public class FileExample {
��6�У�	
��7�У�		public static void main(String[] args) {
��8�У�			// TODO Auto-generated method stub
��9�У�			System.out.println("�������봴�����ļ�����");
��10�У�			@SuppressWarnings("resource")
��11�У�			String filename = (new Scanner(System.in)).nextLine();
��12�У�			File file = new File(filename);
��13�У�			
��14�У�			if(file.exists()){
��15�У�				if(file.isFile()){
��16�У�					System.out.println("�ļ�����"+file.getName());
��17�У�					System.out.println("����·����"+file.getAbsolutePath());
��18�У�					System.out.println("�ļ���С��"+file.length());
��19�У�				}
��20�У�				else{
��21�У�					String s[]= file.list();
��22�У�					System.out.println("�ļ���"+filename+"����"+s.length+"������");
��23�У�					for(String ss:s)
��24�У�						System.out.println(ss);
��25�У�				}
��26�У�			}else{
��27�У�				file.mkdir();
��28�У�			}
��29�У�		}
��30�У�	
��31�У�	}
