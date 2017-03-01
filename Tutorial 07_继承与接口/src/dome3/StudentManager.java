package dome3;
import java.io.*;
public class StudentManager {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(read);
		StudentManager manager = new StudentManager();
		String name = "",id = "",birthday="",home="";
		boolean sex,flag=true;
		double score;
		int opt;
		while(flag)
		{
			manager.option();
			opt = Integer.parseInt(input.readLine());
			switch(opt)
			{
			case 1:manager.showStudent();break;
			case 2:
				System.out.print("������");
				name = input.readLine();
				System.out.print("ѧ�ţ�");
				id = input.readLine();
				System.out.print("�������ڣ�");
				birthday = input.readLine();
				System.out.print("�Ա�");
				sex = Boolean.parseBoolean(input.readLine());
				System.out.print("���᣺");
				home = input.readLine();
				System.out.print("�ɼ���");
				score = Double.parseDouble(input.readLine());
				if(manager.addStudent(name, id, birthday, sex, score, home))
					System.out.println("��ӳɹ���");
				else
					System.out.println("���ʧ�ܣ�");
				break;
			case 3:
				System.out.print("������Ҫɾ��ѧ����ѧ�ţ�");
				id = input.readLine();
				if(manager.deleteStudent(id))
					System.out.println("ɾ���ɹ���");
				else
					System.out.println("ɾ��ʧ�ܣ�");
				break;
			case 4:
				System.out.print("������");
				name = input.readLine();
				System.out.print("ѧ�ţ�");
				id = input.readLine();
				System.out.print("�������ڣ�");
				birthday = input.readLine();
				System.out.print("�Ա�");
				sex = Boolean.parseBoolean(input.readLine());
				System.out.print("���᣺");
				home = input.readLine();
				System.out.print("�ɼ���");
				score = Double.parseDouble(input.readLine());
				if(manager.updateStudent(id, name, birthday, sex, home, score))
					System.out.println("�޸ĳɹ���");
				else 
					System.out.println("�޸�ʧ�ܣ�");
				break;
			case 5:
				System.out.print("�����ѯѧ�ţ�");
				id = input.readLine();
				if(manager.selectStudent(id))
					System.out.println("���ҳɹ���");
				else
					System.out.println("����ʧ�ܣ�");
				break;
			case 6:flag=false;break;
			default:System.out.println("�޴˲�����");
			}
		}
	}
	
	public StudentManager()
	{
		group[0] = new Student("ë����","20153144","1996/12/08",false,99.0,"����");
		count++;
	}
	
	public void showStudent()                    //��ʾ����ѧ����Ϣ
	{
		for(int i = 0; i < count; i++)
			group[i].display();
	}
	public boolean addStudent(String name,       //���һ��ѧ������Ϣ
			String ID,String birthday,boolean sex,double score,String home)                 
	{
		for(int i = 0; i < count; i++)
			if(count >= 50||group[i].getID().equals(ID))
				return false;
		
		group[count] = new Student(name, ID, birthday, sex,score,home);
		count++;
		return true;
	}
	public boolean deleteStudent(String ID)      //ɾ��һ��ѧ������Ϣ
	{
		for(int i = 0; i < count; i++)
			if(group[i].getID().equals(ID))
			{
				for(int j = i; j < count-1; j++)
					group[j]=group[j+1];
				count--;
				return true;
			}
		return false;
	}
	public boolean updateStudent(String ID,      //�޸�һ��ѧ������Ϣ
			String name,String birthday,boolean sex,String home,double score)      
	{
		for(int i = 0; i < count; i++)
			if(group[i].getID().equals(ID))
			{
				group[i].setName(name);
				group[i].setBirthday(birthday);
				group[i].setSex(sex);
				group[i].setScore(score);
				group[i].setHome(home);
				return true;
			}
		return false;
	}
	public boolean selectStudent(String ID)      //��ѯ�����ѧ����Ϣ
	{
		for(int i = 0; i < count; i++)
			if(group[i].getID().equals(ID))
			{
				group[i].display();
				return true;
			}
		return false;
	}
	private void option(){                       //��ӡ����
		System.out.print(""
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
		System.out.print("��ѡ��");
	}
	
	private Student[] group = new Student[50];    //���һ���������ѧ������Ϣ���������ܳ���50
	private int count;                            //һ���ж�����
}
