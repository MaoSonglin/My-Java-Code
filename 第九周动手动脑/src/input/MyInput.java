package input;
import java.io.*;
public class MyInput {
	public static String strData()throws IOException{  //��ȡ�ַ�������
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		return input.readLine();
	}
	public static float floatData()throws IOException{ //��ȡ�����ȱ���
		return Float.parseFloat(strData());
	}
	public static double doubleData()throws IOException{//��ȡ˫���ȱ���
		return Double.parseDouble(strData());
	}
	public static int intData()throws IOException{      //��ȡ���ͱ���
		return Integer.parseInt(strData());
	}
	public static long longData()throws IOException{    //��ȡ�����ͱ���
		return Long.parseLong(strData());
	}
	public static short shortData()throws IOException{  //��ȡ�����ͱ���
		return Short.parseShort(strData());
	}
	public static boolean boolData()throws IOException{ //��ȡBoolean����
		return Boolean.parseBoolean(strData());
	}
}
