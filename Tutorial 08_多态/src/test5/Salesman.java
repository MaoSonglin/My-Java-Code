package test5;

public class Salesman extends Employee{

	public Salesman() {
		// TODO Auto-generated constructor stub
		super("����Ա","00005",30);
		salary= (int)(4000*Math.random());
		ss = (int)(1000*Math.random());
	}
	
	public double computeSalary(){
		return salary + ss;
	}
	public double get(){return ss;}
	public void set(double s){ss=s;}
	private double ss;//���
	@Override
	public void linggongzi() {
		// TODO Auto-generated method stub
		System.out.println(name+"��������"+salary+"Ԫ,���Ϊ"+ss+"Ԫ�����칤��"+computeSalary()+"Ԫ");
	}
}
