
import java.io.*;
import java.util.*;
 
public class RandomAccessFileDemo {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Student[] students = {
                new Student("Justin", 90), 
                new Student("momor", 95), 
                new Student("Bush", 88), 
                new Student("caterpillar", 84)}; 
        
        try {
            File file = new File("student.dat");
            // 建立RandomAccessFile实例并以读写模式开启文件
            RandomAccessFile randomAccessFile = 
                    new RandomAccessFile(file, "rw"); 
            
            for(int i = 0; i < students.length; i++) { 
              // 使用对应的write方法写入数据
              randomAccessFile.writeChars(students[i].getName());
              randomAccessFile.writeInt(students[i].getScore()); 
            }
 
            Scanner scanner = new Scanner(System.in);
 
            System.out.print("读取第几笔数据？"); 
            
            int num = scanner.nextInt(); 
            
            // 使用seek()方法操作存取位置
            randomAccessFile.seek((num-1) * Student.size()); 
            Student student = new Student(); 

            // 使用对应的read方法读出数据
            student.setName(readName(randomAccessFile));
            student.setScore(randomAccessFile.readInt());

            System.out.println("姓名：" + student.getName());
            System.out.println("分数：" + student.getScore());
 
            // 设定关闭文件
            randomAccessFile.close(); 
        }
        catch(IOException e) { 
            e.printStackTrace(); 
        }
    }
 
    private static String readName(
                           RandomAccessFile randomAccessfile)
                               throws IOException { 
        char[] name = new char[15]; 
 
        for(int i = 0; i < name.length; i++) 
            name[i] = randomAccessfile.readChar(); 

        // 将空字符取代为空格符并返回
        return new String(name).replace('\0', ' '); 
    } 
}


class Student {
    private String name; 
    private int score; 
 
    public Student() { 
        setName("noname"); 
    } 
 
    public Student(String name, int score) {
        setName(name);
        this.score = score; 
    } 
 
    public void setName(String name) {
        StringBuilder builder = null;
        if(name != null) 
            builder = new StringBuilder(name); 
        else 
            builder = new StringBuilder(15); 
 
        builder.setLength(15); // 最长 15 字符
        this.name = builder.toString();
    }
    
    public void setScore(int score) {
        this.score = score;
    }
 
    public String getName() { 
        return name; 
    } 
 
    public int getScore() { 
        return score; 
    } 
     // 每笔数据固定写入34字节 
    public static int size() { 
        return 34; 
    } 
}