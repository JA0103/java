<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/movie.css">
</head>
<body>
<div id="box" align="center">
	<h1>리스트</h1>
	<br><a href="insertMovie.do" style="float: right;">정보등록</a>
	<table border="1" style="text-align: center;">
		<tr>
			<th>제목</th>
			<th>감독</th>
			<th>배우</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	<c:forEach var="movie" items="${movieList}">
		<tr>
			<td>${movie.title}</td> 
			<td>${movie.director}</td> 
			<td>${movie.actor}</td> 
			<td>${movie.price}원</td> 
			<td><a href="updateMovie.do?code=${movie.code}">정보 수정</a></td> 
			<td><a href="deleteMovie.do?code=${movie.code}">정보 삭제</a></td> 
		</tr>
	</c:forEach>
	</table>
</div>
</body>
</html>