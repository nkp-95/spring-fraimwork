<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력폼 jsp</title>
</head>
<body>
	<form action="ex04-result.jsp" method="post">
		<input type="text" name="n1"/>
		 + 
		 <input type="text" name="n2" />
		<input type="submit" value="계산"/>
	</form>
</body>
</html>