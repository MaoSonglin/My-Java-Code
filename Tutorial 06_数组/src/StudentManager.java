
import java.io.*;
public class StudentManager {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader cin =new BufferedReader(read);
		StudentManager manager = new StudentManager();
		while(true){
			manager.option();
			System.out.print("��ѡ��");
			int opt = Integer.parseInt(cin.readLine().trim());
			String id = "",name ="";
			int age;
			boolean sex;
			double score;
			switch(opt){
			case 1:manager.showStudent();break;
			case 2:
				System.out.print("ѧ�ţ�");
				id = cin.readLine();
				System.out.print("������");
				name = cin.readLine();
				System.out.print("���䣺");
				age = Integer.parseInt(cin.readLine());
				System.out.print("�Ա�");
				sex = Boolean.parseBoolean(cin.readLine());
				System.out.print("�ɼ���");
				score = Double.parseDouble(cin.readLine());
				
				if(manager.addStudent(id, name, age, sex, score))
					System.out.println("��ӳɹ���");
				else
					System.out.println("���ʧ�ܣ�");
				break;
			case 3:
				System.out.print("������Ҫɾ��ѧ����ѧ�ţ�");
				id = cin.readLine();
				if(manager.deleteStudent(id))
					System.out.println("ɾ���ɹ���");
				else
					System.out.println("ɾ��ʧ�ܣ�");
				break;
			case 4:
				System.out.print("ѧ�ţ�");
				id = cin.readLine();
				System.out.print("������");
				name = cin.readLine();
				System.out.print("���䣺");
				age = Integer.parseInt(cin.readLine().trim());
				System.out.print("�Ա�");
				sex = Boolean.parseBoolean(cin.readLine());
				System.out.print("�ɼ���");
				score = Double.parseDouble(cin.readLine());
				if(manager.updataStudent(id, name, age, sex, score))
					System.out.println("�޸ĳɹ���");
				else
					System.out.println("�޸�ʧ�ܣ�");
				break;
			case 5:
				System.out.print("�����ѯѧ�ţ�");
				id = cin.readLine();
				if(manager.selectStudnet(id))
					System.out.println("���ҳɹ���");
				else
					System.out.println("����ʧ�ܣ�");
				break;
			case 6:return;
			default:System.out.println("�޴˲�����");
			}
		}
	}
	public StudentManager(){}
	
	//��ӡ�������ѧ������Ϣ
	public void showStudent(){
		for(int i=0; i < count; i++)
			group[i].display();
	}
	
	//���ѧ����Ϣ
	public boolean addStudent(String id,String name,int age,boolean sex,double score){
		for(int i=0; i < count; i++)
			if(group[i].getNumber().equals(id)||count >= 50)
				return false;
		group[count] = new Student();
		group[count].setNumber(id);
		group[count].setName(name);
		group[count].setAge(age);
		group[count].setSex(sex);
		group[count].setScore(score);
		count++;
		return true;
	}
	
	//ɾ��ѧ����Ϣ
	public boolean deleteStudent(String id){
		
		for(int i = 0; i < count; i++){
			if(group[i].getNumber().equals(id)){
				for(int j = i; j < count-1; j++){
					group[j] = group[j+1];
				}
				count--;
				return true;
			}
		}
		
		return false;}

	//�޸�ѧ����Ϣ
	public boolean updataStudent(String id,String name,int age,boolean sex, double score){
		for(int i = 0; i < count; i++){
			if(group[i].getNumber().equals(id)){
				group[i].setName(name);
				group[i].setAge(age);
				group[i].setSex(sex);
				group[i].setScore(score);
				return true;
			}
		}
		return false;
	}

	//��ѯ�����ѧ������Ϣ
	public boolean selectStudnet(String id){
		for(int i = 0; i < count; i++){
			if(group[i].getNumber().equals(id)){
				group[i].display();
				return true;
			}
		}
		return false;
	}
	
	//��ӡ����
	public void option(){
		System.out.println(""
				+ "************************************************************\n"
				+ "                    ʯ��ׯ������ѧ�������ϵѧ����Ϣ����ϵͳ\n"
				+ "************************************************************\n"
				+ "                   1�������������ѧ����Ϣ\n"
				+ "                   2����ѧ����Ϣ¼��\n"
				+ "                   3��ɾ��ѧ����Ϣ\n"
				+ "                   4���޸�ѧ����Ϣ\n"
				+ "                   5����ѯѧ����Ϣ\n"
				+ "                   6���˳�\n"
				+ "************************************************************\n");
	}
	
	//˽������
	private Student[] group = new Student[50];//�洢ѧ����Ϣ
	private int count = 0;                    //����
}
class Student{
	//TODO
	//˽������
	private String stunumber;
	private String name;
	private int age;
	private boolean sex;
	private double score;
	
	//���췽��
	public Student(){}
	public Student(String id,String name,int age,boolean sex,double score){
		this.stunumber = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
	}
	
	//get����
	public String getNumber(){return this.stunumber;}
	public String getName(){return this.name;}
	public int getAge(){return this.age;}
	public boolean getSex(){return this.sex;}
	public double getScore(){return this.score;}
	
	//set����
	public void setNumber(String id){this.stunumber=id;}
	public void setName(String name){this.name=name;}
	public void setAge(int age){this.age=age;}
	public void setSex(boolean sex){this.sex=sex;}
	public void setScore(double score){this.score=score;}
	
	//��ʾѧ����Ϣ
	public void display(){
		System.out.print("ѧ�ţ�"+stunumber);
		System.out.print("  ������"+name);
		System.out.print("  ���䣺"+age);
		System.out.print("  �Ա�"+sex);
		System.out.println("  �ɼ���"+score);
	}
	
}
