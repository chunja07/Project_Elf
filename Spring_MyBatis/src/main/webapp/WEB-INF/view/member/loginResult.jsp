<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<c:if test="${result==0}" var="result">
		아이디나 비밀번호가 잘못되었습니다. 로그인을 다시 시도하십시오.
		
		<a href = "${pageContext.request.contextPath}/">메인 페이지로 돌아가기</a>
		
	</c:if>
	
	<c:if test="${not result}">
					
		<h3>${islogin.name}님의 로그인을 축하드립니다.</h3>
		
		<a href = "${pageContext.request.contextPath}/">메인 페이지로 돌아가기</a>
		
	</c:if>
	
	
	
	
</body>
</html>