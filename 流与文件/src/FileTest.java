
import java.io.*;
import java.util.ArrayList;

public class FileTest {

    public static void main(String[] args) throws IOException {
    	
    	 File file = new File("c:\\windows");
         if(file.isFile()) { // 是否为文件
             System.out.println(" 文件"); 
             System.out.print(
                   file.canRead() ? "可读" : "不可读"); 
             System.out.print(
                   file.canWrite() ? "可写" : "不可写"); 
             System.out.println(
                   file.length() + "字节"); 
         } 
         else { 
             // 列出所有的文件及目录
             File[] files = file.listFiles(); 
             ArrayList<File> fileList = 
                                 new ArrayList<File>(); 
             for(int i = 0; i < files.length; i++) { 
                 // 先列出目录 
                 if(files[i].isDirectory()) { //是否为目录
                     // 取得路径名
                     System.out.println("[" + 
                             files[i].getPath() + "]"); 
                 }
                 else {
                     // 文件先存入fileList，待会再列出??
                     fileList.add(files[i]); 
                 }
             } 

             // 列出文件 
             for(File f: fileList) {
                 System.out.println(f.toString());
             }
             System.out.println(); 
         } 
    	
    	
        //以当前路径来创建一个File对象
        file = new File(".");
        //直接获取文件名，输出一点
        System.out.println(file.getName());
        //获取相对路径的父路径可能出错，下面代码输出null
        System.out.println(file.getParent());
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
        //在当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        //指定当JVM退出时删除该文件
        tmpFile.deleteOnExit();
        //以系统当前时间作为新文件名来创建新文件
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在：" + newFile.exists());
        //以指定newFile对象来创建一个文件
        newFile.createNewFile();
        //以newFile对象来创建一个目录，因为newFile已经存在，
        //所以下面方法返回false，即无法创建该目录
        newFile.mkdir();
        //使用list方法来列出当前路径下的所有文件和路径
        String[] fileList = file.list();
        System.out.println("======当前路径下所有文件和路径如下=====");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }

        //listRoots静态方法列出所有的磁盘根路径。
        File[] roots = File.listRoots();
        System.out.println("======系统所有根路径如下=====");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
