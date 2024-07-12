<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 스크립틀릿
	int n1 = Integer.parseInt(request.getParameter("n1"));
	int n2 = Integer.parseInt(request.getParameter("n2"));
	//String op = request.getParameter("op"); 이렇게 적고
	long result = 0;
	
	switch(request.getParameter("op")) {//switch(op)  스위치에 이렇게 적더오 ok
		case "+": result = n1 + n2; break;
		case "-": result = n1 - n2; break;
		case "*": result = n1 * n2; break;
		case "/": result = n1 / n2; break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 JSP</title>
</head>
<body>
	<h2>계산결과</h2>
	<hr />
	결과 <%= result %>
	<!-- 표현식 -->
</body>
</html>