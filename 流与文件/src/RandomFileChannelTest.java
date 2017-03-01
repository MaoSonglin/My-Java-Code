
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;


@SuppressWarnings("unused")
public class RandomFileChannelTest
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		FileChannel randomChannel = null;
		try
		{
			File f = new File("C:\\Users\\acer-pc\\Desktop\\widget\\��׼��ǩ����������.txt");
			//����һ��RandomAccessFile����
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			//��ȡRandomAccessFile��Ӧ��Channel
			randomChannel = raf.getChannel();
			//��Channel����������ӳ���ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY,
				0 , f.length());
			//��Channel�ļ�¼ָ���ƶ������
			randomChannel.position(f.length());
			//��buffer�������������
			randomChannel.write(buffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (randomChannel != null)
					randomChannel.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
