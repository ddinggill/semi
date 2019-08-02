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
*{
	margin: 0;
	padding: 0;
}

#card{
	margin-top:50px;
}

#color{
	background: #F361A6;
}
.tt{
	/* font-family: 'Do Hyeon', sans-serif; */
	color: #F361A6;
	font-size: 30px;
}

.card-title{
	margin-bottom: 0px;
}
a{
	margin-left:20px;
}

.mypage-active{
	margin-top:20px;
	margin-bottom:0px;
	font-size:20px;
	font-weight: bold;
}

</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<div class="container" id="card">
		<div class="card-body">
			<img class="lecture-logo" src="../images/user-icon.png" alt="JS Logo">
			<p class="card-title">
				<strong class="tt">${sessionScope.loginOk.nickname }</strong>님 반갑습니다. <a href="/semi/mypage/memberinfo.do">회원정보수정</a>
			</p>
		</div>
			<p class="mypage-active">활동내역</p>
	</div>

	<div class="container">
	<div class="card border-danger mt-3 mb-3"> 
		<h5>후기 게시판</h5> 
		<!-- <div class="card-body"> 
			<img class="lecture-logo" src="../images/js_logo.png" alt="JS Logo"> 
				<h5 class="card-title">최준영</h5> 
				<p class="card-text">쌍문동 웹 프론트엔드 강사</p> 
		</div>  -->
		<table class="table table-hover"> 
			<thead> 
				<tr> 
					<th>제목</th>
					<th>작성일</th>  
				</tr> 
			</thead>
		 	<tbody> 
		 	<c:forEach items="${requestScope.reviewList }" var="reviewList">
		 		<tr> 
		 			<td><a href="" >${reviewList.reviewTitle }</a></td> 
		 			<td>${reviewList.reviewDate }</td> 
		 		</tr> 
		 		</c:forEach>	
		 	</tbody> 
		</table> 
		
	</div>
	<div class="card border-danger mt-3 mb-3"> 
		<h5>댓글</h5> 
		<!-- <div class="card-body"> 
			<img class="lecture-logo" src="../images/js_logo.png" alt="JS Logo"> 
				<h5 class="card-title">최준영</h5> 
				<p class="card-text">쌍문동 웹 프론트엔드 강사</p> 
		</div>  -->
		<table class="table table-hover"> 
			<thead> 
				<tr> 
					<th>내용</th> 
				</tr> 
			</thead>
		 	<tbody> 
		 	<c:forEach items="${requestScope.recommentList }" var="recommentList">
		 		<tr> 
		 			<td>${recommentList.comment }</td> 
		 		</tr> 	
		 		</c:forEach>
		 	</tbody> 
		</table> 
		
	</div>
	<div class="card border-danger mt-3 mb-3"> 
		<h5>홍보 문의 게시판</h5> 
		<!-- <div class="card-body"> 
			<img class="lecture-logo" src="../images/js_logo.png" alt="JS Logo"> 
				<h5 class="card-title">최준영</h5> 
				<p class="card-text">쌍문동 웹 프론트엔드 강사</p> 
		</div>  -->
		<table class="table table-hover"> 
			<thead> 
				<tr> 
					<th>제목</th>
					
				</tr> 
			</thead>
		 	<tbody> 
		 	<c:forEach items="${requestScope.promotionList }" var="promotionList">
		 		<tr> 
		 			<td>${promotionList.promotionTitle }</td> 
		 			
		 		</tr> 
		 		</c:forEach>	
		 	</tbody> 
		</table> 
		
	</div>
</div>

<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>