<%@page import="multi.PlayListDAO"%>
<%@page import="multi.PlayListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="bag" class="multi.PlayListVO"></jsp:useBean>
	<jsp:setProperty property="*" name="bag"/>
<%
	PlayListDAO dao = new PlayListDAO();
	dao.update(bag);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h3>음원 수정 요청되었습니다.</h3>
	<hr color="red">
	<a href="update5.html">
		<button>음원 수정 페이지로</button>
	</a> <br>
	수정할 음원 Title :
	<%=bag.getTitle()%> <br>
	수정된 Genre :
	<%=bag.getGenre()%>
	<br>
</body>
</html>