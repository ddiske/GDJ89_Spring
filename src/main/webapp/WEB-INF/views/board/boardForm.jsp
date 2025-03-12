<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/summernote.jsp"></c:import>
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
						<input type="text" class="form-control" id="title"
							placeholder="${dto.boardTitle}"
							value="${dto.boardTitle}" name="boardTitle"> <label
							for="title"></label>
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="form-control">
						<textarea id="detail" name="boardContents" value="${dto.boardContents}"></textarea>
					</div>
				</div>

				<div class="mb-3">
					<c:forEach items="${dto.boardFileDTOs }" var="f">
						<div class="alert alert-secondary" role="alert">
							${f.oldName }<button type="button" class="btn badge text-bg-secondary file_delete" data-file-num="${f.fileNum}" data-kind="${kind}">X</button>
						</div>
					</c:forEach>
				</div>

				<div id="files" data-files-size="${dto.boardFileDTOs.size()}" class="mb-3">
					<button type="button" id="add_file">파일추가</button>
				</div>
					
					
					
					<button class="btn btn-outline-success">완료</button>
			</form>
		</div>
	</div>

	<!-- <script src="/resources/js/files/fileDelete.js"></script> -->
	<script src="/resources/js/files/summernote.js"></script>
	<script src="/resources/js/files/fileManager.js" type="module"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>