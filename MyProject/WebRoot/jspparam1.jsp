<%@ page contentType="text/html;charset=GB2312"%>
<html>
<body>
<p>加载文件显示效果：

	<jsp:include page="sum.jsp">
		<jsp:param name = "number" value="300" />
	</jsp:include>
	</p>
</body>
</html>