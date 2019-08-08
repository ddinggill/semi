<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function timecount(){
	
		var minute = 30;
		var second = 30;
		
		$("#time").html("남은로그인 유지시간:");
		$("#countTimerMinute").html(minute+"분");
		$("#countTimerSecond").html(second+"초");
		
		var timer = setInterval(function(){
			$("#time").html("남은로그인 유지시간:");
			$("#countTimerMinute").html(minute+"분");
			$("#countTimerSecond").html(second+"초");
			
			if(second==0 && minute==0){
				alert("로그인 시간이 만료되었습니다.다시 로그인 해주세요.");
				clearInterval(timer);
				location.href = "/semi/logout";
			}else{
				second--;
				if(second==0){
					minute--;
					if(minute<0){
						minute = 0;
					}else{
						second=59;
					}
				}
				
			}
		},1000);
	
}

</script>
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
				<a class="nav-link" href="/semi/district/hotList.do" style="color: white">인기축제</a> 
			</li> 
			<li class="nav-item active"> 
				<a class="nav-link" href="/semi/district/list.do" style="color: white">지역/기간별검색</a> 
			</li> 
		
			<li class="nav-item active"> 
				<a class="nav-link" href="/semi/district/reviewList.do" style="color: white">후기게시판</a> 
			</li> 
			<li class="nav-item"> 
				<a class="nav-link" href="/semi/notice/list.do" style="color: white">공지사항</a> 
			</li> 
			
			<c:if test="${sessionScope.loginOk.userlevel eq 0 }">
			<li class="nav-item"> 
				<a class="nav-link" href="/semi/festival/InsertFestival.jsp" style="color: yellow">축제등록</a> 
			</li>
			<li class="nav-item"> 
				<a class="nav-link" href="/semi/admin/membermanage.do" style="color: yellow">회원관리</a> 
			</li>
			</c:if>
		</ul>
		
		 <!-- search bar -->
		 <form class="form-inline my-2 my-lg-0 mr-auto" id="my_searchbar"> 
		 	<!-- <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"> 
		 	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
		  </form>
		  <!-- login components --> 
		  <ul class="navbar-nav"> 
		  	<c:if test="${!empty sessionScope.loginOk}">
		  		<li class="nav-item"> 
					<a class="nav-link" href="" style="color: white" id="time"></a> 
				</li> 
			  	<li class="nav-item"> 
					<a class="nav-link" href="" style="color: white" id="countTimerMinute"></a> 
				</li> 
				<li class="nav-item"> 
					<a class="nav-link" href="" style="color: white" id="countTimerSecond"></a> 
				</li> 
		  	</c:if>
		  	<li class="nav-item dropdown">
		  		<a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white"> 내 정보 
		  		</a> 
		  		<c:choose>
		  			<c:when test="${empty sessionScope.loginOk}">
				  		<div class="dropdown-menu" aria-labelledby="navbarDropdown"> 
				  			<a class="dropdown-item" href="/semi/main/login.do">로그인</a> 
				  			<a class="dropdown-item" href="/semi/main/join.do">회원가입</a> 
				  		</div> 
		  			</c:when>
		  			<c:otherwise>
		  				<script type="text/javascript">
		  					timecount();
		  				</script>
		  				<div class="dropdown-menu" aria-labelledby="navbarDropdown"> 
				  			<a class="dropdown-item" href="/semi/mypage/mypage.do">My Page</a>
				  			<a class="dropdown-item" href="/semi/promotion/promotion.do">홍보문의</a> 
				  			<a class="dropdown-item" href="/semi/logout">로그아웃</a>
				  		</div> 
		  			</c:otherwise>
		  		</c:choose>
		  	</li> 
		  </ul>
	</div>
</nav>

</body>
</html>