<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review Update</title>
<style type="text/css">
 table{  
  width:80%
 }
 
 table, th, td{
  border:1px solid black;
  border-collapse: collapse;
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

<jsp:scriptlet>
	pageContext.setAttribute("cr", "\r"); //Space
	pageContext.setAttribute("cn", "\n"); //Enter
	pageContext.setAttribute("crcn","\r\n");//Space,Enter
</jsp:scriptlet>

<form name="frm" action="reviewUpdatePro.do" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="pageNum" value="${param.pageNum}" />
	    <input type="hidden" name="boardkey" value="${dto.boardkey}" />
	    <input type="hidden" name="searchKey" value="${param.searchKey}" />
	    <input type="hidden" name="searchWord" value="${param.searchWord}" />
	    <table>
			<tr>

				<td width="20%">글쓴이</td>
				<td colspan="3"><input type="text" name="userName"
					value="${dto.userName}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td width="20%">작성일</td>
				<td colspan="3"><input type="text" name="day"
					value="${dto.day}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="btitle"
					value="${dto.btitle}" /></td>
			</tr>

			<tr>
				<td>내용</td>
				<td colspan="3">				
                 
						<textarea rows="15"
						cols="25" name="contents">${fn:replace(dto.contents,'<br/>',crcn)}</textarea></td>
			</tr>

			<tr>
				<td>파일</td>
				<td colspan="3"><input type="file" name="filename" /><span>${dto.filename}</span>
				</td>
			</tr>

			<tr><td colspan="2">
				<input type="submit" value="수정" id="btnUpdate"/>&nbsp;&nbsp;
				<input type="reset" value="취소" /></td>
			</tr>
		</table>

	</form>
</body>
</html>