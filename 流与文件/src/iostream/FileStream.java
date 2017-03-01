package iostream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileStream {

	public static final String read(String name)
	{
		File file = new File(name);
		if(!file.exists()){
			System.err.println(name+" is not exist!");
			return null;
		}
		try{
			BufferedReader read = new BufferedReader(new FileReader(file));
			String temp = null;
			String result = "";
			while((temp=read.readLine())!=null)
				result += temp + '\n';
			read.close();
			return result;
		}catch(IOException e){
			return null;
		}
	}
	
	
	public static final boolean write(String name,String context)
	{
		File file = new File(name);
		try{
			if(!file.exists())
				file.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(file,true));
			out.println(context);
			out.close();
			return true;
		}catch(IOException e){
			return false;
		}
	}
	
	public static final boolean rewrite(String name,String context)
	{
		File file = new File(name);
		try{
			if(!file.exists())
				file.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(file));
			out.println(context);
			out.close();
			return true;
		}catch(IOException e){
			return false;
		}
	}
	
	public static final boolean rewrite(String name,Object target)
	{
		return rewrite(name,target.toString());
	}
	
	
	public static final boolean write(String name,Object target)
	{
		return write(name,target.toString());
	}
}
