<%@page import="multi.PlayListDAO"%>
<%@page import="multi.PlayListVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 1. 가방 만들기 -->
	<!-- 패키지.클래스네임 -->
	<jsp:useBean id="bag" class="multi.PlayListVO"></jsp:useBean>
	<!-- 2 .가방에 값 넣기 -->
	<jsp:setProperty property="*" name="bag"/>
<%
	// 3. 가방의 값 전달하기
	PlayListDAO dao = new PlayListDAO();
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
	음원이 추가되었습니다.
	<hr color="red">
	<a href="insert5.html">
		<button>영화 등록 페이지로</button>
	</a> <br>
	ID :
	<%=bag.getId()%> <br>
	Title :
	<%=bag.getTitle()%> <br>
	Artist :
	<%=bag.getArtist()%> <br>
	Genre :
	<%=bag.getGenre()%> <br>
	Album : <br>
	<img src="img/<%=bag.getImg()%>" width="200", height="200"></img> <br>
	
</body>
</html>