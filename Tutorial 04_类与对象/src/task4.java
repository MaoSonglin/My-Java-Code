
public class task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student first = new Student("ц╚киаж",20,false,100);
		first.show();
	}

}
class Student{
	//TODO
	private String name;
	private int age;
	private boolean sex;
	private double score;
	
	public Student(String name,int age,boolean sex,double score){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
	}
	
	public void setName(String newName){name = newName;}
	public String getName(){return name;}
	public void setAge(int newAge){age = newAge;}
	public int getAge(){return age;}
	public void setSex(boolean newSex){sex = newSex;}
	public boolean getSex(){return sex;}
	public void setScore(double newScore){score = newScore;}
	
	
	public void show(){
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		if(sex)
			System.out.println("sex: "+"girl");
		else
			System.out.println("sex: "+"boy");
		System.out.println("score: "+score);
	}
}