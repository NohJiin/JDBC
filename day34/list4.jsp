<%@page import="multi.MovieDAO"%>
<%@page import="multi.MovieVO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MovieDAO dao = new MovieDAO();

	// 5, 6번 : dao가 리턴한 BbsVO가 들어간 ArrayList를 받는다
	ArrayList<MovieVO> list = dao.list();
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
}
</style>
</head>
<body>
전체 영화 수 : <%= list.size() %>
	<table class="table table-danger table-striped">
		<tr>
			<td>id</td>
			<td>title</td>
			<td>content</td>
			<td>location</td>
			<td>director</td>
		</tr>
		<!-- 7번 -->
		<%	if(list.size() == 0) { %>
			<tr>
				<td colspan="5">등록된 영화가 없습니다.</td>
			</tr>
			<tr>
				<td colspan="5"><img src="img/nothing.png" width=250 height="250"></td>
			</tr>
		<% } else {
				for (MovieVO bag2 : list) {
		%>
		<!-- 8번 -->
		<tr>
			<td><%= bag2.getId() %></td>
			<td>	<!-- a태그로 링크 걸어줌 => 결과값을 보여주는 html로 이동하도록 + bag2에 저장된 NO이용 -->
				<a href="one4.jsp?id=<%= bag2.getId() %>">
					<%= bag2.getTitle() %>
				</a>
			</td>
			<td><%= bag2.getContent() %></td>
			<td><%= bag2.getLocation() %></td>
			<td><%= bag2.getDirector() %></td>
		</tr>

		<%
				}
			}
		%>
	</table>
	<a href="one4.html">
		<button>영화 상세 검색 페이지로</button>
	</a>
</body>
</html>