import iostream.*;
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
				id =Stream.getLine();
				System.out.print("������");
				name =Stream.getLine();
				System.out.print("���䣺");
				age = Stream.getInt();
				System.out.print("�Ա�");
				sex = In.getBoolean();
				System.out.print("�ɼ���");
				score = Stream.getDobule();
				
				if(manager.addStudent(id, name, age, sex, score))
					System.out.println("��ӳɹ���");
				else
					System.out.println("���ʧ�ܣ�");
				break;
			case 3:
				System.out.print("������Ҫɾ��ѧ����ѧ�ţ�");
				id = In.getString();
				if(manager.deleteStudent(id))
					System.out.println("ɾ���ɹ���");
				else
					System.out.println("ɾ��ʧ�ܣ�");
				break;
			case 4:
				System.out.print("ѧ�ţ�");
				id =Stream.getLine();
				System.out.print("������");
				name =Stream.getLine();
				System.out.print("���䣺");
				age = Stream.getInt();
				System.out.print("�Ա�");
				sex = In.getBoolean();
				System.out.print("�ɼ���");
				score = Stream.getDobule();
				if(manager.updataStudent(id, name, age, sex, score))
					System.out.println("�޸ĳɹ���");
				else
					System.out.println("�޸�ʧ�ܣ�");
				break;
			case 5:
				System.out.print("�����ѯѧ�ţ�");
				id = In.getString();
				if(manager.selectStudnet(id))
					System.out.println("���ҳɹ���");
				else
					System.out.println("����ʧ�ܣ�");
				break;
			case 6:manager.calculate();
			default:System.out.println("�޴˲�����");
			}
		}
	}
	public StudentManager(){}
	
	//��ӡ�������ѧ������Ϣ
	public void showStudent(){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return;
		for(int i=0; i < group.length; i++)
			group[i].display();
	}
	
	//���ѧ����Ϣ
	public boolean addStudent(String id,String name,int age,boolean sex,double score){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null){
			Student s = new Student(id,name,age,sex,score);
		f.addRecord(s);return true;}
		
		for(int i=0; i < group.length; i++)
			if(group[i].getNumber().equals(id))
				return false;
		Student s = new Student(id,name,age,sex,score);
		f.addRecord(s);
		count++;
		return true;
	}
	
	//ɾ��ѧ����Ϣ
	public boolean deleteStudent(String id){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return false;
		
		for(int i = 1; i < group.length; i++){
			if(group[i].getNumber().equals(id)){
				f.deleteRecord(id);
				return true;
			}
		}
		
		return false;}

	//�޸�ѧ����Ϣ
	public boolean updataStudent(String id,String name,int age,boolean sex, double score){
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return false;
		
		for(int i = 0; i < group.length; i++){
			if(group[i].getNumber().equals(id)){
				group[i].setName(name);
				group[i].setAge(age);
				group[i].setSex(sex);
				group[i].setScore(score);
				FileStream.rewrite("StuInfoTalbe.txt", group[0].toString());
				for(int j = 1; j < group.length; j++)
					FileStream.write("StuInfoTalbe.txt", group[j].toString());
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
				+ "                   6��ͳ��ѧ����Ϣ\n"
				+ "************************************************************\n");
	}
	public void calculate()
	{
		FileOperation f = new FileOperation();
		Student[] group = f.readRecord();
		if(group==null)
			return;
		int count=0;
		for(int i = 0; i < group.length; i++)
			if(group[i].getScore()<60)
				count++;
		System.out.println("���������"+count+"���ˣ�");
	}
	
	//˽������
	private Student[] group = new Student[50];//�洢ѧ����Ϣ
	private int count = 0;                    //����
}

