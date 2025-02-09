<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/login_func.js"></script>
<link rel="stylesheet" type="text/css" href="../css/index_style.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<!-- login-form --> 
<div class="container"> 
	<div class="card card-container"> 
		<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> --> 
		<img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" /> 
		<p id="profile-name" class="profile-name-card"></p> 
		<h4 class="mb-3 mx-auto">Sign in to MySite</h4> 
		<form class="form-signin"> 
			<span id="reauth-email" class="reauth-email"></span> 
			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus> 
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" required> 
			<div id="remember" class="checkbox"> 
				<label> <input type="checkbox" value="remember-me"> Remember me </label> 
			</div> <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button> 
		</form>
		<!-- /form --> 
		<a href="#" class="forgot-password"> Forgot the password? </a> 
	</div>
	<!-- /card-container --> 
</div>
<!-- /container -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>