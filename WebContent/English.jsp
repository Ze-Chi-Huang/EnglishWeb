<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<style>
	input {
		style :font-family:calibri;
		background-color : #C7EDCC;
		text-align:center;
	}
</style>
</head>
<body style="font-family:calibri;background-color:#C7EDCC">
	<% request.setAttribute("course", request.getParameter("course")); %>
	
	<div style="margin:0 auto;width:70%;text-align:center; font-family:�L�n������">
		<h1>�z��ܪ��椸�� : ${course }�A</h1>
		<h1><a href="/EnglishWeb/ScriptServlet?course=${course }">�I���������</a></h1> 
	</div>
	
	<div style="margin:0 auto;width:70%;text-align:center; font-family:�L�n������">
		<audio src="/EnglishWeb/mp3/${course }.mp3" controls="controls"></audio>
	</div><br>
	
	
	
	<div id = "myscript" style="margin:0 auto;width:50%;">
	
	<form action="/EnglishWeb/CheckAnswerServlet" method="post">

	${script}
	<br>
	</div>
	
	<div id = "myscript" style="margin:0 auto;width:50%;text-align:center;">
		<input type="submit" value="�ﵪ��" 
		style="width:30%;height:40px; border-color:red; font-family:�L�n������ ;" />
	</div>
	</form>
	
	<hr>
	
	<div style="margin:0 auto; width:70%; text-align:center; font-family:�L�n������">
		<h1><a href="/EnglishWeb/ChooseCourse.jsp">�^�W����ܽҵ{</a></h1>
	</div>
	

	
</body>
	<script>
	function show(){
		document.getElementById("myscript").innerHTML ="${scriptWithAnswer}";
		
	}
	</script>
</html>