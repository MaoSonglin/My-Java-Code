package dome3;

class Person {
	//���췽��
	public Person(){
		
	}
	public Person(String d,boolean s){
		birthday=d;
		sex = s;
	}	
	public Person(boolean s,String d)
	{
		this(d,s);
	}

	public String getBirthday(){return birthday;}     //���س�������
	public boolean getSex(){return sex;}              //�����Ա�
	
	public void setBirthday(String d){birthday = d;}  //���ó�������
	public void setSex(boolean x){sex = x;}           //�����Ա�
	
	public void display()                             //��ʾ��Ϣ
	{
		System.out.println("���գ�"+birthday+'\t');
		System.out.print("�Ա�"+sex+'\t');
	}
	
	protected String birthday;                        //��������
	protected boolean sex;                            //�Ա�
}
