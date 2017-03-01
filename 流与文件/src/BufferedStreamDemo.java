
 
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
 
            System.out.println("�����ļ���" + 
                             srcFile.length() + "�ֽ�");

            while(bufferedInputStream.read(data) != -1) { 
                bufferedOutputStream.write(data); 
            }
            
            // ���������е�����ȫ��д�� 
            bufferedOutputStream.flush();
 
            // �ر��� 
 
            bufferedInputStream.close(); 
            bufferedOutputStream.close(); 

            System.out.println("�������"); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
}