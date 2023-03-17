<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BbsDAO dao = new BbsDAO();
// 5, 6번 : dao가 리턴한 BbsVO가 들어간 ArrayList를 받는다
ArrayList<BbsVO> list = dao.list();
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body { /* 자동주석 : ctrl + /, 태그선택 */
	background: #fcffed;
}
a{
	text-decoration: none;
	color: black;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
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
	<table class="table table-striped">
		<tr>
			<td>no</td>
			<td>title</td>
			<td>content</td>
			<td>writer</td>
		</tr>
		<!-- 7번 -->
		<%
			for (BbsVO bag2 : list) {
		%>
		<!-- 8번 -->
		<tr>
			<td><%=bag2.getNo()%></td>
			<td>	<!-- a태그로 링크 걸어줌 => 결과값을 보여주는 html로 이동하도록 + bag2에 저장된 NO이용 -->
				<a href="http://localhost:8888/web02/one2.jsp?no=<%=bag2.getNo()%>">
					<%=bag2.getTitle()%>
				</a>
			</td>
			<td><%=bag2.getContent()%></td>
			<td><%=bag2.getWriter()%></td>
		</tr>

		<%
			}
		%>
	</table>
	<a href="bbs.html">
		<button>게시판 페이지로</button>
	</a>
</body>
</html>