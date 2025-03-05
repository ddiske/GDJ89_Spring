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
			<form action="./join" method="post" enctype="multipart/form-data">
			<legend>회원가입</legend>
				<div class="input-group mb-3">
					<span class="input-group-text">UserName</span>
					<div class="form-control">
						<input type="text" class="form-control" id="un"
							placeholder="" name="userName"> <label for="un"></label>
							<div id="userNameResult"></div>
					</div>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">Password</span>
					<div class="form-control">
						<input type="password" class="form-control" id="floatingInputGroup1"
							placeholder="" name="passWord"> <label for="floatingInputGroup1"></label>
					</div>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">Name</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder="" name="name"> <label for="floatingInputGroup1"></label>
					</div>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">Phone</span>
					<div class="form-control">
						<input type="tel" class="form-control" id="floatingInputGroup1"
							placeholder="" name="phone"> <label for="floatingInputGroup1"></label>
					</div>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">Email</span>
					<div class="form-control">
						<input type="email" class="form-control" id="floatingInputGroup1"
							placeholder="" name="email"> <label for="floatingInputGroup1"></label>
					</div>
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text">Profile</span>
					<div class="form-control">
						<input type="file" class="form-control" id="profile"
							placeholder="" name="profile"> <label for="profile"></label>
					</div>
				</div>
				<button class="btn btn-outline-success">회원가입</button>
			</form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
	<script src="/resources/js/users/join.js"></script>
</body>
</html>