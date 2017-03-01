
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		int a[] = {2,1,4,8,9,5,3};
		for(i = 0; i < a.length-1; i++){
			int k = i;
			for(j = i; j < a.length; j++){
				if(a[j] < a[k]){
					k = j;
				}
			}
			int temp = a[i];
			a[i]= a[k];
			a[k]=temp;
			System.out.print("i="+i+" j="+j+" k="+k+"Êý×éÔªËØ£º");
			for(int index=0; index < a.length; index++)
				System.out.print(a[index]+" ");
			System.out.println();
		}
		
		for(i = 0; i < a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
