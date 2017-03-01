package dome3;

class Student extends Person {
	//构造方法
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
	
	public void setName(String n){name = n;}         //设置姓名
	public void setID(String i){ID = i;}             //设置学号
	public void setScore(double s){score = s;}       //设置成绩
	public void setHome(String h){home = h;}         //设置籍贯信息
	
	public String getName(){return name;}            //获取姓名
	public String getID(){return ID;}                //获取学号
	public double getScore(){return score;}          //获取成绩
	public String getHome(){return home;}            //获取籍贯
	
	public void display()                            //显示信息
	{
		System.out.print("姓名："+name+'\t');
		System.out.print("学号："+ID+'\t');
		super.display();
		System.out.print("籍贯："+home+'\t');
		System.out.println("成绩："+score+'\n');
	}
	
	private String name;                   //姓名
	private String ID;                     //学号
	private double score;                  //入学成绩
	private String home;                   //籍贯
}
