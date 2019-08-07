<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
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
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap"
	rel="stylesheet">

<meta charset="UTF-8">
<title>review Update</title>
<style type="text/css">
div.container {
	margin-top: 50px;
}

h2 {
	font-family: 'Do Hyeon', sans-serif;
}

table {
	width: 100%;
}

.subject, .content {
	width: 100%;
	border: solid 1px #BDBDBD;
}
.buttom{
	margin-top:10px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script type="text/javascript">
  	$(document).ready(function(){
  		$('form').on('click',function(){
  			$('[name=contents]').val($('[name=contents]').val().replace(/\n/gi,'<br/>'));
  		    
  		});
  	});
</script>

</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
<jsp:scriptlet>
	pageContext.setAttribute("cr", "\r"); //Space
	pageContext.setAttribute("cn", "\n"); //Enter
	pageContext.setAttribute("crcn","\r\n");//Space,Enter
</jsp:scriptlet>
<div class="container" id="write">
<h2>내용수정</h2>
<form name="frm" action="reviewUpdatePro.do" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="pageNum" value="${param.pageNum}" />
	    <input type="hidden" name="boardkey" value="${dto.boardkey}" />
	    <input type="hidden" name="searchKey" value="${param.searchKey}" />
	    <input type="hidden" name="searchWord" value="${param.searchWord}" />
	    <table>
				<tr>
					<td>제목</td>
					<td colspan="2"><input type="text" name="btitle"
						value="${dto.btitle}" class="subject" required="required"/></td>
				</tr>
			<tr>
				<td>글쓴이</td>
				<td colspan="2"><input type="text" name="userName"
					value="${dto.userName}" class="subject" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="2"><input type="text" name="day"
					value="${dto.day}" class="subject" readonly="readonly" /></td>
			</tr>

			<tr>	
				<td>내용</td>
				<td colspan="3">
				<textarea rows="15"class="content" cols="20" rows="23" style="resize: none" required="required"name="contents">${fn:replace(dto.contents,'<br/>',crcn)}</textarea></td>
			</tr>

			<tr>
				<td>파일</td>
				<td colspan="3"><input type="file" name="filename" /><span>${dto.filename}</span>
				</td>
			</tr>
			<!-- <tr>
			<td colspan="2">
				<input type="submit" value="수정" id="btnUpdate" class="btn btn-danger"/>&nbsp;&nbsp;
				<input type="reset" value="취소" class="btn btn-danger"/></td>
			</tr> -->

			
		</table>
		<div class="buttom">
		<input type="submit" value="수정" id="btnUpdate" class="btn btn-danger"/>&nbsp;&nbsp;
				<input type="reset" value="취소" class="btn btn-danger"/>
			</div>
	</form>
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>