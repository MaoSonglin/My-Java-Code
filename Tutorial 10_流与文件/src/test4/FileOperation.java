//�ó�����������һ���ļ��Ĵ�С
package test4;
import java.io.*;

public class FileOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename;
		System.out.print("�����ļ�����");
		try {
			filename = br.readLine();
			File file = new File(filename);
			if(file.exists()){
				long size = file.length();
				System.out.println(filename+"�Ĵ�СΪ"+size+"b");
			}else
				System.out.println("�ļ������ڣ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
