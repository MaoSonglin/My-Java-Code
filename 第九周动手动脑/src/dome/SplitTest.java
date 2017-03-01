package dome;
import java.io.*;
public class SplitTest {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(read);
		String str[] = input.readLine().split(" ");
		for(String s:str){
			System.out.println(s);
		}
	}

}
