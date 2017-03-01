package test4;

public class StudentDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Undergraduate student1 = new Undergraduate("20155487","undergraduate1",randomNumber(),randomNumber(),randomNumber());
		Undergraduate student2 = new Undergraduate("20154251","undergraduate2",randomNumber(),randomNumber(),randomNumber());
		
		Graduate student3 = new Graduate("25142514","graduate1",randomNumber(),randomNumber(),randomNumber());
		Graduate student4 = new Graduate("25142514","graduate2",randomNumber(),randomNumber(),randomNumber());
		
		display(student1);
		display(student2);
		display(student3);
		display(student4);
	}
	public static int randomNumber(){return (int)(Math.random()*100);}//产生一个100以内的随机数
	public static void display(Student s){
		System.out.print("姓名："+s.getName()+" 学号:"+s.getID()+" 成绩："+s.getScore(1)+" "+s.getScore(2)+" "+s.getScore(3));
		if(s.isORnot())
			System.out.println(" 该学生达到毕业要求！");
		else
			System.out.println(" 该学生未达到毕业要求！");
	}
}
