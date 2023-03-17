<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		// 클라이언트가 입력한 No를 서버에서 받아주기(자바로!)
		String no = request.getParameter("no");
		// JSP안에 만들어진 변수는 서버의 RAM에 저장되는 지역변수!
	
		BbsDAO dao = new BbsDAO();
		BbsVO bag2 = dao.one(Integer.parseInt(no));
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
</style>
</head>
<body>
	<!-- <h3>게시판 검색 요청되었습니다.</h3> -->
	<h3>검색을 원하는 번호는 <%=no%></h3>
	<hr color="red">
	<table class="table table-dark table-striped">
		<tr>
			<td>검색한 제목</td>
			<td><%= bag2.getTitle() %></td>
		</tr>
		<tr>
			<td>검색한 내용</td>
			<td><%= bag2.getContent() %></td>
		</tr>
		<tr>
			<td>검색한 글쓴이</td>
			<td><%= bag2.getWriter() %></td>
		</tr>
	</table>
	<a href="bbs.html">
		<button>게시판 페이지로</button>
	</a>
</body>
</html>