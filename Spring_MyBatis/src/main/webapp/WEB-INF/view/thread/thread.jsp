<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 게시판</title>
</head>
<body>
	<table border = "1">
		<caption>게시글 리스트</caption>
		<tr>
			<th>글번호</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>제목</th>
			<th>등록시간</th>
		</tr>	
		
		<c:forEach items="${post}" var= "m">
		<tr>
			<th>${m.no}</th>
			<th>${m.id}</th>
			<th>${m.name}</th>
			<th><a href = "${pageContext.request.contextPath}/rv_board">${m.title}</a></th>
			<th>${m.registerdate}</th>		
		</tr>
	</c:forEach>
	</table>
	<table>
		<tr>
		<td>
		<c:if test = "${ page !=1 }">
		<a href= "${pageContext.request.contextPath}/thread/?page=${1}">First Page</a>
		</c:if>
		</td>
		
		<td>
		<c:if test = "${startPage !=1 }">
			<a href= "${pageContext.request.contextPath}/thread/?page=${startPage-1}">이전</a>
		</c:if>
		
		</td>
		<td>
		
		<c:forEach var = "i" begin="${startPage}" end="${endPage}">
			<c:if test="${ page == i }" var = "result">
				<b>${i}</b>
			</c:if>
			<c:if test="${not result}">
				<a href="${pageContext.request.contextPath}/thread/?page=${i}">	${i}</a>
			</c:if>
			
		</c:forEach>
		</td>
		<td>
		<c:if test = "${endPage != totalPage }">
			<a href= "${pageContext.request.contextPath}/thread/?page=${endPage+1}">next</a>
		</c:if>		
		</td>
		<td>
		<c:if test = "${endPage != page }">
			<a href= "${pageContext.request.contextPath}/thread/?page=${totalPage}">end Page</a>
		</c:if>	
		</td>
		
		</tr>	
	</table>
	
</body>
</html>