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
			<form action=""	method="post" enctype="multipart/form-data">
				<legend>${kind } 글 작성</legend>
				<div class="input-group mb-3">
				<input type="hidden" name="boardNum" value="${dto.boardNum }">
					<span class="input-group-text">제목</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder="${dto.boardTitle}"
							value="${dto.boardTitle}" name="boardTitle"> <label
							for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">내용</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder=""
							value="${dto.boardContents}" name="boardContents"> <label
							for="floatingInputGroup1"></label>
					</div>
				</div>

				<div id="files" data-files-size="${dto.boardFileDTOs.size()}">
					<button type="button" id="add_file">파일추가</button>
				</div>
					
					
					
					<button class="btn btn-outline-success">완료</button>
			</form>
		</div>
	</div>

	<script src="/resources/js/files/fileManager.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>