package test4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileDecodeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("������Ҫ���ܵ��ļ�");
		try {
			String filename = read.readLine();
			File file = new File(filename);
			
			if(!file.exists())
				throw new Exception("�ļ������ڣ�");
			
			System.out.println("������ܺ�����ļ���");
			filename = read.readLine();
			File newfile = new File(filename);
			if(!newfile.exists())
				newfile.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(newfile));
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			int i,len;
			byte[] b;
			while((filename=br.readLine())!=null){
				filename+='\n';
				b = filename.getBytes();
				len = b.length;
				for(i = 0; i < len; i++)
					b[i]--;
				out.print(new String(b));
			}
			out.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
