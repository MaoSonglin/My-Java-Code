import java.io.*;

public class FileReaderTest
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = null;
		try
		{
			//创建字符输入流
			fr = new FileReader("FileReaderTest.txt");
			//创建一个长度为32的“竹筒”
			char[] cbuf = new char[32];
			//用于保存实际读取的字符数
			int hasRead = 0;
			//使用循环来重复“取水”过程
			while ((hasRead = fr.read(cbuf)) > 0 )
			{
				//取出“竹筒”中水滴（字节），将字符数组转换成字符串输入！
				System.out.print(new String(cbuf , 0 , hasRead));
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			//使用finally块来关闭文件输入流
			if (fr != null)
			{
				fr.close();
			}
		}
	}
}
