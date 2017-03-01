
import java.io.*;

public class KeyinTest {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //将Sytem.in对象转换成Reader对象
            InputStreamReader reader = new InputStreamReader(System.in);
            //将普通Reader包装成BufferedReader
            br = new BufferedReader(reader);
            String buffer = null;
            //采用循环方式来一行一行的读取
            while ((buffer = br.readLine()) != null) {
                //如果读取的字符串为"exit"，程序退出
                if (buffer.equals("exit")) {
                	System.out.println("程序退出……");
                    System.exit(1);
                }
                //打印读取的内容
                System.out.println("输入内容为:" + buffer);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } //关闭输入流
        finally {
            try {
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
