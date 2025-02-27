<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

	<div class="container-fluid my-5">
		<div class="row col-md-8 offset-md-2">
			<h1>${kind } Detail Page</h1>
			<h6>${dto.boardNum }</h6>
			<h6>${dto.boardTitle }</h6>
			<h6>${dto.boardContents }</h6>
			<h6>${dto.userName }</h6>
			<h6>${dto.boardDate }</h6>
			<h6>${dto.boardHit }</h6>
			<c:if test="${(user.userName eq dto.userName) or (user.userName eq 'admin') }">
				<form id="frm" action="">
					<input type="hidden" name="boardNum" value="${dto.boardNum}">
					<button type="button" id="updatebtn">수정하기</a>
					<button type="button" id="deletebtn">삭제하기</a>
				</form>
			</c:if>
		</div>
	</div>

	<script src="/resources/js/detail.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>