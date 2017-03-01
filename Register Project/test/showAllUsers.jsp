<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页显示</title>
</head>
<body>
<%
int dipage = 1;	//当前页码数默认为1
String pages = request.getParameter("dipage");
if(pages == null)
	pages ="1";
try{
	dipage=Integer.parseInt(pages);
}catch(Exception e){
	dipage=1;
}
String sqlstr="select * from register_table";
Connection con = null;
Statement st = null;
ResultSet rs = null;
try{
	Class.forName("com.hxtt.sql.access.AccessDriver");
	con = DriverManager.getConnection("jdbc:Access:/D:/Users/acer-pc/Documents/databaseone.accdb");
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs = st.executeQuery(sqlstr);
	int countRecord = 0; //记录条数
	int countPageRecord=0;//每页记录条数
	int countPage=0;//总页数
	countPageRecord = 5;
	rs.last();
	countRecord = rs.getRow();
	if(countRecord%countPageRecord==0)
		countPage = countRecord/countPageRecord;
	else
		countPage = countRecord/countPageRecord+1;
	if((dipage-1)*countPageRecord==0)
		rs.beforeFirst();
	else
		rs.absolute((dipage-1)*countPageRecord);
	out.print("<font size=12 ><table border style='font-size:10pt' width='100%'>");
	out.print("<tr><td colspan=6 align=center><font size=6>用户数据</font></td></tr>");
	out.print("<tr>");
		out.print("<td width='15%' align=center><font size=5>用户名</font></td>");
		out.print("<td width='15%' align=center><font size=5>密码</font></td>");
		out.print("<td width='15%' align=center><font size=5>性别</font></td>");
		out.print("<td width='15%' align=center><font size=5>学历</font></td>");
		out.print("<td width='20%' align=center><font size=5>备注</font></td>");
		out.print("<td width='20%' align=center><font size=5>操作</font></td>");
	out.print("</tr>");
	int i = 0;
	while(rs.next()){
		out.print("<tr>");
		out.print("<td align=left  ><font size=4>"+rs.getString(1)+"</font></td>");
		out.print("<td align=left  ><font size=4>"+rs.getString(2)+"</font></td>");
		out.print("<td align=center><font size=4>"+rs.getString(3)+"</font></td>");
		out.print("<td align=center><font size=4>"+rs.getString(4)+"</font></td>");
		out.print("<td align=left  ><font>"+rs.getString(5)+"</font></td>");
		out.print("<td align=center><a href='update.jsp?user="+rs.getString(1)+"'>修改</a><br><a href='deleteuser.jsp?user="+rs.getString(1)+"'>删除</a></td>");
		out.print("</tr>");
		i++;
		if(i >= countPageRecord)break;
	}
	out.print("<tr><td colspan=6 align=center>");
	out.print("共"+countRecord+"条记录，共"+countPage+"页，当前第"+dipage+"页，每页"+countPageRecord+"条记录，");
	if(dipage==1);//当前是首页
	else{
		out.print("<a href=showAllUsers.jsp?dipage=1>首页</a>,");
		out.print("<a href=showAllUsers.jsp?dipage=1>上一页</a>");
	}
	if(dipage==countPage);
	else{
		out.print("<a href=showAllUsers.jsp?dipage="+(dipage+1)+">下一页</a>,");
		out.print("<a href=showAllUsers.jsp?dipage="+countPage+">末页</a>");
	}
	out.print("</td></tr>");
	out.print("</table></font>");
}catch(SQLException e){}
%>
</body>
</html>