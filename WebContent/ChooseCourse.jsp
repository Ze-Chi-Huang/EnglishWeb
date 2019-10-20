<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="font-family:微軟正黑體">
	<h1 style="text-align:center"><a href="/EnglishWeb/TitleServlet">選擇課程內容，按我獲得課程標題 </a></h1>
	<br>
	<div class="table-responsive" style="text-align:center; width:70%; margin:0 auto" >
	
	<table class="table table-bordered">
		<c:forEach items="${titles }" var = "title" varStatus="vs">
		<tr>
			<td>Lesson ${vs.index}</td>
			<td><a href = "/EnglishWeb/English.jsp?course=${title }">${title}</a></td>
		</tr>
		</c:forEach>
		
	</table>

	
	</div>
</body>
</html>