import java.io.*;
public class TaskFour {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//��System��in�����װ��InputStreamReader������
		InputStreamReader reader = new InputStreamReader(System.in);
		//��reader�����װ��BufferedReader������
		BufferedReader input = new BufferedReader(reader);
		//�����ļ�·��
		System.out.println("�����ļ�·����");
		String path = input.readLine();
		
		
		try{
			BufferedReader fr = new BufferedReader(new FileReader(path));
			String str=new String();
			String s = new String();
			do{
				s = fr.readLine();
				str += s+"\n";
			}while(s!=null);
			fr.close();
			int upper_count = 0;
			int lower_count = 0;
			int mumber_count = 0;
			int none_count = 0;
			int else_count = 0;
			int i = 0;
			while(i < str.length()&&str.charAt(i) != '\n'){
				char temp = str.charAt(i);
				if(temp >= 'A' && temp <= 'Z')
					upper_count++;
				else if(temp >= 'a' && temp <= 'z')
					lower_count++;
				else if(temp >= '0' && temp <= '9')
					mumber_count++;
				else if(temp == ' ')
					none_count++;
				else
					else_count++;
				i++;
			}
			System.out.println(str);
			System.out.println("���ı���д��ĸ����Ϊ��"+upper_count);
			System.out.println("Сд��ĸ����Ϊ��"+lower_count);
			System.out.println("���ָ���Ϊ��"+mumber_count);
			System.out.println("�ո���Ϊ��"+none_count);
			System.out.println("�����ַ�����Ϊ��"+else_count);
		}catch(IOException ioe){
			System.out.println("�����쳣");
		}
	}

}
