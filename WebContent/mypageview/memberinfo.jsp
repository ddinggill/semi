<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<link
	href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap&subset=korean"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.container {
	margin-top: 0px;
}

#color {
	background: #F361A6;
}

.tt {
	/* font-family: 'Do Hyeon', sans-serif; */
	color: #F361A6;
	font-size: 30px;
}

.card-title {
	margin-bottom: 0px;
}

a {
	margin-left: 20px;
}
.memInfo{

width: 100%;

padding: 0;
}

#Info_title{
 	font-weight: bold;
 	font-family: Do Hyeon;
 	text-shadow: black;
}
#info_table{
	text-align: center;
	font-family: Do Hyeon;
	font-size: 25px;
	
}
#info_btn{
	font-family: Do Hyeon;
	float: right;
	width: 100px;
	height: 50px;
	font-size: 20px;
	color: #DC3545;
	
}
.info_text{
	width: 80%;
}

</style>
<script type="text/javascript">
 $(document).ready(function(){
	
	 var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	var pw = $("#pw_test").val();
	 var email = $("#email").val();
	 
	 $("#info_btn").click(function(){
		  if(!($("#pw").val() == $("#pw_test").val())){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
	 }); 
	 
	 
}); 

</script>
</head>
<body>
	<jsp:include page="../mainview/nav.jsp"></jsp:include>
	<div class="container">
		<div class="card-body">
			<img class="lecture-logo" src="../images/user-icon.png" alt="JS Logo">
				<p class="card-title">
					<strong class="tt">${sessionScope.loginOk.nickname }</strong>님 반갑습니다.
				</p>
				<h2 id="Info_title">회원정보수정</h2>
		</div>
	</div>
	<!-- 회원 정보를 보여주는 div -->
	<div class="container memInfo">
	
	<form action="memberupdate.do" method="post">
		<table class="table table-striped" id="info_table">
				<tr ><td>아이디</td><td><input type="text" class="info_text"  value="${sessionScope.loginOk.userid }" readonly="readonly" ></tr>
				<tr> <td>비밀번호</td><td><input type="password" class="info_text"   name="password" id="pw"></tr>
				<tr ><td>비밀번호확인</td><td><input type="password" class="info_text"   id="pw_test"></tr>
				<tr><td>이름</td><td><input type="text" class="info_text" value="${sessionScope.loginOk.name }" name="name"></tr>
				<tr ><td>닉네임</td><td><input type="text" class="info_text" value="${sessionScope.loginOk.nickname }" name="nickname"></tr>
				<tr ><td>이메일</td><td><input type="email" class="info_text" value="${sessionScope.loginOk.useremail }" name="email"></tr>
				
		
		</table>
		<input type="submit" value="정보수정"  id="info_btn"/>
	</form>
	</div>
	<jsp:include page="../mainview/footer.jsp"></jsp:include>
</body>
</html>