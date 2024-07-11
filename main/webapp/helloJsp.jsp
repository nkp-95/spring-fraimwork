<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//JSP
	/*
		Java Sever Pages
		HTML에서 자바 코드를 사용할수 있는 구조
		
	*/

	//JSP 요소 : 1. 선언부
	String str1 = "JSP";
	String str2 = "안녕하세요...";
	
	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloJSP</title>
</head>
<body>
	<h2>처음 만들어 보는 <%= str1 %></h2><!-- 2. 표현식 -->
	<p>
		<%
			//3. 스크립틀릿
			out.println(str2 + str1 + "입니다. 열공 합시다 ^^*.");
		
		%>
	</p>
	
	<table>
		<c:forEach var="m" items="${mlist}"> 
			<tr>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>

	<table>	
		<tr data-th-each="m : ${mlist}">
			<td data-th-text="${m.name}">Hong</td>
			<td data-th-text="${e.email}">test@test.com</td>
		</tr>
	</table>
	
	
</body>
</html>