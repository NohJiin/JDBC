<%@page import="multi.MovieVO"%>
<%@page import="multi.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		// 클라이언트가 입력한 No를 서버에서 받아주기(자바로!)
		String id = request.getParameter("id");
	
		MovieDAO dao = new MovieDAO();
		MovieVO bag2 = dao.one(id);
	%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body { /* 자동주석 : ctrl + /, 태그선택 */
	background: #fcffed;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body { /* 자동주석 : ctrl + /, 태그선택 */
	background: #fcffed;
}

button {
	background: pink;
}
a{
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<!-- <h3>게시판 검색 요청되었습니다.</h3> -->
	<h3>검색을 원하는 아이디는 <%=id%></h3>
	<hr color="red">
	<table class="table table-danger table-striped">
		<tr>
			<td>영화 아이디</td>
			<td><%= bag2.getId() %></td>
		</tr>
		<tr>
			<td>영화 제목</td>
			<td><%= bag2.getTitle() %></td>
		</tr>
		<tr>
			<td>영화 내용</td>
			<td><%= bag2.getContent() %></td>
		</tr>
		<tr>
			<td>상영 위치</td>
			<td><%= bag2.getLocation() %></td>
		</tr>
		<tr>
			<td>영화 감독</td>
			<td><%= bag2.getDirector() %></td>
		</tr>
	</table>
	<a href="one4.html"> <!-- one4.html만들어야하나? -->
		<button>영화 검색 페이지로</button>
	</a>
</body>
</html>