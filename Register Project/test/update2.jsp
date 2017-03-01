<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement st=null; 
ResultSet rs =null;
try{
	con = DriverManager.getConnection("jdbc:Access:/D:/users/acer-pc/documents/databaseone.accdb");
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = st.executeQuery("select * from register_table where 用户名="+request.getParameter("id"));
	rs.updateString(1,request.getParameter("username"));
	rs.updateString(2,request.getParameter("userpassword"));
	rs.updateString(3,request.getParameter("sex"));
	rs.updateString(4,request.getParameter("degree"));
	rs.updateString(5,request.getParameter("comment"));
	rs.updateRow();
	out.print("<h4>修改成功！</h4><a href='showAllUsers.jsp'>返回首页</a>");
}catch(SQLException e){
	e.printStackTrace();
}
%>
</body>
</html>