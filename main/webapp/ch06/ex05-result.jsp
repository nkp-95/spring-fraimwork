<%@ page import= "java.util.Enumeration" %>
<%@ page import= "java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 수신</title>
</head>
<body>
<%
	//getParameter(), getParameterValues()
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String[] pets = request.getParameterValues("pet");
	System.out.println("name: " + name);
	System.out.println("address: " + address);
	for(String pet : pets){
		System.out.println("pet: " + pet);
	}

/*
	Enumeration<String> enumData = request.getParameterNames();
	while(enumData.hasMoreElements()){
		String name = (String)enumData.nextElement();
		System.out.println("name: " + name);
	}
	// getParameterMap()
	Map paramMap = request.getParameterMap();
	String[] paramName = (String[])paramMap.get("pet");
	for(String param : paramName){
		System.out.println("param: "+ param); 
	}
*/	
	
%>
전송이 완료되었습니다.
</body>
</html>