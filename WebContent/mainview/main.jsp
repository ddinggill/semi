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
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn").on("click",function(){
			alert("hi");
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
	<div class="jumbotron">
	<h1 class="text-center">축제알림 홈페이지</h1>
	<p class="text-center">축제정보 알려주는 홈페이지 입니다.</p>
	<p class="text-center"><a class="btn btn-primary btn-lg" href="#" role="button" >자세히 알아보기</a></p>
	</div>
	<!-- lecture -->
	<div class="row"> 
		<div class="col-md-4"> 
			<h4>HTML & CSS</h4> 
			<p>HTML과 CSS는 웹페이지에서 정적인 요소들을 표현하는 언어이다. 버튼이나 텍스트 등의 요소는 HTMl로 표현되며, 해당 요소들의 색상이나 크기 등은 CSS로 표현한다.</p> 
			<p><a class="btn btn-default " href="#" data-target="#modal-1" data-toggle="modal" style="color:blue">자세히 알아보기</a> </p> 
		</div>
		<div class="col-md-4"> 
			<h4>Javascript</h4> 
			<p>Javascript는 웹페이지에서 사용자 동작을 정해진 로직에 따라 처리하는 언어이다.</p> 
			<p><a class="btn btn-default" href="#" style="color:blue">자세히 알아보기</a> </p> 
		</div> 
		<div class="col-md-4"> 
			<h4>Django</h4>
			<p>Django는 Python 기반의 프레임워크로, 데이터를 필요로 하거나 서버의 자원을 필요로 하는 사용자 요청을 서버에서 처리한다.</p> 
			<p><a class="btn btn-default" href="#" style="color:blue">자세히 알아보기</a> </p> 
		</div>
	</div>
	<hr>
</div>
<!-- card -->
	<div class="card"> 
		<h5 class="card-header text-white bg-primary mb-3">최신 강의 목록</h5> 
		<ul class="list-group list-group-flush"> 
			<div class="list-group-item"> 
				<img class="lecture-logo" src="../images/html_logo.png" alt="HTML Logo"> 
				<div class="card-body"> 
					<h5 class="card-title">HTML 기초 <span class="badge my_badge">New</span></h5> 
					<p class="card-text">웹 프론트엔드 초보자를 위한 HTML 기초 강의입니다.</p> 
					<a href="#" class="btn btn-primary">강좌 신청하기</a> 
				</div> 
			</div> 
			<div class="list-group-item"> 
				<img class="lecture-logo" src="../images/css_logo.png" alt="CSS Logo"> 
				<div class="card-body"> 
					<h5 class="card-title">CSS 기초 <span class="badge my_badge">New</span></h5> 
					<p class="card-text">웹 프론트엔드 초보자를 위한 CSS 기초 강의입니다.</p> 
					<a href="#" class="btn btn-primary">강좌 신청하기</a> 
				</div> 
			</div> 
			<div class="list-group-item"> 
				<img class="lecture-logo" src="../images/js_logo.png" alt="JS Logo"> 
				<div class="card-body"> 
					<h5 class="card-title">Javascript 심화</h5> 
					<p class="card-text">현직 개발자를 위한 Javascript 심화 강의입니다.</p> 
					<a href="#" class="btn btn-primary">강좌 신청하기</a> 
				</div> 
			</div> 
		</ul> 
	</div> 
	<br>


<jsp:include page="footer.jsp"></jsp:include>
<div class="modal fade" id="modal-1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
	<div class="modal-dialog" role="document"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<h5 class="modal-title" id="exampleModalLabel">알림창</h5> 
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> 
					<span aria-hidden="true">×</span> 
				</button> 
			</div> 
			<div class="modal-body"> 아직 구현이 완료되지 않은 서비스입니다. </div> 
			<div class="modal-footer"> 
				<button type="button" class="btn btn-secondary" data-dismiss="modal">확인</button> 
			</div> 
		</div> 
	</div> 
</div> 

</body>
</html>