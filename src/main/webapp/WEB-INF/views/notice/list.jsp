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
<style>
	a {
		text-decoration: none;
		color: black;
	}
</style>
<body>
	<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

	<div class="container-fluid my-5">
		<div class="row col-md-8 offset-md-2">

			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="v">
						<tr>
							<td>${v.boardNum }</td>
							<td><a href="./detail?boardNum=${v.boardNum }">${v.boardTitle }</td>
							<td>${v.userName }</td>
							<td>${v.boardDate }</td>
							<td>${v.boardHit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href="./add" class="btn btn-primary">새 글 작성</a>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
			    <c:forEach begin="1" end="">
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    </c:forEach>
			    <li class="page-item"><a class="page-link" href="#">Next</a></li>
			  </ul>
			</nav>

		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>