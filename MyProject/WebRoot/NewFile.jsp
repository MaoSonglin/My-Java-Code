<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="欢迎测试你的第一个使用到 JSTL 的网页"/>
你使用的浏览器是：
<c:out value="${header['User-Agent']}"/>
<c:set var="a" value="David O'Davies" />
<c:out value="David O'Davies" escapeXml="true"/>

</body>
</html>