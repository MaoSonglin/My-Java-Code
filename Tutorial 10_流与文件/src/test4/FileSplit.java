package test4;
import java.io.*;
public class FileSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String target = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������Ҫ�ָ���ļ���");
		try {
			target = br.readLine();
			
			//�����ļ�
			BufferedReader read = new BufferedReader(new FileReader(target));
			String result = "";
			String temp = null;
			while((temp=read.readLine())!=null)
				result += temp + '\n';
			read.close();
			
			//��������ļ�
			File file1 = new File("�ָ��ļ�1.txt");
			File file2 = new File("�ָ��ļ�2.txt");
			if(!file1.exists()) file1.createNewFile();
			if(!file2.exists()) file2.createNewFile();
			
			//���
			PrintWriter pw1 = new PrintWriter(new FileOutputStream("�ָ��ļ�1.txt"));
			int i = 0;
			int len = result.length();
			for(;i < len / 2 ;i++)
				pw1.print(result.charAt(i));
			PrintWriter pw2 = new PrintWriter(new FileOutputStream("�ָ��ļ�2.txt"));
			for(; i < len; i++)
				pw2.print(result.charAt(i));
			pw1.close();
			pw2.close();
			
			//�ӷָ���ļ��ж���
			BufferedReader reader1 = new BufferedReader(new FileReader("�ָ��ļ�1.txt"));
			String str ="";
			String sss = null;
			while((sss=reader1.readLine())!=null)str+=sss+'\n';
			reader1.close();
			BufferedReader reader2 = new BufferedReader(new FileReader("�ָ��ļ�2.txt"));
			while((sss=reader2.readLine())!=null)str+=sss+'\n';
			reader2.close();
			System.out.println(str);
			
			//���ָ��ļ���Ϻ����
			File f = new File("�ָ������ļ�.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write(str);
			writer.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
