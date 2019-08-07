<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$("#list").on('click',function(){
			$("form").attr("action","/mypage/mypage.do");
			$("form").submit();
		});
		
		$("#change").on('click',function(){
			$("form").attr("action","updateForm.do");
			$("form").submit();
		});
		
		$("#delete_promotion").on('click',function(){
			$("form").attr("action","delete_promotion.do");
			$("form").submit();
		});
		$("#comment").on('click',function(){
			$("form").attr("action","comment.do");
			$("form").submit();
		});
	});

</script>
</head>
<body>
	<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<div class="container" id="view">
		<table>
			<tr>
				<td colspan="2" class="title">${dto.commentTitle }</td>
			</tr>
			
			<tr>
				<td class="writer">관리자</td>
				<td align="right" class="day">${dto.commentday }</td>
			</tr>

			<tr>
				<td colspan="2" class="view_content">${dto.commentContents }</td>
			</tr>
			
		</table>
	<form name="frm" method="post" class="frm">		
		<input type="hidden" name="boardkey" value="${dto.boardkey }"/>
		<input type="button" value="뒤로가기" class="btn btn-danger"  onclick="history.back(-1);"/> 	
		<c:if test="${sessionScope.loginOk.userlevel == 0 }">	
		<input type="hidden" name="commentcode" value="${dto.commentcode }"/>
			<input type="button" value="삭제" class="btn btn-danger" id="delete_promotion"/>
		</c:if>
	</form>
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>