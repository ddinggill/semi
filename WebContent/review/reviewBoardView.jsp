<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 80%
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('.list').on('click', function(){
			$('form').attr('action','reviewList.do');
			$('form').submit();
		})

		$('.update').on('click' , function(){
			$('form').attr('action', 'reviewUpdateForm.do');
			$('form').submit();
		});
		
		$('.del').on('click' , function(){
			$('form').attr('action', 'reviewDelete.do');
			$('form').submit();
		});
		
	});
</script>

</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<table>
		<tr>
			<td width="20%">글쓴이</td>
			<td>${dto.userName}</td>
			<td width="20%">작성일</td>
			<td>${dto.day}</td>
		</tr>

		<tr>
			<td>제목</td>
			<td colspan="3">${dto.btitle}</td>
		</tr>

		<tr>
			<td>내용</td>
				
			<td colspan="3">${dto.contents }</td>
		</tr>

		<tr>
			<td>파일</td>
			<td colspan="3"><a href="reviewDownload.do?filename=${dto.filename}" >${dto.filename}</a></td>
		</tr>
	</table>

	<form name="frm" method="post">		
		<input type="hidden" name="pageNum" value="${param.pageNum}" /> 
		<input type="hidden" name="boardkey" value="${dto.boardkey}" />
		<input type="hidden" name="fcode" value="${dto.fcode}" />
		<input type="hidden" name="number" value="${param.number}" />
		<input type="hidden" name="searchKey" value="${param.searchKey }"/>
		<input type="hidden" name="searchWord" value="${param.searchWord }"/>
		<input type="button" value="목록" class="list" /> 
		<input type="button" value="수정" class="update"  />
		<input type="button" value="삭제" class="del" />
	</form>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>











