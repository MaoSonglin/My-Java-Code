
public class NullPointerArrayExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyClass[] arr=new MyClass[10];
		arr[2] = new MyClass();
		arr[2].value=100;
		System.out.println(arr[2].value);
	}

}
class MyClass{
	public int value=1;
}
