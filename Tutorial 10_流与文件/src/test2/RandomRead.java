package test2;
import java.io.*;
public class RandomRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fn1 = new String("нд╪Ч4.txt");
		File f1 = new File(fn1);
		
		RandomAccessFile raf1 = new RandomAccessFile(f1,"r");
		long pos = raf1.length();
		
		int index = 2;
		String result="";
		String temp=null;
		byte[] ch = new byte[2];
		while(pos-index >= 0){
			raf1.seek(pos-index);
			raf1.read(ch);
			index+=2;
			result += new String(ch);
		}
			
		temp = new String(result.getBytes());
		
		
		System.out.println(temp);
		raf1.close();
	}

}
