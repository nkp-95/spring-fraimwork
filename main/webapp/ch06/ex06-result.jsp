<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	if(userid.equals(userpw)){
		System.out.println(userid + ": 로그인 성공");
		// 최상위 요청으로 리다이렉트
		//response.sendRedirect(request.getContextPath());
		response.sendRedirect("ex01.jsp");
	} else {
		System.out.println(userid + ": 로그인 실패!!!");
		response.sendRedirect("ex06-loginForm.jsp");
	}
%>
</body>
</html>