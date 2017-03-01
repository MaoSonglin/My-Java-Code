
 
import java.io.*;
 
public class BufferedStreamDemo {
    public static void main(String[] args) {
        try {
            byte[] data = new byte[1]; 

            File srcFile = new File("BufferedStreamDemo.java"); 
            File desFile = new File("BufferedStreamDemo.java.bak"); 
            if(!srcFile.exists()){
            	srcFile.createNewFile();
            }
            if(!desFile.exists()){
            	desFile.createNewFile();
            }
            BufferedInputStream bufferedInputStream = 
                new BufferedInputStream(
                         new FileInputStream(srcFile)); 
            BufferedOutputStream bufferedOutputStream = 
                new BufferedOutputStream(
                         new FileOutputStream(desFile));
 
            System.out.println("复制文件：" + 
                             srcFile.length() + "字节");

            while(bufferedInputStream.read(data) != -1) { 
                bufferedOutputStream.write(data); 
            }
            
            // 将缓冲区中的数据全部写出 
            bufferedOutputStream.flush();
 
            // 关闭流 
 
            bufferedInputStream.close(); 
            bufferedOutputStream.close(); 

            System.out.println("复制完成"); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
}