import iostream.*;
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
				id =Stream.getLine();
				System.out.print("姓名：");
				name =Stream.getLine();
				System.out.print("年龄：");
				age = Stream.getInt();
				System.out.print("性别：");
				sex = In.getBoolean();
				System.out.print("成绩：");
				score = Stream.getDobule();
				
				if(manager.addStudent(id, name, age, sex, score))
					System.out.println("添加成功！");
				else
					System.out.println("添加失败！");
				break;
			case 3:
				System.out.print("输入需要删除学生的学号：");
				id = In.getString();
				if(manager.deleteStudent(id))
					System.out.println("删除成功！");
				else
					System.out.println("删除失败！");
				break;
			case 4:
				System.out.print("学号：");
				id =Stream.getLine();
				System.out.print("姓名：");
				name =Stream.getLine();
				System.out.print("年龄：");
				age = Stream.getInt();
				System.out.print("性别：");
				sex = In.getBoolean();
				System.out.print("成绩：");
				score = Stream.getDobule();
				if(manager.updataStudent(id, name, age, sex, score))
					System.out.println("修改成功！");
				else
					System.out.println("修改失败！");
				break;
			case 5:
				System.out.print("输入查询学号：");
				id = In.getString();
				if(manager.selectStudnet(id))
					System.out.println("查找成功！");
				else
					System.out.println("查找失败！");
				break;
			case 6:manager.calculate();
			default:System.out.println("无此操作！");
			}
		}
	}
	public StudentManager(){}
	
	//打印输出所有学生的信息
	public void showStudent(){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return;
		for(int i=0; i < group.length; i++)
			group[i].display();
	}
	
	//添加学生信息
	public boolean addStudent(String id,String name,int age,boolean sex,double score){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null){
			Student s = new Student(id,name,age,sex,score);
		f.addRecord(s);return true;}
		
		for(int i=0; i < group.length; i++)
			if(group[i].getNumber().equals(id))
				return false;
		Student s = new Student(id,name,age,sex,score);
		f.addRecord(s);
		count++;
		return true;
	}
	
	//删除学生信息
	public boolean deleteStudent(String id){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return false;
		
		for(int i = 1; i < group.length; i++){
			if(group[i].getNumber().equals(id)){
				f.deleteRecord(id);
				return true;
			}
		}
		
		return false;}

	//修改学生信息
	public boolean updataStudent(String id,String name,int age,boolean sex, double score){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return false;
		
		for(int i = 0; i < group.length; i++){
			if(group[i].getNumber().equals(id)){
				group[i].setName(name);
				group[i].setAge(age);
				group[i].setSex(sex);
				group[i].setScore(score);
				FileStream.rewrite("StuInfoTalbe.txt", group[0].toString());
				for(int j = 1; j < group.length; j++)
					FileStream.write("StuInfoTalbe.txt", group[j].toString());
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
				+ "                   6、统计学生信息\n"
				+ "************************************************************\n");
	}
	public void calculate()
	{
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return;
		int count=0;
		for(int i = 0; i < group.length; i++)
			if(group[i].getScore()<60)
				count++;
		System.out.println("不及格的有"+count+"个人！");
	}
	
	//私有属性
	private Student[] group = new Student[50];//存储学生信息
	private int count = 0;                    //计数
}

