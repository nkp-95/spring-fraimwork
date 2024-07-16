<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈 화면</title>
</head>
<body>
	<h1>인덱스</h1> <!-- http://localhost:8090/jwbook/까지만 치면 나옴 -->
	<ol>
		<li>
			<a href="<%= request.getContextPath() %>/hello.jsp ">hello.jsp</a>
		</li>
	</ol>
</body>
</html>