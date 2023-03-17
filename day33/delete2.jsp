<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		// 클라이언트가 입력한 No를 서버에서 받아주기(자바로!)
		String no = request.getParameter("no");
	// JSP안에 만들어진 변수는 서버의 RAM에 저장되는 지역변수!
	
	BbsDAO dao = new BbsDAO();
	dao.delete(Integer.parseInt(no));
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
	<h3>게시판 삭제 요청되었습니다.</h3>
	<hr color="red">
	<a href="bbs.html">
		<button>게시판 페이지로</button>
	</a>
	<br> 당신이 삭제를 원하는 번호는 
	<%=no%>
	<br>
</body>
</html>