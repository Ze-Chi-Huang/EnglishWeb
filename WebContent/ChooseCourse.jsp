<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="/EnglishWeb/TitleServlet">��ܽҵ{���e�A������o�ҵ{���D </a></h1>
	
	<c:forEach items="${titles }" var = "title">
		<a href = "/EnglishWeb/English.jsp?course=${title }">${title}</a><br>
	</c:forEach>
	
</body>
</html>