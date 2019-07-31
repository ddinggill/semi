<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/index_style.css">

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

<script type="text/javascript">
	$(document).ready(function() {
		$('.bxslider').bxSlider({
			auto : true,
			speed : 500,
			pause : 4000,
			mode : 'fade',
			autoControls : true,
			pager : true
		});
		
		$('.bxslider2').bxSlider({
			auto : true,
			speed : 300,
			pause : 3000,
			mode : 'vertical',
			autoControls : true,
			pager : true
		});
		   
	});
</script>
<style type="text/css">
</style>

<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid ">
		<div class="jumbotron mb-0">
			<!-- <h1 class="text-center">축제알림 홈페이지</h1> -->
			<!-- <p class="text-center">축제정보 알려주는 홈페이지 입니다.</p> -->
			<!-- <p class="text-center"><a class="btn btn-primary btn-lg" href="#" role="button" >자세히 알아보기</a></p> -->
		</div>
		<!-- lecture -->
		<!-- <div class="row"> 
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
	</div> -->
	</div>
	<jsp:include page="nav.jsp"></jsp:include>
	<ul class="bxslider" id="bx1">
		<li><img src="../images/부산불꽃축제.jpg" class="bximg" /></li>
		<li><img src="../images/메인이미지1.jpg" class="bximg" /></li>
		<li><img src="../images/메인이미지2.jpg" class="bximg" /></li>
		
	</ul>
	<!-- card -->
	<!-- <div class="card"> 
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
	</div>  -->
<!-- 배너 -->
<div class="container col-md-12">
	<div class="row">
		<div class="col-md-8">
			<ul class="bxslider2">
				<li><a href="https://www.yanolja.com/"><img src="../images/야놀자.png" class="bximg" /></a></li>
				<li><a href="https://www.goodchoice.kr/"><img src="../images/여기어때.jpg" class="bximg" /></a></li>
				<li><a href="https://www.hotelscombined.co.kr/"><img src="../images/호텔스컴바인.png" class="bximg" /></a></li>
			</ul>
		</div>
		<div class="col-md-4">
			<ul>
				<li class="new_list"><h1 class="new_title">공지사항</h1></li>
				<c:forEach items="${requestScope.noticeList }" var="notice">
				<li class="new_list"><a href="/semi/notice/view.do?boardkey=" class="new_text">${notice.title }</a><span
					class="new_date">${notice.day }</span></li>
				<%--  <li class="new_list"><a href="" class="new_text">${notice.title }</a><span
					class="new_date">${notice.day }</span></li>
				<li class="new_list"><a href="" class="new_text">${notice.title }</a><span
					class="new_date">${notice.day }</span></li>
				<li class="new_list"><a href="" class="new_text">${notice.title }</a><span
					class="new_date">${notice.day }</span></li>
				<li class="new_list"><a href="" class="new_text">${notice.title }</a><span
					class="new_date">${notice.day }</span></li>  --%>
			</c:forEach>
			</ul>
			<ul>
				<li class="new_list"><h1 class="new_title">후기게시판</h1></li>
			<c:forEach items="${requestScope.reviewList }" var="review">
			
				<li class="new_list"><a href="" class="new_text">${review.title }</a><span
					class="new_date">${review.day }</span></li>
				<%--  <li class="new_list"><a href="" class="new_text">${review.title }</a><span
					class="new_date">${review.day }</span></li>
				<li class="new_list"><a href="" class="new_text">${review.title }</a><span
					class="new_date">${review.day }</span></li>
				<li class="new_list"><a href="" class="new_text">${review.title }</a><span
					class="new_date">${review.day }</span></li>
				<li class="new_list"><a href="" class="new_text">${review.title }</a><span
			
					class="new_date">${review.day }</span></li> --%>
					</c:forEach>
			</ul>
		</div>
	</div>
</div>
	<!-- <div class="container col-md-8" id="bx2">
	<ul class="bxslider2">
		<li><a href="https://www.yanolja.com/"><img src="../images/야놀자.png" class="bximg" /></a></li>
		<li><a href="https://www.goodchoice.kr/"><img src="../images/여기어때.jpg" class="bximg" /></a></li>
		<li><a href="https://www.hotelscombined.co.kr/"><img src="../images/호텔스컴바인.png" class="bximg" /></a></li>
	</ul>
	</div>
  최근 게시글
	<div id="new_notice_view">
		<ul>
			<li><h1 class="new_title">공지사항</h1></li>
			<li><a href="" class="new_text">[공지사항]공지사항 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[공지사항]공지사항 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[공지사항]공지사항 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[공지사항]공지사항 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[공지사항]공지사항 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
		</ul>
		<ul>
			<li><h1 class="new_title">후기게시판</h1></li>
			<li><a href="" class="new_text">[후기]후기 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[후기]후기 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[후기]후기 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[후기]후기 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
			<li><a href="" class="new_text">[후기]후기 관련된 내용입니다.</a><span
				class="new_date">2019-07-25</span></li>
		</ul>
	</div>
 -->
<!-- 추천 축제 -->


<div class="container col-md-12" id="recommend">
	<div class="row">
		<div class="col-md-2"><a href="" ><img  src="../images/추천1.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="" ><img  src="../images/추천2.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="" ><img  src="../images/추천3.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href=""><img  src="../images/추천4.png" class="re_link"></a></div>
		<div class="col-md-2"><a href="" ><img  src="../images/추천5.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="" ><img  src="../images/추천6.jpg"  class="re_link" ></a></div>
	</div>


</div>
<div id="test"></div>

	<jsp:include page="footer.jsp"></jsp:include>
	<!-- <div class="modal fade" id="modal-1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
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
</div>  -->

</body>
</html>