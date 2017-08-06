<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="http://fonts.googleapis.com/css?family=Abel|Buenard:400,700" rel="stylesheet" />
<link rel="stylesheet" href="resources/css/wsstyle.css"/>
</head>
<div id="wrapper">
<body>

	<h1 id="header">WiseMoney <span>Portfolio Risk Evaluation</span></h1>
	
	<div id="nav">
	<ul>
		<li><a href="" style="background-color:#869DC7; padding-top: 10px; padding-bottom: 10px">Home</a></li>
		<li><a href="">View Portfolio</a></li>
		<li><a href="">Manager Login</a></li>
		<li><a href="">Log out</a></li>
		</ul>
	</div>
	<div class="content">
	
		<div class="div1">
		
			<form class="login-form" action="add" method="POST">
			  <input type="text" placeholder="Username" name="PersonUName"/>
			  <input type="password" placeholder="Password" name="PersonPass"/>
			  <button type="submit" name="SubmitButton" value="submit">&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp; </button>
			  <p class="message">Not registered? <a href="index.html">Create an account</a></p>
			</form>
		</div>
	</div>

</body>
<footer id="sticky">
	<span style="float:left;">WiseMoney. © All rights reserved.</span>
	<span style="float:right;">Follow us on social media</span>
</footer>
</html>