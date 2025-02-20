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
			<form action="./join" method="post">
			<legend>회원가입</legend>
				<div class="input-group mb-3">
					<span class="input-group-text">UserName</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder="" name="userName"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">Password</span>
					<div class="form-control">
						<input type="password" class="form-control" id="floatingInputGroup1"
							placeholder="" name="passWord"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">Name</span>
					<div class="form-control">
						<input type="text" class="form-control" id="floatingInputGroup1"
							placeholder="" name="name"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">Phone</span>
					<div class="form-control">
						<input type="tel" class="form-control" id="floatingInputGroup1"
							placeholder="" name="phone"> <label for="floatingInputGroup1"></label>
					</div>
					<span class="input-group-text">Email</span>
					<div class="form-control">
						<input type="email" class="form-control" id="floatingInputGroup1"
							placeholder="" name="email"> <label for="floatingInputGroup1"></label>
					</div>
					<button class="btn btn-outline-success">회원가입</button>
				</div>
			</form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>