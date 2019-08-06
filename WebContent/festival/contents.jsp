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
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">
	
<script type="text/javascript">
$(document).ready(function(){
	

	var dp = ['#mainC1','#mainC2','#mainC3'];

	
	$('#mCon').click(function(){
	 	$('#mainC1').css('display','block');
	 	$('#mainC2').css('display','none');
	 	$('#mainC3').css('display','none');
	});
	
	$('#mMap').click(function(){
	 	$('#mainC1').css('display','none');
	 	$('#mainC2').css('display','block');
	 	$('#mainC3').css('display','none');
	});
	
	$('#mReView').click(function(){
	 	$('#mainC1').css('display','none');
	 	$('#mainC2').css('display','none');
	 	$('#mainC3').css('display','block');
	});

	
	//글쓰기 이동
	
	$('#write').click(function(){
		var fcd = $('#fcd').val();
		window.location.href="/semi_start/reviewBoardWrite.jsp?code="+fcd;
	});
	


		

	
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
border: 1px solid black;
text-align: center;
margin-top: 50px;
}

.name{
	text-align: center;
	border: 1px solid black;
}

.content{
width: 100%;
height: 1000px;
text-align: center;
}

a{
 list-style: none;
}

tr td{
 border:1px solid black;
}

#mainC3{
 margin-top: 20px;
}

#danger{
background-color: #FBDEDE;
}


</style>

</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>

	<c:forEach var="cdata" items="${requestScope.cList}">
	
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
	<div class="col-md-2 btn"></div>
		 <div id="mbutton">
		 <button id="mCon">상세보기</button>
		 <button id="mMap">지도&약도</button>
		 <%-- <button id="mReView"><a href="contents.do?key=${cdata.code}">리뷰</a></button> --%>
		 <button id="mReView">리뷰</button>
		 </div>
	<div class="col-md-2 btn"></div>
	</div>
	<!-- btn area end -->
	
	<div class="container content">
		 <div id="mainC1">
		  ----main contents <br/>
		 <p><c:out value="${cdata.fcontents}"/></p>
		 <img src="/semi/images/${cdata.fmainpath}" width="400px" height="300px" />
		 </div>
		 <div id="mainC2" style="display:none">
		 -----map contents <br />
		 <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3167.017626620263!2d127.88749391533396!3d37.4603057379624!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x35630c0b409fb0ab%3A0x9394e6b5cb53110e!2z6rCV7JuQ64-EIOybkOyjvOyLnCDtmLjsoIDrqbQg7Jqp6rOh66asIDM5Mw!5e0!3m2!1sko!2skr!4v1564537373469!5m2!1sko!2skr" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
		 </div>
	</c:forEach>

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
			<input type="button" value="검색" class="btn">
       	    <input type="button" value="글쓰기" class="btn" id="write">
		</div>
		
		<!-- 글내용보기 시작 -->
		<c:forEach var="data" items="${requestScope.rwList }">
		<div class="wrap" style="display:none" id="${data.boardkey}" value="${data.boardkey}">
		<table class="table table-bordered">
			<tbody>
			<tr class="danger" id="danger">
				<tr>
				<td colspan="1">제목</td>
				<td colspan="3"><div id="title" name="${data.btitle}" value="${data.btitle}">${data.btitle}</div>
				<div id="cd" name="${data.boardkey}" style="display:none" value="boardkey">${data.boardkey}</div></td>
				</tr>
				
				<tr>
				<td>작성자</td>
				<td><div id="nm" name="${data.userName}" value="${data.userName}">${data.userName}</div></td>
				<td>작성일</td>
				<td><div id="regday" name="${data.day}" value="${data.day}">${data.day}</div></td>
				</tr>
				
				<tr>
				<td colspan="4"><div id="contents" name="${data.contents}" >${data.contents}</div></td>
				</tr>
				
				<tr>
				<td colspan="4"><div id="attach" name="${data.filename}"><a href="reviewDownload.do?filename=${data.filename}">${data.filename}</a></div></td>
				</tr>
			</tr>
			</tbody>
			</table>
			</div> <!-- 글내용보기 end  -->
		</c:forEach>
	</div> <!-- container end -->
		
	
<jsp:include page="../mainview/footer.jsp"></jsp:include>

</body>
</html>