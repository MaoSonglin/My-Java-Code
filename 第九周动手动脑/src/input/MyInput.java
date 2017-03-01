package input;
import java.io.*;
public class MyInput {
	public static String strData()throws IOException{  //读取字符串数据
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		return input.readLine();
	}
	public static float floatData()throws IOException{ //读取单精度变量
		return Float.parseFloat(strData());
	}
	public static double doubleData()throws IOException{//读取双精度变量
		return Double.parseDouble(strData());
	}
	public static int intData()throws IOException{      //读取整型变量
		return Integer.parseInt(strData());
	}
	public static long longData()throws IOException{    //读取长整型变量
		return Long.parseLong(strData());
	}
	public static short shortData()throws IOException{  //读取短整型变量
		return Short.parseShort(strData());
	}
	public static boolean boolData()throws IOException{ //读取Boolean变量
		return Boolean.parseBoolean(strData());
	}
}
