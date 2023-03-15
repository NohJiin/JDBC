<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String content = request.getParameter("content");
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
	<h3>회원 수정 요청되었습니다.</h3>
	<hr color="red">
	<a href="member.html">
		<button>회원정보 페이지로</button>
	</a> <br>
	수정할 게시물 번호 :
	<%=no%> <br>
	수정할 content :
	<%=content%>
	<br>
</body>
</html>