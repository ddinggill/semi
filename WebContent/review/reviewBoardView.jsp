<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 후기글의 상세내용 보여주는 뷰 -->
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
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

div.container {
	margin-top: 50px;
}

table {
	width: 100%;
	border-collapse: separate;
    border-spacing: 0 10px;
    border: 1px solid #8C8C8C;
    padding-left: 10px;
    padding-right: 10px;
}

.title{
	height : 50px;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 30px;
	border-bottom: 1px dotted #BDBDBD;
}

.frm {
	margin-top: 20px;
	margin-bottom: 125px;
}

.view_content {
	height: 300px;
	vertical-align: top;
}

.day{
   color: #BDBDBD;
}

.writer{
   font-weight: bold;
}

.button{
	margin-top: 10px;
}

.comment>p{
	font-weight: bold;
}

</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--댓글입력으로 js 추가  -->
<script type="text/javascript" src="/semi/review/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//목록버튼 클릭시 후기글 리스트를 보여주는 페이지로 이동
		$('.list').on('click', function(){
			$('form').attr('action','reviewList.do');
			$('form').submit();
		})
		//수정버튼 클릭시 후기글을 수정하는 페이지로 이동
		$('.update').on('click' , function(){
			$('form').attr('action', 'reviewUpdateForm.do');
			$('form').submit();
		});
		//삭제버튼 클릭시 후기글을 삭제
		$('.del').on('click' , function(){
			$('form').attr('action', 'reviewDelete.do');
			$('form').submit();
		});

		//회원등급이 없을시 수정 삭제 버튼 숨기기
		if("${sessionScope.loginOk.userlevel}"==""){
			$('.update').attr('type','hidden');
	        $('.del').attr('type','hidden');
		}else{
			//현재 접속한 회원과 글 작성자가 동일하거나 현재 접속한 회원의 회원등급이 관리자일경우 수정 삭제 버튼 보이고, 그 외에 경우에는 숨기기
			if(("${sessionScope.loginOk.usercode}"=="${requestScope.dto.usercode}") || ("${sessionScope.loginOk.userlevel}"==0)){
		         $('.update').attr('type','button');
		         $('.del').attr('type','button');
		      }else{
		         $('.update').attr('type','hidden');
		         $('.del').attr('type','hidden');
		     }
		}
			
		//비로그인시 댓글 작성 숨기기
		if ("${sessionScope.loginOk.usercode }" == ""){
		      $('#commentAdd').css('display','none');
		}
		
	});
</script>

</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
<div class="container">
	<table>
		<tr>
			<td colspan="2" class="title">${dto.btitle}</td>
		</tr>
		
		<tr>
			<td class="writer">${dto.userName}</td>
			<td align="right" class="day">${dto.day}</td>
		</tr>

		<tr>		
			<td colspan="2" class="view_content">${dto.contents }</td>
		</tr>

		<tr>
			<td width="70">파일</td>
			<td colspan="3"><a href="reviewDownload.do?filename=${dto.filename}" >${dto.filename}</a></td>
		</tr>
	</table>

	<form name="frm" method="post">		
		<input type="hidden" name="pageNum" value="${param.pageNum}" /> <!-- 현재페이지 -->
		<input type="hidden" id="boardkey" name="boardkey" value="${dto.boardkey}" /> <!-- 게시글 코드 -->
		<input type="hidden" id="fcode" name="fcode" value="${dto.fcode}" /> <!-- 축제코드 -->
		<input type="hidden" name="number" value="${param.number}" /> <!-- 게시글 번호 -->
		<input type="hidden" name="searchKey" value="${param.searchKey }"/> <!-- 검색 속성 -->
		<input type="hidden" name="searchWord" value="${param.searchWord }"/> <!-- 검색어 -->
		<input type="hidden" id="ucd" name="ucd" value="${sessionScope.loginOk.usercode }"/> <!-- 로그인 유저코드 -->
		<div class="button">
		<input type="button" style="float:right; margin-right: 3px;" value="목록" class="list btn btn-danger" /> 
		<input type="button" style="float:right; margin-right: 3px;" value="수정" class="update btn btn-danger"  />
		<input type="button" style="float:right; margin-right: 3px;" value="삭제" class="del btn btn-danger" />
		</div>
	</form>
		<!-- 댓글영역 시작 -->
		
			<!--댓글 목록 출력  -->
		 <div class="comment" style="margin-top: 30px;"> 
			<p>댓글</p>
			<div id="commentList">
			<script type="text/javascript">
				listView("${dto.boardkey}");
			</script>
			</div>
		
		<!-- 댓글수정 -->
		<div id="divUpdate" style="display:none;" >
			<input type="hidden" id="textCol" />
			<textarea rows="10" cols="20" id="textUpdate"></textarea>
			<input type="button" id="btnUpdate" value="수정"/>
		</div>
		
				
			<!-- 댓글입력 -->	
		<div id="commentAdd" style="margin-top: 15px;">
			<textarea id="textInput"></textarea>
			<input type="button" id="btnInput" value="댓글입력"/>
		</div>
		
		<!--  댓글영역 끝 -->
		</div>
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>