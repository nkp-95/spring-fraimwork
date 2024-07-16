<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"  
    %>
    <!-- 여기가 에러페이지라는 뜻 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>일시오류 발생 - 전산관리자에게 문의하세요!</h2>
	<p>
		오류명 :<%= exception.getClass().getName() %><br />
		오류 메시지 : <%= exception.getMessage() %>
	</p>

</body>
</html>