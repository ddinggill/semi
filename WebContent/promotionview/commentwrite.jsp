<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

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
</style>

<script type="text/javascript">
  	$(document).ready(function(){
  		$('form').on('submit',function(){
  			//입력한 내용의 엔터가 있으면 br로 줄바꿈
  			$('[name=contents]').val($('[name=contents]').val().replace(/\n/gi,'<br/>'));
  		});
  	});
</script>
</head>
<body>
	<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<div class="container" id="write">
		<h2>글쓰기</h2>
		<form name="frm" method="post" action="/semi/promotion/commentinsert.do">
			<input type="text" name="usercode" value="${sessionScope.loginOk.usercode }">
			<input type="text" name="boardkey" value="${param.boardkey }" />
			<table>
			
				<tr>
					<td align="right" colspan="2"><a href="/semi/promotion/board.do">리스트</a></td>
				</tr>
				<tr>
					<td align="center">제목</td>
					<td><input type="text" name="title" class="subject" required="required"/></td>
				</tr>
				<tr>
					<td align="center">내용</td>
					<td><textarea name="contents" class="content" cols="20"
							rows="23" style="resize: none" required="required"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						class="btn btn-danger" value="글쓰기" /> <input type="reset"
						value="취소" class="btn btn-danger" /></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>

</body>
</html>