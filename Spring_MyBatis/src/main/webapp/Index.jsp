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
	<c:if test="${islogin != null }" var = "main">
	<h3>${islogin.id}님의 로그인을 축하드립니다.</h3>	
	<h3><a href= "${pageContext.request.contextPath}/insert">회원가입</a></h3>
	<h3><a href= "${pageContext.request.contextPath}/login">로그인</a></h3>
	<h3><a href= "${pageContext.request.contextPath}/thread">게시판</a></h3>
	<h3><a href= "${pageContext.request.contextPath}/location">로케이션</a></h3>

	<br>
	<h3><a href = "${pageContext.request.contextPath}/logout">로그아웃</a></h3>	

	</c:if>
	
	<c:if test="${not main}">
	<h3><a href= "${pageContext.request.contextPath}/insert">회원가입</a></h3>
	<h3><a href= "${pageContext.request.contextPath}/login">로그인</a></h3>
	<h3><a href= "${pageContext.request.contextPath}/thread">게시판</a></h3>
	<h3><a href= "${pageContext.request.contextPath}/location">로케이션</a></h3>
	<br>
	<h3><a href = "${pageContext.request.contextPath}/logout">로그아웃</a></h3>	
	</c:if>
</body>
</html>