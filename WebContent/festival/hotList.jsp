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
<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>festival_list</title>
<style type="text/css">
#hot_list_col {
	padding: 0;
	border: 1px solid gray;
	text-align: center;
	font-family: Jua;
	font-weight: bold;
	/*  border-radius: 80px / 40px;  */
	font-size: 23px;
	margin-top: 50px;
	margin-right: 70px;
	margin-left: 70px;
	background-color: #E4E2E2;
	
}

body {
	background-color: #F2F2F2;
}

* {
	border: 0;
	margin: 0;
	padding: 0;
}

li {
	list-style: none;
	display: inline-block;
	margin-right: 0;
	
}
div p{
 color: black;
 
}

.li_img {
	width: 100%;
	height: 220px;
	margin: 0 auto;
}

img {
	/* border-radius: 80px / 40px; */
	
}
div p:hover{
 color: #DC3545;
 
}

#hot_list_link:hover {
	color: #DC3545;
	text-decoration: none;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="list_jquery.js"></script> -->
<script type="text/javascript">
	
	

</script>
</head>

<body>
	<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<!-- 인기축제 영역보기 시작  -->
	<ul class="list">

		<div id="wrap">
		<div class="container-fluid" id="hot_list_div">
			<div class="row" id="hot_list_row">
			<c:forEach items="${requestScope.aList}" var="dto">
			
			<div class="col-sm-3" id="hot_list_col">
				<c:url var="cpage" value="view.do">
					<c:param name="fcode" value="${dto.fcode}" />
					<%-- <c:param name="pageNum" value="${pdto.currentPage }"/> --%>
				</c:url>
				
				<li><a href="${cpage}" id="hot_list_link">
						<p>${dto.ftitle}</p>
						<p></p>
						<img class="li_img" src="/semi/images/${dto.fimgpath}" >
						<p class="tit">${dto.fsdate}~${dto.fedate}</p>
				</a></li>
			
				</div>
				
			</c:forEach>
			</div>
				</div>
		</div>

	</ul>
	<!-- 인기축제 영역보기 끝 -->
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>
