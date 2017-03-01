
import java.io.*;
import java.util.Scanner;

public class In {

	
	public static final int getInt(){
		
		
		int a = 0;
		boolean tag = false;
		do{
//			InputStreamReader read = new InputStreamReader(System.in);
//			BufferedReader reader = new BufferedReader(read);
//			try{
//				String s = reader.readLine();
//				a = Integer.parseInt(s.trim());
//				tag = true;
//			}catch(Exception e){
//				System.out.println("输入错误，请重新输入！");
//				tag = false;
//			}
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			if(reader.hasNextInt()){
				a = reader.nextInt();
				tag = true;
			}
			else{
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	
	public static final double getDouble(){
		
		double a=0;
		boolean tag = false;
		String temp;
		do{
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(read);
			try{
				temp = reader.readLine();
				a = Double.parseDouble(temp.trim());
				tag = true;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final short getShort(){

		
		short a = 0;
		boolean tag = false;
		do{
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(read);
			try{
				String s = reader.readLine();
				a = Short.parseShort(s.trim());
				tag = true;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final long getLong(){
		

		
		long a = 0;
		boolean tag = false;
		do{
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(read);
			try{
				String s = reader.readLine();
				a = Long.parseLong(s.trim());
				tag = true;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final float getFloat(){
		

		
		float a = 0;
		boolean tag = false;
		do{
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(read);
			try{
				String s = reader.readLine();
				a = Float.parseFloat(s.trim());
				tag = true;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final byte getByte(){
		

		
		byte a = 0;
		boolean tag = false;
		do{
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(read);
			try{
				String s = reader.readLine();
				a = Byte.parseByte(s.trim());
				tag = true;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final String getString(){
		
		
		String str = null;
		boolean tag;
		do{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = reader.readLine();
				tag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("输入错误，请重新输入！");
				tag = true;
			}
		}while(tag);
		return str;
	}
	
	public static final boolean getBoolean(){
		
		boolean a=false;
		boolean tag = false;
		do{
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(read);
			
			try{
				String s = reader.readLine();
				a = Boolean.parseBoolean(s.trim());
				tag = true;
			}catch(Exception e){
				System.out.println("输入错误，请重新输入！");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final char getChar(){
		
		
		char ch=97;
		boolean tag = false;
		
		do{
			DataInputStream dis = new DataInputStream(System.in);
			try {
				ch = dis.readChar();
				tag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("输入错误，请重新输入！");
				tag = true;
			}
		}while(tag);
		return ch;
	}
}
