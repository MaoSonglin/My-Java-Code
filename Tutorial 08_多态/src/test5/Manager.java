package test5;

public class Manager extends Employee {

	public Manager() {
		// TODO Auto-generated constructor stub
		super("����","001",30);
		salary = (int)(100000*Math.random());
	}
	
	public Manager(String name,String id,double s){
		super(name,id,30);
		salary = s;
	}
	

	@Override
	public double computeSalary() {
		// TODO Auto-generated method stub
		return salary;
	}
	public void linggongzi(){
		System.out.println(name+"ÿ�¹������ʣ�"+salary+"Ԫ");
	}
}
