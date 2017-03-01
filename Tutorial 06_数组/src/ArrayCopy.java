
public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myArray[] = {1,2,3,4,5,6};               //初始化一个数组
		int yourArray[] = {10,9,8,7,6,5,4,3,2,1,0};  //初始化另一个数组
		
		//输出复制前的第一个数组中的元素
		System.out.println("复制前myArray：");
		for(int i = 0; i < myArray.length; i++)
			System.out.print(myArray[i]+" ");
		System.out.println();
		
		//输出复制前第二个数组中的元素
		System.out.println("复制前yourArray：");
		for(int i = 0; i < yourArray.length; i++)
			System.out.print(yourArray[i]+" ");
		System.out.println();
		
		//调用System类的函数arraycopy()函数将myArray数字从位置0开始5个元素
		//复制到yourArray数组的位置为0开始的5个元素中。
		System.arraycopy(myArray, 0, yourArray, 0, 5);
		
		//输出复制后的yourArray数组。
		System.out.println("复制后yourArray：");
		for(int i=0; i < yourArray.length; i++)
			System.out.print(yourArray[i]+" ");
		System.out.println();
	}

}
