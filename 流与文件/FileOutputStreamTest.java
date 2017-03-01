package filetestdome;
import java.util.Scanner;

import fileStream.Student;

import java.io.*;
public class StudentManager {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String path = "D:\\student.txt";
		StudentManager manager = new StudentManager();
		boolean tag = true;
		Scanner intRead = new Scanner(System.in);
		int opt;
		do{
			manager.option();
			opt = intRead.nextInt();
			switch(opt){
			case 1:manager.ShowInformation(path);break;//��ʾ����ѧ������Ϣ
			case 2:										//���ļ������һ����Ϣ
				if(manager.inputStudent(path))
					System.out.println("��ӳɹ���");
				else 
					System.out.println("���ʧ�ܣ�");
				break;
			case 3:										//ɾ���ļ��е�һ����¼
				if(manager.Delete(path))
					System.out.println("ɾ���ɹ���");
				else 
					System.out.println("ɾ��ʧ�ܣ�");
				break;
			case 4:										//�޸�һ����¼
				if(manager.Update(path))System.out.println("���³ɹ���");
				else System.out.println("����ʧ�ܣ�");
				break;
			case 5:										//��ѯָ��ѧ���ļ�¼
				if(manager.Select(path))System.out.println("��ѯ�ɹ���");
				else System.out.println("��ѯʧ�ܣ�");
				break;
			case 6:tag=false;
			}
		}while(tag);
	}
	//�÷�������һ��ѧ���Ļ�����Ϣ��������Щ��Ϣ��װΪһ��ѧ������
	//���ҵ���addRecord�ķ��������ѧ������Ϣ��ӵ��ļ���path����ĩβ
	//����ֵ��ʾ��ӽ��
	@SuppressWarnings("resource")
	public boolean inputStudent(String path){
		
		Scanner read = new Scanner(System.in);
		System.out.print("����ѧ�ţ�");
		String id = read.nextLine();
		System.out.print("����������");
		String name=read.nextLine();
		System.out.print("�������䣺");
		int age=read.nextInt();
		System.out.print("�����Ա�(true/false):");
		boolean sex=read.nextBoolean();
		System.out.print("����ɼ���");
		double score=read.nextDouble();
		Student std=new Student(id,name,age,sex,score);
		boolean tag = this.addRecord(std, path);
		return tag;
	}
	//�÷���Ҫ��������Ҫɾ��ѧ����ѧ�ţ�Ȼ�����deleteStudent�ķ���ɾ����ѧ�����ļ��е���Ϣ
	@SuppressWarnings({ "finally", "resource" })
	public boolean Delete(String path){
		Scanner read = new Scanner(System.in);
		System.out.println("������Ҫɾ����ѧ�ţ�");
		String id = read.nextLine();
		boolean t = false;
		try {
			t=this.deleteStudent(id, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{return t;}
	}
	public boolean Update(String path) throws IOException{
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ�ѧ����ѧ��");
		String id =read.nextLine();
		boolean tag = this.updateStudent(id, path);
		return tag;
	}
	@SuppressWarnings("resource")
	public boolean Select(String path) throws IOException{
		System.out.print("�����ѯѧ�ţ�");
		Scanner read = new Scanner(System.in);
		String id = read.nextLine();
		Student[] array = this.readAllStudent(path);
		for(Student s:array){
			if(s.getNumber().equals(id)){
				s.display();return true;
			}
		}
		return false;
	}
	public boolean printToFile(Student s[],String path){//��һ��ѧ������Ϣ���뵽�ļ���
		boolean flag = true;
		FileWriter fw =null;
		BufferedWriter bw = null;
		try {
			fw= new FileWriter(path);
			bw = new BufferedWriter(fw);
			for(int i = 0; i< s.length;i++)
				if(s[i]!=null){
					bw.write(s[i].toStirng());
					//bw.newLine();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	public boolean addRecord(Student s,String path){//���¼�����һ��ѧ������Ϣ
		boolean flag = true;
		File file = new File(path);
		RandomAccessFile raf=null;
		try {
			raf= new RandomAccessFile(file,"rw");
			long length = raf.length();
			raf.seek(length);
			String temp = s.toStirng();
			for(int i = 0; i < temp.length(); i++)
				raf.write(temp.charAt(i));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	//��ȡ��n��ѧ������Ϣ
	public Student readRecord(String path,int n) throws IOException
	{
		Student std = null;
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		String a[] = s.split("\t");
		std = toStudent(a[n-1]);
		br.close();
		return std;
	}
	//��ȡ����ѧ������Ϣ
	public Student[] readAllStudent(String path)throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		String a[] = s.split("\t");
		Student sa[] = new Student[a.length];
		for(int i = 0; i < a.length; i++){
			sa[i]=toStudent(a[i]);
		}
		br.close();
		return sa;
	}
	//��ʾ����ѧ������Ϣ
	public void ShowInformation(String path) throws IOException{
		Student array[] = this.readAllStudent(path);
		for(Student s:array){
			s.display();
		}
	}
	//�������һ���ַ����е�ѧ����Ϣת��Ϊһ��Student��
	public Student toStudent(String s){
		Student std = new Student();
		String trmstr[] = s.split(" ");
		std.setNumber(trmstr[1]);
		std.setName(trmstr[3]);
		std.setAge(Integer.parseInt(trmstr[5].trim()));
		std.setSex(Boolean.parseBoolean(trmstr[7]));
		std.setScore(Double.parseDouble(trmstr[9].trim()));
		return std;
	}
	//�޸�һ��ѧ������Ϣ
	@SuppressWarnings({ "resource" })
	public boolean updateStudent(Student s)
	{
		boolean flag = true;
		Scanner readoption = null;
		Scanner readname = null;
		Scanner readid = null;
		Scanner readage = null;
		Scanner readsex = null;
		Scanner readscore = null;
		System.out.println("�������޸���                           1��ѧ�� 2������ 3������  4���Ա�   5���ɼ�");
		int option;
		readoption = new Scanner(System.in);
		option = readoption.nextInt();
		switch(option){
		case 1:
			System.out.print("��������ѧ�ţ�");
			readid = new Scanner(System.in);
			String newid = readid.nextLine();
			s.setNumber(newid);
			break;
		case 2:
			System.out.print("����������");
			readname = new Scanner(System.in);
			String newname = readname.nextLine();
			s.setName(newname);break;
		case 3:
			System.out.print("�������䣺");
			readage = new Scanner(System.in);
			int newage = readage.nextInt();
			s.setAge(newage);
			break;
		case 4:
			System.out.print("�����Ա�");
			readsex = new Scanner(System.in);
			boolean sex = readsex.nextBoolean();
			s.setSex(sex);
			break;
		case 5:
			System.out.print("����ɼ���");
			readscore = new Scanner(System.in);
			double score = readscore.nextDouble();
			s.setScore(score);
			break;
			default:flag = false;
		}
		
		return flag;
	}
	//ɾ��һ��ѧ��
	public boolean deleteStudent(String s,Student sa[])
	{
		boolean flag = false;
		for(int i = 0; i < sa.length;i++){
			Student temp = sa[i];
			if(temp.getName().equals(s)){
				sa[i] = null;
				flag = true;
				break;
			}
		}
		this.printToFile(sa, "D:student.txt");
		return flag;
	}
	//ɾ��һ��ѧ������Ϣ
	public boolean deleteStudent(String id,String path) throws IOException
	{
		boolean flag = false;
		Student[] array = this.readAllStudent(path);
		for(int i=0;i < array.length;i++){
			Student s=array[i];
			if(s.getNumber().equals(id))
			{
				array[i] = null;
				flag=true;
				this.printToFile(array, path);break;}
		}
		return flag;
	}
	
	public boolean updateStudent(String s,String path)throws IOException
	{
		boolean flag = false;
		Student array[] = this.readAllStudent(path);
		for(Student t:array){
			if(t.getNumber().equals(s)){//�ҵ���Ҫ�޸ĵ�ѧ��
				this.updateStudent(t);	//�޸�ѧ��Ϣ
				this.printToFile(array, path);//���޸ĺ��ѧ����Ϣ���뵽�ļ���
				flag = true;//�޸ĳɹ���־
				break;
			}
		}
		return flag;
	}
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
}