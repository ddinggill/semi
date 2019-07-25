<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	$('.message a').click(function(){ //Already registered?
		   $('.login-form').animate({height: "show", opacity: "show"}, "slow");
		   $('.pw-find').animate({height: "hide", opacity: "hide"}, "slow");
		   $('.register-form').animate({height: "hide", opacity: "hide"}, "slow");	   
		});
	$('.message2 a').click(function(){ //Not registered?
		   $('.login-form').animate({height: "hide", opacity: "hide"}, "slow");
		   $('.pw-find').animate({height: "hide", opacity: "hide"}, "slow");
		   $('.register-form').animate({height: "show", opacity: "show"}, "slow");	
		});
	$('.message3 a').click(function(){ //Forget Password?
		   $('.login-form').animate({height: "hide", opacity: "hide"}, "slow");
		   $('.pw-find').animate({height: "show", opacity: "toggle"}, "slow");
		   $('.register-form').animate({height: "hide", opacity: "hide"}, "slow");	
		});
	
});

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
  display: none;
}

.form .pw-find{
	display: none;
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
 


</style>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" name="userid" placeholder="id"/>
      <input type="text" name="name" placeholder="username"/>
      <input type="text" name="nickname" placeholder="nickname" />
      <input type="password" name="password" placeholder="password"/>
      <input type="text" name="phonenumber" placeholder="phone number"/>
      <input type="text" name="useremail" placeholder="email address"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
      <p class="message3">Forget Password? <a href="#">Click this</a></p>
    </form>
    <form class="login-form">
      <input type="text" placeholder="username"/>
      <input type="password" placeholder="password"/>
      <button>login</button>
      <p class="message2">Not registered? <a href="#">Create an account</a></p>
      <p class="message3">Forget Password? <a href="#">Click this</a></p>
    </form>
    <form class="pw-find">
  	<input type="text" placeholder="userid" />
  	<input type="text" placeholder="useremail" />
  	<button>find password</button>
  	<p class="message2">Not registered? <a href="#">Create an account</a></p>
  	<p class="message">Already registered? <a href="#">Sign In</a></p>
  	</form>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>