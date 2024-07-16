<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
	//선언부 (메서드 선언)
	public int add(int num1, int num2){
		return num1 + num2;
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
	<%  //스크립틀릿
	//선언부 : <%! - 멤버변수나 메서드 선언하는 영역입니다.
	//스크립틀릿: <% - JSP에서 선언부 선언된 메서드 호출하거나 
	//				자바코드를 작성하는 영역 입니다.
	//표현식 : 주로 변수의 값을 간단하게 출력할때 사용 합니다.
	
	
	int result = add(10, 20);
	
	%>
	덧셈 결과 1 : <%= result %><br />
	덧셈 결과 2 : <%= add(30, 40) %>
</body>
</html>