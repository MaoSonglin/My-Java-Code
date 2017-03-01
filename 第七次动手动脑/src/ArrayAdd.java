import javax.swing.JOptionPane;
public class ArrayAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[10];
		
		int sum = 0;
		String input = "";
		String add = "";
		for(int i = 0; i < array.length; i++)
		{
			array[i] = (int)(Math.random() * 100);
			sum += array[i];
			input += array[i] + " ";
			if(i != array.length-1)
				add += array[i] + "+";
			else 
				add += array[i];
		}
		
		JOptionPane.showMessageDialog(null, input);
		JOptionPane.showMessageDialog(null, add + "="+sum);
	}

}
