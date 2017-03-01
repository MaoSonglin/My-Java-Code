package test4;

@SuppressWarnings("serial")
public class WirhdrawException extends Exception {

	public WirhdrawException(String s) {
		// TODO Auto-generated constructor stub
		message = s;
	}
	public String getMessage(){
		System.out.println(message);
		return "";
	}
	private String message;
}
