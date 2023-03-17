<%@page import="multi.ProductDAO"%>
<%@page import="multi.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 가방 만들기 -->
	<jsp:useBean id="bag" class="multi.ProductVO"></jsp:useBean>
	<!-- 가방에 값 넣기 -->
	<jsp:setProperty property="*" name="bag"/>
<%
	// 0. 클라이언트가 입력한 정보를 받자
	/* String id = request.getParameter("id");
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	String price = request.getParameter("price");
	String company = request.getParameter("company");
	String img = request.getParameter("img"); */
	
	// 1. 받은 데이커를 dao에게 주기 위해서 가방을 만들어서 넣자
	/* ProductVO bag = new ProductVO();
	bag.setId(id);
	bag.setName(name);
	bag.setContent(content);
	bag.setPrice(Integer.parseInt(price));
	bag.setCompany(company);
	bag.setImg(img); */
	
	// 2. dao에게 가방을 전다랗면서 insert 요청하자
	ProductDAO dao = new ProductDAO();
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
	상품 등록 요청되었음
	<hr color="red">
	<!-- <a href="bbs.html">
		<button>상품등록 페이지로</button>
	</a> <br> -->
	상품 ID :
	<%=bag.getId()%> <br>
	상품 NAME :
	<%=bag.getName()%> <br>
	상품 CONTENT :
	<%=bag.getContent()%> <br>
	상품 PRICE :
	<%=bag.getPrice()%> <br>
	상품 COMPANY :
	<%=bag.getCompany()%> <br>
	<!-- 상품 IMG <br> -->
	<img src="img/<%= bag.getImg() %>"   width=200  height=200>
</body>
</html>