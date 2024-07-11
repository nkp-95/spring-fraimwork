<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 라이프 사이클</title>
</head>
<body>
	<%! //느낌표 선언부
	private int num1 = 0;  //멤버 변수(인스턴스 변수)
	public void jspInit(){  //오버라이딩 된 메서드(멤버함수)
		System.out.println("jspInit() 호출됨");
	}
	public void jspDestroy(){	
		System.out.println("jspDestroy() 호출됨");
	}
	
	%>
	<%
	//스크립틀릿  지역변수
	int num2 = 0; //메서드 안에 변수 = 지역 변수  //새로 고침 해도 증가 x
	num1++; //인스턴스 변수  //힙메모리에 있어서 페이지 새로 고침 할때마다 계속 증가
	num2++;
	System.out.println("num1 " + num1);
	System.out.println("num2 " + num2);
	System.out.println("수정");
	%>
	<ul>
		<li>num1: <%= num1 %></li>	<%-- jsp요소 : <%= 표현식 --%>
		<li>num2: <%= num2 %></li>
	</ul>
</body>
</html>