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
	
	<form class="row row-cols-lg-auto g-3 align-items-center my-5 offset-md-2" action="./list">
		<input type="hidden" name="page" id="pageNum">
		<h1>${kind }</h1>
	  <div class="col-12">
	    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
	    <select class="form-select" id="inlineFormSelectPref" name="kind">
	      <option value="k1">제목</option>
	      <option value="k2">내용</option>
	      <option value="k3">제목+내용</option>
	    </select>
	  </div>
	  <div class="col-12">
	    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
	      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
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
					<li class="page-item"><a class="page-link"
						href="./list?page=${pager.startBlock-1 }">Previous</a></li>
					<c:forEach begin="${pager.startBlock }" end="${pager.endBlock }"
						var="i">
						<li class="page-item "><a class="page-link"
							href="./list?page=${i }">${i }</a></li>
					</c:forEach>
					<li class="page-item ${pager.endCheck?'disabled':'' }"><a
						class="page-link" href="./list?page=${pager.endBlock+1 }">Next</a></li>
				</ul>
			</nav>

		</div>
	</div>

	<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>