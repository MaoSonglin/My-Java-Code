package filetestdome;
import java.util.Scanner;

import fileStream.Student;

import java.io.*;
public class StudentManager {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String path = "D:\\student.txt";
		StudentManager manager = new StudentManager();
		boolean tag = true;
		Scanner intRead = new Scanner(System.in);
		int opt;
		do{
			manager.option();
			opt = intRead.nextInt();
			switch(opt){
			case 1:manager.ShowInformation(path);break;//显示所有学生的信息
			case 2:										//向文件中添加一条信息
				if(manager.inputStudent(path))
					System.out.println("添加成功！");
				else 
					System.out.println("添加失败！");
				break;
			case 3:										//删除文件中的一条记录
				if(manager.Delete(path))
					System.out.println("删除成功！");
				else 
					System.out.println("删除失败！");
				break;
			case 4:										//修改一条记录
				if(manager.Update(path))System.out.println("更新成功！");
				else System.out.println("更新失败！");
				break;
			case 5:										//查询指定学生的纪录
				if(manager.Select(path))System.out.println("查询成功！");
				else System.out.println("查询失败！");
				break;
			case 6:tag=false;
			}
		}while(tag);
	}
	//该方法输入一个学生的基本信息，并将这些信息组装为一个学生对象
	//并且调用addRecord的方法将这个学生的信息添加到文件“path”的末尾
	//返回值表示添加结果
	@SuppressWarnings("resource")
	public boolean inputStudent(String path){
		
		Scanner read = new Scanner(System.in);
		System.out.print("输入学号：");
		String id = read.nextLine();
		System.out.print("输入姓名：");
		String name=read.nextLine();
		System.out.print("输入年龄：");
		int age=read.nextInt();
		System.out.print("输入性别(true/false):");
		boolean sex=read.nextBoolean();
		System.out.print("输入成绩：");
		double score=read.nextDouble();
		Student std=new Student(id,name,age,sex,score);
		boolean tag = this.addRecord(std, path);
		return tag;
	}
	//该方法要求输入需要删除学生的学号，然后调用deleteStudent的方法删除该学生在文件中的信息
	@SuppressWarnings({ "finally", "resource" })
	public boolean Delete(String path){
		Scanner read = new Scanner(System.in);
		System.out.println("输入需要删除的学号：");
		String id = read.nextLine();
		boolean t = false;
		try {
			t=this.deleteStudent(id, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return t;}
	}
	public boolean Update(String path) throws IOException{
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("输入需要修改的学生的学号");
		String id =read.nextLine();
		boolean tag = this.updateStudent(id, path);
		return tag;
	}
	@SuppressWarnings("resource")
	public boolean Select(String path) throws IOException{
		System.out.print("输入查询学号：");
		Scanner read = new Scanner(System.in);
		String id = read.nextLine();
		Student[] array = this.readAllStudent(path);
		for(Student s:array){
			if(s.getNumber().equals(id)){
				s.display();return true;
			}
		}
		return false;
	}
	public boolean printToFile(Student s[],String path){//将一组学生的信息输入到文件中
		boolean flag = true;
		FileWriter fw =null;
		BufferedWriter bw = null;
		try {
			fw= new FileWriter(path);
			bw = new BufferedWriter(fw);
			for(int i = 0; i< s.length;i++)
				if(s[i]!=null){
					bw.write(s[i].toStirng());
					//bw.newLine();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	public boolean addRecord(Student s,String path){//向记录中添加一个学生的信息
		boolean flag = true;
		File file = new File(path);
		RandomAccessFile raf=null;
		try {
			raf= new RandomAccessFile(file,"rw");
			long length = raf.length();
			raf.seek(length);
			String temp = s.toStirng();
			for(int i = 0; i < temp.length(); i++)
				raf.write(temp.charAt(i));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	//读取第n个学生的信息
	public Student readRecord(String path,int n) throws IOException
	{
		Student std = null;
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		String a[] = s.split("\t");
		std = toStudent(a[n-1]);
		br.close();
		return std;
	}
	//读取所有学生的信息
	public Student[] readAllStudent(String path)throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		String a[] = s.split("\t");
		Student sa[] = new Student[a.length];
		for(int i = 0; i < a.length; i++){
			sa[i]=toStudent(a[i]);
		}
		br.close();
		return sa;
	}
	//显示所有学生的信息
	public void ShowInformation(String path) throws IOException{
		Student array[] = this.readAllStudent(path);
		for(Student s:array){
			s.display();
		}
	}
	//将存放在一个字符串中的学生信息转化为一个Student类
	public Student toStudent(String s){
		Student std = new Student();
		String trmstr[] = s.split(" ");
		std.setNumber(trmstr[1]);
		std.setName(trmstr[3]);
		std.setAge(Integer.parseInt(trmstr[5].trim()));
		std.setSex(Boolean.parseBoolean(trmstr[7]));
		std.setScore(Double.parseDouble(trmstr[9].trim()));
		return std;
	}
	//修改一个学生的信息
	@SuppressWarnings({ "resource" })
	public boolean updateStudent(Student s)
	{
		boolean flag = true;
		Scanner readoption = null;
		Scanner readname = null;
		Scanner readid = null;
		Scanner readage = null;
		Scanner readsex = null;
		Scanner readscore = null;
		System.out.println("请输入修改项                           1：学号 2：姓名 3：年龄  4：性别   5：成绩");
		int option;
		readoption = new Scanner(System.in);
		option = readoption.nextInt();
		switch(option){
		case 1:
			System.out.print("请输入新学号：");
			readid = new Scanner(System.in);
			String newid = readid.nextLine();
			s.setNumber(newid);
			break;
		case 2:
			System.out.print("请输姓名：");
			readname = new Scanner(System.in);
			String newname = readname.nextLine();
			s.setName(newname);break;
		case 3:
			System.out.print("请输年龄：");
			readage = new Scanner(System.in);
			int newage = readage.nextInt();
			s.setAge(newage);
			break;
		case 4:
			System.out.print("输入性别：");
			readsex = new Scanner(System.in);
			boolean sex = readsex.nextBoolean();
			s.setSex(sex);
			break;
		case 5:
			System.out.print("输入成绩：");
			readscore = new Scanner(System.in);
			double score = readscore.nextDouble();
			s.setScore(score);
			break;
			default:flag = false;
		}
		
		return flag;
	}
	//删除一个学生
	public boolean deleteStudent(String s,Student sa[])
	{
		boolean flag = false;
		for(int i = 0; i < sa.length;i++){
			Student temp = sa[i];
			if(temp.getName().equals(s)){
				sa[i] = null;
				flag = true;
				break;
			}
		}
		this.printToFile(sa, "D:student.txt");
		return flag;
	}
	//删除一个学生的信息
	public boolean deleteStudent(String id,String path) throws IOException
	{
		boolean flag = false;
		Student[] array = this.readAllStudent(path);
		for(int i=0;i < array.length;i++){
			Student s=array[i];
			if(s.getNumber().equals(id))
			{
				array[i] = null;
				flag=true;
				this.printToFile(array, path);break;}
		}
		return flag;
	}
	
	public boolean updateStudent(String s,String path)throws IOException
	{
		boolean flag = false;
		Student array[] = this.readAllStudent(path);
		for(Student t:array){
			if(t.getNumber().equals(s)){//找到需要修改的学生
				this.updateStudent(t);	//修改学信息
				this.printToFile(array, path);//将修改后的学生信息输入到文件中
				flag = true;//修改成功标志
				break;
			}
		}
		return flag;
	}
	public void option(){
		System.out.println(""
				+ "************************************************************\n"
				+ "                    石家庄铁道大学软件工程系学生信息管理系统\n"
				+ "************************************************************\n"
				+ "                   1、遍历输出所有学生信息\n"
				+ "                   2、新学生信息录入\n"
				+ "                   3、删除学生信息\n"
				+ "                   4、修改学生信息\n"
				+ "                   5、查询学生信息\n"
				+ "                   6、退出\n"
				+ "************************************************************\n");
	}
}