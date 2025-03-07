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
			<form action="./login" method="post" id="login_form">
			<legend>로그인</legend>
				<div class="input-group mb-3">
					<span class="input-group-text">UserName</span>
					<div class="form-control">
						<input type="text" class="form-control" id="userName"
							placeholder="" name="userName"> <label for="userName"></label>
					</div>
					<span class="input-group-text">Password</span>
					<div class="form-control">
						<input type="password" class="form-control" id="passWord"
							placeholder="" name="passWord"> <label for="passWord"></label>
					</div>
					<button class="btn btn-outline-success" id="login_btn" type="button">로그인</button>
				</div>
			</form>
		</div>
	</div>

	
	<script src="/resources/js/login.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>