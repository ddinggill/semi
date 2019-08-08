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
<link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">

<meta charset="UTF-8">
<title>festival_list</title>
<style type="text/css">
li {
	list-style: none;
	display: inline-block;
	margin-right: 10px;
}

.li_img {
	width: 70%;
	height: 70%;
}

div.container{
	padding : 10px;
	margin-top: 50px;
	margin-bottom: 50px;
	background: #EDEDED;
	max-width: 1160px;
}

.list_date,.list_place{
	font-family: 'Fredoka One', cursive;
	font-size: 20px;
	text-align: center;
	margin-bottom: 10px;
}

.con{
	text-align: center;
}

/* 리스트 */

#list_col {
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
	background-color: white;
	
}

body {
	background-color: white;
}

* {
	border: 0;
	margin: 0;
	padding: 0;
}

#link {
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

div p:hover{
 color: #DC3545;
 
}

#list_link:hover {
	color: #DC3545;
	text-decoration: none;
}

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="list_jquery.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		var month = [ "전체", "1월", "2월", "3월", "4월", "5월", "6월","7월", "8월", "9월", "10월", "11월", "12월" ];
		var place = [ "전체지역", "경기도", "강원도", "충청북도", "서울", "인천","대전", "대구", "광주", "부산", "울산", "세종", "충청남도",
						"경상북도", "경상남도", "전라북도", "전라남도", "제주도" ];
		for (var i = 0; i < month.length; i++) {
			$('#ul_date').append('<li><a>' + month[i] + '</a></li>').hover(function(){
				$(this).css({'cursor':'pointer'});
			});
		}
		for (var i = 0; i < place.length; i++) {
			$('#ul_place').append('<li><a>' + place[i] + '</a></li>').hover(function(){
				$(this).css({'cursor':'pointer'});
			});
		}
		
		
		
		$('.con li a').on('click',function() {
			if ($(this).parent().parent().attr('id') == 'ul_place') {		
				$('#ul_place li a').css({'color':'black',
					'background': '#EDEDED',
					'border-radius':'20%',
					'padding':'2px'});
				$(this).css({'color':"white",
					'background': '#EB6864',
					'border-radius':'20%',
					'padding':'2px'});	
				$('#listPlace').attr('value',place.indexOf($(this).text()));
				
				
			} else if ($(this).parent().parent().attr('id') == 'ul_date') {
				$('#ul_date li a').css({'color':'black',
					'background': '#EDEDED',
					'border-radius':'20%',
					'padding':'2px'});
				$(this).css({'color':"white",
					'background': '#EB6864',
					'border-radius':'20%',
					'padding':'2px'});
				$('#listDate').attr('value',month.indexOf($(this).text()));
			}
			
			process();
		});
	});
	
	function process() {
		$.ajax({
			type : 'GET',
			dataType:'text',
			url : 'searchList.do?place=' + $('#listPlace').val()+'&date=' + $('#listDate').val(),
			success : viewMessage
		});
	}
	
	function viewMessage(result) {
		 $('#wrap').html(result);
	}
</script>
</head>

<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<input type="hidden" id="listDate" value="0" class="listState" />
	<input type="hidden" id="listPlace" value="0" class="listState" />
	<div class="container">
	<div class="list_date">DATE</div>
	<ul class="con" id="ul_date">

	</ul>
	<div class="list_place">PLACE</div>
	<ul class="con" id="ul_place">

	</ul>
	</div>
	<ul class="list">
		<div id="wrap">
		<div class="container-fluid" id="list_div">
		<div class="row" id="list_row">
			<c:forEach items="${requestScope.aList}" var="dto">
			<div class="col-sm-3" id="list_col">
				<c:url var="cpage" value="view.do">
					<c:param name="fcode" value="${dto.fcode}" />
					<%-- <c:param name="pageNum" value="${pdto.currentPage }"/> --%>
				</c:url>
				<li id="link"><a href="${cpage}" id="list_link">
						<p><%-- [${dto.fcode}]  --%>${dto.ftitle}</p>
						<p>
							<img class="li_img" src="/semi/images/${dto.fimgpath}">
						<p class="tit">${dto.fsdate}~${dto.fedate}</p>
				</a></li>
				</div>
			</c:forEach>
		</div>
		</div>
	</div>
	</ul>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>
