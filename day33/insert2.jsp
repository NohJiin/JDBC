<%@page import="multi.BbsVO"%>
<%@page import="multi.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 1. 전달된 값 받기 (request사용) -->
<!-- 2. sql만들어서 dao에게 갑 전달(DAO이용) 생략 -->
<!-- 3. 전달된 값을 출력하는 결과를 브라우저에 HTML로 보내기 -->
<%
/// 0. 클라이언트가 입력한 정보를 받자
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	
	// 1. 받은 데이커를 dao에게 주기 위해서 가방을 만들어서 넣자
	BbsVO bag = new BbsVO();
	bag.setTitle(title);
	bag.setContent(content);
	bag.setWriter(writer);
	
	// 2. dao에게 가방을 전다랗면서 insert 요청하자
	BbsDAO dao = new BbsDAO();
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
	게시판 등록 요청되었음
	<hr color="red">
	게시판 제목 :
	<%=title%> <br>
	작성자 이름 :
	<%=writer%> <br>
	게시판 내용 :
	<%=content%> <br>
</body>
</html>