<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="from1" action="index.jsp" method="post">
<table>
	<tr>
		<td colspan="3">欢迎使用</td>
	</tr>
	<tr>
		<td><label>起始<input type="number" name="begin"size="4"value="0"></label></td>
		<td><label>终止<input type="number" name="end"size="4"value="100"></label></td>
		<td><label>数目<input type="number" name="num"size="4"value="30"></label></td>
	</tr>
	<tr>
		<td><input type="submit" value="确定"></td>
	</tr>
</table>
</form>
<%
	try{
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		int num = Integer.parseInt(request.getParameter("num"));
		Equation[] array = new Equation[num];
		for(int i = 0; i < num; i++){
			array[i] = Equation.createEquation(begin, end);
			for(int j = 0; j < i; j++){
				if(array[j].equals(array[i])){
					array[i] = Equation.createEquation(begin, end);
					j = 0;
				}
			}
		}
		for(int i = 0; i < num; i+=1){
			
			out.print("<h4>"+array[i]+array[i].getResult()+"</h4>");
			//if(i % 3==0&&i!=0)
				//out.print("<br>");
		}
	}catch(Exception e){}
%>
</body>
</html>