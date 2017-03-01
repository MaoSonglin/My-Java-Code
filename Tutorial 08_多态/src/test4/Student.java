package test4;

public abstract class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String i,String na,double s1,double s2,double s3){
		id = i;
		name = na;
		score_1 = s1;
		score_2 = s2;
		score_3 = s3;
	}
	public abstract boolean isORnot();
	public void setId(String newid){id = newid;}
	public void setName(String newname){name = newname;}
	public void setScore(int l,double s){
		switch(l){
		case 1:score_1 = s;break;
		case 2:score_2 = s;break;
		case 3:score_3 = s;break;
		}
	}
	public double getScore(int i){
		if(i == 1)
			return score_1;
		else if(i == 2)
			return score_2;
		else if(i == 3)
			return score_3;
		else
			return 0;
	}
	public String getID(){return id;}
	public String getName(){return name;}
	protected String id;
	protected String name;
	protected double score_1;
	protected double score_2;
	protected double score_3;
}
