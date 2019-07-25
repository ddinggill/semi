<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-danger"> 
	<a class="navbar-brand" href="/semi/main/main.do" style="color: white">Main</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<!-- nav components -->
		<ul class="navbar-nav"> 
			<li class="nav-item active"> 
				<a class="nav-link" href="/semi/board/boardview.do" style="color: white">인기축제</a> 
			</li> 
			<li class="nav-item active"> 
				<a class="nav-link" href="extra.html" style="color: white">지역/기간별검색</a> 
			</li> 
			<!-- <li class="nav-item dropdown"> 
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> 기능 리스트 </a> 
				<div class="dropdown-menu" aria-labelledby="navbarDropdown"> 
					<a class="dropdown-item" href="/semi/main/lecture.do">강좌</a>
					<a class="dropdown-item" href="#">Another action</a> 
					<div class="dropdown-divider"></div> 
					<a class="dropdown-item" href="#">Something else here</a> 
				</div> 
			</li>  -->
			<li class="nav-item active"> 
				<a class="nav-link" href="extra.html" style="color: white">후기게시판</a> 
			</li> 
			<li class="nav-item"> 
				<a class="nav-link" href="#" data-target="#modal-1" data-toggle="modal" style="color: white">미완성 기능</a> 
			</li> 
		</ul>
		
		 <!-- search bar -->
		 <form class="form-inline my-2 my-lg-0 mr-auto" id="my_searchbar"> 
		 	<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"> 
		 	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		  </form>
		  <!-- login components --> 
		  <ul class="navbar-nav"> 
		  	<li class="nav-item dropdown">
		  		<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white"> 내 정보 
		  		</a> 
		  		<div class="dropdown-menu" aria-labelledby="navbarDropdown"> 
		  			<a class="dropdown-item" href="/semi/main/login.do">로그인</a> 
		  			<a class="dropdown-item" href="#">회원가입</a> 
		  		</div> 
		  	</li> 
		  </ul>
	</div>
</nav>
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