package test1;

public class TestAPP {

	@SuppressWarnings({ "unused", "null" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int i = 0;
			int j = 1/i;
			String myname=null;
			if(myname.length()>2)
				System.out.println("1");
		}catch(NullPointerException e){
			System.out.println("2");
		}catch(Exception e){
			System.out.println("3");
		}
	}

}
