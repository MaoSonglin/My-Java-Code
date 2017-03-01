package dome3;
import java.util.Scanner;
public class StudentManager1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentManager1 manager = new StudentManager1();
		String name = "",id = "",birthday="",home="";
		boolean sex,flag=true;
		double score;
		int opt;
		while(flag)
		{
			Scanner in =new Scanner(System.in);
			manager.option();
			opt = in.nextInt();
			
			switch(opt)
			{
			case 1:manager.showStudent();break;
			case 2:
				System.out.print("姓名：");
				name=in.next();
				System.out.print("学号：");
				id = in.next();
				System.out.print("出生日期：");
				birthday=in.next();
				System.out.print("性别：");
				sex=in.nextBoolean();
				System.out.print("籍贯：");
				home = in.next();
				System.out.print("成绩：");
				score=in.nextDouble();
				if(manager.addStudent(name, id, birthday, sex, score, home))
					System.out.println("添加成功！");
				else
					System.out.println("添加失败！");
				break;
			case 3:
				System.out.print("输入需要删除学生的学号：");
				id = in.next();
				if(manager.deleteStudent(id))
					System.out.println("删除成功！");
				else
					System.out.println("删除失败！");
				break;
			case 4:
				System.out.print("姓名：");
				name=in.next();
				System.out.print("学号：");
				id = in.next();
				System.out.print("出生日期：");
				birthday=in.next();
				System.out.print("性别：");
				sex=in.nextBoolean();
				System.out.print("籍贯：");
				home = in.next();
				System.out.print("成绩：");
				score=in.nextDouble();
				if(manager.updateStudent(id, name, birthday, sex, home, score))
					System.out.println("修改成功！");
				else 
					System.out.println("修改失败！");
				break;
			case 5:
				System.out.print("输入查询学号：");
				id = in.next();
				if(manager.selectStudent(id))
					System.out.println("查找成功！");
				else
					System.out.println("查找失败！");
				break;
			case 6:flag=false;break;
			default:System.out.println("无此操作！");
			}
			in.close();
		}
	}
	
	public StudentManager1()
	{
		group[0] = new Student("毛松林","20153144","1996/12/08",false,99.0,"重庆");
		count++;
	}
	
	public void showStudent()                    //显示所有学生信息
	{
		for(int i = 0; i < count; i++)
			group[i].display();
	}
	public boolean addStudent(String name,       //添加一个学生的信息
			String ID,String birthday,boolean sex,double score,String home)                 
	{
		for(int i = 0; i < count; i++)
			if(count >= 50||group[i].getID().equals(ID))
				return false;
		
		group[count] = new Student(name, ID, birthday, sex,score,home);
		count++;
		return true;
	}
	public boolean deleteStudent(String ID)      //删除一个学生的信息
	{
		for(int i = 0; i < count; i++)
			if(group[i].getID().equals(ID))
			{
				for(int j = i; j < count-1; j++)
					group[j]=group[j+1];
				count--;
				return true;
			}
		return false;
	}
	public boolean updateStudent(String ID,      //修改一个学生的信息
			String name,String birthday,boolean sex,String home,double score)      
	{
		for(int i = 0; i < count; i++)
			if(group[i].getID().equals(ID))
			{
				group[i].setName(name);
				group[i].setBirthday(birthday);
				group[i].setSex(sex);
				group[i].setScore(score);
				group[i].setHome(home);
				return true;
			}
		return false;
	}
	public boolean selectStudent(String ID)      //查询并输出学生信息
	{
		for(int i = 0; i < count; i++)
			if(group[i].getID().equals(ID))
			{
				group[i].display();
				return true;
			}
		return false;
	}
	private void option(){                       //打印界面
		System.out.print(""
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
		System.out.print("请选择：");
	}
	
	private Student[] group = new Student[50];    //存放一个班的所有学生的信息，人数不能超过50
	private int count;                            //一共有多少人
}
