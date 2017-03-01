package dome3;

class Person {
	//构造方法
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

	public String getBirthday(){return birthday;}     //返回出生日期
	public boolean getSex(){return sex;}              //返回性别
	
	public void setBirthday(String d){birthday = d;}  //设置出生日期
	public void setSex(boolean x){sex = x;}           //设置性别
	
	public void display()                             //显示信息
	{
		System.out.println("生日："+birthday+'\t');
		System.out.print("性别："+sex+'\t');
	}
	
	protected String birthday;                        //出生日期
	protected boolean sex;                            //性别
}
