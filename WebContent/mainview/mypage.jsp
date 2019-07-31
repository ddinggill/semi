<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#color{
	background: #F361A6;
}
</style>
<link rel="stylesheet" type="text/css" href="../css/index_style.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
<div class="container">
	<div class="card border-danger mt-3 mb-3"> 
		<h5 class="card-header text-white mb-3" id="color">최준영 강사</h5> 
		<div class="card-body"> 
			<img class="lecture-logo" src="../images/js_logo.png" alt="JS Logo"> 
				<h5 class="card-title">최준영</h5> 
				<p class="card-text">쌍문동 웹 프론트엔드 강사</p> 
		</div> 
		<table class="table table-hover"> 
			<thead> 
				<tr> 
					<th>강사명</th>
					<th>강의 번호</th> 
					<th>강의 제목</th> 
					<th>강의 날짜</th> 
				</tr> 
			</thead>
		 	<tbody> 
		 		<tr> 
		 			<td>최준영</td> 
		 			<td>1</td> 
		 			<td>HTML 기초</td> 
		 			<td>2018-07-23</td> 
		 		</tr> 
		 		<tr> 
		 			<td>최준영</td> 
		 			<td>2</td> 
		 			<td>CSS 기초</td> 
		 			<td>2018-08-01</td> 
		 		</tr> 
		 		<tr> 
		 			<td>최준영</td> 
		 			<td>3</td> 
		 			<td>Javascript 심화</td> 
		 			<td>2018-08-05</td> 
		 		</tr> 
		 	</tbody> 
		</table> 
		
	</div>
</div>

<div class="container">
	<div class="card border-danger mt-3 mb-3"> 
		<h5 class="card-header text-white mb-3" id="color">후기게시판</h5> 
		<!-- <div class="card-body"> 
			<img class="lecture-logo" src="../images/js_logo.png" alt="JS Logo"> 
				<h5 class="card-title">최준영</h5> 
				<p class="card-text">쌍문동 웹 프론트엔드 강사</p> 
		</div>  -->
		<table class="table table-hover"> 
			<thead> 
				<tr> 
					<th>강사명</th>
					<th>강의 번호</th> 
					<th>강의 제목</th> 
					<th>강의 날짜</th> 
				</tr> 
			</thead>
		 	<tbody> 
		 		<tr> 
		 			<td>최준영</td> 
		 			<td>1</td> 
		 			<td>HTML 기초</td> 
		 			<td>2018-07-23</td> 
		 		</tr> 
		 		<tr> 
		 			<td>최준영</td> 
		 			<td>2</td> 
		 			<td>CSS 기초</td> 
		 			<td>2018-08-01</td> 
		 		</tr> 
		 		<tr> 
		 			<td>최준영</td> 
		 			<td>3</td> 
		 			<td>Javascript 심화</td> 
		 			<td>2018-08-05</td> 
		 		</tr> 
		 	</tbody> 
		</table> 
		
	</div>
</div>

<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>