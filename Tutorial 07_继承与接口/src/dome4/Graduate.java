package dome4;
import java.util.Scanner;
public class Graduate implements StudentInterface,TeacherInterface{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Graduate student = new Graduate();
		System.out.println("����������");
		student.setName(input.nextLine());
		System.out.println("�����Ա�");
		student.setSex(input.nextBoolean());
		System.out.println("�������䣺");
		student.setAge(input.nextInt());
		System.out.println("�����¹��ʣ�");
		student.setPay(input.nextDouble());
		System.out.println("����ÿѧ��ѧ�ѣ�");
		student.setFee(input.nextDouble());
		
		if(student.needLoad())
			System.out.println("��Ҫ���");
		else
			System.out.println("����Ҫ���");
		input.close();
	}
	
	private double pay,fee;                        //�¹��ʺ�ÿѧ�ڷ���
	private String name;                           //����
	private boolean sex;                           //�Ա�false��ʾ������true��ʾŮ��
	private int age;                               //����


	public Graduate()                                            //Ĭ�ϵ��޲������췽��
	{
		// TODO Auto-generated constructor stub
	}
	public Graduate(String n,boolean s,int a,double p,double f)  //�в����Ĺ��췽��
	{
		name = n;
		sex = s;
		age = a;
		pay = p;
		fee = f;
	}
	public void setFee(double fee){this.fee = fee;}              //����ÿ��ѧ��
	public void setPay(double pay){this.pay = pay;}              //����ÿ�¹���
	public void setName(String name){this.name = name;}          //��������
	public void setSex(boolean sex){this.sex = sex;}             //�����Ա�
	public void setAge(int a){this.age = a;}                     //��������
	
	public double getPay() {                                     //����ÿ�¹���
		// TODO Auto-generated method stub
		return pay;
	}
	public double getFee() {                                     //����ÿ��ѧ��
		// TODO Auto-generated method stub
		return fee;
	}
	public String getName(){return name;}                        //��������
	public boolean getSex(){return sex;}                         //�����Ա�
	public int getAge(){return age;}                             //��������
	public boolean needLoad()                                    //�����Ƿ���Ҫ����
	{
		if(pay*12-fee*2 < 2000)
			return true;
		else
			return false;
	}
}
