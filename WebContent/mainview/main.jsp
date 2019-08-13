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
			pager : true,
			touchEnabled : false
		});
		   
	});
</script>
<style type="text/css">
</style>

<title>Insert title here</title>
</head>
<body>
<!-- 메인페이지의 로고 -->
	<div class="container-fluid ">
		<div class="jumbotron mb-0">
			<!-- <h1 class="text-center">축제알림 홈페이지</h1> -->
			<!-- <p class="text-center">축제정보 알려주는 홈페이지 입니다.</p> -->
			<!-- <p class="text-center"><a class="btn btn-primary btn-lg" href="#" role="button" >자세히 알아보기</a></p> -->
		</div>
		
	</div>
	<!-- 메이페이지 네비게이션 바 -->
	<jsp:include page="nav.jsp"></jsp:include>
	
	<!-- 메인페이지의 축제 이미지 슬라이더 -->
	<ul class="bxslider" id="bx1">
		<li><img src="../images/부산불꽃축제.jpg" class="bximg" /></li>
		<li><img src="../images/메인이미지1.jpg" class="bximg" /></li>
		<li><img src="../images/메인이미지2.jpg" class="bximg" /></li>
		
	</ul>
	
<!-- 메인페이지의  숙박업소 광고배너 -->
<div class="container col-md-12">
	<div class="row">
		<div class="col-md-8">
			<ul class="bxslider2">
				<li><a href="https://www.yanolja.com/"><img src="../images/야놀자.png" class="bximg" /></a></li>
				<li><a href="https://www.goodchoice.kr/"><img src="../images/여기어때.jpg" class="bximg" /></a></li>
				<li><a href="https://www.hotelscombined.co.kr/"><img src="../images/호텔스컴바인.png" class="bximg" /></a></li>
			</ul>
		</div>
		<!-- 메인페이지의 최근 공지사항 및 최근 후기게시글 -->
		<div class="col-md-4">
			<ul>
				<li class="new_list"><h1 class="new_title">공지사항</h1></li>
				<c:forEach items="${requestScope.noticeList }" var="notice">
				<li class="new_list"><a href="/semi/notice/view.do?boardkey=${notice.boardkey }&pageNum=1" class="new_text">${notice.title }</a><span
					class="new_date">${notice.day }</span></li>
				</c:forEach>
			</ul>
			<ul>
				<li class="new_list"><h1 class="new_title">후기게시판</h1></li>
			<c:forEach items="${requestScope.reviewList }" var="review">
			
				<li class="new_list"><a href="/semi/district/reviewView.do?boardkey=${review.boardkey }&pageNum=1" class="new_text">${review.title }</a><span
					class="new_date">${review.day }</span></li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>
	
<!-- 메인페이지의 추천 축제 -->

<div class="container col-md-12" id="recommend">
	<div class="row">
		<div class="col-md-2"><a href="https://hangang.seoul.go.kr/project" ><img  src="../images/추천1.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="http://www.bonghwafestival.com/eunuh/" ><img  src="../images/추천2.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="https://tofly.tistory.com/entry/%EC%A3%BC%EB%A7%90%EA%B0%80%EC%A1%B1%EC%B2%B4%ED%97%98-2018-%EC%84%9C%EC%9A%B8%EB%A1%9C-%EC%97%AC%EB%A6%84%EC%B6%95%EC%A0%9C-%EC%84%9C%EC%9A%B8%EB%A1%9C-GO" ><img  src="../images/추천3.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="http://www.bfo.or.kr/festival_sea/info/01.asp?MENUDIV=1"><img  src="../images/추천4.png" class="re_link"></a></div>
		<div class="col-md-2"><a href="http://www.cultureexpo.or.kr/open.content/ko/community/press/?i=3026" ><img  src="../images/추천5.jpg" class="re_link"></a></div>
		<div class="col-md-2"><a href="https://mapo.go.kr/CmsWeb/viewPage.req?idx=PG0000002199&CP0000000001_BD0000002533_action=viewContent&CP0000000001_BD0000002533_atcId=BA0000361664" ><img  src="../images/추천6.jpg"  class="re_link" ></a></div>
	</div>

</div>
	<!-- 메인페이지의 풋터 -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>