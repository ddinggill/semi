<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/index_style.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<style type="text/css">
div.container {
margin-top:50px 
}

h2{
	font-family: 'Do Hyeon', sans-serif;
}

.pagination a {
color: black
}

ul.pagination {width:150px; margin:0 auto}

li{text-align:center}

/* 글쓰기 버튼 */
div.write{width:100px; height:35px; background:#EB6864; text-align:center; line-height:35px; color:#fff; float:right; margin-bottom : 10px; margin-right: 10px;}

div.write a{color:#fff}

div.write:hover{
	background:#e74742;
}
</style>
<title>공지사항</title>
</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
<div class="container" id="notice">
		<h2>공지사항</h2>
		<!-- 글쓰기 버튼 -->
		<a href="#"><div class="write">글쓰기</div></a> 
		<table class="table table-striped"> 
			<thead> 
				<tr> 
					<th>번호</th>
					<th>제목</th> 
					<th>작성자</th> 
					<th>날짜</th>
				</tr> 
			</thead>
		 	<!-- 테이블 내용 -->
		 	<tbody> 
		 		<tr> 
		 			<td>번호</td> 
		 			<td>제목</td> 
		 			<td>작성자</td> 
		 			<td>날짜</td>
		 		</tr> 
		 	</tbody> 
		</table>
		<div class="text-conter">
		<ul class="pagination">
		<li><a href="#">이전</a></li>
		<li><a href="#">페이지</a></li>
		<li><a href="#">다음</a></li>
		</ul>
		<%-- <!-- 이전 -->
		<c:if test="${pdto.startPage > 1 }">
			<a href="list.do?pageNum=${pdto.startPage - pdto.blockPage}&searchKey=${pdto.searchKey }&searchWord=${pdto.searchWord }">이전</a>
		</c:if>
		<!-- 페이지 -->
		<c:forEach begin="${requestScope.pdto.startPage }" end="${requestScope.pdto.endPage }" var="i">
			<span>
			<c:choose>
				<c:when test="${i == requestScope.pdto.currentPage }">
				<a href="list.do?pageNum=${i }&searchKey=${pdto.searchKey }&searchWord=${pdto.searchWord }"
                  class="pagecolor">${i }</a><!-- 페이지 컬러로 스타일 적용 -->
				</c:when>
				<c:otherwise>
					<a href="list.do?pageNum=${i }&searchKey=${pdto.searchKey }&searchWord=${pdto.searchWord }">${i }</a>
				</c:otherwise>
			</c:choose>
			</span>
		</c:forEach>
		
		<!-- 다음 -->
		<c:if test="${pdto.endPage<pdto.totalPage }">
			<a href="list.do?pageNum=${pdto.startPage + pdto.blockPage}&searchKey=${pdto.searchKey }&searchWord=${pdto.searchWord }">다음</a>
		</c:if> --%>
		</div> 
</div>
<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>