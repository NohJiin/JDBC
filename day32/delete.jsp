<%@page import="multi.MemberVO"%>
<%@page import="multi.MemberDAO3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
	
	// 전달하는 값이 하나밖에 없기 때문에 VO가 필요 없음
	MemberDAO3 dao = new MemberDAO3();
	dao.delete(id);
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
	<h3>회원탈퇴 요청되었습니다.</h3>
	<hr color="red">
	<a href="member.html">
		<button>회원정보 페이지로</button>
	</a> <br>
	입력한 id :
	<%=id%> <br>
</body>
</html>