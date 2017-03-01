//该程序用来计算一个文件的大小
package test4;
import java.io.*;

public class FileOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filename;
		System.out.print("输入文件名：");
		try {
			filename = br.readLine();
			File file = new File(filename);
			if(file.exists()){
				long size = file.length();
				System.out.println(filename+"的大小为"+size+"b");
			}else
				System.out.println("文件不存在！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
