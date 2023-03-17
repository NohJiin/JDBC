<%@page import="multi.MovieDAO"%>
<%@page import="multi.ProductDAO"%>
<%@page import="multi.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 1. 가방 만들기 -->
	<!-- 패키지.클래스네임 -->
	<jsp:useBean id="bag" class="multi.MovieVO"></jsp:useBean>
	<!-- 2 .가방에 값 넣기 -->
	<jsp:setProperty property="*" name="bag"/>
<%
	// 3. 가방의 값 전달하기
	MovieDAO dao = new MovieDAO();
	dao.insert(bag);
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
	영화가 등록되었습니다.
	<hr color="red">
	<a href="insert4.html">
		<button>영화 등록 페이지로</button>
	</a> <br>
	영화 ID :
	<%=bag.getId()%> <br>
	영화 Title :
	<%=bag.getTitle()%> <br>
	영화 Content :
	<%=bag.getContent()%> <br>
	영화 location :
	<%=bag.getLocation()%> <br>
	영화 Director :
	<%=bag.getDirector()%> <br>
	
</body>
</html>