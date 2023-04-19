<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<table border = "1" align ="center">
			<tr>
				<td colspan ="3">${ ip }</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${ vo.name }</td>
				<td>${ vo.age }</td>
				<td>${ vo.tel }</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>