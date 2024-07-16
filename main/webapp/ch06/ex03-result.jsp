<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청을 받음</title>
</head>
<body>
<%  // 스크립틀릿 : 자바 코드 작성 가능 
	String name = request.getParameter("name");
	System.out.println("전달받은 값 : " + name);
	
	if(name.equals("코스모")){	
%>
	<%= name %>님 환영합니다,
 <%}else{ %>
	누구세유?
<% } %>
	
</body>
</html>