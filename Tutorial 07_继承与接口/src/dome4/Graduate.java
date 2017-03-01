package dome4;
import java.util.Scanner;
public class Graduate implements StudentInterface,TeacherInterface{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Graduate student = new Graduate();
		System.out.println("输入姓名：");
		student.setName(input.nextLine());
		System.out.println("输入性别：");
		student.setSex(input.nextBoolean());
		System.out.println("输入年龄：");
		student.setAge(input.nextInt());
		System.out.println("输入月工资：");
		student.setPay(input.nextDouble());
		System.out.println("输入每学期学费：");
		student.setFee(input.nextDouble());
		
		if(student.needLoad())
			System.out.println("需要贷款！");
		else
			System.out.println("不需要贷款！");
		input.close();
	}
	
	private double pay,fee;                        //月工资和每学期费用
	private String name;                           //姓名
	private boolean sex;                           //性别，false表示男生，true表示女生
	private int age;                               //年龄


	public Graduate()                                            //默认的无参数构造方法
	{
		// TODO Auto-generated constructor stub
	}
	public Graduate(String n,boolean s,int a,double p,double f)  //有参数的构造方法
	{
		name = n;
		sex = s;
		age = a;
		pay = p;
		fee = f;
	}
	public void setFee(double fee){this.fee = fee;}              //设置每年学费
	public void setPay(double pay){this.pay = pay;}              //设置每月工资
	public void setName(String name){this.name = name;}          //设置姓名
	public void setSex(boolean sex){this.sex = sex;}             //设置性别
	public void setAge(int a){this.age = a;}                     //设置年龄
	
	public double getPay() {                                     //返回每月工资
		// TODO Auto-generated method stub
		return pay;
	}
	public double getFee() {                                     //返回每年学费
		// TODO Auto-generated method stub
		return fee;
	}
	public String getName(){return name;}                        //返回姓名
	public boolean getSex(){return sex;}                         //返回性别
	public int getAge(){return age;}                             //返回年龄
	public boolean needLoad()                                    //计算是否需要贷款
	{
		if(pay*12-fee*2 < 2000)
			return true;
		else
			return false;
	}
}
