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
<style type="text/css">
#list_col {
	padding: 0;
	border: 1px solid gray;
	text-align: center;
	font-family: Jua;
	font-weight: bold;
	/*  border-radius: 80px / 40px;  */
	font-size: 23px;
	margin-top: 50px;
	margin-right: 70px;
	margin-left: 70px;
	background-color: white;
	
}

body {
	background-color: white;
}

* {
	border: 0;
	margin: 0;
	padding: 0;
}

#link {
	list-style: none;
	display: inline-block;
	margin-right: 0;
	
}
div p{
 color: black;
 
}

.li_img {
	width: 100%;
	height: 220px;
	margin: 0 auto;
}

img {
	/* border-radius: 80px / 40px; */
	
}
div p:hover{
 color: #DC3545;
 
}

#list_link:hover {
	color: #DC3545;
	text-decoration: none;
}

</style>
</head>
<body>
	<table>
		<div class="container-fluid" id="list_div">
		<div class="row" id="list_row">
			<c:forEach items="${requestScope.aList}" var="dto">
			<div class="col-sm-3" id="list_col">
				<c:url var="cpage" value="view.do">
					<c:param name="fcode" value="${dto.fcode}" />
					<%-- <c:param name="pageNum" value="${pdto.currentPage }"/> --%>
				</c:url>
				<li id="link"><a href="${cpage}" id="list_link">
						<p><%-- [${dto.fcode}]  --%>${dto.ftitle}</p>
						<p>
							<img class="li_img" src="/semi/images/${dto.fimgpath}">
						<p class="tit">${dto.fsdate}~${dto.fedate}</p>
				</a></li>
				</div>
			</c:forEach>
		</div>
		</div>
		<%-- <c:forEach items="${requestScope.aList}" var="dto">
			<c:url var="cpage" value="view.do">
				<c:param name="fcode" value="${dto.fcode}" />
				<c:param name="pageNum" value="${pdto.currentPage }"/>
			</c:url>
			<li><a href="${cpage}">
					<p>[${dto.fcode}] ${dto.ftitle}</p>
					<p>
						<img class="li_img" src="/semi/images/${dto.fimgpath}">
					<p class="tit">${dto.fsdate}~ ${dto.fedate}</p>
			</a></li>
		</c:forEach> --%>

	</table>
</body>
</html>