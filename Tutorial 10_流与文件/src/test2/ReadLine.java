package test2;
import java.io.*;
public class ReadLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name,rename;
		
		try {
			System.out.print("����һ���ļ�����");
			name = reader.readLine();
			System.out.print("��������ļ�����");
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
				out.println("��"+index+"�У�\t"+temp);
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
