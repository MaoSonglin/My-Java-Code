package test2;
import java.io.*;
public class ReadLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name,rename;
		
		try {
			System.out.print("输入一个文件名：");
			name = reader.readLine();
			System.out.print("输入输出文件名：");
			rename=reader.readLine();
			
			reader = new BufferedReader(new FileReader(name));
			File file = new File(rename);
			if(!file.exists())
				file.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(file));
			int index = 0;
			String temp;
			while((temp=reader.readLine())!=null){
				index++;
				out.println("第"+index+"行：\t"+temp);
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
