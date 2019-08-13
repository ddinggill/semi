<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
	
<script type="text/javascript">
$(document).ready(function(){
	

 	var dp = ['#mainC1','#mainC2','#mainC3'];

	
	$('#mCon').click(function(){
	 	$('#mainC1').css('display','block');
	 	$('#mainC2').css('display','none');
	 	$('#mainC3').css('display','none');
	 	$('.wrap').css('display','none');
	});
	
	$('#mMap').click(function(){
	 	$('#mainC1').css('display','none');
	 	$('#mainC2').css('display','block');
	 	$('#mainC3').css('display','none');
	 	$('.wrap').css('display','none');
	});
	
	$('#mReView').click(function(){
	 	$('#mainC1').css('display','none');
	 	$('#mainC2').css('display','none');
	 	$('#mainC3').css('display','block');
	}); 
	
/* 	
	var button=[
		  {buttonName:'#mCon',c1:["#mainC1",'block'],c2:["#mainC2",'none'],c3:["#mainC3",'none']},
		  {buttonName:'#mMap',c1:["#mainC1",'none'],c2:["#mainC2",'block'],c3:["#mainC3",'none']},
		  {buttonName:'#mReView',c1:["#mainC1",'none'],c2:["#mainC2",'none'],c3:["#mainC3",'bloack']},
		]

		button.forEach(function(b,i){
		  $(b.buttonName).click(function(){
		       $(b.c1[0]).css('display',b.c1[0]);
		       $(b.c1[1]).css('display',b.c1[1]);
		       $(b.c1[2]).css('display',b.c1[2]);
		   });
		});
	 */

	
	//글쓰기 이동
	
	$('#write').click(function(){
		var fcd = $('#fcd').val();
		window.location.href="/semi/review/reviewBoardWrite.jsp?code="+fcd;
	});
	
	// 비로그인시 리뷰 글쓰기 버튼 비활성화
	if("${sessionScope.loginOk.usercode}"==""){
  		$('input#write').attr('type','hidden');
	}else{
	    $('input#write').attr('type','button');
	}

	
});

</script>
<script type="text/javascript">

function showlist(data){
	
	
	console.log(data + "  data값임");
	
	//선택된 글값
	var dpon = document.getElementById(data);
	
	//글 class 가져옴
	var alldp = document.getElementsByClassName('wrap');
	
	if (dpon.style.display == "none") {;

		for (var i = 0; i < alldp.length; i++) {
			alldp[i].style.display="none";
		}
		
		dpon.style.display="block";
	}
	else {
		dpon.style.display="none";
	}

};


</script>

<style type="text/css">
button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}


/* add sector */

.mainimg{
text-align: center;
margin-top: 50px;
}

.name{
	text-align: center;
}

.content{
width: 100%;
height: 100%;
text-align: center;
border: 1px dotted #B0C4DE;
}

a{
 list-style: none;
}

 tr td{
 border:1px dotted #B0C4DE;
} 


#mainC3{
 margin-top: 20px;
}

#danger{
background-color: #FBDEDE;
}

#expla{
 margin-top: 50px;
 margin-bottom: 50px;
}

body{
background-color: #FFFFE0;
font-family: 'Do Hyeon', sans-serif;
}


/* 내용보기 start  */

.wrap{
display:none; 
background-color:#FFF5EE; 
margin-top:80px; 
}

table {
    border: 1px dotted #B0C4DE;
	width: 100%;
    border-spacing: 0 10px;
    padding-left: 10px;
    padding-right: 10px;
}

.title{
	height : 50px;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 30px;
	border-bottom: 1px dotted #BDBDBD;
}

.view_content {
	height: 300px;
	vertical-align: top;
	text-align: left;
}

.day{
   color: #BDBDBD;
}

.writer{
   font-weight: bold;
}

#mainC2 iframe{
	
}
/* 내용보기 end  */
</style>

