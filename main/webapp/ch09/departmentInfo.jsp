<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
</head>
<body>
	<h2>부서 정보</h2>[<a href="/jwbook/departmentControl">새로고침</a>]
	<hr />
	<table border="1">
		<tr><th>부서번호</th><th>부서명</th><th>위치</th></tr>
		<c:forEach items="${departments}" var="d">
			<tr><td>${d.deptno}</td><td>${d.dname}</td><td>${d.loc}</td></tr>
		</c:forEach>
	</table>
	<hr />
	<h2>부서 추가</h2>
	<hr />
	<form method="post" action="/jwbook/departmentControl?action=insert">
		<label for="deptno">부서번호</label>
		<input type="text" name="deptno" id="deptno"/><br>
		<label for="dname">부서명</label>
		<input type="text" name="dname" id="dname"/><br>
		<label for="loc">위치</label>
		<input type="text" name="loc" id="loc"/><br>
		
		<button type="submit">등록</button>
	</form>
</body>
</html>