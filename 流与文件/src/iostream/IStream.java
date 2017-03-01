package iostream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IStream {

public static final int getInt(){
		
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		int a = 0;
		boolean tag = false;
		do{
			try{
				String s = reader.readLine();
				a = Integer.parseInt(s.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	
	public static final double getDouble(){
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		double a=0;
		boolean tag = false;
		String temp;
		do{
			try{
				temp = reader.readLine();
				a = Double.parseDouble(temp.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final short getShort(){

		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		short a = 0;
		boolean tag = false;
		do{
			try{
				String s = reader.readLine();
				a = Short.parseShort(s.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final long getLong(){
		

		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		long a = 0;
		boolean tag = false;
		do{
			try{
				String s = reader.readLine();
				a = Long.parseLong(s.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final float getFloat(){
		

		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		float a = 0;
		boolean tag = false;
		do{
			try{
				String s = reader.readLine();
				a = Float.parseFloat(s.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final byte getByte(){
		

		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		byte a = 0;
		boolean tag = false;
		do{
			try{
				String s = reader.readLine();
				a = Byte.parseByte(s.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final String getString(){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		boolean tag;
		do{
			try {
				str = reader.readLine();
				tag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Input error, please input again!");
				tag = true;
			}
		}while(tag);
		return str;
	}
	
	public static final boolean getBoolean(){
		
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(read);
		boolean a=false;
		boolean tag = false;
		do{
			try{
				String s = reader.readLine();
				a = Boolean.parseBoolean(s.trim());
				tag = true;
			}catch(Exception e){
				System.err.println("Input error, please input again!");
				tag = false;
			}
		}while(!tag);
		return a;
	}
	
	public static final char getChar(){
		
		DataInputStream dis = new DataInputStream(System.in);
		char ch=97;
		boolean tag = false;
		
		do{
			try {
				ch = dis.readChar();
				tag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Input error, please input again!");
				tag = true;
			}
		}while(tag);
		return ch;
	}
}
