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

			<table class="table">
				<thead class="table-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">First</th>
						<th scope="col">Middle</th>
						<th scope="col">Last</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">1</td>
						<td>a</td>
						<td>b</td>
						<td>c</td>
					</tr>
					<tr>
						<td scope="row">2</td>
						<td>d</td>
						<td>e</td>
						<td>f</td>
					</tr>
					<tr>
						<td scope="row">3</td>
						<td>g</td>
						<td>h</td>
						<td>i</td>
					</tr>
					<tr>
						<td scope="row">4</td>
						<td>j</td>
						<td>k</td>
						<td>l</td>
					</tr>
					<tr>
						<td scope="row">5</td>
						<td>m</td>
						<td>n</td>
						<td>o</td>
					</tr>
				</tbody>
			</table>
			
			<a href="./add" class="btn btn-primary">상품 등록</a>

		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>