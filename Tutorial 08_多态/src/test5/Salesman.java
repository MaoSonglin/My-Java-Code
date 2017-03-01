package test5;

public class Salesman extends Employee{

	public Salesman() {
		// TODO Auto-generated constructor stub
		super("销售员","00005",30);
		salary= (int)(4000*Math.random());
		ss = (int)(1000*Math.random());
	}
	
	public double computeSalary(){
		return salary + ss;
	}
	public double get(){return ss;}
	public void set(double s){ss=s;}
	private double ss;//提成
	@Override
	public void linggongzi() {
		// TODO Auto-generated method stub
		System.out.println(name+"基本工资"+salary+"元,提成为"+ss+"元，共领工资"+computeSalary()+"元");
	}
}
