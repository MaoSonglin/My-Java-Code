package test4;
import java.io.*;
public class FileSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String target = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("输入需要分割的文件：");
		try {
			target = br.readLine();
			
			//读入文件
			BufferedReader read = new BufferedReader(new FileReader(target));
			String result = "";
			String temp = null;
			while((temp=read.readLine())!=null)
				result += temp + '\n';
			read.close();
			
			//创建输出文件
			File file1 = new File("分割文件1.txt");
			File file2 = new File("分割文件2.txt");
			if(!file1.exists()) file1.createNewFile();
			if(!file2.exists()) file2.createNewFile();
			
			//输出
			PrintWriter pw1 = new PrintWriter(new FileOutputStream("分割文件1.txt"));
			int i = 0;
			int len = result.length();
			for(;i < len / 2 ;i++)
				pw1.print(result.charAt(i));
			PrintWriter pw2 = new PrintWriter(new FileOutputStream("分割文件2.txt"));
			for(; i < len; i++)
				pw2.print(result.charAt(i));
			pw1.close();
			pw2.close();
			
			//从分割的文件中读入
			BufferedReader reader1 = new BufferedReader(new FileReader("分割文件1.txt"));
			String str ="";
			String sss = null;
			while((sss=reader1.readLine())!=null)str+=sss+'\n';
			reader1.close();
			BufferedReader reader2 = new BufferedReader(new FileReader("分割文件2.txt"));
			while((sss=reader2.readLine())!=null)str+=sss+'\n';
			reader2.close();
			System.out.println(str);
			
			//将分割文件组合后输出
			File f = new File("分割后组合文件.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(str);
			writer.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
