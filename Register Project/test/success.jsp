<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.hxtt.sql.access.AccessDriver" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	request.setCharacterEncoding("utf-8");
	String username= request.getParameter("username");
	if(username==null)
		username="";
	String password = request.getParameter("userpassword");
	if(password==null)
		password = "";
	String sex = new String();
	if(request.getParameter("sex")=="false")
		sex = "男";
	else 
		sex = "女";
	String degree = request.getParameter("degree");
	if(degree==null)
		degree="";
	String comment= request.getParameter("comment");
	if(comment==null)
		comment="";
	String sqlString = null;//Sql语句
	sqlString="select * from register_table";
%>
<%
try{
	Connection con;
	Statement sql;
	ResultSet rs;
	Class.forName("com.hxtt.sql.access.AccessDriver");
	con=DriverManager.getConnection("jdbc:Access:/D:/Users/acer-pc/Documents/databaseone.accdb");
	sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = sql.executeQuery(sqlString);
	rs.moveToInsertRow();
	rs.updateString(1,username);
	rs.updateString(2,password);
	rs.updateString(3,sex);
	rs.updateString(4,degree);
	rs.updateString(5,comment);
	rs.insertRow();
	out.print("<h3>注册成功！</h3>");
	rs.close();
	sql.close();
	con.close();
}catch(SQLException e){
	out.print("<h3>注册失败！</h3>");
	e.printStackTrace();
}
%>

</body>
</html>