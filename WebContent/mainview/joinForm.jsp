<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("[name=userid]").on('change',function(){
		var regExpId = /([a-z]{1,12})[a-z0-9]{3,12}$/;
		if(!(regExpId.test($("[name=userid]").val()))){
			$(".id_check").text("아이디는 4~12자 영문자와 숫자여야 합니다.");
			$(".id_check").css("color","#e74742");
			return false;
		};
		var userid = $("[name=userid]").val();
		idchkprocess(userid);
	});
		//alert($("[name=userid]").val());

	//password: 4글자 이상 12글자 이하 소문자,숫자(둘다 반드시 포함)
	$("[name=password]").on('change',function(){
		var regExpId = /[a-z0-9]{4,12}$/;
		if(!(regExpId.test($("[name=password]").val()))){
			$(".pw_check").text("비밀번호는 4~12자 영문자,숫자여야 합니다.");
			$(".confirmpw").css("color","#e74742");
			return false;
		}else{
			$(".pw_check").text("사용가능한 비밀번호 입니다.");
			$(".pw_check").css("color","#2F9D27");
			
			//confirmpw : 중복체크
			$("[name=password2]").on('change', function(){
				var pwd1=$("[name=password]").val();
		        var pwd2=$("[name=password2]").val();
		        if(pwd1 != "" || pwd2 != ""){
		            if(pwd1 == pwd2){
		            	$(".confirmpw").css("color","#2F9D27");
		            	$(".confirmpw").text("비밀번호가 일치합니다.");
		            }else{
		            	$(".confirmpw").css("color","#e74742");
		            	$(".confirmpw").text("비밀번호가 일치하지 않습니다.");
		            }
		        }
			});
		}
	});//password check
		
	if("${requestScope.joinOK}" == 1){
	      alert("회원가입 성공했습니다.로그인 페이지로 이동하세요.");
	}
	
	
});

function idchkprocess(userid){
	
	//alert(userid);
	$.ajax({
		type:'POST',
		dataType:'text',
		//data:'id='+id+'&pass='+pass,
		data:'userid='+userid,
		url:'/semi/help/idchk.do',
		success: function(res){
			if(res == "true"){
				$(".id_check").text("사용가능한 아이디 입니다.");
				$(".id_check").css("color","#2F9D27");
			}else{
				$(".id_check").text("이미 존재하는 아이디입니다. 다른 아이디를 입력하세요.");
			}
			//alert(res);
		}
	});
}///////////////////////////////////

</script>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 200px 0px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.form .input1 {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 2px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #EB6864;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #e74742;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message2 {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message3 {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #e07975;
  text-decoration: none;
}
.form .message2 a {
  color: #e07975;
  text-decoration: none;
}
.form .message3 a {
  color: #e07975;
  text-decoration: none;
}
.form .register-form {
  /* display: none; */
}

.form .pw-find{
	/* display: none; */
}

.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  background: #EB6864; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #EB6864, #e05c58);
  background: -moz-linear-gradient(right, #EB6864, #e05c58);
  background: -o-linear-gradient(right, #EB6864, #e05c58);
  background: linear-gradient(to left, #EB6864, #e05c58);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
} 

/* .container-fluid {
  background: #EB6864; /* fallback for old browsers 
  background: -webkit-linear-gradient(right, #EB6864, #e05c58);
  background: -moz-linear-gradient(right, #EB6864, #e05c58);
  background: -o-linear-gradient(right, #EB6864, #e05c58);
  background: linear-gradient(to left, #EB6864, #e05c58);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}  */
 
.id_check,.pw_check, .confirmpw{
	/* visibility: hidden; */
	text-align: left;
	font-size: 12px;
	color:#e74742;
}

</style>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="login-page">
  <div class="form">
    <form class="register-form" action="/semi/help/join.do" method="post">
      <input type="text" name="userid" placeholder="id" class="input1"/>
      <div class="id_check">&nbsp;</div>
      <input type="text" name="name" placeholder="username"/>
      <input type="text" name="nickname" placeholder="nickname" />
      <input type="password" name="password" placeholder="password" class="input1"/>
      <div class="pw_check">&nbsp;</div>
      <input class="input1" type="password" name="password2" placeholder="confirm password"/>
      <div class="confirmpw">&nbsp;</div>
      <input type="text" name="phonenumber" placeholder="phone number"/>
      <input type="text" name="useremail" placeholder="email address"/>
      <button>create</button>
      <p class="message">Already registered? <a href="/semi/main/login.do">Sign In</a></p>
      <p class="message3">Forget Password? <a href="/semi/main/pwfind.do">Click this</a></p>
    </form>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>