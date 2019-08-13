<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/index_style.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<style type="text/css">
div.container {
	margin-top: 50px
}

h2 {
	font-family: 'Do Hyeon', sans-serif;
}

.pagination a:hover {
	color: red;
}

ul.pagination {
	width: 150px;
	margin: 0 auto
}

li {
	text-align: center
}

/* 글쓰기 버튼 */
div.write {
	width: 100px;
	height: 35px;
	background: #EB6864;
	text-align: center;
	line-height: 35px;
	color: #fff;
	float: right;
	margin-bottom: 10px;
	margin-right: 10px;
}

div.write a {
	color: #fff
}

div.write:hover {
	background: #e74742;
}

.pagecolor {
	color: red;
}
</style>
<title>공지사항</title>
</head>
<body>
	<!-- 네비바 -->
	<jsp:include page="../mainview/nav.jsp"></jsp:include>

<!-- 홍보문의의 게시글 리스트(관리자용) -->
	<div class="container" id="notice">
		<h2>홍보문의</h2>
		<!-- 글쓰기 버튼 -->
		<%-- <c:if test="${sessionScope.loginOk.userlevel == 0 }">
			<a href="/semi/notice/writeform.do"><div class="write" >글쓰기</div></a> 
		</c:if> --%>
		<table class="table table-striped">

			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
				</tr>
			</thead>
			<!-- 테이블 내용 -->
			<tbody>
				<c:forEach items="${requestScope.aList }" var="aList"
					varStatus="status">
					<tr>
						<!--<td>${cnt }</td>-->
						<td>${pdto.number-status.count+1}</td>
						<td><a
							href="view.do?boardkey=${aList.boardkey }&pageNum=${pdto.currentPage}">${aList.fTitle }</a>
							<c:forEach items="${aList.comment}" var="commentlist">
								<br />&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="../images/re.gif">
								<a
									href="/semi/promotion/commentview.do?commentcode=${commentlist.commentcode}"
									id="comment_link">${commentlist.commentTitle } </a>
								<input type="hidden" value="${commentlist.commentcode}"
									name="commentcode">
							</c:forEach></td>
						<td><input type="hidden" value="${aList.boardkey }"
							name="boardkey"></td>
					</tr>
				</c:forEach>

			</tbody>
			<!-- 게시판 페이징 처리 -->
		</table>
		<div class="text-conter">
			<ul class="pagination">
				<c:if test="${requestScope.pdto.startPage != 1 }">
					<li><a
						href="board.do?pageNum=${requestScope.pdto.startPage- requestScope.pdto.blockPage}">이전</a>
					</li>
				</c:if>
				<li><c:forEach begin="${requestScope.pdto.startPage }"
						end="${requestScope.pdto.endPage }" var="i">
						<c:choose>
							<c:when test="${i == requestScope.pdto.currentPage }">
								<a href="board.do?pageNum=${i }" class="pagecolor">${i }</a>
							</c:when>
							<c:otherwise>
								<a href="board.do?pageNum=${i }">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach></li>

				<li><c:if
						test="${requestScope.pdto.totalPage > requestScope.pdto.endPage }">
						<a href="board.do?pageNum=${requestScope.pdto.endPage+1 }">다음</a>
					</c:if></li>
			</ul>

		</div>
	</div>
	<!-- 풋터 -->
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>