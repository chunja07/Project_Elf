<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지입니다!!!!</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/login/${param.id}" method = "post">
	<table>
		<caption>로그인 화면 입니다.</caption>
		<tr>
			<td>ID : </td>
			<td><input type = "text" name = "id" placeholder = "아이디를 입력하세요" value = "${param.id}"></td>		
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type = "password" name = "password" placeholder = "패스워드를 입력하세요"></td>		
		</tr>
		<tr>
			<td><input type = "submit" value= "submit"></td>
		</tr>
	</table>
	</form>
	
	
</body>
</html>