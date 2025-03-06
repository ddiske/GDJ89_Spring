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
	
		<form id="list_form" class="row row-cols-lg-auto g-3 align-items-center my-5 offset-md-2" action="./carts">
			<input type="hidden" name="page" id="pageNum">
		</form>

	<div class="container-fluid my-5">
		<div class="row col-md-8 offset-md-2">

			<table class="table table-striped">
				<thead class="table-dark">
					<tr>
						<th>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="flexCheckDefault" id="checkAll">
								<label class="form-check-label" for="flexCheckDefault1">
									전체 선택
								</label>
							</div>
						</th>
						<th scope="col">상품번호</th>
						<th scope="col">상품명</th>
						<th scope="col">이자율</th>
						<th scope="col">기간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="v">
						<tr>
							<td>
								<div class="form-check">
									<input class="form-check-input checks" type="checkbox" value=${v.productNum} name="flexCheckDefault" id="check1">
								</div>
							</td>
							<td>${v.productNum }</td>
							<td><a href="../products/detail?productNum=${v.productNum }">${v.productName }</td>
							<td>${v.productRate }</td>
							<td>${v.productDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <button class="page-link pages" data-page-num = "${pager.startBlock-1 }" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
				  </button>
			    </li>
			    <c:forEach begin="${pager.startBlock }" end="${pager.endBlock }" var="i">
			    	<li class="page-item"><button class="page-link pages" data-page-num = "${i } ">${i }</button></li>
			    </c:forEach>
			    <li class="page-item ${pager.endCheck?'disabled':'' }">
			      <button class="page-link pages" data-page-num = "${pager.endBlock+1 }" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
				  </button>
			    </li>
			  </ul>
			</nav>

			<button id="cart_add" class="btn btn-outline-success">가입</button>
			<button id="cart_delete" class="btn btn-outline-danger">삭제</button>

		</div>
	</div>

	<script src="/resources/js/list.js"></script>
	<script src="/resources/js/users/cart.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>