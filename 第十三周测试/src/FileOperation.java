import java.io.*;
public class FileOperation {

	public boolean  addRecord(Student std){
		//添加一个学生
		File file = new File("StuInfoTable.txt");
		try{
			if(!file.exists())
				file.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(file,true));
			out.println(std.tramslate());
			out.close();
		}catch(IOException e){
			return false;
		}
		return true;
	}
	
	public Student[] readRecord(){
		try {
			BufferedReader read = new BufferedReader(new FileReader("StuInfoTable.txt"));
			String temp = null;
			String result = "";
			while((temp = read.readLine())!=null)
				result += temp+"\t";
			read.close();
			if(result != null && result != ""){
				String array[] = result.split("\t");
				int len = array.length;
				Student[] ss = new Student[len];
				for(int i = 0; i < len; i++){
					ss[i] =new Student();
					ss[i].tramslate(array[i]);
					}
				return ss;
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			return null;
			
		}
		return null;
	}
	
	public boolean deleteRecord(String target)
	{
		
		Student []array = readRecord();
		for(int i = 0; i < array.length; i++)
			if(array[i].tramslate().indexOf(target)>=0)
			{
				try {
					PrintWriter out = new PrintWriter(new FileWriter("StuInfoTable.txt"));
					for(int j = 0 ; j < array.length; j++)
					{
						if(j != i)
						{
							out.println(array[j].tramslate());
						}
					}
					out.close();
							
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return false;
	}
}
