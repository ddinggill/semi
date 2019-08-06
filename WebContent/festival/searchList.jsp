<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<table>
		<c:forEach items="${requestScope.aList}" var="dto">
			<c:url var="cpage" value="view.do">
				<c:param name="fcode" value="${dto.fcode}" />
				<%-- <c:param name="pageNum" value="${pdto.currentPage }"/> --%>
			</c:url>
			<li><a href="${cpage}">
					<p>[${dto.fcode}] ${dto.ftitle}</p>
					<p>
						<img class="li_img" src="/semi/images/${dto.fimgpath}">
					<p class="tit">${dto.fsdate}~ ${dto.fedate}</p>
			</a></li>
		</c:forEach>

	</table>
</body>
</html>