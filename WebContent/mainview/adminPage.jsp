<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="../css/index_style.css"> -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
div.container {
margin-top:50px 
}

h2{
	font-family: 'Do Hyeon', sans-serif;
}

.pagination a:hover {
	color: red;
} 

ul.pagination {width:150px; margin:0 auto}

li{text-align:center}

/* 글쓰기 버튼 */
div.write{width:100px; height:35px; background:#EB6864; text-align:center; line-height:35px; color:#fff; float:right; margin-bottom : 10px; margin-right: 10px;}

div.write a{color:#fff}

div.write:hover{
	background:#e74742;
}

.pagecolor{
	color: red;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	//회원 정보변경 요청
	$('button[id=update]').each(function(){ 
		$(this).click(function(){
			var usercode = $(this).parents("tr").find("#usercode").val();
			var userlevel = $(this).parents("tr").find("select").val();
			updateprocess(usercode,userlevel)
		});
	});
	//회원 삭제변경 요청
	$('button[id=delete]').each(function(){ 
		$(this).click(function(){
			var usercode = $(this).parents("tr").find("#usercode").val();
			deleteprocess(usercode);
		});
	});

});

//회원정보 요청 ajax
function updateprocess(usercode,userlevel){
	
	$.ajax({
		type:'POST',
		dataType:'text',
		//data:'id='+id+'&pass='+pass,
		data:'usercode='+usercode+'&userlevel='+userlevel,
		url:'/semi/admin/update.do',
		success: function(res){
			alert("회원정보가 변경되었습니다.");
		}
	});
}

//삭제하고 회원정보 다시 요청
function refreshMemList(res){
	
	location.href="/semi/admin/membermanage.do?pageNum="+res;
}

//회원삭제 요청 ajax
function deleteprocess(usercode){
	$.ajax({
		type:'POST',
		dataType:'text',
		data:'usercode='+usercode+'&pageNum=${requestScope.pdto.currentPage}',
		url:'/semi/admin/delete.do',
		success: function(res){
			alert("회원이 삭제되었습니다.");
			refreshMemList(res);
		}
	});
	
}
</script>
<title>공지사항</title>
</head>
<body>
<jsp:include page="../mainview/nav.jsp"></jsp:include>
<div class="container" id="notice">
		<h2>회원관리</h2>
		
		<table class="table table-striped"> 
			<thead> 
				<tr> 
					<th>USERID</th>
					<th>PHONENUMBER</th> 
					<th>NAME</th> 
					<th>NICKNAME</th>
					<th>USEREMAIL</th>
					<th>USERLEVEL</th>
					<th></th>
					<th></th>
				</tr> 
			</thead>
		 	<!-- 테이블 내용 -->
		 	<tbody> 
		 	<c:forEach items="${requestScope.userlist }" var="dto">
				<tr>
					<input type="hidden" id="usercode" value="${dto.usercode }">
					<td>${dto.userid }</td>
					<td>${dto.phonenumber }</td>
					<td>${dto.name }</td>
					<td>${dto.nickname }</td>
					<td>${dto.useremail }</td>
					<td>
					<select name="level">
					<option value=0 <c:if test="${dto.userlevel ==0}">selected</c:if>>0</option>
					<option value=1 <c:if test="${dto.userlevel ==1}">selected</c:if>>1</option>
					</select>
					</td>
					<td><button class="btn btn-secondary" id="update">수정</button></td>
					<td><button class="btn btn-secondary" id="delete">삭제</button></td>
				</tr>
		</c:forEach>
		 		
		 	</tbody> 
		</table>
		<div class="text-conter">
		<ul class="pagination">
			<c:if test="${requestScope.pdto.startPage != 1 }" >
				<li>
					<a href="membermanage.do?pageNum=${requestScope.pdto.startPage- requestScope.pdto.blockPage}">이전</a>
				</li>
			</c:if>
				<li>
					<c:forEach begin="${requestScope.pdto.startPage }" end="${requestScope.pdto.endPage }" var="i">
						<c:choose>
							<c:when test="${i == requestScope.pdto.currentPage }">
								<a href="membermanage.do?pageNum=${i }" class="pagecolor">${i }</a>
							</c:when>
							<c:otherwise>
								<a href="membermanage.do?pageNum=${i }">${i }</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</li>
		
				<li>
					<c:if test="${requestScope.pdto.totalPage > requestScope.pdto.endPage }" >
					<a href="membermanage.do?pageNum=${requestScope.pdto.endPage+1 }">다음</a>
					</c:if>
				</li>
		</ul>
		</div> 
</div>
<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>