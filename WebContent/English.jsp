<%@page import="java.util.List"%>
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
	<% request.setAttribute("course", request.getParameter("course")); %>

	<a href="/EnglishWeb/ScriptServlet?course=${course }">�I���������</a> ${course }<br>
	<audio src="/EnglishWeb/mp3/${course }.mp3" controls="controls"></audio>
	<br>
	
	<div id = "myscript">
	
	<form action="/EnglishWeb/CheckAnswerServlet" method="post">
	
	
	${script}
	
	<input type="submit" value="�ﵪ��"/>
	</form>
	
	</div>
	<hr>

	
	<input type="button" onclick="show()" value = "�I���������" /> <br>
	<div id = "showScript"></div>
	
	<a href="/EnglishWeb/ChooseCourse.jsp">�^�W����ܽҵ{</a>

	
</body>
	<script>
	function show(){
		document.getElementById("myscript").innerHTML ="${scriptWithAnswer}";
		
	}
	</script>
</html>