<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap&subset=korean" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">

<meta charset="UTF-8">
<title>ReviewBoardList</title>
<style type="text/css">

div.container {
margin-top:50px 
}

h2{
	font-family: 'Do Hyeon', sans-serif;
}

div.searchbar{
margin-top:20px;
margin-bottom:15px
}

.pagelist{
text-align: center;
}

.pagelist a {
	text-decoration: none;
	color: black;
}

.pagelist a:hover, .pagelist .pagecolor {
	text-decoration: underline;
	color: red;
}

li {
	list-style: none;
	display: inline-block;
	margin-right: 10px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#searchBtn").on('click' , function(){
		$('form').attr('action', 'reviewList.do');
		$('form').submit();
	});
	
	$('[name=searchWord]').val('${pdto.searchWord}');
	  if('${pdto.searchKey}' == 'null'){
		$('[name=searchWord]').val(''); 
	 } else{
		
		switch ('${pdto.searchKey}') {
		case 'all': $('[value=all]').prop('selected','selected');
					$('[name=searchWord]').val('');
					break;
		case 'subject' :$('[value=subject]').prop('selected','selected');
						break;
		case 'writer' :$('[value=writer]').prop('selected','selected');
						break;				
		case 'content' :$('[value=content]').prop('selected','selected');
						break;
		}
	}
	
});

</script>
</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<div class="wrap container">
	<h2>후기게시판</h2>
		<div class="searchbar search-panel">
			<form>
					<select name="searchKey">
						<option value="all">검색어를 입력</option>
						<option value="title">제목</option>
						<option value="contents">내용</option>
						<option value="userName">글쓴이</option>
					</select>	
					<input type="text" name="searchWord"> 
					<input type="button" value="검색" id="searchBtn" class="btn btn-danger"/>		
			</form>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>게시글 제목</th>
					<th>게시글 작성자</th>
					<th>게시글 작성일</th>
					<th>첨부 파일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${requestScope.aList }" var="dto" varStatus="status">
               <tr>
                  <td>${pdto.number-status.count+1}</td>
						<td>
							<c:url var="cpage" value="reviewView.do">
								<c:param name="boardkey" value="${dto.boardkey }"/>
								<c:param name="pageNum" value="${pdto.currentPage }"/>
								<c:param name="number" value="${pdto.number }"/>
								<c:param name="searchKey" value="${pdto.searchKey }"/>
								<c:param name="searchWord" value="${pdto.searchWord }"/>
							</c:url>
							<%-- <a href="view.do?num=${dto.num }&pageNum=${pdto.currentPage}&number=${pdto.number}&searchKey=${pdto.searchKey}">${dto.subject }</a></td> --%>
							<a href="${cpage}">${dto.btitle }</a>
							</td>
						<td>${dto.userName }</td>
						<td>${dto.day }</td>
						<td>
							<c:if test="${!empty dto.filename }">
							<img src="/semi_start/img\save.gif">
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="pagelist">
		<!-- 이전 -->
		<c:if test="${pdto.startPage > 1 }">
			<a href="reviewList.do?pageNum=${pdto.startPage - pdto.blockPage}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}">이전</a>
		</c:if>
		<!-- 페이지 -->
		<c:forEach begin="${requestScope.pdto.startPage }" end="${requestScope.pdto.endPage }" var="i">
			<span>
			<c:choose>
				<c:when test="${i == requestScope.pdto.currentPage }">
				<a href="reviewList.do?pageNum=${i}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}" class="pagecolor">${i}</a><!-- 페이지 컬러로 스타일 적용 -->
				</c:when>
				<c:otherwise>
					<a href="reviewList.do?pageNum=${i}&searchKey=${pdto.searchKey }&searchWord=${pdto.searchWord }">${i }</a>
				</c:otherwise>
			</c:choose>
			</span>
		</c:forEach>
		
		<!-- 다음 -->
		<c:if test="${pdto.endPage<pdto.totalPage }">
			<a href="reviewList.do?pageNum=${pdto.startPage + pdto.blockPage}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}">다음</a>
		</c:if>
		</div>
		
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>