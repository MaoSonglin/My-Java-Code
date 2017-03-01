package iostream;

import java.util.Scanner;

public class Stream {
	
	public static void main(String[] args){
		
		System.out.print("请输两个整数");
		int a = getInt();
		int b = getInt();
		System.out.println("你刚才输入了"+a+"和"+b+"\n输入两个字符串");
		String s= getLine();
		String t = getNext();
		System.out.println(s+t);
	}

	public static int getInt(){
		
		int a = 0;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextInt()){
				a = scan.nextInt();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static double getDouble(){
		
		double a = 0;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextDouble()){
				a = scan.nextDouble();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static float getFloat(){
		
		float a = 0;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextFloat()){
				a = scan.nextFloat();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static short getShort(){
		
		short a = 0;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextShort()){
				a = scan.nextShort();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static byte getByte(){
		
		byte a = 0;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextByte()){
				a = scan.nextByte();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static long getLong(){
		
		long a = 0;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextLong()){
				a = scan.nextLong();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static String getLine(){
		
		String a = null;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextLine()){
				a = scan.nextLine();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static String getNext(){
		
		String a = null;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNext()){
				a = scan.next();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		return a;
	}
	
	public static boolean getBoolean(){
		
		boolean a = false;
		boolean tag = false;
		do{
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextBoolean()){
				a = scan.hasNextBoolean();
				tag = false;
			}else{
				System.err.println("Input error, please entry again!");
				tag = true;
			}
		}while(tag);
		
		return a;
	}
}
