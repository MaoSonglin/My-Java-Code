package test5;

public abstract class Employee {
	protected String name;                    //员工姓名
	protected String id;                      //员工的工号
	protected int day;                        //员工每一个月工作的天数
	protected double salary;                  //员工每个月的薪水
	
	
	public Employee(String name,String id,int day){
		this.name = name;
		this.id = id;
		this.day = day;
	}
	public Employee(){}
	
	public String getName(){return name;}
	public String getID(){return id;}
	public int getDay(){return day;}
	public double getSalary(){return salary;}
	public void setName(String newname){name = newname;}
	public void setID(String id){this.id = id;}
	public void setDay(int d){day = d;}
	public void setSalary(double s){salary =s;}
	public abstract double computeSalary();
	public abstract void linggongzi();
}
