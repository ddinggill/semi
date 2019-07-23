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
<nav class="navbar navbar-expand-lg navbar-light bg-light"> 
	<a class="navbar-brand" href="main.do">Main</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<!-- nav components -->
		<ul class="navbar-nav"> 
			<li class="nav-item active"> 
				<a class="nav-link" href="boardview.do">소개(게시판)</a> 
			</li> 
			<li class="nav-item"> 
				<a class="nav-link" href="extra.html">추가 기능</a> 
			</li> 
			<li class="nav-item dropdown"> 
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> 기능 리스트 </a> 
				<div class="dropdown-menu" aria-labelledby="navbarDropdown"> 
					<a class="dropdown-item" href="lecture.do">강좌</a>
					<a class="dropdown-item" href="#">Another action</a> 
					<div class="dropdown-divider"></div> 
					<a class="dropdown-item" href="#">Something else here</a> 
				</div> 
			</li> 
			<li class="nav-item"> 
				<a class="nav-link disabled" href="#">미완성 기능</a> 
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
		  		<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 내 정보 
		  		</a> 
		  		<div class="dropdown-menu" aria-labelledby="navbarDropdown"> 
		  			<a class="dropdown-item" href="login.do">로그인</a> 
		  			<a class="dropdown-item" href="#">회원가입</a> 
		  		</div> 
		  	</li> 
		  </ul>
	</div>
</nav>
</body>
</html>