import java.io.*;
import java.nio.channels.*;
import java.util.Scanner;

public class Example{
	
	@SuppressWarnings("resource")
	public static void main(String[] args){

		File file = new File("Example.java");
		Scanner scanner = new Scanner(System.in);
		try{

			RandomAccessFile input = new RandomAccessFile(file,"rw");
			FileChannel channel = input.getChannel();
			FileLock lock = channel.tryLock();
			System.out.println("输入要读取的行数：");
			while(scanner.hasNextInt()){
				int m = scanner.nextInt();
				lock.release();
				for(int i = 1; i <= m; i++){
					String str = input.readLine();
					System.out.println(str);
				}
				lock = channel.tryLock();
				System.out.println("输入要读取的行数：");
			}
		}catch(IOException e){
			System.out.println(e);
		}
	}
}