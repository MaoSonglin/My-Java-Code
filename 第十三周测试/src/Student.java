public class Student{
	//TODO
	//私有属性
	private String stunumber;
	private String name;
	private int age;
	private boolean sex;
	private double score;
	
	//构造方法
	public Student(){}
	public Student(String id,String name,int age,boolean sex,double score){
		this.stunumber = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
	}
	
	//get方法
	public String getNumber(){return this.stunumber;}
	public String getName(){return this.name;}
	public int getAge(){return this.age;}
	public boolean getSex(){return this.sex;}
	public double getScore(){return this.score;}
	
	//set方法
	public void setNumber(String id){this.stunumber=id;}
	public void setName(String name){this.name=name;}
	public void setAge(int age){this.age=age;}
	public void setSex(boolean sex){this.sex=sex;}
	public void setScore(double score){this.score=score;}
	
	//显示学生信息
	public void display(){
		System.out.print("学号："+stunumber);
		System.out.print("  姓名："+name);
		System.out.print("  年龄："+age);
		System.out.print("  性别："+sex);
		System.out.println("  成绩："+score);
	}
	
	//将学生的信息转化为一个字符串
	public String tramslate()
	{
		return stunumber+"|"+name+"|"+age+"|"+sex+"|"+score;
	}
	
	public void tramslate(String str){
		String[] temp = str.split("\\|");
		stunumber = temp[0];
		name = temp[1];
		age = Integer.parseInt(temp[2]);
		sex = Boolean.parseBoolean(temp[3]);
		score = Double.parseDouble(temp[4]);
		
	}
	public String toString(){
		return tramslate();
	}
}