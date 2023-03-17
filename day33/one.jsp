<%@page import="multi.MemberVO"%>
<%@page import="multi.MemberDAO3"%>
<%@page import="multi.BbsDAO"%>
<%@page import="multi.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		// 클라이언트가 입력한 No를 서버에서 받아주기(자바로!)
		String id = request.getParameter("id");
	
		MemberDAO3 dao = new MemberDAO3();
		MemberVO bag = dao.one(id);
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
	<!-- <h3>게시판 검색 요청되었습니다.</h3> -->
	<h3>검색을 원하는 아이디는 <%=id%></h3>
	<hr color="red">
	이름 : <%= bag.getName() %> <br>
	비밀번호 : <%= bag.getPw() %> <br>
	전화번호 : <%= bag.getTel() %> <br>
	<br>
	<a href="one.html">
		<button>아이디 검색 페이지로</button>
	</a>
</body>
</html>