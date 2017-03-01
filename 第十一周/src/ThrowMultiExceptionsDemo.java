import java.io.*;
public class ThrowMultiExceptionsDemo { 
    public static void main(String[] args) 
    	{ 
      try { 
            throwsTest(); 
       } 
        catch(IOException e) { 
            System.out.println("捕捉异常"); 
        }
    }

    private static void throwsTest()  throws ArithmeticException,IOException { 
        System.out.println("这只是一个测试"); 
        // 程序处理过程假设发生异常
        throw new IOException(); 
        //throw new ArithmeticException(); 
    } 
}