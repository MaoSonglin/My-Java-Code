 
import java.io.*;
import java.util.*;
 
public class ByteArrayStreamDemo {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        try { 
            File file = new File("test.txt"); 
            BufferedInputStream bufferedInputStream = 
                new BufferedInputStream( 
                     new FileInputStream(file)); 

            ByteArrayOutputStream arrayOutputStream = 
                new ByteArrayOutputStream(); 

            byte[] bytes = new byte[10];             

            // 将文件内容写入位数组流
            while(bufferedInputStream.read(bytes) != -1) {
                arrayOutputStream.write(bytes);
            }
            arrayOutputStream.close(); 
            bufferedInputStream.close(); 

             // 以字符方式显示位数组内容 
            bytes = arrayOutputStream.toByteArray(); 
            for(int i = 0; i < bytes.length; i++) {
                System.out.print((char) bytes[i]);
            }
            System.out.println(); 

            // 让使用者输入位置与字符修改位数组内容 
            Scanner scanner = new Scanner(System.in);

            System.out.print("输入修改位置："); 
            int pos = scanner.nextInt();
            System.out.print("输入修改字符："); 
           // 修改数组中对应的字符
            bytes[pos-1] = (byte) scanner.next().charAt(0);

            // 将位数组内容存回文件 
            ByteArrayInputStream byteArrayInputStream = 
                new ByteArrayInputStream(bytes); 
            BufferedOutputStream bufOutputStream = 
                new BufferedOutputStream( 
                     new FileOutputStream(file)); 
            byte[] tmp = new byte[1]; 
            while(byteArrayInputStream.read(tmp) != -1) 
                bufOutputStream.write(tmp); 
            byteArrayInputStream.close(); 
            bufOutputStream.flush(); 
            bufOutputStream.close(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
}