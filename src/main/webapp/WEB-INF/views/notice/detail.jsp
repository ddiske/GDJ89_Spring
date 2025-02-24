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
			<h1>Notice Detail Page</h1>
			<h6>${noticeDTO.boardNum }</h6>
			<h6>${noticeDTO.boardTitle }</h6>
			<h6>${noticeDTO.boardContents }</h6>
			<h6>${noticeDTO.userName }</h6>
			<h6>${noticeDTO.boardDate }</h6>
			<h6>${noticeDTO.boardHit }</h6>
			<c:if test="${user.userName eq (noticeDTO.userName or admin) }">
				<a href="./update?boardNum=${noticeDTO.boardNum }">수정하기</a>
				<a href="./delete?boardNum=${noticeDTO.boardNum }">삭제하기</a>
			</c:if>
		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>