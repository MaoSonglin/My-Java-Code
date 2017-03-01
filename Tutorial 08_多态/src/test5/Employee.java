package test5;

public abstract class Employee {
	protected String name;                    //Ա������
	protected String id;                      //Ա���Ĺ���
	protected int day;                        //Ա��ÿһ���¹���������
	protected double salary;                  //Ա��ÿ���µ�нˮ
	
	
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
