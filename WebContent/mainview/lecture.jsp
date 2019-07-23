<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<!-- list-group --> 
<div class="container"> 
	<ul class="list-group mt-3"> 
		<a href="#" class="list-group-item active">1강 Hello world</a> 
		<a href="#" class="list-group-item">2강 변수</a> 
		<a href="#" class="list-group-item">3강 데이터 타입</a> 
		<a href="#" class="list-group-item">4강 연산자</a> 
		<a href="#" class="list-group-item">5강 조건문과 반복문</a> 
	</ul> 
	<div class="mt-4 embed-responsive embed-responsive-16by9"> 
		<iframe class="embed-responsive-item" src="https://www.youtube.com/embed/ZGRO--BDH10"></iframe> 
	</div> 
</div>
<!-- form --> 
<div class="container"> 
	<hr> 
	<form class="mt-5 col-md-6"> 
		<div class="form-group"> 
			<label for="exampleFormControlInput1">Email address</label> 
			<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com"> 
		</div> 
		<div class="form-group"> 
			<label for="exampleInputPassword1">Password</label> 
			<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"> 
		</div> 
		<div class="form-group"> 
			<label for="exampleFormControlSelect1">강의 평가</label> 
			<select class="form-control" id="exampleFormControlSelect1"> 
				<option>매우 좋음</option> 
				<option>좋음</option> 
				<option>보통</option> 
				<option>나쁨</option> 
				<option>매우 나쁨</option> 
			</select> 
		</div> 
		<div class="form-group"> 
			<label for="exampleFormControlTextarea1">기타 의견</label> 
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea> 
		</div> 
		<button type="submit" class="btn btn-primary">평가 제출</button> 
	</form> 
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>