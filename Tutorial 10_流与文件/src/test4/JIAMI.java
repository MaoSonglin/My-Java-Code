package test4;
import java.io.*;
public class JIAMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����ļ�����");
		try {
			filename = br.readLine();
			
			//���ȶ�����Ҫ���ܵ��ļ�
			FileReader fis = new FileReader(filename);
			br = new BufferedReader(fis);
			String result = "";
			String temp = null;
			while((temp = br.readLine()) !=null ){
				result += temp + '\n';
//				System.out.println(result);
			}
			br.close();
			
			//�������ܺ��ļ�����ļ�
			File f = new File("�����ļ�.txt");
			if(!f.exists())
				f.createNewFile();
			
			//���ܹ���
			char[] array = result.toCharArray();
			for(int i = 0; i < array.length; i++)
				array[i] = (char)(array[i]^2);
			byte b2[] = new String(array).getBytes();
			
			//�����ܺ���ļ����
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(b2);
			fos.close();
			
			//������ܺ���ļ�
			FileInputStream fs = new FileInputStream(f);
			byte b3[] = new byte[100];
			int len = 0;
			String ss="";
			while((len = fs.read(b3)) > 0){
				
				ss += new String(b3,0,len);
			}
			fs.close();
			
			//���ܹ���
			array = ss.toCharArray();
			for(int i = 0; i < array.length; i++)
				array[i] = (char)(array[i]^2);
			String b5 = new String(array);
			System.out.println(new String(b5));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
