<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 연습 화면</title>
</head>
<body>
	<ol>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/ex02.jsp">/ex02.jsp</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/ex03.jsp">/ex03.jsp get 연습</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/ex04.jsp">/ex04.jsp post 연습</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/ex05.jsp">/ex05.jsp 같은 이름 여러개</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/RequestHeader.jsp">/RequestHeader.jsp</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/ex06.jsp">/ex06.jsp 리다이렉트</a>
		</li>
		<li>
			<a href="<%= request.getContextPath() %>/ch06/ex06-loginForm.jsp">로그인폼</a>
		</li>
	</ol>
</body>
</html>