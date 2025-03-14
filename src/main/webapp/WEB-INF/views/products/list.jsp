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
	
		<form id="list_form" class="row row-cols-lg-auto g-3 align-items-center my-5 offset-md-2" action="./list">
			<input type="hidden" name="page" id="pageNum">
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
		    <select class="form-select" id="inlineFormSelectPref" name="kind">
		      <option value="k1" ${pager.kind eq 'k1' ? 'selected': '' }>제목</option>
		      <option value="k2" ${pager.kind eq 'k2' ? 'selected': '' }>내용</option>
		      <option value="k3" ${pager.kind eq 'k3' ? 'selected': '' }>제목+내용</option>
		    </select>
		  </div>
		  <div class="col-12">
		    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
		      <input type="text" value="${pager.search}" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
		  </div>
		
		  <div class="col-12">
		    <button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		</form>

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
			
			<c:if test="${user.userName eq 'admin' }">
				<a href="./add" class="btn btn-primary">상품 등록</a>
			</c:if>

		</div>
	</div>

	<script src="/resources/js/list.js"></script>
	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>