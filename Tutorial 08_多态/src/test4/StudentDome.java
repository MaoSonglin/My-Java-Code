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
	public static int randomNumber(){return (int)(Math.random()*100);}//����һ��100���ڵ������
	public static void display(Student s){
		System.out.print("������"+s.getName()+" ѧ��:"+s.getID()+" �ɼ���"+s.getScore(1)+" "+s.getScore(2)+" "+s.getScore(3));
		if(s.isORnot())
			System.out.println(" ��ѧ���ﵽ��ҵҪ��");
		else
			System.out.println(" ��ѧ��δ�ﵽ��ҵҪ��");
	}
}
