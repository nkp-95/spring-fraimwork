<%@ page import="java.util.Collection" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   //응답 헤더에 추가할 값 준비
   SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm");
   long add_date = s.parse(request.getParameter("add_date")).getTime();
   
   java.sql.Date date2 = new java.sql.Date(add_date);
   System.out.println(date2);
   
   int add_int = Integer.parseInt(request.getParameter("add_int"));
   String add_str = request.getParameter("add_str");
   
   //응답헤더에 값 추가
   response.addDateHeader("myBirthday", add_date);
   response.addIntHeader("mynumber", add_int);
   response.addIntHeader("mynumber", 1004);  //추가
   response.addHeader("myName", add_str);
   response.setHeader("myName", "안중근");  //수정
   //add 계열의 메서드: 동일항 이름이 있으면 추가
   //set 계열 메서드: 수정 되고 존재하지 않는다면 새롭게 추가
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - response</title>
</head>
<body>
	<h2>응답 헤더 정보 출력하기</h2>
	<ul>
	<%
	Collection<String> headerNames = response.getHeaderNames();
	for(String hName : headerNames){
		String hValue = response.getHeader(hName);
		//getHeader 메서트 특성으로 값이 여러개라도 첫번째 값만 가져옴
	%>
		<li><%= hName %>: <%= hValue %></li>
	<% } %>
	</ul>
	
	<h2>myNumber만 출력하기</h2>
	<ul>
	<% Collection<String> myNumber = response.getHeaders("myNumber");
		for(String myNum : myNumber){%>
		<li>myNumber : <%= myNum %></li>
	<% } %>	
	</ul>
	
</body>
</html>