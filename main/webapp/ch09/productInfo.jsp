<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 정보</title>
</head>
<body>
	<h2>제품 정보</h2>
	<a href="/jwbook/prodControl">새로 고침</a>
	<hr />
	<table border="1">
		<tr>
			<th>id</th>
			<th>품명</th>
			<th>제조사</th>
			<th>가격</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="p" items="${products}">
			<tr>
				<td>${p.id}</td>
				<td><a href="/jwbook/prodControl?action=info&id=${p.id}">${p.itemname}</a></td>
				<td>${p.maker}</td>
				<td>${p.price}</td>
				<td>${p.regdate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr />
	<h2>제품 추가</h2>
	<hr />
	<form method="post" action="/jwbook/prodControl?action=insert">
		<label for="">품명</label>
		<input type="text" name="itemname"/><br />
		<label for="">제조사</label>
		<input type="text" name="maker"/><br />
		<label for="">가격</label>
		<input type="text" name="price"/><br />
		<label for="">등록일</label>
		<input type="text" name="regdate"/><br />
		<button type="submit">등록</button>
	</form>
	
	

</body>
</html>