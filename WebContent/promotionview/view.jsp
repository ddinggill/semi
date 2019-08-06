<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function(){
  		$('form').on('submit',function(){
  			//입력한 내용의 엔터가 있으면 br로 줄바꿈
  			$('[name=contents]').val($('[name=contents]').val().replace(/\n/gi,'<br/>'));
  		});
  	});

</script>
<meta charset="UTF-8">
<title>글제목</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
<style type="text/css">
div.container {
	margin-top: 50px;
	font-family: Jua;
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

	vertical-align: top;
}

.content{
  
   /* border:  1px solid #6E6E6E; */
}

.writer{
   font-weight: bold;
}
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$("#list").on('click',function(){
			$("form").attr("action","list.do");
			$("form").submit();
		});
		
		$("#change").on('click',function(){
			$("form").attr("action","updateForm.do");
			$("form").submit();
		});
		
		$("#delete").on('click',function(){
			$("form").attr("action","delete.do");
			$("form").submit();
		});
		$("#comment").on('click',function(){
			$("form").attr("action","promotion/promotionwrite.do");
			$("form").submit();
		});
	});

</script>
</head>
<body>
	<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<input type="text" name="boardkey" value="${dto.boardkey}" />	
	<div class="container" id="view">
		<table>
			<tr>
				<td colspan="60" class="title">${dto.fTitle }</td>
			</tr>
			
			<tr>
				<td class="writer">등록유저</td>
				<td align="left" class="content">${dto.usercode }</td>
			</tr>
			
			<tr>
				<td colspan="2" class="view_content">시작일</td>
				<td align="left" class="content">${dto.fSdate }</td>
			</tr>
			<tr>
				<td colspan="2" class="view_content">종료일</td>
				<td align="left" class="content">${dto.fEdate }</td>
			</tr>
			<tr>
				<td colspan="2" class="view_content">주소</td>
				<td align="left" class="content">${dto.fAddress }</td>
			</tr>
			<tr>
				<td colspan="2" class="view_content">내용</td>
				<td align="left" class="content">${dto.fContents }</td>
			</tr>
			
			<tr>
				<td width="150">메인이미지파일</td>
				<td><a href="download.do?fImgpath=${dto.fImgpath}">${dto.fImgpath}</a></td>
			</tr>
			<tr>
				<td width="150">첨부이미지파일</td>
				<td><a href="download.do?fMainpath=${dto.fMainpath}">${dto.fMainpath}</a></td>
			</tr>
		</table>
		
	<form name="frm" method="post" class="frm">		
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="boardkey" value="${dto.boardkey }"/>
		<!-- <input type="button" value="목록" class="btn btn-danger" id="list"/> 	 -->
		<c:if test="${sessionScope.loginOk.userlevel == 0 }">	
			<input type="button" value="삭제" class="btn btn-danger" id="delete"/>
			<input type="button" value="답글" class="btn btn-danger" id="comment"/>
		</c:if>
		<c:if test="${sessionScope.loginOk.usercode == dto.usercode }">
			<input type="button" value="수정" class="btn btn-danger" id="change"/>
			<input type="button" value="삭제" class="btn btn-danger" id="delete"/>
		</c:if>
	</form>
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>