<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

.pagination a:hover {
	color: red;
} 

ul.pagination {width:150px; margin:0 auto}

li{text-align:center}

/* 글쓰기 버튼 */
div.write{width:100px; height:35px; background:#EB6864; text-align:center; line-height:35px; color:#fff; float:right; margin-bottom : 10px; margin-right: 10px;}

div.write a{color:#fff}

div.write:hover{
	background:#e74742;
}

.pagecolor{
	color: red;
}
</style>
<title>공지사항</title>
</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
<div class="container" id="notice">
		<h2>공지사항</h2>
		<!-- 글쓰기 버튼 -->
		<c:if test="${sessionScope.loginOk.userlevel == 0 }">
			<a href="/semi/notice/writeform.do"><div class="write">글쓰기</div></a> 
		</c:if>
		<table class="table table-striped"> 
			<thead> 
				<tr> 
					<th>번호</th>
					<th>제목</th> 
					<th>작성자</th> 
					<th>작성날짜</th>
				</tr> 
			</thead>
		 	<!-- 테이블 내용 -->
		 	<tbody> 
		 	<c:forEach items="${requestScope.aList }" var="dto" varStatus="status">
				<tr>
					<!--<td>${cnt }</td>-->
					<td>${pdto.number-status.count+1}</td>
					<td><a href="view.do?boardkey=${dto.boardkey }&pageNum=${pdto.currentPage}">${dto.title }</a></td>
					<td>관리자</td>
					<td>${dto.day }</td>
				<!-- <c:set var="cnt" value="${cnt-1 }"></c:set> -->
					<%-- <td>
						<form action="updateForm.do">
							<input type="hidden" name="num" value="${dto.num }">
							<input type="submit" value="수정">			
						</form>
					</td>
					<td>
						<form action="delete.do">
							<input type="hidden" name="num" value="${dto.num }">
							<input type="hidden" name="pageNum" value="${pdto.currentPage }"> 
							<input type="submit" value="삭제">			
						</form>
					</td> --%>
				</tr>
		</c:forEach>
		 		
		 	</tbody> 
		</table>
		<div class="text-conter">
		<ul class="pagination">
			<c:if test="${requestScope.pdto.startPage != 1 }" >
				<li>
					<a href="list.do?pageNum=${requestScope.pdto.startPage- requestScope.pdto.blockPage}">이전</a>
				</li>
			</c:if>
				<li>
					<c:forEach begin="${requestScope.pdto.startPage }" end="${requestScope.pdto.endPage }" var="i">
						<c:choose>
							<c:when test="${i == requestScope.pdto.currentPage }">
								<a href="list.do?pageNum=${i }" class="pagecolor">${i }</a>
							</c:when>
							<c:otherwise>
								<a href="list.do?pageNum=${i }">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</li>
		
				<li>
					<c:if test="${requestScope.pdto.totalPage > requestScope.pdto.endPage }" >
					<a href="list.do?pageNum=${requestScope.pdto.endPage+1 }">다음</a>
					</c:if>
				</li>
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