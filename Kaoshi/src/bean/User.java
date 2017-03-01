package bean;
import java.sql.*;
public class User {

	private String username;//�û���
	private String usertype;//�û�����
	
	public User(){}
	public User(String user){username = user;}
	
	public void setUsername(String data){username = data;}
	public void setUsertype(String data){usertype = data;}
	
	public String getUsername(){return username;}
	public String getUsertype(){return usertype;}
	
	//��Ӽ�¼
	public boolean addRecord(Record record){
		
		String sql = "insert into records(�û�,����,˵��,���,���㷽ʽ,���ʱ��,��ע)"
				+ " values('"+username+"','"+record.getDate()+"','"
				+record.getDescription()+"','"+record.getSum()+"','"+record.getMode()+"','"
				+new java.util.Date()+"','"+record.getComment()+"')";
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
			con = DriverManager.getConnection("jdbc:Access:/C:/Users/acer-pc/Documents/ffasdb.accdb");
			st = con.createStatement();
			boolean result = st.execute(sql);
			st.close();
			con.close();
			return !result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Record[] selectRecord(){
		String sql = "select * from records where �û� = '"+username+"'";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
			con = DriverManager.getConnection("jdbc:Access://C:/Users/acer-pc/Documents/ffasdb.accdb");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql);
			rs.last();
			int size = rs.getRow();
			Record array[]  = new Record[size];
			do{
				size--;
				array[size] = new Record();
				array[size].setDescription(rs.getString("˵��"));
				array[size].setSum(rs.getDouble("���"));
				array[size].setMode(rs.getInt("���㷽ʽ"));
				array[size].setDate((java.util.Date)rs.getObject("����"));
				array[size].setAddtime((java.util.Date)rs.getObject("���ʱ��"));
				array[size].setComment(rs.getString("��ע"));
			}while(rs.previous());
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
