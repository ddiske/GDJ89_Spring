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
			<form action="./add" method="post" id="add_form">
			<legend>신규 상품 등록하기</legend>
				<div class="input-group mb-3">
					<span class="input-group-text">상품명</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1 pdtName" value=""
							placeholder="" name="productName"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">이자율</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1 pdtRate"
							placeholder="" name="productRate"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">기한</span>
					<div class="form-control">
						<input type="date" class="form-control" id="floatingInputGroup1 pdtDate"
							placeholder="" name="productDate"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">상세 정보</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1 pdtDetail"
							placeholder="" name="productDetail"> <label for="floatingInputGroup1"></label>
					</div>
					<button class="btn btn-outline-success" type="button" id="add_btn">등록하기</button>
				</div>
			</form>
		</div>
	</div>

	<script src="/resources/js/add.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>