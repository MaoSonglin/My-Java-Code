<%@ page contentType="text/html; charset=GB2312" %>
<html>
<body>
	<% String str=request.getParameter("number");//
	   int n = Integer.parseInt(str);
	   int sum = 0;
	   for(int i = 1; i <= n; i++)
		{sum+=i;}
	%>

<p> ��1��<%=n%>���ۼӺ��ǣ�<br>
<%=sum%>
</body>
</html>