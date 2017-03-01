
import java.io.*;

public class PrintStreamTest {

    public static void main(String[] args) throws IOException {
        PrintStream ps = null;
        try {
            //创建一个节点输出流：FileOutputStream
            FileOutputStream fos = new FileOutputStream("test.txt");
            //以PrintStream来包装FileOutputStream输出流
            ps = new PrintStream(fos);
            //使用PrintStream执行输出
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (IOException ioe) {
            ioe.printStackTrace(ps);
        } finally {
            ps.close();
        }
    }
}
