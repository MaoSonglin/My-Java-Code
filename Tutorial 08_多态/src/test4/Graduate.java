package test4;

public class Graduate extends Student {

	public Graduate() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Graduate(String id,String name,double s1,double s2,double s3){
		super(id,name,s1,s2,s3);
	}
	public boolean isORnot(){
		if((score_1+score_2+score_3)/3 >= 80)
			return true;
		else 
			return false;
	}
}
