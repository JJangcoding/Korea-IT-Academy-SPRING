<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<table border="1" align="center">
		<caption>부서목록</caption>
		
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
			
		</tr>
	<c:forEach var = "vo" items="${list }">
	<tr>
		<th>${vo.deptno }</th>
		<th>${vo.dname }</th>
		<th>${vo.loc }</th>
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>