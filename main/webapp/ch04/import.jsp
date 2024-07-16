<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어 - import 속성</title>
</head>
<body>
	<%
	//page 지시어 - <%@ - 문서의 타입, 에러페이지 같은 정보 설정합니다.
	//include 지시어 - JSP에서 또 다른 JSP나 HTML페이지를 포함 시킬때 사용합니다.
	//taglib 지시어 - El(표현언어)에서 자바 클래스의 메서드를 호출하거나,
	//				JSTL(JSP 표준 태그 라이브러리)을 사용하기 위해 선언합니다.
	
	
	
	
	Date today = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String todayStr = dateFormat.format(today);
	out.println("오늘 날짜 : " + todayStr);
	%>
</body>
</html>