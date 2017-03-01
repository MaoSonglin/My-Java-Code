<%@ page contentType="text/html; charset=GB2312" %>
<html>
<body>
	<% String str=request.getParameter("number");//
	   int n = Integer.parseInt(str);
	   int sum = 0;
	   for(int i = 1; i <= n; i++)
		{sum+=i;}
	%>

<p> 从1到<%=n%>的累加和是：<br>
<%=sum%>
</body>
</html>