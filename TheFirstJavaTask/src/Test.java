import java.io.*;
public class Test {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		double one, tow;
		BufferedReader readone = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader readtow = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input a  menbers:");
		String readword = readone.readLine();
		one = Double.parseDouble(readword);
		
		System.out.println("Input another menber:");
		readword = readtow.readLine();
		tow = Double.parseDouble(readword);
		
		System.out.println("The total of tow menbers is :" + (one+tow));
	}

}
