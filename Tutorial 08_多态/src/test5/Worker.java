package test5;

public class Worker extends Employee {
	private double money;//每天工资
	public void set(double m){money = m;}
	public double get(){return money;}
	public Worker() {
		// TODO Auto-generated constructor stub
		super("工人","0669966",(int)(Math.random()*31));
		money = (int)(Math.random()*200);
	}
	
	@Override
	public double computeSalary() {
		// TODO Auto-generated method stub
		salary = day*money;
		return salary;
	}
	@Override
	public void linggongzi() {
		// TODO Auto-generated method stub
		System.out.println(name+"工作"+day+"天,"+"每天工资"+money+"元,共领工资"+computeSalary()+"元");
	}

}
