<%@page import="multi.PlayListDAO"%>
<%@page import="multi.PlayListVO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 	<jsp:useBean id="bag" class="multi.PlayListVO"></jsp:useBean>
	<jsp:setProperty property="*" name="bag"/> --%>

<%
	PlayListDAO dao = new PlayListDAO();
	// 입력받은 단어 가져오기
	String word = request.getParameter("word");

	// 5, 6번 : dao가 리턴한 BbsVO가 들어간 ArrayList를 받는다
	ArrayList<PlayListVO> list = dao.listLike(word);
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
' <%= word %> '가 포함된 영화 수 : <%= list.size() %>
	<table class="table table-danger table-striped">
		<tr>
			<td>ID</td>
			<td>Album</td>
			<td>Title</td>
			<td>Artist</td>
			<td>Genre</td>
		</tr>
		<!-- 7번 -->
		<%	if(list.size() == 0) { %>
			<tr>
				<td colspan="5" align="center">찾으시는 음원이 없습니다.<br><img src="img/nothing.png" width=250 height="250"></td>
			</tr>
		<% } else {
				for (PlayListVO bag : list) {
		%>
		<!-- 8번 -->
		<tr>
			<td><%= bag.getId() %></td>
			<td><img src="img/<%= bag.getImg() %>" width="200", height="200"></img></td>
			<td>	<!-- a태그로 링크 걸어줌 => 결과값을 보여주는 html로 이동하도록 + bag에 저장된 NO이용 -->
				<a href="one5.jsp?id=<%= bag.getId() %>">
					<%= bag.getTitle() %>
				</a>
			</td>
			<td><%= bag.getArtist() %></td>
			<td><%= bag.getGenre() %></td>
		</tr>

		<%
				}
			}
		%>
	</table>
	<a href="one55.html">
		<button>음원 상세 검색 페이지로</button>
	</a>
</body>
</html>