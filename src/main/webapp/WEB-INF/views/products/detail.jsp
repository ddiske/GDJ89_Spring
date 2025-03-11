<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
<style>
	#contents{
		width: 100%;
		height: 100px;
	}
</style>
</head>
<body>
	<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

	<div class="container-fluid my-5">
		<div class="row col-md-8 offset-md-2">
			<h1>Product Detail Page</h1>
			<h6>${productDTO.productNum }</h6>
			<h6>${productDTO.productName }</h6>
			<h6>${productDTO.productRate }</h6>
			<h6>${productDTO.productDate }</h6>
			<h6>${productDTO.productDetail }</h6>

			<div>
				<form action="/test" id="frm">
					<input type="hidden" name="productNum" id="input" value="${productDTO.productNum}">
					<button type="button" id="updatebtn">수정</button>
					<button type="button" id="deletebtn">삭제</button>
				</form>
				<button type="button" id="addCart">장바구니에 담기</button>
			</div>

			<div>
				<form action="" id="frm2">
					<h6>댓글</h6>
					<input type="text" id="contents" name="boardContents">
					<button type="button" id="reply">등록</button>
				</form>
			</div>

			<%-- <a href="./update?productNum=${productDTO.productNum }">수정하기</a>
			<a href="./delete?productNum=${productDTO.productNum }">삭제하기</a> --%>
		</div>
	</div>

	<script src="/resources/js/detail.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>