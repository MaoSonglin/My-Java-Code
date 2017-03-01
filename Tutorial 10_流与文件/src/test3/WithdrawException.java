package test3;

@SuppressWarnings("serial")
public class WithdrawException extends Exception{

	public WithdrawException(String s) {
		// TODO Auto-generated constructor stub
		message=s;
	}
	public String getMessage(){
		System.out.println(message);
		return "";
	}
	private String message;
}
