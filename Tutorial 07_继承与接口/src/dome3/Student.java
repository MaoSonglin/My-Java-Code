package dome3;

class Student extends Person {
	//���췽��
	public Student() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Student(String name,String ID,String birthday,boolean sex,double score,String home)
	{
		super(birthday,sex);
		this.name = name;
		this.ID = ID;
		this.score = score;
		this.home = home;
	}
	
	public void setName(String n){name = n;}         //��������
	public void setID(String i){ID = i;}             //����ѧ��
	public void setScore(double s){score = s;}       //���óɼ�
	public void setHome(String h){home = h;}         //���ü�����Ϣ
	
	public String getName(){return name;}            //��ȡ����
	public String getID(){return ID;}                //��ȡѧ��
	public double getScore(){return score;}          //��ȡ�ɼ�
	public String getHome(){return home;}            //��ȡ����
	
	public void display()                            //��ʾ��Ϣ
	{
		System.out.print("������"+name+'\t');
		System.out.print("ѧ�ţ�"+ID+'\t');
		super.display();
		System.out.print("���᣺"+home+'\t');
		System.out.println("�ɼ���"+score+'\n');
	}
	
	private String name;                   //����
	private String ID;                     //ѧ��
	private double score;                  //��ѧ�ɼ�
	private String home;                   //����
}
