package test4;

public class Undergraduate extends Student {

	public Undergraduate() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Undergraduate(String id,String name,double s1,double s2,double s3)
	{
		super(id,name,s1,s2,s3);
	}

	@Override
	public boolean isORnot() {
		// TODO Auto-generated method stub
		if((score_1+score_2+score_3)/3 >= 60)
			return true;
		return false;
	}

}
