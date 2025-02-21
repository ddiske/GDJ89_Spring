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
			<!-- contents 내용 작성 -->
			<form action="./update?boardNum=${noticeDTO.boardNum }"
				method="post">
				<legend>작성 글 수정</legend>
				<div class="input-group mb-3">
					<span class="input-group-text">제목</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder="${noticeDTO.boardTitle}"
							value="${noticeDTO.boardTitle}" name="boardTitle"> <label
							for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">내용</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder=""
							value="${noticeDTO.boardContents}" name="boardContents"> <label
							for="floatingInputGroup1"></label>
					</div>
					<button class="btn btn-outline-success">수정하기</button>
				</div>
			</form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>