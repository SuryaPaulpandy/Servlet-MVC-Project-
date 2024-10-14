<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
Integer id = (Integer)session.getAttribute("sid");
String name = (String)session.getAttribute("sname");
Integer Marks1 = (Integer)session.getAttribute("sMarks1");
Integer Marks2 = (Integer)session.getAttribute("sMarks2");
Integer Marks3 = (Integer)session.getAttribute("sMarks3");

out.println(id+" "+name+" "+Marks1+" "+Marks2+" "+Marks3);
%>
</body>
</html>