</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>

	<c:set var="cdata" value="${requestScope.cList}" />
	
	<div class="container mainimg">
		<img src="/semi/images/${cdata.fimgpath}" height="300px" width="400px"/>
	</div>
	
	
	<div class="container-fluid name"><h1><c:out value="${cdata.ftitle}" /></h1>
	<c:out value="${cdata.fsdate}" /> ~ <c:out value="${cdata.fedate}" /><br/>
	 <c:out value="${cdata.faddress}" />
	 <input type="hidden" name="${cdata.fcode}" value="${cdata.fcode}"/>
	</div>
	
	<!-- btn area -->
	<div class="container-fluid name">
	<!-- <div class="col-md-2 btn"></div> -->
		 <div id="mbutton">
		 <button id="mCon">상세보기</button>
		 <button id="mMap">지도&약도</button>
		 <%-- <button id="mReView"><a href="contents.do?key=${cdata.code}">리뷰</a></button> --%>
		 <button id="mReView">리뷰</button>
		 </div>
	<!-- <div class="col-md-2 btn"></div> -->
	</div>
	<!-- btn area end -->
	
	<div class="container content">
		 <div id="mainC1">
		 <div id="expla"><c:out value="${cdata.fcontents}"/></div>
		 <img src="/semi/images/${cdata.fmainpath}" width="90%;" />
		 </div>
		  <div id="mainC2" style="display:none; height: 100%">
		 <iframe src="https://www.google.com/maps/embed?pb=${cdata.fmap }" width="100%" height="800px;" frameborder="0" style="border:0" allowfullscreen></iframe>
		 </div>

		 <div id="mainC3" style="display:none">
			<table class="table table-bordered">
			 <thead>
         		  <tr>
               <th>축제명</th>
               <th>글제목</th>
               <th>작성자</th>
               <th>작성일</th>
          	  </tr>
       		 </thead>
			<c:forEach var="data" items="${requestScope.rwList}">
			<tbody>
				<tr class="danger" id="danger">
				<td><c:out value="${data.ftitle}"/></td>
				<c:if test="${requestScope.aList != requestScope.rwList}">
				<input type="hidden" id="tcd" name="tcd" value="${data.boardkey}" />
				</c:if>
				<%-- <td><a href="readReview.do?rcode=${data.boardkey}"><c:out value="${data.btitle}"/></a></td> --%>
				<td><a href="javascript:void(0);" onclick="showlist('${data.boardkey}');" ><c:out value="${data.btitle}"/></a></td>
				<td><c:out value="${data.userName}"/></td>
				<td><c:out value="${data.day}"/></td>
				</tr>
      	    </tbody>
			</c:forEach>
			 </table>
	 		
			<!-- 글쓰기 처리시 축제코드 -->
			<input type="hidden" name="${param.fcode}" id="fcd" value="${param.fcode}"/>
       	    <div style="background-color: #1AAB8A; float:right; width:120px; color: white"><input type="button" value="글쓰기" class="btn" id="write" ></div>
		</div>
		
		<!-- 글내용보기 시작 -->
		<c:forEach var="data" items="${requestScope.rwList }">
			
			<!-- add sector -->
			<div class="wrap" id="${data.boardkey}" value="${data.boardkey}" >
				<table>
					<tr>
						<td colspan="2" class="title">${data.btitle}</td>
					</tr>
					<tr>
						<td class="writer">${data.userName}</td>
						<td align="right" class="day">${data.day}</td>
					</tr>
			
					<tr>		
						<td colspan="2" class="view_content">${data.contents }</td>
					</tr>
			
					<tr>
						<td width="70">파일</td>
						<c:if test="${data.filename != null}">
						<td colspan="3"><a href="reviewDownload.do?filename=${data.filename}" >${data.filename}</a></td>
						</c:if>
					</tr>
				</table>
			</div>
						
			<!-- add sector end -->
			
		</c:forEach>
	</div> <!-- container end -->
		
	
<jsp:include page="../mainview/footer.jsp"></jsp:include>

</body>
</html>