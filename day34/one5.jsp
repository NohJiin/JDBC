<%@page import="multi.PlayListVO"%>
<%@page import="multi.PlayListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		// 클라이언트가 입력한 No를 서버에서 받아주기(자바로!)
		String title = request.getParameter("title");
	
		PlayListDAO dao = new PlayListDAO();
		PlayListVO bag = dao.one(title);
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
	<h3>검색을 원하는 Title은 <%=title%></h3>
	<hr color="red">
	<table class="table table-danger table-striped">
		<tr>
			<td>음원 아이디</td>
			<td><%= bag.getId() %></td>
		</tr>
		<tr>
			<td>음원 제목</td>
			<td><%= bag.getTitle() %></td>
		</tr>
		<tr>
			<td>아티스트</td>
			<td><%= bag.getArtist() %></td>
		</tr>
		<tr>
			<td>장르</td>
			<td><%= bag.getGenre() %></td>
		</tr>
		<tr>
			<td>앨범이미지</td>
			<td><img src="img/<%= bag.getImg() %>" width="200", height="200"></img></td>
		</tr>
	</table>
	<a href="one5.html"> <!-- one4.html만들어야하나? -->
		<button>음원 검색 페이지로</button>
	</a>
</body>
</html>