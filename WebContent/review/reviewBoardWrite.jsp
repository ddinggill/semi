<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
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
<title>ReviewWrite</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
  	$(document).ready(function(){
  		$('form').on('submit', function(){
  			$('[name=contents]').val($('[name=contents]').val().replace(/\n/gi,'<br/>'));//여러개의 엔터를 <br/>로 바꿔준다.
  			
  		});
  		
  		$('input[value="취소"]').on('click', function() {
  			$('form').attr('action', '/semi/district/view.do?fcode='+"${param.code}");
  			$('form').submit();
  			
		});
  	});
</script>
</head>

<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
	
	<form name="frm" method="post" enctype="multipart/form-data" action="/semi/district/reviewWrite.do">
		<table>
			<tr>
				<input type="hidden" name="usercode" value="${sessionScope.loginOk.usercode}"/>
				<td width="20%" align="center">축제</td>
				<td width="80%"><input type="text" name="fcode" value="${param.code}" readonly="readonly" /></td>
			</tr>
			
			<tr>
				<td width="20%" align="center">제목</td>
				<td width="80%">	
			   		    			  
				   <input type="text" name="title"  required="required"/>			 		
				</td>
			</tr>

			<tr>
				<td width="20%" align="center">내용</td>
				<td width="80%"><textarea name="contents" rows="13" cols="40" required="required"></textarea></td>
			</tr>

			<tr>
				<td width="20%" align="center">파일첨부</td>
				<td width="80%" id="fileDiv"><input type="file" name="filename" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="글쓰기" />&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소"  /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>