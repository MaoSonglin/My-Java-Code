package bean;
import java.sql.*;
public class User {

	private String username;//用户名
	private String usertype;//用户类型
	
	public User(){}
	public User(String user){username = user;}
	
	public void setUsername(String data){username = data;}
	public void setUsertype(String data){usertype = data;}
	
	public String getUsername(){return username;}
	public String getUsertype(){return usertype;}
	
	//添加记录
	public boolean addRecord(Record record){
		
		String sql = "insert into records(用户,日期,说明,金额,结算方式,添加时间,备注)"
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
		String sql = "select * from records where 用户 = '"+username+"'";
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
				array[size].setDescription(rs.getString("说明"));
				array[size].setSum(rs.getDouble("金额"));
				array[size].setMode(rs.getInt("结算方式"));
				array[size].setDate((java.util.Date)rs.getObject("日期"));
				array[size].setAddtime((java.util.Date)rs.getObject("添加时间"));
				array[size].setComment(rs.getString("备注"));
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
