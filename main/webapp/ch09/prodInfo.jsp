<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세정보</title>
</head>
<body>
	<h2>상품 상세정보</h2>
	<hr />
	<form method="post" action="/jwbook/prodControl?action=update">
		<ul>
			<li>상품 코드: <input type="text" name="id" value="${p.id}"/></li>
			<li>상품명: <input type="text" name="itemname" value="${p.itemname}"/></li>
			<li>제조사: <input type="text" name="maker" value="${p.maker}"/></li>
			<li>가격: <input type="text" name="price" value="${p.price}"/></li>
			<li>등록일: <input type="text" name="regdate" value="${p.regdate}"/></li>
			<button type="submit">수정</button>
		</ul>
	</form>
	
</body>
</html>