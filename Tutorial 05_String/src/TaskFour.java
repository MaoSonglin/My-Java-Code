import java.io.*;
public class TaskFour {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//将System。in对象包装入InputStreamReader对象中
		InputStreamReader reader = new InputStreamReader(System.in);
		//将reader对象包装入BufferedReader对象中
		BufferedReader input = new BufferedReader(reader);
		//输入文件路径
		System.out.println("输入文件路径：");
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
			System.out.println("该文本大写字母个数为："+upper_count);
			System.out.println("小写字母个数为："+lower_count);
			System.out.println("数字个数为："+mumber_count);
			System.out.println("空格数为："+none_count);
			System.out.println("其它字符个数为："+else_count);
		}catch(IOException ioe){
			System.out.println("输入异常");
		}
	}

}
