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
						<th scope="col">상품번호</th>
						<th scope="col">상품명</th>
						<th scope="col">이자율</th>
						<th scope="col">상세 정보</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="v">
						<tr>
							<td>${v.productNum }</td>
							<td><a href="./detail?productNum=${v.productNum }">${v.productName }</td>
							<td>${v.productRate }</td>
							<td>${v.productDetail }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.startBlock-1 }" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach begin="${pager.startBlock }" end="${pager.endBlock }" var="i">
			    	<li class="page-item"><a class="page-link" href="./list?page=${i }">${i }</a></li>
			    </c:forEach>
			    <li class="page-item ${pager.endCheck?'disabled':'' }">
			      <a class="page-link" href="./list?page=${pager.endBlock+1 }" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			<a href="./add" class="btn btn-primary">상품 등록</a>

		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>