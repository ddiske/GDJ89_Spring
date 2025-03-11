<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${ list.size() ne '0' }">
<table class="table table-success table-striped">
	<thead>
		<tr>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="commentsDTO">
			<tr>
				<td>${commentsDTO.userName }</td>
				<td>${commentsDTO.boardContents }</td>
				<td>${commentsDTO.boardDate }</td>
				<td><button class="btn btn-outline-success updateComments" value="${commentsDTO.boardNum}">수정</button></td>
				<td><button class="btn btn-outline-danger deleteComments" value="${commentsDTO.boardNum}">X</button></td>
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
</c:if>