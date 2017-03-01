
import java.io.*;
public class StudentManager {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader cin =new BufferedReader(read);
		StudentManager manager = new StudentManager();
		while(true){
			manager.option();
			System.out.print("请选择：");
			int opt = Integer.parseInt(cin.readLine().trim());
			String id = "",name ="";
			int age;
			boolean sex;
			double score;
			switch(opt){
			case 1:manager.showStudent();break;
			case 2:
				System.out.print("学号：");
				id = cin.readLine();
				System.out.print("姓名：");
				name = cin.readLine();
				System.out.print("年龄：");
				age = Integer.parseInt(cin.readLine());
				System.out.print("性别：");
				sex = Boolean.parseBoolean(cin.readLine());
				System.out.print("成绩：");
				score = Double.parseDouble(cin.readLine());
				
				if(manager.addStudent(id, name, age, sex, score))
					System.out.println("添加成功！");
				else
					System.out.println("添加失败！");
				break;
			case 3:
				System.out.print("输入需要删除学生的学号：");
				id = cin.readLine();
				if(manager.deleteStudent(id))
					System.out.println("删除成功！");
				else
					System.out.println("删除失败！");
				break;
			case 4:
				System.out.print("学号：");
				id = cin.readLine();
				System.out.print("姓名：");
				name = cin.readLine();
				System.out.print("年龄：");
				age = Integer.parseInt(cin.readLine().trim());
				System.out.print("性别：");
				sex = Boolean.parseBoolean(cin.readLine());
				System.out.print("成绩：");
				score = Double.parseDouble(cin.readLine());
				if(manager.updataStudent(id, name, age, sex, score))
					System.out.println("修改成功！");
				else
					System.out.println("修改失败！");
				break;
			case 5:
				System.out.print("输入查询学号：");
				id = cin.readLine();
				if(manager.selectStudnet(id))
					System.out.println("查找成功！");
				else
					System.out.println("查找失败！");
				break;
			case 6:return;
			default:System.out.println("无此操作！");
			}
		}
	}
	public StudentManager(){}
	
	//打印输出所有学生的信息
	public void showStudent(){
		for(int i=0; i < count; i++)
			group[i].display();
	}
	
	//添加学生信息
	public boolean addStudent(String id,String name,int age,boolean sex,double score){
		for(int i=0; i < count; i++)
			if(group[i].getNumber().equals(id)||count >= 50)
				return false;
		group[count] = new Student();
		group[count].setNumber(id);
		group[count].setName(name);
		group[count].setAge(age);
		group[count].setSex(sex);
		group[count].setScore(score);
		count++;
		return true;
	}
	
	//删除学生信息
	public boolean deleteStudent(String id){
		
		for(int i = 0; i < count; i++){
			if(group[i].getNumber().equals(id)){
				for(int j = i; j < count-1; j++){
					group[j] = group[j+1];
				}
				count--;
				return true;
			}
		}
		
		return false;}

	//修改学生信息
	public boolean updataStudent(String id,String name,int age,boolean sex, double score){
		for(int i = 0; i < count; i++){
			if(group[i].getNumber().equals(id)){
				group[i].setName(name);
				group[i].setAge(age);
				group[i].setSex(sex);
				group[i].setScore(score);
				return true;
			}
		}
		return false;
	}

	//查询并输出学生的信息
	public boolean selectStudnet(String id){
		for(int i = 0; i < count; i++){
			if(group[i].getNumber().equals(id)){
				group[i].display();
				return true;
			}
		}
		return false;
	}
	
	//打印界面
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
	
	//私有属性
	private Student[] group = new Student[50];//存储学生信息
	private int count = 0;                    //计数
}
class Student{
	//TODO
	//私有属性
	private String stunumber;
	private String name;
	private int age;
	private boolean sex;
	private double score;
	
	//构造方法
	public Student(){}
	public Student(String id,String name,int age,boolean sex,double score){
		this.stunumber = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
	}
	
	//get方法
	public String getNumber(){return this.stunumber;}
	public String getName(){return this.name;}
	public int getAge(){return this.age;}
	public boolean getSex(){return this.sex;}
	public double getScore(){return this.score;}
	
	//set方法
	public void setNumber(String id){this.stunumber=id;}
	public void setName(String name){this.name=name;}
	public void setAge(int age){this.age=age;}
	public void setSex(boolean sex){this.sex=sex;}
	public void setScore(double score){this.score=score;}
	
	//显示学生信息
	public void display(){
		System.out.print("学号："+stunumber);
		System.out.print("  姓名："+name);
		System.out.print("  年龄："+age);
		System.out.print("  性别："+sex);
		System.out.println("  成绩："+score);
	}
	
}
