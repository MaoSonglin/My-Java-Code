package test5;
import java.util.Vector;
public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Employee> group = new Vector<Employee>();
		
		group.add(new Manager());
		int i = 1;
		for(; i < 10; i++){
			group.add(new Salesman());
		}
		for(;i < 40;i++){
			group.add(new Worker());
		}
		
		for(Employee a:group){
			a.linggongzi();
		}
	}

}
